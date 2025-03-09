package com.petshop.house.pets;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public interface PetRepositoryPort extends JpaRepository<PetEntity, UUID>,
    QuerydslPredicateExecutor<PetEntity>,
    QuerydslBinderCustomizer<QPetEntity>{
    
    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QPetEntity pet) {
        bindings.bind(pet.petName).first((StringPath path, String value) -> path.containsIgnoreCase(value));
    }

    default List<PetEntity> searchAll(JPAQueryFactory queryFactory) {
        return queryFactory
                    .select(QPetEntity.petEntity)
                    .from(QPetEntity.petEntity)
                    .fetch();
    }

    default PetEntity saveOne(JPAQueryFactory queryFactory, PetEntity entity) {
        queryFactory
            .insert(QPetEntity.petEntity)
            .set(QPetEntity.petEntity.petName, entity.getPetName())
            .set(QPetEntity.petEntity.petRace, entity.getPetRace())
            .set(QPetEntity.petEntity.petGender, entity.getPetGender())
            .execute();
        return entity;
    }

    default Optional<PetEntity> searchOneById(JPAQueryFactory queryFactory, UUID id) {
        return Optional.ofNullable(
                        queryFactory
                            .selectFrom(QPetEntity.petEntity)
                            .where(QPetEntity.petEntity.petId.eq(id))
                            .fetchOne());
    }

    default PetEntity updateOne(JPAQueryFactory queryFactory, PetEntity entity, UUID id) {
        queryFactory
            .update(QPetEntity.petEntity)
            .where(QPetEntity.petEntity.petId.eq(id))
            .set(QPetEntity.petEntity.petName, entity.getPetName())
            .set(QPetEntity.petEntity.petRace, entity.getPetRace())
            .set(QPetEntity.petEntity.petGender, entity.getPetGender())
            .set(QPetEntity.petEntity.petStatus, entity.getPetStatus())
            .set(QPetEntity.petEntity.petUpdatingDate, entity.getPetUpdatingDate())
            .execute();
        return entity;
    }

    default PetEntity deleteOne(JPAQueryFactory queryFactory, PetEntity entity) {
        queryFactory
                .delete(QPetEntity.petEntity)
                .where(QPetEntity.petEntity.petId.eq(entity.getPetId()),
                    QPetEntity.petEntity.petName.eq(entity.getPetName()),
                    QPetEntity.petEntity.petRace.eq(entity.getPetRace()),
                    QPetEntity.petEntity.petGender.eq(entity.getPetGender()))
                .execute();
        return entity;
    }
}
