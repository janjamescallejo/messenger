package com.weekend.messenger;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
@EnableEncryptableProperties
public class MessengerApplication {


    public static void main(String[] args) {

        SpringApplication.run(MessengerApplication.class, args);
    }

}
