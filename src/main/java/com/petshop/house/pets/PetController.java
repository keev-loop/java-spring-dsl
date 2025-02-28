package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetController {
    private final PetService petService;
    private final PetMapper petMapper;

    @GetMapping
    public List<PetResponse> findAll() {
        log.info("Buscando todos...");
        return petService
                .findAll()
                .stream()
                .map(pet -> petMapper.toResponse(pet))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PetResponse findAn(@PathVariable(value="id") UUID id) {
        log.info("Buscando um...");
        return petMapper.toResponse(petService.findById(id));
    }

    @PostMapping
    public PetResponse findAn(PetRequest request) {
        log.info("Criando um...");
        return petMapper.toResponse(
            petService.saveAn(petMapper.toDto(request)));
        
    }
}
