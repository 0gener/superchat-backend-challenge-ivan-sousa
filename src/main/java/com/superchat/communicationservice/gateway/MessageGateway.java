package com.superchat.communicationservice.gateway;

import com.superchat.communicationservice.persistence.model.Contact;

public interface MessageGateway {
    public void sendMessage(Contact contact, String body);
}
