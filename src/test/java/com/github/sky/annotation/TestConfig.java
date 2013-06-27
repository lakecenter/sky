package com.github.sky.annotation;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: zjp
 * Date: 13-6-26
 * Time: 下午6:15
 */
@Configuration
public class TestConfig {
    @Bean
    public BeanPostProcessor loggerProcessor() {
        return new SpringBeanPostProcessor();
    }
}
