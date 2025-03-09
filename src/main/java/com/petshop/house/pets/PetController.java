package com.petshop.house.pets;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/pets", name = "Pets")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetController implements PetControllerPort {
    private final PetServicePort petService;
    private final PetMapper petMapper;

    @Override
    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("Buscando todos...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(petMapper.toPetResponse(
                petService.findAll()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") UUID id) {
        log.info("Buscando um...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(petMapper.toPetResponse(
                petService.findById(id)));
    }

    @Override
    @PostMapping
    public ResponseEntity<?> saveAn(@RequestBody PetRequest request) {
        log.info("Criando um...");
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(petMapper.toPetResponse(
                petService.saveAn(
                petMapper.toPetDto(request))));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@RequestBody PetRequest request, @PathVariable(value="id") UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }
}
