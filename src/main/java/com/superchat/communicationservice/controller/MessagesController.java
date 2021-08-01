package com.superchat.communicationservice.controller;

import javax.validation.Valid;

import com.superchat.communicationservice.controller.model.MessageCreateRequest;
import com.superchat.communicationservice.controller.model.MessageCreateResponse;
import com.superchat.communicationservice.controller.model.MessageListResponse;
import com.superchat.communicationservice.controller.model.MessageReceiveRequest;
import com.superchat.communicationservice.controller.model.MessageReceiveResponse;
import com.superchat.communicationservice.persistence.model.Message;
import com.superchat.communicationservice.service.MessagesService;

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
@RequestMapping(path = "/messages")
@Tag(name = "Messages")
@RequiredArgsConstructor
public class MessagesController {
    @Autowired
    private MessagesService service;

    @Operation(summary = "Send a message to a contact using a specific channel")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageCreateResponse> createMessage(@Valid @RequestBody MessageCreateRequest body) {
        Message entity = service.createMessage(body);
        MessageCreateResponse responseEntity = new MessageCreateResponse(entity);

        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }

    @Operation(summary = "List all conversations")
    @GetMapping(produces = "application/json")
    public ResponseEntity<MessageListResponse> listMessages(@RequestParam(name = "contactId") Long contactId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Message> list = service.listMessages(contactId, page, size);
        MessageListResponse responseEntity = new MessageListResponse(list);

        return new ResponseEntity<MessageListResponse>(responseEntity, HttpStatus.OK);
    }

    @Operation(summary = "Webhook to receive messages from external services")
    @PostMapping(path = "/external", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageReceiveResponse> receiveMessage(@Valid @RequestBody MessageReceiveRequest body) {
        Message entity = service.receiveMessage(body);
        MessageReceiveResponse responseEntity = new MessageReceiveResponse(entity);

        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }
}
