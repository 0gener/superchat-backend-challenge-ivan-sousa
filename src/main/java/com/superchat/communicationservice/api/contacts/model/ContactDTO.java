package com.superchat.communicationservice.api.contacts.model;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactDTO {
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;
}
