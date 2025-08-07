package clonedodo.DodoAlert.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topicMessage", groupId = "messagesConsumer")
    public void lListener(String username) {
        System.out.println(username);
    }
}
