package com.superchat.communicationservice.api;

import javax.validation.Valid;

import com.superchat.communicationservice.api.model.ContactCreateRequest;
import com.superchat.communicationservice.api.model.ContactCreateResponse;
import com.superchat.communicationservice.api.model.ContactListResponse;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contacts")
@RequiredArgsConstructor
public class ContactsController {
    @Autowired
    private ContactsService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ContactCreateResponse createContact(@RequestHeader("X-Username") String username,
            @Valid @RequestBody ContactCreateRequest body) {
        Contact contact = service.createContact(ContactsMapper.toEntity(username, body));

        return new ContactCreateResponse(contact);
    }

    @GetMapping(produces = "application/json")
    public ContactListResponse listContacts(@RequestHeader("X-Username") String username,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Contact> list = service.listContacts(username, page, size);

        return new ContactListResponse(list);
    }
}
