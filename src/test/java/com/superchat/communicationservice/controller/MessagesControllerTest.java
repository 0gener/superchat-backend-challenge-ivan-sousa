package com.superchat.communicationservice.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.superchat.communicationservice.controller.model.MessageListResponse;
import com.superchat.communicationservice.controller.model.MessageCreateRequest;
import com.superchat.communicationservice.messaging.factory.MessageChannelType;
import com.superchat.communicationservice.persistence.model.Contact;
import com.superchat.communicationservice.persistence.model.Message;
import com.superchat.communicationservice.service.MessagesService;

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

@WebMvcTest(MessagesController.class)
public class MessagesControllerTest {
        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;

        @MockBean
        private MessagesService service;

        @Test
        public void sendMessage_ValidRequest_Created() throws Exception {
                MessageCreateRequest request = new MessageCreateRequest();
                request.setContactId(1L);
                request.setChannel(MessageChannelType.SMS);
                request.setBody("Test message body!");

                Contact contact = new Contact();
                contact.setId(1L);

                when(service.sendMessage(request)).thenReturn(
                                new Message(contact, request.getChannel(), request.getBody(), request.getBody()));

                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isCreated());
        }

        @Test
        public void sendMessage_NoRequest_BadRequest() throws Exception {
                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages").contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void sendMessage_EmptyRequest_BadRequest() throws Exception {
                Map<String, Object> request = new HashMap<>();

                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void sendMessage_NoContactId_BadRequest() throws Exception {
                MessageCreateRequest request = new MessageCreateRequest();
                request.setChannel(MessageChannelType.SMS);
                request.setBody("Test message body!");

                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void sendMessage_NoChannel_BadRequest() throws Exception {
                MessageCreateRequest request = new MessageCreateRequest();
                request.setContactId(1L);
                request.setBody("Test message body!");

                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void sendMessage_NoBody_BadRequest() throws Exception {
                MessageCreateRequest request = new MessageCreateRequest();
                request.setContactId(1L);
                request.setChannel(MessageChannelType.SMS);

                this.mockMvc.perform(MockMvcRequestBuilders.post("/messages")
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                                .andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }

        @Test
        public void listMessages_OkEmptyList() throws Exception {
                int page = 0;
                int size = 10;

                List<Message> list = new ArrayList<>();

                Page<Message> pageEntity = new PageImpl<Message>(list, PageRequest.of(page, size), list.size());
                MessageListResponse response = new MessageListResponse(pageEntity);

                when(service.listMessages(1L, page, size)).thenReturn(pageEntity);

                this.mockMvc.perform(MockMvcRequestBuilders.get("/messages").queryParam("contactId", "1"))
                                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content()
                                                .json(objectMapper.writeValueAsString(response)));
        }

        @Test
        public void listMessages_OkNotEmptyList() throws Exception {
                int page = 0;
                int size = 10;

                Contact contact = new Contact();
                contact.setId(1L);

                List<Message> list = new ArrayList<>();
                list.add(new Message(contact, MessageChannelType.SMS, "Test message", "Test message"));

                Page<Message> pageEntity = new PageImpl<Message>(list, PageRequest.of(page, size), list.size());
                MessageListResponse response = new MessageListResponse(pageEntity);

                when(service.listMessages(1L, page, size)).thenReturn(pageEntity);

                this.mockMvc.perform(MockMvcRequestBuilders.get("/messages").queryParam("contactId", "1"))
                                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content()
                                                .json(objectMapper.writeValueAsString(response)));
        }

        @Test
        public void listMessages_NoContactId_BadRequest() throws Exception {
                int page = 0;
                int size = 10;

                List<Message> list = new ArrayList<>();

                Page<Message> pageEntity = new PageImpl<Message>(list, PageRequest.of(page, size), list.size());

                when(service.listMessages(1L, page, size)).thenReturn(pageEntity);

                this.mockMvc.perform(MockMvcRequestBuilders.get("/messages")).andDo(MockMvcResultHandlers.print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
}
