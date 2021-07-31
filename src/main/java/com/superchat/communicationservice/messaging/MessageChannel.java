package com.superchat.communicationservice.messaging;

import com.superchat.communicationservice.persistence.model.Contact;

public interface MessageChannel {
    public void sendMessage(Contact contact, String body);
}
