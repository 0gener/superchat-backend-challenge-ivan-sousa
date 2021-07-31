package com.superchat.communicationservice.api.model;

import com.superchat.communicationservice.dto.MessageDTO;
import com.superchat.communicationservice.dto.mapper.MessageMapper;
import com.superchat.communicationservice.persistence.model.Message;

public class MessageCreateResponse extends ItemResponse<MessageDTO, Message> {
    public MessageCreateResponse(Message entity) {
        super(entity);
    }

    @Override
    public MessageDTO convert(Message entity) {
        return MessageMapper.toDto(entity);
    }
}
