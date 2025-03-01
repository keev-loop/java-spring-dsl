package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.petshop.house.errors.ResourceNotFoundException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public List<PetDto> findAll() {
        log.info("Buscando...");
        return petMapper.toDto(
            petRepository.findAll());
    }

    @Override
    public PetDto findById(UUID id) {
        log.info("Buscando ID: {}", id);
        return petMapper.toDto(
            petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Pet ID %s não encontrado!", id))));
    }

    @Override
    public PetDto saveAn(PetDto dto) {
        log.info("Cadastrando DTO: {}", dto);
        return petMapper.toDto(
            petRepository.save(petMapper.toEntity(dto)));
    }
}
