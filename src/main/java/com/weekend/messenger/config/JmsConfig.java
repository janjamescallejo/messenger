package com.weekend.messenger.config;

import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
public class JmsConfig {
    @Value("${app.queue-name}")
    private String queueName;

    @Bean
    public String demoQueue() {
        return queueName;
    }

    @Value("${app.topic-name}")
    private String topicName;

    @Bean
    public String topicName() {
        return topicName;
    }

    @Bean
    public DefaultJmsListenerContainerFactory topicListenerFactory(
            ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);

        // IMPORTANT: Use Topic mode
        factory.setPubSubDomain(true);

        return factory;
    }
}
