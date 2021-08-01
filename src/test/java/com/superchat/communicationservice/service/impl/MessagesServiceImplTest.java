package com.superchat.communicationservice.service.impl;

import com.superchat.communicationservice.messaging.factory.MessageChannelFactory;
import com.superchat.communicationservice.persistence.repository.ContactRepository;
import com.superchat.communicationservice.persistence.repository.MessageRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
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
    }
}
