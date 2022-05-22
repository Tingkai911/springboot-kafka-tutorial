package net.javaguides.springbootkafkatutorial.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.springbootkafkatutorial.event.WikimediaChangesHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class WikimediaKafkaProducer {
  private KafkaTemplate<String, String> stringKafkaTemplate;

  public void sendMessage() throws InterruptedException {
    String topic = "wikimedia_recent_change";

    // use event source to read real time stream data from wikimedia
    EventHandler eventHandler = new WikimediaChangesHandler(stringKafkaTemplate, topic);
    String url = "https://stream.wikimedia.org/v2/stream/recentchange";
    EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
    eventSource.start();

    // stop the event handler after 10 minutes
    TimeUnit.MINUTES.sleep(10);
  }
}
