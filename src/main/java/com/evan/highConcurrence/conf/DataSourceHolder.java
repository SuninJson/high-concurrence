package com.evan.highConcurrence.conf;

import com.evan.highConcurrence.constant.DataSourceType;
import lombok.extern.slf4j.Slf4j;

/**
 * 使用ThreadLocal安全管理当前进程使用的数据
 *
 * @author Evan Huang
 * @date 2018/9/6
 */
@Slf4j
public class DataSourceHolder {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DATA_SOURCE = DataSourceType.MASTER_DB;

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DataSourceHolder() {

    }

    public static void setDB(String dbType) {
        contextHolder.set(dbType);
        log.info("切换到数据源：{}", dbType);
    }

    public static String getDB() {
        return contextHolder.get();
    }

    public static void clearDB() {
        contextHolder.remove();
    }

}
