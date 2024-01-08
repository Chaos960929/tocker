package com.tocker.corebase.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 远程调用请求头丢失问题
 */
@Slf4j
public class FeignClientConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        try {
            log.info("Thread:{}", Thread.currentThread().getId());
            RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = ((ServletRequestAttributes) attributes).getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (null != headerNames) {
                while (headerNames.hasMoreElements()) {
                    String headName = headerNames.nextElement();
                    String headValue = request.getHeader(headName);
                    if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(headName)) {
                        template.header(headName, headValue);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
