package com.superchat.communicationservice.templating;

import lombok.Getter;

@Getter
public abstract class TemplatePlaceholder {
    private String placeholder;

    public TemplatePlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public abstract String loadReplacement();
}
