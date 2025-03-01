package com.petshop.house.pets;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.StringPath;



@Repository
public interface PetRepository extends JpaRepository<PetEntity, UUID>,
    QuerydslPredicateExecutor<PetEntity>,
    QuerydslBinderCustomizer<QPetEntity> {

    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QPetEntity pet) {
        bindings.bind(pet.petName).first((StringPath path, String value) -> path.containsIgnoreCase(value));
    }
}
