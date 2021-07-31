package com.superchat.communicationservice.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO extends MessageDetailsDTO {
    private Long id;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
