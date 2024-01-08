package com.tocker.corebase.aspect;


import com.alibaba.fastjson.JSON;
import com.tocker.corebase.annotion.Log;
import com.tocker.corebase.entity.SysLogEntity;
import com.tocker.corebase.enums.HttpMethodEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component  //能够让spring找到他
@Aspect //切面 定义了通知和切点的关系
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.songchao.systemmanager.annotion.Log) ||@within(com.songchao.systemmanager.annotion.Log)")//切点
    public void pt() {
    }

    //环绕通知
    @Around("pt()")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        log.info("开始时间:{}", beginTime);
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("结束时间:{}", endTime);
        recordLog(joinPoint, endTime - beginTime);
    }

    private void recordLog(JoinPoint joinPoint, long l) {
        System.out.println();
        log.info("执行方法" + joinPoint.getTarget().getClass().getName() + "====执行时间：===" + l);
    }

//    @AfterReturning(pointcut = "pt()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        log.info("方法结束!");
    }

    protected void handLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {
            Log controllerLog = getAnnotionLog(joinPoint);
            if (null == controllerLog) {
                return;
            }
            SysLogEntity sysLogEntity = new SysLogEntity();
            sysLogEntity.setStatus("1");
            sysLogEntity.setOperateTime(new Date());
            if (null != e) {
                sysLogEntity.setStatus("0");
            }
            //设置方法名
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            sysLogEntity.setMethod(methodName);

            log.info("待保存日志信息", JSON.toJSONString(sysLogEntity));
            //*======数据日志=======*//
        } catch (Exception exception) {
            log.error("==前置异常==");
            log.error("异常信息:{}", exception.getMessage());
        }

    }

    private Log getAnnotionLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Log annotation = null;
        if (method != null) {
            annotation = method.getAnnotation(Log.class);
            if (annotation == null) {
                annotation = joinPoint.getTarget().getClass().getDeclaredAnnotation(Log.class);
            }
        }
        return annotation;
    }

    private void setRequestValue(JoinPoint joinPoint, SysLogEntity sysLogEntity) throws Exception {
        String method = sysLogEntity.getMethod();
        if (HttpMethodEnum.POST.getCode().equals(method)) {
            Object[] args = joinPoint.getArgs();
        }
    }
}
