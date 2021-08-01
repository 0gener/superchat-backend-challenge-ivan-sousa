package com.superchat.communicationservice.dto.mapper;

import com.superchat.communicationservice.dto.ContactDTO;
import com.superchat.communicationservice.dto.ContactDetailsDTO;
import com.superchat.communicationservice.persistence.model.Contact;

public class ContactsMapper {
    public static Contact toEntity(ContactDetailsDTO dto) {
        return new Contact(dto.getName(), dto.getEmail(), dto.getPhoneNumber());
    }

    public static ContactDTO toDto(Contact entity) {
        ContactDTO dto = new ContactDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }
}
