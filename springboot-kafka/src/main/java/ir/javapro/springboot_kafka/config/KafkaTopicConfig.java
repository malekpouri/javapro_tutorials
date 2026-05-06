package ir.javapro.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic java_pro_topic() {
        return new NewTopic("java_pro_topic", 2, (short) 1);
    }
    @Bean
    public NewTopic java_pro_topic_json() {
        return new NewTopic("java_pro_topic_json", 2, (short) 1);
    }

}
