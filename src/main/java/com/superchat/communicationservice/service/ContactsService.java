package com.superchat.communicationservice.service;

import com.superchat.communicationservice.dto.ContactDetailsDTO;
import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.data.domain.Page;

public interface ContactsService {
    public Contact createContact(ContactDetailsDTO contact);

    public Page<Contact> listContacts(int page, int size);
}
