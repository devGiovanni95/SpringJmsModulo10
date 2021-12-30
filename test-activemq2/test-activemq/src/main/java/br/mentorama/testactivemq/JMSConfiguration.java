package br.mentorama.testactivemq;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;


import javax.jms.ConnectionFactory;

@Configuration
public class JMSConfiguration {

    //filas
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer,
                                                    JmsErrorHandler jmsErrorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setErrorHandler(jmsErrorHandler);
        //This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        //You could still override some of Boot's defaults if necessary.
        return factory;
    }

    //topicos
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory,
                                                                DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        //This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        //You could still override some of Boot's defaults if necessary.
        return factory;
    }

    @Bean//Serialize message content toMessageConverter json using TextMessage
    public MessageConverter jacksonJmsMessageConverter(){
      MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }



}
