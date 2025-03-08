package com.petshop.house.pets;

import java.util.List;
import java.util.UUID;

public interface PetServicePort {
    public List<PetDto> findAll();
    public PetDto findById(UUID id);
    public PetDto saveAn(PetDto dto);
}
