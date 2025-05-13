package com.Mapper;


import com.DTOS.PublicProjectManagementNotificationDTO;
import com.Domian.PublicProjectManagementNotificationEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PublicProjectManagementNotificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "timestamp", source = "timestamp")
    @Mapping(target = "viewed", source = "viewed")
    PublicProjectManagementNotificationEntity toEntity(PublicProjectManagementNotificationDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "timestamp", source = "timestamp")
    @Mapping(target = "viewed", source = "viewed")
    PublicProjectManagementNotificationDTO toDto(PublicProjectManagementNotificationEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PublicProjectManagementNotificationDTO dto, @MappingTarget PublicProjectManagementNotificationEntity entity);
}