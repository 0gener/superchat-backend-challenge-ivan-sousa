package com.superchat.communicationservice.service.impl;

import com.superchat.communicationservice.dto.ContactDetailsDTO;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.repository.ContactRepository;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactsServiceImpl implements ContactsService {
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(ContactDetailsDTO contact) {
        return contactRepository.save(ContactsMapper.toEntity(contact));
    }

    @Override
    public Page<Contact> listContacts(int page, int size) {
        return contactRepository.findAll(PageRequest.of(page, size));
    }
}
