package com.github.sky.annotation;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: zjp
 * Date: 13-6-26
 * Time: 下午6:36
 */
public class SpringBeanPostProcessor implements BeanPostProcessor {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class c = bean.getClass();
        logger.debug("为 {}处理标注 ", c);
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            if (f.isAnnotationPresent(Logger.class)) {
                try {
                    f.setAccessible(true);
                    f.set(bean, createLoggerBean(f.getType(), c));
                    f.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
        return bean;
    }

    private static Object createLoggerBean(Class<?> loggerClazz, Class<?> targetClass) {
        String logClassname = loggerClazz.getName();
        switch (logClassname) {
            case "org.slf4j.Logger":
                return org.slf4j.LoggerFactory.getLogger(targetClass);
            case "org.apache.commons.logging.Log":
                return org.apache.commons.logging.LogFactory.getLog(targetClass);
            case "org.apache.log4j.Logger":
                return org.apache.log4j.Logger.getLogger(targetClass);
            case "java.util.logging.Logger":
                return java.util.logging.Logger.getLogger(targetClass.getName());
        }
        return null;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
