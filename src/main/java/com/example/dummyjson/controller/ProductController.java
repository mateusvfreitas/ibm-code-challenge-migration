package com.example.dummyjson.controller;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsável por operações relacionadas a produtos.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "API para gerenciamento de produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Obtém todos os produtos disponíveis.
     *
     * @return Lista de produtos
     */
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Product.class))))
    })
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Obtém um produto específico pelo seu ID.
     *
     * @param id ID do produto a ser buscado
     * @return Produto encontrado
     */
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico com base no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable @NotNull Long id) {
        return productService.getProductById(id);
    }
}
