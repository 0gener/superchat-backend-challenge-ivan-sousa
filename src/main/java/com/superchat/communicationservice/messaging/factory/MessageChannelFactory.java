package com.superchat.communicationservice.messaging.factory;

import com.superchat.communicationservice.messaging.MessageChannel;
import com.superchat.communicationservice.messaging.impl.EmailChannel;
import com.superchat.communicationservice.messaging.impl.GoogleBusinessChatChannel;
import com.superchat.communicationservice.messaging.impl.SmsChannel;

public class MessageChannelFactory {
    public static MessageChannel getChannel(MessageChannelType type) {
        switch (type) {
            case SMS:
                return new SmsChannel();
            case EMAIL:
                return new EmailChannel();
            case GOOGLE_BUSINESS_CHAT:
                return new GoogleBusinessChatChannel();
            default:
                return null;
        }
    }
}
