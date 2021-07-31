package com.superchat.communicationservice.messaging.impl;

import com.superchat.communicationservice.messaging.MessageChannel;
import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.stereotype.Component;

@Component
public class GoogleBusinessChatChannel implements MessageChannel {
    @Override
    public void sendMessage(Contact contact, String body) {
        // TODO Missing implementation
        System.out.println("GoogleBusinessChatChannel");
    }
}
