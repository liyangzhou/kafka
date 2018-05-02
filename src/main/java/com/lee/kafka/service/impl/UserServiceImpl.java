package com.lee.kafka.service.impl;

import com.lee.kafka.model.User;
import com.lee.kafka.repository.UserMapper;
import com.lee.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yz.li
 * @date 2018/4/28
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
