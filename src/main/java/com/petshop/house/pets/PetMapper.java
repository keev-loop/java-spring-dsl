package com.petshop.house.pets;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PetDto toDto(PetEntity entity){
        log.info("ENTIDADE para DTO");
        return modelMapper.map(entity, PetDto.class);
    }

    public PetDto toDto(PetRequest request){
        log.info("REQUEST para DTO");
        return modelMapper.map(request, PetDto.class);
    }

    public PetDto toDto(PetResponse response){
        log.info("RESPONSE para DTO");
        return modelMapper.map(response, PetDto.class);
    }

    public PetEntity toEntity(PetDto dto){
        log.info("DTO para ENTIDADE");
        return modelMapper.map(dto, PetEntity.class);
    }


    public PetRequest toRequest(PetDto dto){
        log.info("DTO para REQUEST");
        return modelMapper.map(dto, PetRequest.class);
    }

    public PetResponse toResponse(PetDto dto){
        log.info("DTO para RESPONSE");
        return modelMapper.map(dto, PetResponse.class);
    }
}
