package com.evan.highConcurrence.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 动态取出我们在切面中设置的数据源类型
 *
 * @author Evan Huang
 * @date 2018/9/6
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源为：{}", DataSourceHolder.getDB());
        return DataSourceHolder.getDB();
    }
}
