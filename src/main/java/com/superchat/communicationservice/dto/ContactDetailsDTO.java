package com.superchat.communicationservice.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContactDetailsDTO {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;
}
