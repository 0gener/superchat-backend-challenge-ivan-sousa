package com.superchat.communicationservice.messaging.factory;

import com.superchat.communicationservice.messaging.MessageChannel;
import com.superchat.communicationservice.messaging.impl.EmailChannel;
import com.superchat.communicationservice.messaging.impl.GoogleBusinessChatChannel;
import com.superchat.communicationservice.messaging.impl.SmsChannel;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class MessageChannelFactory {
    private SmsChannel smsChannel;
    private EmailChannel emailChannel;
    private GoogleBusinessChatChannel googleBusinessChatChannel;

    public MessageChannel getChannel(MessageChannelType type) {
        switch (type) {
            case SMS:
                return smsChannel;
            case EMAIL:
                return emailChannel;
            case GOOGLE_BUSINESS_CHAT:
                return googleBusinessChatChannel;
            default:
                return null;
        }
    }
}
