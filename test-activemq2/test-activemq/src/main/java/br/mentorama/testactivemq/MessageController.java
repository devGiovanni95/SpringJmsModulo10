package br.mentorama.testactivemq;

import br.mentorama.testactivemq.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public void sendMessage(@RequestBody final Email email){
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", email);
    }

    @PostMapping("/topic")
    public void sendMessageTopic(@RequestBody final Email email){
        System.out.println("Sending an email message to topic.");
        jmsTemplate.convertAndSend("topic.mailbox", email);
    }
}
