package ru.lerning.springbootintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.jdbc.JdbcMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class IntegrationService2 {

    @Autowired
    public DataSource dataSource;

    @ServiceActivator(inputChannel = "channel2", outputChannel = "channel3")
    public Message<?> anotherMessage(MessageSource<?> message) {
        return message.receive();
    }
}