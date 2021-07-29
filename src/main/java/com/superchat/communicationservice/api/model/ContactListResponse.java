package com.superchat.communicationservice.api.model;

import com.superchat.communicationservice.dto.ContactDTO;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.data.domain.Page;

public class ContactListResponse extends ListResponse<ContactDTO, Contact> {
    public ContactListResponse(Page<Contact> page) {
        super(page);
    }

    @Override
    public ContactDTO convert(Contact item) {
        return ContactsMapper.toDto(item);
    }
}
