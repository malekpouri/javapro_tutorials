package ir.javapro.service;

import ir.javapro.entity.WikimediaEntity;
import ir.javapro.repository.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    private final WikimediaRepository WikimediaRepository;
    public ConsumerService(WikimediaRepository WikimediaRepository) {
        this.WikimediaRepository = WikimediaRepository;
    }
    @KafkaListener(
            topics = "wikimedia",
            groupId = "myGroup"
    )
    public void listen(String eventMessage) {
        logger.info(String.format("Received '%s'", eventMessage));
        WikimediaEntity wikimediaEntity=new WikimediaEntity();
        wikimediaEntity.setData(eventMessage);
        WikimediaRepository.save(wikimediaEntity);
    }
}
