package com.evan.highConcurrence.conf;

import com.evan.highConcurrence.constant.DataSourceType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Evan Huang
 * @date 2018/9/6
 */
@Configuration
@MapperScan(basePackages = {"com.evan.highConcurrence.mapper"})
public class MybatisConfig {

    @Autowired
    @Qualifier(DataSourceType.MASTER_DB)
    private DataSource masterDB;

    @Autowired
    @Qualifier(DataSourceType.SLAVE_DB)
    private DataSource slaveDB;

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDB);

        HashMap<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DataSourceType.MASTER_DB, masterDB);
        dataSourceMap.put(DataSourceType.SLAVE_DB, slaveDB);

        dynamicDataSource.setTargetDataSources(dataSourceMap);

        return dynamicDataSource;
    }

    @Bean
    @ConfigurationProperties(prefix = "mybatis-plus")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource());
        return bean;
    }

}
