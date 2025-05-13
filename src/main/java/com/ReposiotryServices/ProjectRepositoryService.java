package com.ReposiotryServices;

import com.Domian.Enums.ProjectStatus;
import com.Domian.ProjectEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectRepositoryService {
    private final ProjectRepository projectRepository;

    public ProjectEntity createProject(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    public ProjectEntity updateProject(ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    public ProjectEntity getProjectById(Long id) {
        return getProjectEntity(id);
    }

    private ProjectEntity getProjectEntity(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Id wiuth given project found" + id)));
    }

    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<ProjectEntity> getProjectsByStatus(ProjectStatus status) {
        return projectRepository.findByStatus(status);
    }


    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public List<ProjectEntity> getProjectsByStatusAndLocation(ProjectStatus status, String location) {
        return projectRepository.findByStatusAndLocation(status, location);
    }
}
