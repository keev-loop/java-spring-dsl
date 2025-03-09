package com.petshop.house.guardian;

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
public class GuardianServiceImpl implements GuardianServicePort {
    private final GuardianRepositoryPort guardianRepositoryPort;
    private final GuardianMapper guardianMapper;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<GuardianDto> searchAll() {
        log.info("Buscando...");
        return guardianMapper.toGuardianDto(
            guardianRepositoryPort.searchAll(queryFactory));
    }

    @Override
    public GuardianDto searchById(UUID id) {
        log.info("Buscando...");
        return guardianMapper.toGuardianDto(
            guardianRepositoryPort.searchOneById(queryFactory, id)
            .orElseThrow(() -> new ResourceNotFoundException(GuardianEntity.class, id)));
    }

    @Override
    public GuardianDto create(GuardianDto dto) {
        log.info("Criando...");
        return guardianMapper.toGuardianDto(
            guardianRepositoryPort.create(queryFactory, guardianMapper.toGuardianEntity(dto)));
    }
}
