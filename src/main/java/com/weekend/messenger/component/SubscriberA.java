package com.weekend.messenger.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriberA {

    @JmsListener(
            destination = "${app.topic-name}",
            containerFactory = "topicListenerFactory"
    )
    public void receive(String message) {

        System.out.println(
                "[Subscriber A] Received: " + message
        );
    }
}
