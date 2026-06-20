package com.weekend.messenger.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${app.queue-name}")
    public void receiveMessage(String message) throws Exception {

        Thread.sleep(5000);
        System.out.println(
                "Message Received : " + message
        );
    }
}
