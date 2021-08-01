package com.superchat.communicationservice.controller.model;

import com.superchat.communicationservice.dto.MessageDTO;
import com.superchat.communicationservice.dto.mapper.MessageMapper;
import com.superchat.communicationservice.persistence.model.Message;

public class MessageReceiveResponse extends ItemResponse<MessageDTO, Message> {
    public MessageReceiveResponse(Message entity) {
        super(entity);
    }

    @Override
    public MessageDTO convert(Message entity) {
        return MessageMapper.toDto(entity);
    }
}