package com.Mapper;

import com.DTOS.OrganizerDTO;
import com.DTOS.ResourceDTO;
import com.Domian.OrganizerEntity;
import com.Domian.ResourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrganizerMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    OrganizerDTO toDto(OrganizerEntity organizerEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    OrganizerEntity toEntity(OrganizerDTO organizerDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(OrganizerDTO organizerDTO, @MappingTarget OrganizerEntity organizerEntity);
}