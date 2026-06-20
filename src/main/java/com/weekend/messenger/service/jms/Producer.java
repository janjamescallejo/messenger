package com.weekend.messenger.service.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private final JmsTemplate jmsTemplate;
    private final String queueName;

    public Producer(
            JmsTemplate jmsTemplate,
            String demoQueue) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = demoQueue;
    }

    public void sendMessage(String message) {

        jmsTemplate.convertAndSend(
                queueName,
                message
        );

        System.out.println(
                "Message Sent : " + message
        );
    }
}
