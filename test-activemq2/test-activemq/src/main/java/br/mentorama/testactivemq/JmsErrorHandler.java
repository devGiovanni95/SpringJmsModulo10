package br.mentorama.testactivemq;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;
@Component
public class  JmsErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        System.out.println("Error processing message " + t.getMessage());

    }
}
