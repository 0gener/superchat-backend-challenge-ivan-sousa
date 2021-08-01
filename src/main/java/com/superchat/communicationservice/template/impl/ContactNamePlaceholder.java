package com.superchat.communicationservice.template.impl;

public class ContactNamePlaceholder extends SimpleStringPlaceholder {
    public ContactNamePlaceholder(String replacement) {
        super("{contact_name}", replacement);
    }
}
