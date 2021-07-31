package com.superchat.communicationservice.dto.mapper;

import com.superchat.communicationservice.dto.MessageDTO;
import com.superchat.communicationservice.persistence.model.Message;

public class MessageMapper {
    public static Message toEntity(MessageDTO dto) {
        return new Message(null, dto.getBody(), null);
    }

    public static MessageDTO toDto(Message entity) {
        MessageDTO dto = new MessageDTO();

        dto.setId(entity.getId());
        dto.setContactId(entity.getContact().getId());
        dto.setBody(entity.getReplacedBody());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }
}
