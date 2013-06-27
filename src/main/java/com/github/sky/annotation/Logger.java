package com.github.sky.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: zjp
 * Date: 13-6-26
 * Time: 下午3:12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Logger {
}
