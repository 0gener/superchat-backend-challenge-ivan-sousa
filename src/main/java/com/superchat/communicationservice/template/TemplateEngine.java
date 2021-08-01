package com.superchat.communicationservice.template;

public class TemplateEngine {
    private TemplatePlaceholder[] placeholders;

    public TemplateEngine(TemplatePlaceholder... placeholders) {
        this.placeholders = placeholders;
    }

    public String render(String template) {
        for (TemplatePlaceholder placeholder : placeholders) {
            if (template.contains(placeholder.getPlaceholder()))
                template = template.replace(placeholder.getPlaceholder(), placeholder.loadReplacement());
        }

        return template;
    }
}
