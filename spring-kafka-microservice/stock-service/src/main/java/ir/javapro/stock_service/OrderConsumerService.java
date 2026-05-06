package ir.javapro.stock_service;

import ir.javapro.base_domain.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {
    private static final Logger log = LoggerFactory.getLogger(OrderConsumerService.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent) {
        log.info("Consumed OrderEvent: " + orderEvent);

        // save to database
    }
}
