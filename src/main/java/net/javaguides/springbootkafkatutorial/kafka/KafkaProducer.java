package net.javaguides.springbootkafkatutorial.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate; // springboot provide auto config for kafka template

    public void sendMessage(String message) {
        log.info(String.format("Message send %s", message));

        // same topic name as KafkaTopicConfig
        kafkaTemplate.send("javaguides", message);
    }
}
