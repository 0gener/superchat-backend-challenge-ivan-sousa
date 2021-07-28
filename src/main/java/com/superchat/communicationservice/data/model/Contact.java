package com.superchat.communicationservice.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Setter;

@Entity
@Setter
public class Contact implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name = "name", nullable = false, unique = false)
    public String getName() {
        return name;
    }

    @Column(name = "email", nullable = false, unique = false)
    public String getEmail() {
        return email;
    }

    @Column(name = "phone_number", nullable = false, unique = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
