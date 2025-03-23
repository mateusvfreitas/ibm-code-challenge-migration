package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * Testes de integração para {@link ProductService}.
 */
@SpringBootTest
public class ProductServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    private ProductService productService;

    /**
     * Configura os mocks e o serviço antes de cada teste.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersUriSpec.uri(anyString(), eq(1L))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

        productService = new ProductService(webClient);

        try {
            Field field = ProductService.class.getDeclaredField("productsPath");
            field.setAccessible(true);
            field.set(productService, "/products");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Testa a recuperação de todos os produtos via ProductService.
     */
    @Test
    public void testGetAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");

        List<Product> products = Arrays.asList(product1, product2);

        Map<String, Object> responseMap = Map.of("products", products);
        when(responseSpec.bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {}))
                .thenReturn(Mono.just(responseMap));

        List<Product> result = productService.getAllProducts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("Product 1", result.get(0).getTitle());
        assertEquals(2L, result.get(1).getId());
        assertEquals("Product 2", result.get(1).getTitle());
    }

    /**
     * Testa a recuperação de um produto por ID via ProductService.
     */
    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Product 1");

        when(responseSpec.bodyToMono(Product.class)).thenReturn(Mono.just(product));

        Product result = productService.getProductById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Product 1", result.getTitle());
    }
}