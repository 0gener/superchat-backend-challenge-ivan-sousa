package com.superchat.communicationservice.data.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @NonNull
    @Column(name = "email", nullable = false, unique = false)
    private String email;

    @NonNull
    @Column(name = "phone_number", nullable = false, unique = false)
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, unique = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, unique = false)
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true, unique = false)
    private OffsetDateTime deletedAt;
}
