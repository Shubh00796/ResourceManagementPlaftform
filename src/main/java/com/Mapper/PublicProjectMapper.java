package com.Mapper;


import com.DTOS.PublicProjectManagementDTO;
import com.Domian.ProjectEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PublicProjectMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "budget", source = "budget")
    @Mapping(target = "expenditure", source = "expenditure")
    @Mapping(target = "milestoneId", source = "milestoneId")
    @Mapping(target = "feedbackId", source = "feedbackId")
    ProjectEntity toEntity(PublicProjectManagementDTO projectDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "budget", source = "budget")
    @Mapping(target = "expenditure", source = "expenditure")
    @Mapping(target = "milestoneId", source = "milestoneId")
    @Mapping(target = "feedbackId", source = "feedbackId")
    PublicProjectManagementDTO toDto(ProjectEntity projectEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "milestoneId", ignore = true)
    @Mapping(target = "feedbackId", ignore = true)
    void updateEntityFromDto(PublicProjectManagementDTO dto, @MappingTarget ProjectEntity entity);
}