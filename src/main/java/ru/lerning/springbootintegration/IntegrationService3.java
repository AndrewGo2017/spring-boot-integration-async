package ru.lerning.springbootintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.jdbc.JdbcMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class IntegrationService3 {

    @Autowired
    private DataSource dataSource;

    @ServiceActivator(inputChannel = "channel4")
    public void anotherMessage(List<Message<?>> receives) {
        receives.forEach( receive -> {
            JdbcMessageHandler jdbcMessageHandler = new JdbcMessageHandler(dataSource, "insert into account_1 (id , amount, currency) values (:payload[id_account], :payload[amount], :payload[currency]  )");
            jdbcMessageHandler.afterPropertiesSet();
            jdbcMessageHandler.handleMessage(receive);
        });
    }
}