package com.evan.highConcurrence.conf;

import com.evan.highConcurrence.annotation.RoutingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 通过编写切面，对所有我们加上自定义切库注解的方法进行拦截，动态的选择数据源
 *
 * @author Evan Huang
 * @date 2018/9/6
 */
@Aspect
@Component
@Slf4j
public class DynamicDataSourceAspect {

    @Before("@annotation(com.evan.highConcurrence.annotation.RoutingDataSource)")
    public void beforeSwitchDataSource(JoinPoint point) {
        //获得当前访问class
        Class<?> targetClass = point.getTarget().getClass();

        //获取访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的各参数类型
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();

        String dataSource = DataSourceHolder.DEFAULT_DATA_SOURCE;

        try {
            Method method = targetClass.getMethod(methodName, parameterTypes);

            //判断是否存在注解<@RoutingDataSource>
            if (method.isAnnotationPresent(RoutingDataSource.class)) {
                RoutingDataSource annotation = method.getAnnotation(RoutingDataSource.class);
                dataSource = annotation.value();
            }

        } catch (Exception e) {
            log.info("Routing data source exception:{}->{}", methodName, e);
        }

        //切库
        DataSourceHolder.setDB(dataSource);

    }

    @After("@annotation(com.evan.highConcurrence.annotation.RoutingDataSource)")
    public void afterSwitchDataSource() {
        DataSourceHolder.clearDB();
    }

}
