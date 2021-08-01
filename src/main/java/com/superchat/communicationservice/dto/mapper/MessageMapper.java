package com.superchat.communicationservice.dto.mapper;

import com.superchat.communicationservice.dto.MessageDTO;
import com.superchat.communicationservice.persistence.model.Message;

public class MessageMapper {
    public static MessageDTO toDto(Message entity) {
        MessageDTO dto = new MessageDTO();

        dto.setId(entity.getId());
        dto.setContactId(entity.getContact().getId());
        dto.setChannel(entity.getChannel());
        dto.setOrientation(entity.getOrientation());
        dto.setBody(entity.getBody());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }
}
