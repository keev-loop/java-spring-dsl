package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.petshop.house.errors.ResourceNotFoundException;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetServiceImpl implements PetServicePort {
    private final PetRepositoryPort petRepository;
    private final PetMapper petMapper;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<PetDto> findAll() {
        log.info("Buscando...");
        return petMapper.toPetDto(
            petRepository.findAll());
    }

    @Override
    public PetDto findById(UUID id) {
        log.info("Buscando ID: {}", id);
        return petMapper.toPetDto(
            petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Pet ID %s não encontrado!", id))));
    }

    @Override
    public PetDto saveAn(PetDto dto) {
        log.info("Cadastrando DTO: {}", dto);
        return petMapper.toPetDto(
            petRepository.save(petMapper.toPetEntity(dto)));
    }
}