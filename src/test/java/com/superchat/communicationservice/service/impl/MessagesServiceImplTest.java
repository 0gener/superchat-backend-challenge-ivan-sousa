package com.superchat.communicationservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import com.superchat.communicationservice.dto.MessageDetailsDTO;
import com.superchat.communicationservice.exception.ContactNotFoundException;
import com.superchat.communicationservice.messaging.factory.MessageChannelFactory;
import com.superchat.communicationservice.messaging.factory.MessageChannelType;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.model.Message;
import com.superchat.communicationservice.persistence.repository.ContactRepository;
import com.superchat.communicationservice.persistence.repository.MessageRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MessagesServiceImplTest {
    private MessagesServiceImpl service;

    @MockBean
    private ContactRepository contactRepository;

    @MockBean
    private MessageRepository messageRepository;

    @MockBean
    private MessageChannelFactory messageChannelFactory;

    @BeforeEach
    public void setUp() {
        service = new MessagesServiceImpl(contactRepository, messageRepository, messageChannelFactory);

        Contact contact = new Contact("John Doe", "john.doe@test.com", "+351969969969");
        contact.setId(1L);

        Message message = new Message(contact, MessageChannelType.SMS, "Test message", "Test message");

        Mockito.when(contactRepository.findById(1L)).thenReturn(Optional.of(contact));
        Mockito.when(messageRepository.save(message)).thenReturn(message);
    }

    @Test
    public void sendMessage_ContactExists_ThrowsContactNotFoundException() throws Exception {
        MessageDetailsDTO dto = new MessageDetailsDTO(999L, MessageChannelType.SMS, "Test Message");

        assertThrows(ContactNotFoundException.class, () -> service.sendMessage(dto));
    }
}
