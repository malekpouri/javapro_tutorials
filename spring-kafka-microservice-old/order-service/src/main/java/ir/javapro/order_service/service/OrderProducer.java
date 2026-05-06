package ir.javapro.order_service.service;


import ir.javapro.base_domain.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderProducer {
    private static Logger logger = Logger.getLogger(OrderProducer.class.getName());
    private static KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private static NewTopic orderTopic;
    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate, NewTopic orderTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderTopic = orderTopic;
    }

    public void sendOrderEvent(OrderEvent orderEvent) {
        logger.info("Sending order event: " + orderEvent);
        Message<OrderEvent> message=MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC,orderTopic.name())
                .build();
        kafkaTemplate.send(message);

    }
}
