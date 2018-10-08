package com.evan.highConcurrence.annotation;

import com.evan.highConcurrence.constant.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Evan Huang
 * @date 2018/9/4
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.METHOD
})
public @interface RoutingDataSource {
    String value() default DataSourceType.MASTER_DB;
}
