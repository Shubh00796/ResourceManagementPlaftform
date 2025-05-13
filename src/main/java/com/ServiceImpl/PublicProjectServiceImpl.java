package com.ServiceImpl;

import com.DTOS.PublicProjectManagementDTO;
import com.Domian.Enums.ProjectStatus;
import com.Domian.ProjectEntity;
import com.Domian.ResourceEntity;
import com.Mapper.PublicProjectMapper;
import com.ReposiotryServices.ProjectRepositoryService;
import com.Services.PublicProjectService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicProjectServiceImpl implements PublicProjectService {
    private final ProjectRepositoryService projectRepositoryService;
    private final PublicProjectMapper projectMapper;
    private final Validator validator;

    @Override
    public PublicProjectManagementDTO createProject(PublicProjectManagementDTO projectDTO) {
        ProjectEntity projectEntity = projectMapper.toEntity(projectDTO);
        validatePublicProjectManagementEntity(projectEntity);
        projectRepositoryService.createProject(projectEntity);

        return projectMapper.toDto(projectEntity);
    }

    @Override
    public PublicProjectManagementDTO updateProject(Long id, PublicProjectManagementDTO projectDTO) {
        ProjectEntity projectEntity = projectRepositoryService.getProjectById(id);
        validatePublicProjectManagementEntity(projectEntity);
        projectMapper.updateEntityFromDto(projectDTO, projectEntity);
        ProjectEntity updatedProjectEntity = projectRepositoryService.updateProject(projectEntity);

        return projectMapper.toDto(updatedProjectEntity);
    }

    @Override
    public PublicProjectManagementDTO getProjectById(Long id) {
        ProjectEntity projectById = projectRepositoryService.getProjectById(id);
        return projectMapper.toDto(projectById);
    }

    @Override
    public List<PublicProjectManagementDTO> getAllProjects() {
        return projectRepositoryService.getAllProjects()
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicProjectManagementDTO> getProjectsByStatus(ProjectStatus status) {
        return projectRepositoryService.getProjectsByStatus(status)
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProject(Long id) {
        projectRepositoryService.deleteProject(id);

    }

    @Override
    public List<PublicProjectManagementDTO> getProjectsByStatusAndLocation(ProjectStatus status, String location) {
        return projectRepositoryService.getProjectsByStatusAndLocation(status, location)
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());

    }

    private void validatePublicProjectManagementEntity(ProjectEntity projectEntity) {
        Set<ConstraintViolation<ProjectEntity>> violations = validator.validate(projectEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
