package com.superchat.communicationservice.data.repository;

import com.superchat.communicationservice.data.model.Contact;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

}
