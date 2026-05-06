package ir.javapro.springboot_kafka.service;

import ir.javapro.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private final Logger logger = LoggerFactory.getLogger(JsonProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User user) {
        logger.info("Sending user: {}", user.toString());

        kafkaTemplate.send("java_pro_topic_json", user);
    }

}
