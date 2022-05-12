package net.javaguides.springbootkafkatutorial.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaConsumer {
  @KafkaListener(
      topics = "string",
      groupId = "myGroup",
      containerFactory = "kafkaListenerContainerFactory")
  public void consumeMessage(String message) {
    log.info(String.format("Message received -> %s", message));
  }

  @KafkaListener(
      topics = "user",
      groupId = "myGroup",
      containerFactory = "userKafkaListenerContainerFactory")
  public void consumeUser(User user) {
    log.info(String.format("User received -> %s", user));
  }
}
