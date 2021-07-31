package com.superchat.communicationservice.service.impl;

import com.superchat.communicationservice.dto.MessageDetailsDTO;
import com.superchat.communicationservice.exception.ContactNotFoundException;
import com.superchat.communicationservice.messaging.factory.MessageChannelFactory;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.model.Message;
import com.superchat.communicationservice.persistence.repository.ContactRepository;
import com.superchat.communicationservice.persistence.repository.MessageRepository;
import com.superchat.communicationservice.service.MessagesService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MessagesServiceImpl implements MessagesService {
    private ContactRepository contactRepository;
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(String username, MessageDetailsDTO dto) {
        Contact contact = contactRepository.findByUsernameAndId(username, dto.getContactId())
                .orElseThrow(() -> new ContactNotFoundException());

        String replacedBody = dto.getBody().replace("{contact_name}", contact.getName()).replace("{btc_price_usd}",
                "US$41,496.64");

        Message message = messageRepository.save(new Message(contact, dto.getChannel(), dto.getBody(), replacedBody));

        MessageChannelFactory.getChannel(dto.getChannel()).sendMessage(contact, replacedBody);

        return message;
    }

    @Override
    public Page<Message> listMessages(String username, Long contactId, int page, int size) {
        Contact contact = contactRepository.findByUsernameAndId(username, contactId)
                .orElseThrow(() -> new ContactNotFoundException());

        return messageRepository.findAllByContact(contact, PageRequest.of(page, size));
    }
}
