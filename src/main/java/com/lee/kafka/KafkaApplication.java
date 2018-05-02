package com.lee.kafka;

import com.lee.kafka.service.MessageProducer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

		/*MessageProducer sender = context.getBean(MessageProducer.class);
		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send("lee", "key1", "data" + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
	}
}
