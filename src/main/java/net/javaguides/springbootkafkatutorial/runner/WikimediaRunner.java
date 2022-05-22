package net.javaguides.springbootkafkatutorial.runner;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.kafka.WikimediaKafkaProducer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class WikimediaRunner implements ApplicationRunner {
  private WikimediaKafkaProducer wikimediaKafkaProducer;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    wikimediaKafkaProducer.sendMessage();
  }
}
