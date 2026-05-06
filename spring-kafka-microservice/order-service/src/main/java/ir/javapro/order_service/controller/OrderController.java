package ir.javapro.order_service.controller;

import ir.javapro.base_domain.dto.Order;
import ir.javapro.base_domain.dto.OrderEvent;
import ir.javapro.order_service.service.OrderProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderProducerService orderProducerService;
    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is PENDING");
        orderProducerService.sendMessage(orderEvent);
        return ResponseEntity.ok("Order created");
    }
}
