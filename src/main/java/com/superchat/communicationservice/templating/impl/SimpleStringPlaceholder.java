package com.superchat.communicationservice.templating.impl;

import com.superchat.communicationservice.templating.TemplatePlaceholder;

public class SimpleStringPlaceholder extends TemplatePlaceholder {
    private String replacement;

    public SimpleStringPlaceholder(String placeholder, String replacement) {
        super(placeholder);

        this.replacement = replacement;
    }

    @Override
    public String loadReplacement() {
        return replacement;
    }
}
