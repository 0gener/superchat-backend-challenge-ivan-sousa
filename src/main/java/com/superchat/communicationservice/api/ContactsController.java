package com.superchat.communicationservice.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.superchat.communicationservice.dto.ContactDTO;
import com.superchat.communicationservice.dto.ContactDetailsDTO;
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
    public ContactDTO createContact(@RequestHeader("X-Username") String username,
            @Valid @RequestBody ContactDetailsDTO body) {
        Contact contact = service.createContact(ContactsMapper.toEntity(username, body));

        return ContactsMapper.toDto(contact);
    }

    @GetMapping(produces = "application/json")
    public Page<Contact> listContacts(@RequestHeader("X-Username") String username,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Contact> list = service.listContacts(username, page, size);

        return list;
    }
}
