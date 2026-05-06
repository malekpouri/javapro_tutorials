package ir.javapro.order_service.service;

import ir.javapro.base_domain.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {
    private static final Logger logger = LoggerFactory.getLogger(OrderProducerService.class);
    private final NewTopic orderTopic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducerService(NewTopic orderTopic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.orderTopic = orderTopic;
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(OrderEvent orderEvent) {
        logger.info("Sending order event: " + orderEvent);
        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC,orderTopic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
