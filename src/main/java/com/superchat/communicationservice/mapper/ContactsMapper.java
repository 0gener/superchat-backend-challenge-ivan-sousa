package com.superchat.communicationservice.mapper;

import com.superchat.communicationservice.api.contacts.model.ContactDetailsDTO;
import com.superchat.communicationservice.data.model.Contact;

public class ContactsMapper {
    public static Contact dtoToEntity(ContactDetailsDTO dto) {
        return new Contact(dto.getName(), dto.getEmail(), dto.getPhoneNumber());
    }
}
