package net.javaguides.springbootkafkatutorial.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")

    public ResponseEntity<String> publish(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message send to the topic");
    }
}
