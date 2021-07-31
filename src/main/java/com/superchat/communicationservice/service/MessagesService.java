package com.superchat.communicationservice.service;

import com.superchat.communicationservice.dto.MessageDetailsDTO;
import com.superchat.communicationservice.persistence.model.Message;

import org.springframework.data.domain.Page;

public interface MessagesService {
    public Message sendMessage(String username, MessageDetailsDTO message);

    public Page<Message> listMessages(String username, Long contactId, int page, int size);
}
