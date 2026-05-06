package ir.javapro.springboot_kafka.service;

import ir.javapro.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    private final Logger logger = LoggerFactory.getLogger(JsonConsumer.class);

    @KafkaListener(topics = "java_pro_topic_json",groupId = "myGroup")
    public void consume(User user) {
        logger.info("Received Object -> ".concat(user.toString()));
    }
}
