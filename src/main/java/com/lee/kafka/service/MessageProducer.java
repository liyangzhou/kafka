package com.lee.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author yz.li
 * @date 2018/4/25
 */
@Component
public class MessageProducer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, String key, String data) {
        System.out.println("start send ......");
        kafkaTemplate.send(topic, key, data);
        System.out.println("end send ......");
    }

}
