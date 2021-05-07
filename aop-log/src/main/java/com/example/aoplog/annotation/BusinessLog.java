package com.example.aoplog.annotation;

import com.example.aoplog.api.IExtBusinessLogUser;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 业务日志注解
 * @author zsy
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {

    /**
     * 业务动作
     *
     * @return
     */
    String action();

    /**
     * 日志用户class
     *
     * @return
     */
    Class<? extends IExtBusinessLogUser> logUserClass() default IExtBusinessLogUser.class;

}
