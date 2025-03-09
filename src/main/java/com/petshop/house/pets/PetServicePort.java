package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;

public interface PetServicePort {
    List<PetDto> findAll();
    PetDto findById(UUID id);
    PetDto saveAn(PetDto dto);
}
