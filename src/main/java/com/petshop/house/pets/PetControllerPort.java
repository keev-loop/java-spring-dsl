package com.petshop.house.pets;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PetControllerPort {
    @Operation(summary = "View all...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the PetResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetResponse.class)) })})
    ResponseEntity<?> findAll();

    @Operation(summary = "Create one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Created the PetResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetResponse.class)) }) })
    ResponseEntity<?> saveAn(PetRequest request);

    @Operation(summary = "View one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get the PetResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetResponse.class)) }) })
    ResponseEntity<?> findById(UUID id);

    @Operation(summary = "Update one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the PetResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetResponse.class)) }) })
    ResponseEntity<?> updateById(PetRequest request, UUID id);

    @Operation(summary = "Remove one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Removed the PetResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetResponse.class)) }) })
    ResponseEntity<?> deleteById(UUID id);
}
