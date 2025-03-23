package com.example.dummyjson.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes para {@link Product}.
 */
@SpringBootTest
public class ProductTest {

    /**
     * Teste de getters e setters.
     */
    @Test
    void testGetAndSetters() {
        Long expectedId = 1L;
        String expectedTitle = "A dummy title";
        String expectedDescription = "A dummy description";
        Double expectedPrice = 2.1;

        Product product = new Product();
        product.setId(expectedId);
        product.setTitle(expectedTitle);
        product.setDescription(expectedDescription);
        product.setPrice(expectedPrice);

        assertEquals(expectedId, product.getId(), "ID should match");
        assertEquals(expectedTitle, product.getTitle(), "Title should match");
        assertEquals(expectedDescription, product.getDescription(), "Description should match");
        assertEquals(expectedPrice, product.getPrice(), "Price should match");
    }
}
