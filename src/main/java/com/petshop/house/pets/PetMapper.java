package com.petshop.house.pets;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetMapper {
    private final ModelMapper modelMapper;

    public PetDto toPetDto(@NotNull PetEntity entity){
        log.info("ENTIDADE para DTO: {}", entity);
        return modelMapper.map(entity, PetDto.class);
    }

    public List<PetDto> toPetDto(@NotNull @NotEmpty List<PetEntity> entities){
        log.info("ENTIDADE para DTO: {}", entities);
        return entities.stream()
            .map(entity -> toPetDto(entity))
            .collect(Collectors.toList());
    }

    public PetDto toPetDto(@NotNull PetRequest request){
        log.info("REQUEST para DTO: {}", request);
        return modelMapper.map(request, PetDto.class);
    }

    public PetEntity toPetEntity(@NotNull PetDto dto){
        log.info("DTO para ENTIDADE: {}", dto);
        return modelMapper.map(dto, PetEntity.class);
    }

    public PetResponse toPetResponse(@NotNull PetDto dto){
        log.info("DTO para RESPONSE: {}", dto);
        return modelMapper.map(dto, PetResponse.class);
    }

    public List<PetResponse> toPetResponse(@NotNull @NotEmpty List<PetDto> dtos){
        log.info("DTOs para RESPONSEs: {}", dtos);
        return dtos.stream()
            .map(dto -> toPetResponse(dto))
            .collect(Collectors.toList());
    }
}
