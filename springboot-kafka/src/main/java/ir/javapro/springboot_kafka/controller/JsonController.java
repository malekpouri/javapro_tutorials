package ir.javapro.springboot_kafka.controller;

import ir.javapro.springboot_kafka.payload.User;
import ir.javapro.springboot_kafka.service.JsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {

    private final JsonProducer jsonProducer;
    public JsonController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("{\"message send \": \"" + user.toString() + "\"}");
    }
}
