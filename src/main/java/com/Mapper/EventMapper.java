package com.Mapper;

import com.DTOS.EventDTO;
import com.DTOS.ResourceDTO;
import com.Domian.EventEntity;
import com.Domian.ResourceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "organizerId", source = "organizerId")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "status", source = "status")
    EventEntity toEntity(EventDTO eventDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "organizerId", source = "organizerId")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "dateTime", source = "dateTime")
    @Mapping(target = "status", source = "status")
    EventDTO toDto(EventEntity eventEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizerId", ignore = true)
    void updateEntityFromDto(EventDTO dto, @MappingTarget EventEntity entity);
}
