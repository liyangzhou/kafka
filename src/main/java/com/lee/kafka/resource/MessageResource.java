package com.lee.kafka.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yz.li
 * @date 2018/4/25
 */
@Api("Kafka Message")
@RestController
@RequestMapping("message")
public class MessageResource {
    private static Logger logger = LoggerFactory.getLogger(MessageResource.class);

    @Autowired
    private KafkaTemplate template;

    @ApiOperation("send msg")
    @PostMapping("send")
    public ResponseEntity send(String topic, String key, String data) {
        ListenableFuture send = this.template.send(topic, key, data);
        if (send.isDone()) {
            System.out.println("send success");
            System.out.println(send.toString());
        }
        return ResponseEntity.ok("OK");
    }

}
