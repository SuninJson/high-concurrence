package com.evan.highConcurrence.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.evan.highConcurrence.util.ThreadLocalUtil;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ResultObj {
    public static final int SUCCESS = 200;
    public static final int NOT_MODIFIED = 304;
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int ERROR = 500;
    private int code;
    private String codeDetail;
    private Object data;
    private String msg;
    private String msgDetail;
    private String moreInfo;
    private String requestId;

    public ResultObj() {
        this(200, (Object) null, (String) null, (String) null, (String) null, (String) null);
    }

    public ResultObj(int code, Object data, String msg, String msgDetail) {
        this(code, data, msg, msgDetail, (String) null, (String) null);
    }

    public ResultObj(int code, Object data, String msg, Exception exception) {
        this(code, data, msg, getDetailMsg(exception), (String) null, (String) null);
    }

    public ResultObj(int code, Object data, String msg, String msgDetail, String codeDetail, String moreInfo) {
        this.code = 200;
        this.codeDetail = "";
        this.data = null;
        this.msg = "";
        this.msgDetail = "";
        this.moreInfo = "";
        this.requestId = "";
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.msgDetail = msgDetail;
        this.codeDetail = codeDetail;
        this.moreInfo = moreInfo;
        this.requestId = ThreadLocalUtil.getRequestId();
    }

    public String getCodeDetail() {
        return this.codeDetail;
    }

    public Object getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getMsgDetail() {
        return this.msgDetail;
    }

    public String getMoreInfo() {
        return this.moreInfo;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public static String getStackMsg(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

    private static String getDetailMsg(Exception e) {
        return ThreadLocalUtil.get("requestUrl") + "\n" + getStackMsg(e);
    }

    public ResultObj setData(String key, Object value) {
        if (!(this.data instanceof JSONObject)) {
            this.data = JSONObject.parseObject(JSON.toJSONString(this.data));
        }

        ((JSONObject) this.data).put(key, value);
        return this;
    }
}