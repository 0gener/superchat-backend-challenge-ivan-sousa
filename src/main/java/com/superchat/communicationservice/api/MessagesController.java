package com.superchat.communicationservice.api;

import javax.validation.Valid;

import com.superchat.communicationservice.api.model.MessageCreateRequest;
import com.superchat.communicationservice.api.model.MessageCreateResponse;
import com.superchat.communicationservice.api.model.MessageListResponse;
import com.superchat.communicationservice.persistence.model.Message;
import com.superchat.communicationservice.service.MessagesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/messages")
@RequiredArgsConstructor
public class MessagesController {
    @Autowired
    private MessagesService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<MessageCreateResponse> createMessage(@RequestHeader("X-Username") String username,
            @Valid @RequestBody MessageCreateRequest body) {
        Message entity = service.createMessage(username, body);
        MessageCreateResponse responseEntity = new MessageCreateResponse(entity);

        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<MessageListResponse> listMessages(@RequestHeader("X-Username") String username,
            @RequestParam(name = "contactId") Long contactId, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Message> list = service.listMessages(username, contactId, page, size);
        MessageListResponse responseEntity = new MessageListResponse(list);

        return new ResponseEntity<MessageListResponse>(responseEntity, HttpStatus.OK);
    }
}
