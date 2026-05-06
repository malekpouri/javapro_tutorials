package ir.javapro.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic wikimediaTopic() {
        return new NewTopic("wikimedia", 2, (short) 1);
    }
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
