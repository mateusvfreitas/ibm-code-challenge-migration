package com.example.dummyjson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuração do WebClient para a API DummyJSON.
 */
@Configuration
public class WebClientConfig {


    @Value("${api.dummyjson.base-url}")
    private String baseUrl; // URL base da API

    /**
     * Cria um WebClient com a URL base configurada.
     * @return WebClient configurado
     */
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }
}