package ir.javapro.service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WikimediaService {
    private static final Logger logger = LoggerFactory.getLogger(WikimediaService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final WebClient webClient;

    public WikimediaService(KafkaTemplate<String, String> kafkaTemplate, WebClient.Builder webClient) {
        this.kafkaTemplate = kafkaTemplate;
        this.webClient = webClient.baseUrl("https://stream.wikimedia.org/v2").build();
    }
    @PostConstruct
    public void startPublishing() {
        logger.info("Starting Wikimedia publishing");
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(event ->{
                    logger.info("Received event: " + event);
                    kafkaTemplate.send("wikimedia", event);
                })
                .doOnError(error -> {
                    logger.error(error.getMessage());
                })
                .subscribe();
    }
}
