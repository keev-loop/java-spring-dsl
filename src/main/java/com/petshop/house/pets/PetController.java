package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetController {
    private final PetService petService;
    private final PetMapper petMapper;

    @GetMapping
    public ResponseEntity<List<PetResponse>> findAll() {
        log.info("Buscando todos...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(petMapper.toResponse(
                petService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findAn(@PathVariable(value="id") UUID id) {
        log.info("Buscando um...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(petMapper.toResponse(
                petService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PetResponse> findAn(@RequestBody PetRequest request) {
        log.info("Criando um...");
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(petMapper.toResponse(
                petService.saveAn(petMapper.toDto(request))));
    }
}
