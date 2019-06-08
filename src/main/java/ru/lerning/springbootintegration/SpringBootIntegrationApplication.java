package ru.lerning.springbootintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
public class SpringBootIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationApplication.class, args);
    }

    @Autowired
    public IntegrationGateway integrationGateway;

    @Bean
    public CommandLineRunner runner(DataSource dataSource) {
        return args -> {
            JdbcPollingChannelAdapter jdbcPollingChannelAdapter = new JdbcPollingChannelAdapter(dataSource, "select * from account");
            integrationGateway.send1(jdbcPollingChannelAdapter);
            integrationGateway.send2(jdbcPollingChannelAdapter);
        };
    }

}