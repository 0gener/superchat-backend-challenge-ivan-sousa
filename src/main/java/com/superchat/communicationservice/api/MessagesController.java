package com.superchat.communicationservice.api;

import javax.validation.Valid;

import com.superchat.communicationservice.api.model.MessageCreateRequest;
import com.superchat.communicationservice.api.model.MessageCreateResponse;
import com.superchat.communicationservice.service.MessagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/messages")
@RequiredArgsConstructor
public class MessagesController {
    @Autowired
    private MessagesService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public MessageCreateResponse createMessage(@Valid @RequestBody MessageCreateRequest body) {
        return null;
    }

    @GetMapping(produces = "application/json")
    public void listMessages() {

    }
}
