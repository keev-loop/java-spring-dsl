package com.petshop.house.guardian;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface GuardianControllerPort {
    @Operation(summary = "View all...")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Found the GuardianResponse",
                        content = { @Content(mediaType = "application/json",
                                schema = @Schema(implementation = GuardianResponse.class)) })})
    ResponseEntity<?> findAll();

    @Operation(summary = "View one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get the GuardianResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GuardianResponse.class)) }) })
    ResponseEntity<?> searchById(UUID id);

    @Operation(summary = "Create one...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the GuardianResponse",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GuardianResponse.class)) }) })
    ResponseEntity<?> create(GuardianRequest request);
}
