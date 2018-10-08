package com.evan.highConcurrence.base.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.evan.highConcurrence.annotation.RoutingDataSource;
import com.evan.highConcurrence.base.service.IUserService;
import com.evan.highConcurrence.common.BaseController;
import com.evan.highConcurrence.common.ResultObj;
import com.evan.highConcurrence.constant.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Evan Huang
 * @since 2018-10-08
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Override
    @RoutingDataSource(DataSourceType.SLAVE_DB)
    public ResultObj list() {
        return successReturn(userService.list());
    }

    @Override
    protected IService getService() {
        return userService;
    }
}
