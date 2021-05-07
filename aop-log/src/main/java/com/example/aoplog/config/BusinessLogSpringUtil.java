package com.example.aoplog.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author
 */
@Component
public class BusinessLogSpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BusinessLogSpringUtil.applicationContext = applicationContext;
    }

    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取 Bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);

    }

    /**
     * 通过class获取Bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        try {
            return getApplicationContext().getBean(clazz);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 获取接口某个实现类
     *
     * @param interfaceClass
     * @param implClass
     * @return
     */
    public static <T> T getApiBean(Class<T> interfaceClass, Class<?> implClass) {
        Map<String, T> beanMap = getApiBeanImpl(interfaceClass);
        for (Entry<String, T> entry : beanMap.entrySet()) {
            if (implClass.isAssignableFrom(entry.getValue().getClass())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static <T> T getApiBean(Class<T> interfaceClass, String implClassName) {
        try {
            return getApiBean(interfaceClass, Class.forName(implClassName));
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    /**
     * 获取接口所有实现类
     *
     * @param interfaceClass
     * @return
     */
    public static <T> Map<String, T> getApiBeanImpl(Class<T> interfaceClass) {
        return getApplicationContext().getBeansOfType(interfaceClass);
    }

    /**
     * 动态注入bean
     *
     * @param beanName
     * @param beanDefinitionBuilder
     */
    public static void registerBean(String beanName, BeanDefinitionBuilder beanDefinitionBuilder) {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext
                .getAutowireCapableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());

    }

    public static void registerBean(String beanName, BeanDefinition beanDefinition) {
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext
                .getAutowireCapableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition(beanName, beanDefinition);
    }

    /**
     * 注入bean
     *
     * @param beanDefinitionBuilder
     */
    public static void registerBean(BeanDefinitionBuilder beanDefinitionBuilder) {
        String beanName = beanDefinitionBuilder.getBeanDefinition().getBeanClassName();
        registerBean(beanName, beanDefinitionBuilder);
    }

    /**
     * 注入bean
     *
     * @param clazz
     */
    public static void registerBean(Class<?> clazz) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        registerBean(beanDefinitionBuilder);
    }

    /**
     * 获取此注解所有对象
     *
     * @param annotionClass
     * @return
     */
    public static Map<String, Object> getAnnotationMap(Class<? extends Annotation> annotionClass) {
        Map<String, Object> beansWithAnnotationMap = getApplicationContext().getBeansWithAnnotation(annotionClass);
        return beansWithAnnotationMap;
    }
}
