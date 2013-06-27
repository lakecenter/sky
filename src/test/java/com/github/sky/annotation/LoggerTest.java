package com.github.sky.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Level;


/**
 * Created with IntelliJ IDEA.
 * User: zjp
 * Date: 13-6-26
 * Time: 下午3:44
 */

@ContextConfiguration(classes = {TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoggerTest {
    @Logger
    private org.slf4j.Logger slf4jLogger;
    @Logger
    private org.apache.commons.logging.Log jclogger;
    @Logger
    private org.apache.log4j.Logger log4j;
    @Logger
    private java.util.logging.Logger utilLogger;
    @Test
    public void out() {
        slf4jLogger.debug("inject...");
        jclogger.debug("inject...");
        log4j.debug("inject...");
        utilLogger.log(Level.SEVERE, "inject...");
    }
}
