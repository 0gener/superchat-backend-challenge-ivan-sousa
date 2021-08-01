package com.superchat.communicationservice.persistence.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "contacts")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name", nullable = false, unique = false)
    @EqualsAndHashCode.Include
    private String name;

    @NonNull
    @Column(name = "email", nullable = false, unique = false)
    @EqualsAndHashCode.Include
    private String email;

    @NonNull
    @Column(name = "phone_number", nullable = false, unique = false)
    @EqualsAndHashCode.Include
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
