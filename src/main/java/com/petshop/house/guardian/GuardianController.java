package com.petshop.house.guardian;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/guardians", name = "Guardians")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class GuardianController implements GuardianControllerPort {
    private final GuardianServicePort guardianServicePort;
    private final GuardianMapper guardianMapper;

    @Override
    @GetMapping
    public ResponseEntity<?> findAll() {
        log.info("Buscando todos...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(guardianMapper.toGuardianResponse(
                guardianServicePort.searchAll()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable(value="id") UUID id) {
        log.info("Buscando um...");
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(guardianMapper.toGuardianResponse(
                guardianServicePort.searchById(id)));
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(GuardianRequest request) {
        log.info("Criando um...");
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(guardianMapper.toGuardianResponse(
                guardianServicePort.create(
                guardianMapper.toGuardianDto(request))));
    }
}
