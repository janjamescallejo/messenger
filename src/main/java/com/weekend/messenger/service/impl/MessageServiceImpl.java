package com.weekend.messenger.service.impl;

import com.weekend.messenger.dto.MessageDTO;
import com.weekend.messenger.entity.Message;
import com.weekend.messenger.repository.MessageRepository;
import com.weekend.messenger.service.MessageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public List<Message> getMyMessages() {
        return messageRepository.findAll();
    }

    private WebClient webClient;

    @Override
    @Transactional
    public String sendMessage(MessageDTO messageDTO) {
        //save message to db
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setSender(messageDTO.getSender());
        message.setReceiver(messageDTO.getReceiver());
        message.setSentTime(LocalDateTime.now());
        Message sentMessage = messageRepository.save(message);
        System.out.println("Message ID sent: "+sentMessage.getId());

        webClient = WebClient.builder().baseUrl(messageDTO.getReceiver()).build();
        String response = webClient.get()
                .uri("/?id="+sentMessage.getId())
                .retrieve()
                .bodyToMono(String.class)
                        .block();

        return response;
    }

    @Override
    @Transactional
    public String receiveMessage(long id) {
        Message receivedMessage = messageRepository.getReferenceById(id);
        receivedMessage.setReceivedTime(LocalDateTime.now());
        messageRepository.save(receivedMessage);
        System.out.println(receivedMessage.getContent());
        return "Message Received";
    }


}
