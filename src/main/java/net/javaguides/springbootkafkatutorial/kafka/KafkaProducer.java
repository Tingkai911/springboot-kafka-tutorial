package net.javaguides.springbootkafkatutorial.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.model.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {
  private KafkaTemplate<String, String> stringKafkaTemplate;
  private KafkaTemplate<String, User> userKafkaTemplate;

  public void sendMessage(String message) {
    log.info(String.format("Message send %s", message));
    stringKafkaTemplate.send("string", message);
  }

  public void sendUser(User user) {
    log.info(String.format("User send %s", user));
    userKafkaTemplate.send("user", user);
  }
}
