package com.superchat.communicationservice.service;

import com.superchat.communicationservice.data.model.Contact;

import org.springframework.data.domain.Page;

public interface ContactsService {
    public Contact createContact(Contact contact);

    public Page<Contact> listContacts(int page, int size);
}
