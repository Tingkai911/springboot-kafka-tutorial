package net.javaguides.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    // create a new topic
    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name("javaguides")
                .build();
    }
}
