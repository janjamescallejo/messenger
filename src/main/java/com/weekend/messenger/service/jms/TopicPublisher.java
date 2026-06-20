package com.weekend.messenger.service.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicPublisher {
    private final JmsTemplate jmsTemplate;
    private final String topicName;

    public TopicPublisher(
            JmsTemplate jmsTemplate,
            String topicName) {

        this.jmsTemplate = jmsTemplate;
        this.topicName = topicName;

        // IMPORTANT: Publish to Topic
        this.jmsTemplate.setPubSubDomain(true);
    }

    public void publish(String message) {

        jmsTemplate.convertAndSend(
                topicName,
                message
        );

        System.out.println(
                "Published: " + message
        );
    }
}
