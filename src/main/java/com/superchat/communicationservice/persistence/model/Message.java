package com.superchat.communicationservice.persistence.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.superchat.communicationservice.messaging.factory.MessageChannelType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @NonNull
    @Column(name = "channel", nullable = false, unique = false)
    private MessageChannelType channel;

    @NonNull
    @Column(name = "orientation", nullable = false, unique = false)
    private MessageOrientation orientation;

    @NonNull
    @Column(name = "body", nullable = false, unique = false)
    private String body;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, unique = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false, unique = false)
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at", nullable = true, unique = false)
    private OffsetDateTime deletedAt;
}
