package com.superchat.communicationservice.mapper;

import com.superchat.communicationservice.api.contacts.model.ContactDTO;
import com.superchat.communicationservice.data.model.Contact;

public class ContactsMapper {
    public static Contact dtoToEntity(ContactDTO dto) {
        return new Contact(dto.getName(), dto.getEmail(), dto.getPhoneNumber());
    }
}
