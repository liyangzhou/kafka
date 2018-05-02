package com.lee.kafka.service.impl;

import com.lee.kafka.KafkaApplication;
import com.lee.kafka.model.User;
import com.lee.kafka.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author yz.li
 * @date 2018/4/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaApplication.class)
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("Tom");
        user.setAddress("上海");

        this.userService.insertUser(user);
    }


}