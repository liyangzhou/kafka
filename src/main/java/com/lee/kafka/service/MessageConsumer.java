package com.lee.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.internals.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author yz.li
 * @date 2018/4/25
 */
@Component
public class MessageConsumer {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = {"lee"})
    public void messageConsumer(ConsumerRecord<?, ?> record) {
        logger.debug("consumer msg is [{}]", record.value());
        System.out.println("XXXXXXX consumer msg is [" + record.value() + "]");
    }
}
