package com.superchat.communicationservice.api.model;

import com.superchat.communicationservice.dto.ContactDTO;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;

import lombok.Getter;

@Getter
public class ContactCreateResponse {
    private ContactDTO item;

    public ContactCreateResponse(Contact entity) {
        this.item = ContactsMapper.toDto(entity);
    }
}
