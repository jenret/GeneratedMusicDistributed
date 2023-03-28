package io.swagger.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SongUpdateProducer {
    @Value("songupdate")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SongUpdateProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
