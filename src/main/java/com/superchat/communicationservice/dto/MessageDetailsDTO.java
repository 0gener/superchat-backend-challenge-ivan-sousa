package com.superchat.communicationservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDetailsDTO {
    private Long contactId;
    private String body;
}
