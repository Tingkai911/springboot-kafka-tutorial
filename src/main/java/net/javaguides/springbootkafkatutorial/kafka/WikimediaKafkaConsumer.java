package net.javaguides.springbootkafkatutorial.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class WikimediaKafkaConsumer {
  @KafkaListener(
      topics = "wikimedia_recent_change",
      groupId = "myGroup",
      containerFactory = "kafkaListenerContainerFactory")
  public void consumer(String message) {
    log.info(String.format("event message received -> %s", message));
  }
}
