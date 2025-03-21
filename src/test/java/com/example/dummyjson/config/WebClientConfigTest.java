package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test de integração para o {@link WebClientConfig}.
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WebClientConfigTest {

    @Autowired
    private WebClient webClient;

    /**
     * Testa se o bean WebClient foi criado e configurado corretamente.
     */
    @Test
    public void testWebClientBean() {
        assertNotNull(webClient);
    }
}