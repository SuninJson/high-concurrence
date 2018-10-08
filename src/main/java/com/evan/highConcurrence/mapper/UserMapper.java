package com.evan.highConcurrence.mapper;

import com.evan.highConcurrence.base.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Evan Huang
 * @since 2018-10-08
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> list();
}
