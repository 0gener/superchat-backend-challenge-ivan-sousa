package com.superchat.communicationservice.controller.model;

import com.superchat.communicationservice.dto.ContactDTO;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;

import lombok.Getter;

@Getter
public class ContactCreateResponse extends ItemResponse<ContactDTO, Contact> {
    public ContactCreateResponse(Contact entity) {
        super(entity);
    }

    @Override
    public ContactDTO convert(Contact entity) {
        return ContactsMapper.toDto(entity);
    }
}
