package com.superchat.communicationservice.persistence.repository;

import com.superchat.communicationservice.persistence.model.Contact;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
