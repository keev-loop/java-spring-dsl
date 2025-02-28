package com.petshop.house.pets;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetMapper {
    private final ModelMapper modelMapper;

    public PetDto toDto(PetEntity entity){
        return modelMapper.map(entity, PetDto.class);
    }

    public PetEntity toEntity(PetDto dto){
        return modelMapper.map(dto, PetEntity.class);
    }


    public PetRequest toRequest(PetDto dto){
        return modelMapper.map(dto, PetRequest.class);
    }

    public PetResponse toResponse(PetDto dto){
        return modelMapper.map(dto, PetResponse.class);
    }
}
