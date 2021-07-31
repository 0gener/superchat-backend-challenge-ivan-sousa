package com.superchat.communicationservice.service;

import com.superchat.communicationservice.dto.MessageDetailsDTO;
import com.superchat.communicationservice.persistence.model.Message;

public interface MessagesService {
    public Message createMessage(String username, MessageDetailsDTO message);
}
