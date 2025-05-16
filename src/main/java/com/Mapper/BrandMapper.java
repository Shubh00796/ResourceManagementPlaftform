package com.Mapper;


import com.DTOS.BrandDTO;
import com.Domian.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "totalBudget", source = "totalBudget")
    @Mapping(target = "remainingBudget", source = "remainingBudget")
    BrandDTO toDto(BrandEntity brandEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "totalBudget", source = "totalBudget")
    @Mapping(target = "remainingBudget", source = "remainingBudget")
    BrandEntity toEntity(BrandDTO brandDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(BrandDTO brandDTO, @MappingTarget BrandEntity brandEntity);
}