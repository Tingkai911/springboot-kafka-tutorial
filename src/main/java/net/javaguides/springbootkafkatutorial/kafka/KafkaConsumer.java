package net.javaguides.springbootkafkatutorial.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {

    // subscribe to the "javaguides" java topic
    // groupId same as application.yml
    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message) {
        log.info(String.format("Message received -> %s", message));
    }
}
