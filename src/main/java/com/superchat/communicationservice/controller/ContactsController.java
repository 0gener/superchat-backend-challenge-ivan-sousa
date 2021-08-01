package com.superchat.communicationservice.controller;

import javax.validation.Valid;

import com.superchat.communicationservice.controller.model.ContactCreateRequest;
import com.superchat.communicationservice.controller.model.ContactCreateResponse;
import com.superchat.communicationservice.controller.model.ContactListResponse;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contacts")
@Tag(name = "Contacts")
@RequiredArgsConstructor
public class ContactsController {
    @Autowired
    private ContactsService service;

    @Operation(summary = "Create a contact")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ContactCreateResponse> createContact(@Valid @RequestBody ContactCreateRequest body) {
        Contact contact = service.createContact(body);
        ContactCreateResponse responseEntity = new ContactCreateResponse(contact);

        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }

    @Operation(summary = "List contacts")
    @GetMapping(produces = "application/json")
    public ResponseEntity<ContactListResponse> listContacts(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Contact> list = service.listContacts(page, size);
        ContactListResponse responseEntity = new ContactListResponse(list);

        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }
}
