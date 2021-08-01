package com.superchat.communicationservice.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superchat.communicationservice.controller.model.ContactListResponse;
import com.superchat.communicationservice.controller.model.ContactCreateRequest;
import com.superchat.communicationservice.dto.mapper.ContactsMapper;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.service.ContactsService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ContactsController.class)
public class ContactsControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private ContactsService service;

        @Test
        public void createContact_ValidRequest_Created() throws Exception {
                ContactCreateRequest request = new ContactCreateRequest();
                request.setName("John Doe");
                request.setEmail("john.doe@test.com");
                request.setPhoneNumber("+351969969969");

                when(service.createContact(request)).thenReturn(ContactsMapper.toEntity(request));

                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isCreated());
        }

        @Test
        public void createContact_NoRequest_BadRequest() throws Exception {
                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts").contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void createContact_EmptyRequest_BadRequest() throws Exception {
                Map<String, Object> request = new HashMap<>();

                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void createContact_NoName_BadRequest() throws Exception {
                ContactCreateRequest request = new ContactCreateRequest();
                request.setEmail("john.doe@test.com");
                request.setPhoneNumber("+351969969969");

                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void createContact_NoEmail_BadRequest() throws Exception {
                ContactCreateRequest request = new ContactCreateRequest();
                request.setName("John Doe");
                request.setPhoneNumber("+351969969969");

                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void createContact_NoPhoneNumber_BadRequest() throws Exception {
                ContactCreateRequest request = new ContactCreateRequest();
                request.setName("John Doe");
                request.setEmail("john.doe@test.com");

                this.mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void listContacts_OkEmptyList() throws Exception {
                int page = 0;
                int size = 10;

                List<Contact> list = new ArrayList<>();

                Page<Contact> pageEntity = new PageImpl<Contact>(list, PageRequest.of(page, size), list.size());
                ContactListResponse response = new ContactListResponse(pageEntity);

                when(service.listContacts(page, size)).thenReturn(pageEntity);

                this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts")).andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers
                                                .content().json(objectMapper.writeValueAsString(response)));
        }

        @Test
        public void listContacts_OkNotEmptyList() throws Exception {
                int page = 0;
                int size = 10;

                List<Contact> list = new ArrayList<>();
                list.add(new Contact("John Doe", "john.doe@test.com", "+351969969969"));

                Page<Contact> pageEntity = new PageImpl<Contact>(list, PageRequest.of(page, size), list.size());
                ContactListResponse response = new ContactListResponse(pageEntity);

                when(service.listContacts(page, size)).thenReturn(pageEntity);

                this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts")).andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers
                                                .content().json(objectMapper.writeValueAsString(response)));
        }
}
