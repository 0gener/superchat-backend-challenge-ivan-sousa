package com.superchat.communicationservice.api.contacts;

import javax.validation.Valid;

import com.superchat.communicationservice.api.contacts.model.CreateContactRequest;
import com.superchat.communicationservice.api.contacts.model.ListContactsResponse;
import com.superchat.communicationservice.service.ContactsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/contacts")
@RequiredArgsConstructor
public class ContactsController {
    private ContactsService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createContact(@Valid @RequestBody CreateContactRequest body) {
        service.createContact();
    }

    @GetMapping(produces = "application/json")
    public ListContactsResponse listContacts(@RequestParam("page") int page, @RequestParam("size") int size) {
        service.listContacts();

        return null;
    }
}
