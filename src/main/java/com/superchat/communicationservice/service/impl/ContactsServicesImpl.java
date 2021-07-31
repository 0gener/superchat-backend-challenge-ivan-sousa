package com.superchat.communicationservice.service.impl;

import com.superchat.communicationservice.dto.ContactDetailsDTO;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.repository.ContactRepository;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactsServicesImpl implements ContactsService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(String username, ContactDetailsDTO contact) {
        return contactRepository.save(ContactsMapper.toEntity(username, contact));
    }

    @Override
    public Page<Contact> listContacts(String username, int page, int size) {
        return contactRepository.findAllByUsername(username, PageRequest.of(page, size));
    }
}
