package com.lee.kafka.resource;

import com.lee.kafka.model.User;
import com.lee.kafka.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yz.li
 * @date 2018/4/25
 */
@Api("Kafka Message")
@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService userService;

    @ApiOperation("insert user")
    @PostMapping()
    public ResponseEntity send(@RequestBody User user) {
        this.userService.insertUser(user);
        return ResponseEntity.ok("OK");
    }

}
