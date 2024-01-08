package com.tocker.corebase.exception;


import com.tocker.corebase.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.StringJoiner;

/**
 * @version 1.0
 * @description 全局异常处理，给予前端友好提示
 * @package com.itheima.common.exception
 */
@RestControllerAdvice
@Slf4j(topic = "SYSTEM_ERROR")
public class GlobalExceptionHandler {

    /**
     * 处理未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public ResultVo handleException(Throwable e){
        log.error("系统异常",e);
        return ResultVo.error();
    }

    /**
     * 处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = LeadNewsException.class)
    public ResultVo handleLeadNewsException(LeadNewsException e){
        return ResultVo.bizError(e.getMessage());
    }

    /**
     * 处理请求参数校验失败，返回友好提示
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultVo handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringJoiner sj = new StringJoiner(";");
        for (ObjectError error : allErrors) {
            sj.add(error.getDefaultMessage());
        }
        return ResultVo.bizError(sj.toString());
    }

}
