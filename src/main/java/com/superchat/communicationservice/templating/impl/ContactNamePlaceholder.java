package com.superchat.communicationservice.templating.impl;

public class ContactNamePlaceholder extends SimpleStringPlaceholder {
    public ContactNamePlaceholder(String replacement) {
        super("{contact_name}", replacement);
    }
}
