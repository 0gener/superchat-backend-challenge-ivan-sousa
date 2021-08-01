package com.superchat.communicationservice.service;

import com.superchat.communicationservice.dto.MessageDetailsDTO;
import com.superchat.communicationservice.persistence.model.Message;

import org.springframework.data.domain.Page;

public interface MessagesService {
    public Message createMessage(MessageDetailsDTO dto);

    public Page<Message> listMessages(Long contactId, int page, int size);

    public Message receiveMessage(MessageDetailsDTO dto);
}
