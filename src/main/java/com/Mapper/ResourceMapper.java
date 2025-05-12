package com.Mapper;

import com.DTOS.ResourceDTO;
import com.Domian.ResourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    @Mapping(target = "id", ignore = true)
    ResourceEntity toEntity(ResourceDTO dto);

    ResourceDTO toDto(ResourceEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ResourceDTO dto, @MappingTarget ResourceEntity entity);
}
