package com.superchat.communicationservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.superchat.communicationservice.messaging.factory.MessageChannelType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MessageDetailsDTO {
    @NotNull
    private Long contactId;

    @NotNull
    private MessageChannelType channel;

    @NotBlank
    private String body;
}
