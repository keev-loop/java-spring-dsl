package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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
        return petRepository
                .findAll()
                .stream()
                .map(entity -> petMapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public PetDto findById(UUID id) {
        log.info("Buscando ID: %s", id);
        return petMapper
                .toDto(petRepository.findById(id)
                    .orElseThrow());
    }

    @Override
    public PetDto saveAn(PetDto dto) {
        log.info("Cadastrando DTO: %s", dto);
        return petMapper.toDto(
            petRepository.save(petMapper.toEntity(dto)));
    }
}
