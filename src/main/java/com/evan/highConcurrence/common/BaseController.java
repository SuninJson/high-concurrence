package com.evan.highConcurrence.common;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.evan.highConcurrence.annotation.RoutingDataSource;
import com.evan.highConcurrence.constant.DataSourceType;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Evan Huang
 * @date 2018/10/8
 */
@RestController
public class BaseController {

    private IService service;

    @GetMapping("/list")
    @RoutingDataSource(DataSourceType.MASTER_DB)
    public ResultObj list() {
        service = getService();
        return successReturn(service.list(null));
    }


    protected ResultObj successReturn() {
        return this.successReturn(null);
    }

    protected ResultObj successReturn(Object data) {
        return this.successReturn(data, "");
    }

    protected ResultObj successReturn(Object data, String msg) {
        if (null == data) {
            data = new JSONObject();
        }

        return new ResultObj(ErrorCode.UNION, data, msg, "");
    }

    protected IService getService() {
        return null;
    }

    public static void main(String[] args) {
        String path = ResolverUtil.Test.class.getResource("/").toString();
        System.out.println("path = " + path);
    }
}
