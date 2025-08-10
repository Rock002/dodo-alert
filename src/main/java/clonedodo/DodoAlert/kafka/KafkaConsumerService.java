package clonedodo.DodoAlert.kafka;

import clonedodo.DodoAlert.models.dto.UserDto;
import clonedodo.DodoAlert.models.entity.Food;
import clonedodo.DodoAlert.models.entity.User;
import clonedodo.DodoAlert.socket.WebSocketController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumerService {

    private final WebSocketController webSocketController;

    public KafkaConsumerService(WebSocketController webSocketController) {
        this.webSocketController = webSocketController;
    }

    @KafkaListener(topics = "topicMessage", groupId = "messagesConsumer")
    public void listener(String order) {
        System.out.println(order.trim());
        webSocketController.sendKafkaMessage(order);
    }
}
