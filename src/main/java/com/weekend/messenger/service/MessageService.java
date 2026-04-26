package com.weekend.messenger.service;

import com.weekend.messenger.dto.MessageDTO;
import com.weekend.messenger.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getMyMessages();
    public String sendMessage(MessageDTO messageDTO);

    public String receiveMessage(long id);
}
