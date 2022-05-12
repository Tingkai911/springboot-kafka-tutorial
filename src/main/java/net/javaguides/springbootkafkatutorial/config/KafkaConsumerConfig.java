package net.javaguides.springbootkafkatutorial.config;

import java.util.HashMap;
import java.util.Map;
import net.javaguides.springbootkafkatutorial.model.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {
  @Value("${spring.kafka.consumer.string.bootstrap-servers}")
  private String stringServerUrl;

  @Value("${spring.kafka.consumer.string.group-id}")
  private String stringGroupId;

  @Value("${spring.kafka.consumer.string.auto-offset-reset}")
  private String stringAutoOffsetReset;

  @Value("${spring.kafka.consumer.user.bootstrap-servers}")
  private String userServerUrl;

  @Value("${spring.kafka.consumer.user.group-id}")
  private String userGroupId;

  @Value("${spring.kafka.consumer.user.auto-offset-reset}")
  private String userAutoOffsetReset;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, stringServerUrl);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, stringGroupId);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, stringAutoOffsetReset);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(props);
  }

  @Bean
  public ConsumerFactory<String, User> userConsumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, userServerUrl);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, userGroupId);
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, userAutoOffsetReset);
    props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(
        props, new StringDeserializer(), new JsonDeserializer<>(User.class));
  }

  // consume string data from kafka
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

  // consume user json object from kafka
  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, User> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(userConsumerFactory());
    return factory;
  }
}
