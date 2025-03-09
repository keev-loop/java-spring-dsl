package com.petshop.house.guardian;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GuardianMapper {
    GuardianEntity toGuardianEntity(GuardianDto dto);

    List<GuardianEntity> toGuardianEntity(List<GuardianDto> dtos);

    GuardianDto toGuardianDto(GuardianEntity entity);

    List<GuardianDto> toGuardianDto(List<GuardianEntity> entities);

    @Mapping(target = "guardianCreationDate", ignore = true)
    @Mapping(target = "guardianUpdatingDate", ignore = true)
    @Mapping(target = "guardianStatus", ignore = true)
    @Mapping(target = "guardianId", ignore = true)
    GuardianDto toGuardianDto(GuardianRequest request);

    GuardianResponse toGuardianResponse(GuardianDto dto);

    List<GuardianResponse> toGuardianResponse(List<GuardianDto> dtos);
}
