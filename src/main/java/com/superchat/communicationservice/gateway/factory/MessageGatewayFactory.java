package com.superchat.communicationservice.gateway.factory;

import com.superchat.communicationservice.gateway.MessageGateway;
import com.superchat.communicationservice.gateway.impl.EmailGateway;
import com.superchat.communicationservice.gateway.impl.GoogleBusinessChatGateway;
import com.superchat.communicationservice.gateway.impl.SmsGateway;

public class MessageGatewayFactory {
    public static MessageGateway getGateway(MessageGatewayType type) {
        switch (type) {
            case SMS:
                return new SmsGateway();
            case EMAIL:
                return new EmailGateway();
            case GOOGLE_BUSINESS_CHAT:
                return new GoogleBusinessChatGateway();
            default:
                return null;
        }
    }
}
