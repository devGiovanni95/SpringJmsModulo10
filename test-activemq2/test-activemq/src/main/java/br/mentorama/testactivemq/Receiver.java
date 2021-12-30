package br.mentorama.testactivemq;

import br.mentorama.testactivemq.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    //Receiver message of List
    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void  receiveMessage(Email email){
        if (email.getTo() == null || email.getBody() == null){
            throw new RuntimeException("Invalid email");
        }
        System.out.println("Received email from queue<" + email +">");
    }

    //Receiver message of Topic
    @JmsListener(destination = "topic.mailbox", containerFactory = "topicListenerFactory")
    public void receivedMessageFromTopic(Email email){
        System.out.println("Received email from topic<" + email +">");
    }
}
