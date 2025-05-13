package com.Services;

import com.DTOS.PublicProjectManagementDTO;
import com.Domian.Enums.ProjectStatus;

import java.util.List;

public interface PublicProjectService {
    PublicProjectManagementDTO createProject(PublicProjectManagementDTO projectDTO);

    PublicProjectManagementDTO updateProject(Long id, PublicProjectManagementDTO projectDTO);

    PublicProjectManagementDTO getProjectById(Long id);

    List<PublicProjectManagementDTO> getAllProjects();

    List<PublicProjectManagementDTO> getProjectsByStatus(ProjectStatus status);

    List<PublicProjectManagementDTO> getProjectsByLocation(String location);

    void deleteProject(Long id);

    List<PublicProjectManagementDTO> getProjectsByStatusAndLocation(ProjectStatus status, String location);
}
