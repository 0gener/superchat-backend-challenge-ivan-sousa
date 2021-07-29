package com.superchat.communicationservice.service.impl;

import com.superchat.communicationservice.data.model.Contact;
import com.superchat.communicationservice.data.repository.ContactRepository;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactsServicesImpl implements ContactsService {
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Page<Contact> listContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page, size));
    }
}
