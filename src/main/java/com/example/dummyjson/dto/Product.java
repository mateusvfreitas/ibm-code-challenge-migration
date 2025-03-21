package com.example.dummyjson.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * DTO que representa um produto no sistema.
 */
@Schema(description = "Representa as informações de um produto")
public class Product {

    @Schema(description = "Identificador único do produto", example = "1")
    @NotNull
    @Min(0L)
    @Max(999L)
    private Long id;

    @Schema(description = "Título do produto", example = "iPhone 13")
    @NotNull
    private String title;

    @Schema(description = "Descrição detalhada do produto", example = "Smartphone Apple com tela de 6.1 polegadas")
    @NotNull
    private String description;

    @Schema(description = "Preço do produto", example = "999.99")
    @NotNull
    private Double price;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}