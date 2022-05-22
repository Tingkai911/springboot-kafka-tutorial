package net.javaguides.springbootkafkatutorial.event;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@AllArgsConstructor
public class WikimediaChangesHandler implements EventHandler {
  private KafkaTemplate<String, String> stringKafkaTemplate;
  private String topic;

  @Override
  public void onOpen() throws Exception {}

  @Override
  public void onClosed() throws Exception {}

  // read from wikimedia
  @Override
  public void onMessage(String s, MessageEvent messageEvent) throws Exception {
    log.info(String.format("event data -> %s", messageEvent.getData()));
    // write to kafka
    stringKafkaTemplate.send(topic, messageEvent.getData());
  }

  @Override
  public void onComment(String s) throws Exception {}

  @Override
  public void onError(Throwable throwable) {}
}
