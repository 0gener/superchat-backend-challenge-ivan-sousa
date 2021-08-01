package com.superchat.communicationservice.dto;

import java.time.OffsetDateTime;

import com.superchat.communicationservice.persistence.model.MessageOrientation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO extends MessageDetailsDTO {
    private Long id;
    private MessageOrientation orientation;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
