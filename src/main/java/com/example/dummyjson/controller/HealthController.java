package com.example.dummyjson.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller responsável por fornecer informações sobre a saúde do microsserviço.
 */
@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "API para verificação da saúde do microsserviço")
public class HealthController {

    /**
     * Verifica a saúde do microsserviço.
     *
     * @return ResponseEntity contendo o status da saúde do microsserviço
     */
    @Operation(summary = "Verificar saúde do microsserviço", description = "Retorna o status atual do microsserviço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Microsserviço está operacional",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class)))
    })
    @GetMapping
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        return ResponseEntity.ok(response);
    }
}