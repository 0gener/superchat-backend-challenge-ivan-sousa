package com.superchat.communicationservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.superchat.communicationservice.dto.ContactDetailsDTO;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.repository.ContactRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ContactsServiceImplTest {
    private ContactsServiceImpl service;

    @MockBean
    private ContactRepository contactRepository;

    @BeforeEach
    public void setUp() {
        service = new ContactsServiceImpl(contactRepository);

        Contact contact = new Contact("John Doe", "john.doe@test.com", "+351969969969");
        contact.setId(1L);
        Mockito.when(contactRepository.save(contact)).thenReturn(contact);
    }

    @Test
    public void createContact() throws Exception {
        ContactDetailsDTO dto = new ContactDetailsDTO("John Doe", "john.doe@test.com", "+351969969969");
        Contact entity = service.createContact(dto);

        assertNotNull(entity);
        assertEquals(entity.getId(), 1L);
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getEmail(), dto.getEmail());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
    }
}
