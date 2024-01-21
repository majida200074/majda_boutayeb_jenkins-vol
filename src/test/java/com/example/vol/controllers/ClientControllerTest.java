 package com.example.vol.controllers;

import com.example.vol.controllers.ClientController;
import com.example.vol.models.Client;
import com.example.vol.models.Reservation;
import com.example.vol.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
/*
import static org.mockito.Mockito.*;
@SpringBootTest
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientController clientController;

    @Test
    public void getAllClients() throws Exception {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(clientRepository.findAll()).thenReturn(clients);

        mockMvc.perform(MockMvcRequestBuilders.get("/clts/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(clients.size()));

        verify(clientRepository, times(1)).findAll();
        verifyNoMoreInteractions(clientRepository);
    }

    @Test
    public void addClient() throws Exception {
        Client client = new Client();
        when(clientRepository.save(any(Client.class))).thenReturn(client);

        mockMvc.perform(MockMvcRequestBuilders.post("/clts/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

        verify(clientRepository, times(1)).save(any(Client.class));
        verifyNoMoreInteractions(clientRepository);
    }

  */  // Add similar tests for other controller methods...

