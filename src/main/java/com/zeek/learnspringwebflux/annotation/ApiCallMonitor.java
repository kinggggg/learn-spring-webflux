package com.zeek.learnspringwebflux.annotation;

import java.lang.annotation.*;

/**
 * @author: liweibo
 * @since: 2020-10-14 11:24 下午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiCallMonitor {
}
