package com.superchat.communicationservice.api.model;

import com.superchat.communicationservice.dto.MessageDTO;
import com.superchat.communicationservice.dto.mapper.MessageMapper;
import com.superchat.communicationservice.persistence.model.Message;

import org.springframework.data.domain.Page;

public class MessageListResponse extends ListResponse<MessageDTO, Message> {
    public MessageListResponse(Page<Message> page) {
        super(page);
    }

    @Override
    public MessageDTO convert(Message item) {
        return MessageMapper.toDto(item);
    }
}
