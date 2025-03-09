package com.petshop.house.guardian;

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
public interface GuardianRepositoryPort extends JpaRepository<GuardianEntity, UUID>,
    QuerydslPredicateExecutor<GuardianEntity>,
    QuerydslBinderCustomizer<QGuardianEntity> {

    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QGuardianEntity guardian) {
        bindings.bind(guardian.guardianName).first((StringPath path, String value) -> path.containsIgnoreCase(value));
    }

    default List<GuardianEntity> searchAll(JPAQueryFactory queryFactory) {
        return queryFactory
                    .select(QGuardianEntity.guardianEntity)
                    .from(QGuardianEntity.guardianEntity)
                    .fetch();
    }

    default GuardianEntity create(JPAQueryFactory queryFactory, GuardianEntity entity) {
        queryFactory
            .insert(QGuardianEntity.guardianEntity)
            .set(QGuardianEntity.guardianEntity.guardianName, entity.getGuardianName())
            .execute();
        return entity;
    }

    default Optional<GuardianEntity> searchOneById(JPAQueryFactory queryFactory, UUID id) {
        return Optional.ofNullable(
                        queryFactory
                            .selectFrom(QGuardianEntity.guardianEntity)
                            .where(QGuardianEntity.guardianEntity.guardianId.eq(id))
                            .fetchOne());
    }

    default GuardianEntity update(JPAQueryFactory queryFactory, GuardianEntity entity, UUID id) {
        queryFactory
            .update(QGuardianEntity.guardianEntity)
            .where(QGuardianEntity.guardianEntity.guardianId.eq(id))
            .set(QGuardianEntity.guardianEntity.guardianName, entity.getGuardianName())
            .set(QGuardianEntity.guardianEntity.guardianStatus, entity.getGuardianStatus())
            .set(QGuardianEntity.guardianEntity.guardianUpdatingDate, entity.getGuardianUpdatingDate())
            .execute();
        return entity;
    }

    default GuardianEntity remove(JPAQueryFactory queryFactory, GuardianEntity entity) {
        queryFactory
                .delete(QGuardianEntity.guardianEntity)
                .where(QGuardianEntity.guardianEntity.guardianId.eq(entity.getGuardianId()),
                    QGuardianEntity.guardianEntity.guardianName.eq(entity.getGuardianName()))
                .execute();
        return entity;
    }
}