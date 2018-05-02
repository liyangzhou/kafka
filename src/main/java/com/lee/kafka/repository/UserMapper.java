package com.lee.kafka.repository;

import com.lee.kafka.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author yz.li
 * @date 2018/4/28
 */
@Mapper
public interface UserMapper {

    /**
     *
     * @param user
     * @return
     */
    int insertUser(User user);
}
