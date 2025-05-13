package com.Mapper;


import com.DTOS.PublicProjectManagementMilestoneDTO;
import com.Domian.PublicProjectManagementMilestoneEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PublicProjectManagementMilestoneMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "status", source = "status")
    PublicProjectManagementMilestoneEntity toEntity(PublicProjectManagementMilestoneDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "dueDate", source = "dueDate")
    @Mapping(target = "status", source = "status")
    PublicProjectManagementMilestoneDTO toDto(PublicProjectManagementMilestoneEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PublicProjectManagementMilestoneDTO dto, @MappingTarget PublicProjectManagementMilestoneEntity entity);
}