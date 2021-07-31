package com.superchat.communicationservice.gateway.factory;

import lombok.Getter;

@Getter

public enum MessageGatewayType {
    SMS("SMS"), EMAIL("EMAIL"), GOOGLE_BUSINESS_CHAT("GOOGLE_BUSINESS_CHAT");

    private final String value;

    MessageGatewayType(String value) {
        this.value = value;
    }
}
