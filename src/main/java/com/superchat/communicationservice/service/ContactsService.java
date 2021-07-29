package com.superchat.communicationservice.service;

import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.data.domain.Page;

public interface ContactsService {
    public Contact createContact(Contact contact);

    public Page<Contact> listContacts(String username, int page, int size);
}
