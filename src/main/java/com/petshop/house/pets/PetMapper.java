package com.petshop.house.pets;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetMapper {
    private final ModelMapper modelMapper;

    public PetDto toDto(PetEntity entity){
        log.info("ENTIDADE para DTO: {}", entity);
        return modelMapper.map(entity, PetDto.class);
    }

    public List<PetDto> toDto(List<PetEntity> entities){
        log.info("ENTIDADE para DTO: {}", entities);
        return entities.stream()
            .map(entity -> toDto(entity))
            .collect(Collectors.toList());
    }

    public PetDto toDto(PetRequest request){
        log.info("REQUEST para DTO: {}", request);
        return modelMapper.map(request, PetDto.class);
    }

    public PetDto toDto(PetResponse response){
        log.info("RESPONSE para DTO: {}", response);
        return modelMapper.map(response, PetDto.class);
    }

    public PetEntity toEntity(PetDto dto){
        log.info("DTO para ENTIDADE: {}", dto);
        return modelMapper.map(dto, PetEntity.class);
    }


    public PetRequest toRequest(PetDto dto){
        log.info("DTO para REQUEST: {}", dto);
        return modelMapper.map(dto, PetRequest.class);
    }

    public PetResponse toResponse(PetDto dto){
        log.info("DTO para RESPONSE: {}", dto);
        return modelMapper.map(dto, PetResponse.class);
    }

    public List<PetResponse> toResponse(List<PetDto> dtos){
        log.info("DTOs para RESPONSEs: {}", dtos);
        return dtos.stream()
            .map(dto -> toResponse(dto))
            .collect(Collectors.toList());
    }
}
