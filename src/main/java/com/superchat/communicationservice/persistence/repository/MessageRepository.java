package com.superchat.communicationservice.persistence.repository;

import com.superchat.communicationservice.persistence.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
