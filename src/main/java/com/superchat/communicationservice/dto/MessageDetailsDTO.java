package com.superchat.communicationservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.superchat.communicationservice.gateway.factory.MessageGatewayType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDetailsDTO {
    @NotNull
    private Long contactId;

    @NotNull
    private MessageGatewayType gateway;

    @NotBlank
    private String body;
}
