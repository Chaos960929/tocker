package com.tocker.corebase.annotion;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /*
    模块
     */
    String module() default "";

    /*
    功能
     */
    String operator() default "";
}
