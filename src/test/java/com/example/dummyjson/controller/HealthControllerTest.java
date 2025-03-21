package com.example.dummyjson.controller;

import com.example.dummyjson.config.WebClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Testes de integração para o {@link HealthController}.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Testa se o endpoint de saúde retorna o status "UP" com código 200.
     */
    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/health")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("UP"));
    }
}