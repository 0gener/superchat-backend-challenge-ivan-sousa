package com.superchat.communicationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Contact not found!")
public class ContactNotFoundException extends RuntimeException {

}
