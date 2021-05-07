package com.example.aoplog.config;

import com.alibaba.fastjson.JSON;
import com.example.aoplog.annotation.BusinessLog;
import com.example.aoplog.api.IExtBusinessLogUser;
import com.example.aoplog.dto.BusinessLogUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author zsy
 */
@Component
@Aspect
public class BusinessLogAspect {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Controller层切点 注解拦截
     */
    @Pointcut("@annotation(com.example.aoplog.annotation.BusinessLog)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            logger.info("joinPoint.getArgs():" + JSON.toJSONString(null));
            BusinessLog businessLogApi = method.getAnnotation(BusinessLog.class);
            logger.info("--------注解获取的action:" + businessLogApi.action());
            //获取用户
            IExtBusinessLogUser extBusinessLogUser = BusinessLogSpringUtil.getBean(businessLogApi.logUserClass());
            logger.info("--------extBusinessLogUser:" + JSON.toJSONString(extBusinessLogUser));
            if (extBusinessLogUser != null) {
                BusinessLogUser user = extBusinessLogUser.getUser();
                logger.info("--------user:" + JSON.toJSONString(user));
            }
            return businessLogApi.action();
        } catch (Throwable e) {
            throw e;
        }
    }

}
