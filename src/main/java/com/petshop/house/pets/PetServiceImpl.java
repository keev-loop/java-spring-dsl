package com.petshop.house.pets;

import java.util.List;
import java.util.Optional;
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

    protected final QPetEntity petEntity = QPetEntity.petEntity;
    private final JPAQueryFactory queryFactory;

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

    public List<PetEntity> searchAll() {
        return queryFactory
                    .select(QPetEntity.petEntity)
                    .from(QPetEntity.petEntity)
                    .fetch();
    }

    public PetEntity saveOne(PetEntity entity) {
        queryFactory
            .insert(petEntity)
            .set(petEntity.petName, entity.getPetName())
            .set(petEntity.petRace, entity.getPetRace())
            .set(petEntity.petGender, entity.getPetGender())
            .execute();
        return entity;
    }

    public Optional<PetEntity> searchOneById(UUID id) {
        return Optional.ofNullable(
                        queryFactory
                            .selectFrom(petEntity)
                            .where(petEntity.petId.eq(id))
                            .fetchOne());
    }

    public PetEntity updateOne(PetEntity entity, UUID id) {
        queryFactory
            .update(petEntity)
            .where(petEntity.petId.eq(id))
            .set(petEntity.petName, entity.getPetName())
            .set(petEntity.petRace, entity.getPetRace())
            .set(petEntity.petGender, entity.getPetGender())
            .execute();
        return entity;
    }

    public PetEntity deleteOne(PetEntity entity) {
        queryFactory
                .delete(petEntity)
                .where(petEntity.petId.eq(entity.getPetId()),
                    petEntity.petName.eq(entity.getPetName()),
                    petEntity.petRace.eq(entity.getPetRace()),
                    petEntity.petGender.eq(entity.getPetGender()))
                .execute();
        return entity;
    }
}