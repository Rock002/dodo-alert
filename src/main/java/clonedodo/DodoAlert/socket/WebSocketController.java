package clonedodo.DodoAlert.socket;

import clonedodo.DodoAlert.models.entity.User;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendKafkaMessage(String user) {
        simpMessagingTemplate.convertAndSend("/topic/messages", user);
    }
}
