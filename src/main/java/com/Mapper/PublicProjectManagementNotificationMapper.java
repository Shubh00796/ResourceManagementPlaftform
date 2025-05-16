package com.Mapper;

import com.DTOS.PublicProjectManagementNotificationDTO;
import com.Domian.PublicProjectManagementNotificationEntity;
import org.mapstruct.*;
import java.time.*;

@Mapper(componentModel = "spring")
public interface PublicProjectManagementNotificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "timestamp", source = "timestamp")
    PublicProjectManagementNotificationEntity toEntity(PublicProjectManagementNotificationDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "timestamp", source = "timestamp")
    PublicProjectManagementNotificationDTO toDto(PublicProjectManagementNotificationEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PublicProjectManagementNotificationDTO dto, @MappingTarget PublicProjectManagementNotificationEntity entity);

    // Custom mapping methods
    default Instant map(LocalDate date) {
        return date != null ? date.atStartOfDay(ZoneId.systemDefault()).toInstant() : null;
    }

    default LocalDate map(Instant instant) {
        return instant != null ? instant.atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }
}
