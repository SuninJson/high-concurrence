package com.evan.highConcurrence;

import com.evan.highConcurrence.annotation.RoutingDataSource;
import com.evan.highConcurrence.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Evan Huang
 * @date 2018/10/8
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @RoutingDataSource
    public void list() {
        log.info("", userMapper.list());
    }
}
