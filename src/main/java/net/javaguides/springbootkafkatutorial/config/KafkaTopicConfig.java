package net.javaguides.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
  // to send and receive string
  @Bean
  @Primary
  public NewTopic stringTopic() {
    return TopicBuilder.name("string").build();
  }

  // to send and receive user json object
  @Bean
  public NewTopic userTopic() {
    return TopicBuilder.name("user").build();
  }

  // wikimedia recent change example
  @Bean
  public NewTopic wikimediaTopic() {
    return TopicBuilder.name("wikimedia_recent_change").build();
  }
}
