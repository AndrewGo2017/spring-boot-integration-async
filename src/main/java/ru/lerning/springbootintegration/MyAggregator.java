package ru.lerning.springbootintegration;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.CorrelationStrategy;
import org.springframework.integration.annotation.ReleaseStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyAggregator {

    @Aggregator(inputChannel = "channel3", outputChannel = "channel4")
    public List<Message<?>> aggregatingMethod(List<Message<?>> items) {
        return items;
    }

    @ReleaseStrategy
    public boolean releaseChecker(List<Message<?>> messages) {
        return messages.size() == 2;
    }

    @CorrelationStrategy
    public String correlateBy(Message<?> item) {
        return "1";
    }
}
