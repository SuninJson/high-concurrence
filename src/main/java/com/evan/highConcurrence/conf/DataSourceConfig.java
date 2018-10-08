package com.evan.highConcurrence.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.evan.highConcurrence.constant.DataSourceType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author Evan Huang
 * @date 2018/9/6
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = DataSourceType.MASTER_DB)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = DataSourceType.SLAVE_DB)
    @ConfigurationProperties(prefix = "spring.datasource-slave")
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
}
