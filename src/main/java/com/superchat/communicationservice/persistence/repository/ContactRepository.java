package com.superchat.communicationservice.persistence.repository;

import java.util.Optional;

import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    public Optional<Contact> findByUsernameAndId(String username, Long id);

    public Page<Contact> findAllByUsername(String username, Pageable pageable);
}
