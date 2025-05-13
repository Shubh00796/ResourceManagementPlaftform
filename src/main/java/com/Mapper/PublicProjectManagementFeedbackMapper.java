package com.Mapper;


import com.DTOS.PublicProjectManagementFeedbackDTO;
import com.Domian.PublicProjectManagementFeedbackEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PublicProjectManagementFeedbackMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "submissionDate", source = "submissionDate")
    PublicProjectManagementFeedbackEntity toEntity(PublicProjectManagementFeedbackDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "projectId", source = "projectId")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "submissionDate", source = "submissionDate")
    PublicProjectManagementFeedbackDTO toDto(PublicProjectManagementFeedbackEntity entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(PublicProjectManagementFeedbackDTO dto, @MappingTarget PublicProjectManagementFeedbackEntity entity);
}