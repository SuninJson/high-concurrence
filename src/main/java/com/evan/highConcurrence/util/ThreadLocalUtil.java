package com.evan.highConcurrence.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {
    private static final ThreadLocal<Map<String, Object>> dataMapThreadLocal = new ThreadLocal();
    public static final String REQUEST_URI = "requestUrl";
    private static final String REQUEST_METHOD = "requestMethod";
    private static final String REQUEST_ID = "requestId";
    private static final String JWT_DATA = "jwtData";
    private static final String IP = "ip";
    private static final String MAC = "mac";
    private static final String REQ_EXTEND_INFO = "request_extend_info";
    public static final String EXTEND_FIELDS = "extendFields";
    public static final String CUSTOM_QUERY_CONDITION = "customQueryCondition";
    public static final String DATA_PRIVILEGE_SHOW = "dataPrivilegeShow";

    public ThreadLocalUtil() {
    }

    private static Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = (Map) dataMapThreadLocal.get();
        if (dataMap == null) {
            dataMap = new HashMap();
            dataMapThreadLocal.set(dataMap);
        }

        return (Map) dataMap;
    }

    public static void clear() {
        getDataMap().clear();
    }

    public static Object set(String key, Object value) {
        return getDataMap().put(key, value);
    }

    public static <T> T get(String key) {
        return (T) getDataMap().get(key);
    }

    public static String getRequestId() {
        return (String) get("requestId");
    }
}