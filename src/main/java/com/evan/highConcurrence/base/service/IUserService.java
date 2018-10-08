package com.evan.highConcurrence.base.service;

import com.evan.highConcurrence.base.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Evan Huang
 * @since 2018-10-08
 */
public interface IUserService extends IService<User> {
    List<User> list();
}
