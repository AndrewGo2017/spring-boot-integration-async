package ru.lerning.springbootintegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.scheduling.annotation.Async;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = "channel1")
    void send1(MessageSource<?> message);

    @Gateway(requestChannel = "channel2")
    void send2(MessageSource<?> message);
}
