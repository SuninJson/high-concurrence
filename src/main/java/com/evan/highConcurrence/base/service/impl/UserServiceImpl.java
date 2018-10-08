package com.evan.highConcurrence.base.service.impl;

import com.evan.highConcurrence.base.entity.User;
import com.evan.highConcurrence.mapper.UserMapper;
import com.evan.highConcurrence.base.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Evan Huang
 * @since 2018-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
