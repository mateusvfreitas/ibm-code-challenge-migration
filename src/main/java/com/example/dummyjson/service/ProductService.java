package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

/**
 * Serviço para gerenciar operações relacionadas a produtos da API DummyJSON.
 */
@Service
public class ProductService {

    private final WebClient webClient;

    @Value("${api.dummyjson.products-path}")
    private String productsPath;

    @Autowired
    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Recupera todos os produtos da API.
     * @return Lista de produtos
     */
    public List<Product> getAllProducts() {
        return webClient.get()
                .uri(productsPath)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .map(response -> (List<Product>) response.get("products"))
                .block();
    }

    /**
     * Recupera um produto pelo ID.
     * @param id ID do produto
     * @return Produto correspondente ao ID
     */
    public Product getProductById(Long id) {
        return webClient.get()
                .uri(productsPath + "/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }
}