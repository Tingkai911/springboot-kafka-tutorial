package net.javaguides.springbootkafkatutorial.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.kafka.KafkaProducer;
import net.javaguides.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/kafka/publish")
public class SendToKafkaController {
  private KafkaProducer kafkaProducer;

  @GetMapping("/string")
  public ResponseEntity<String> publishString(@RequestParam String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message send to the topic");
  }

  @PostMapping("/user")
  public ResponseEntity<String> publishUser(@RequestBody User user) {
    kafkaProducer.sendUser(user);
    return ResponseEntity.ok("User send to the topic");
  }
}
