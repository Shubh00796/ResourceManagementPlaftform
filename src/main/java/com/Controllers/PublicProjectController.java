package com.Controllers;


import com.DTOS.PublicProjectManagementDTO;
import com.Domian.Enums.ProjectStatus;
import com.Services.PublicProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class PublicProjectController {

    private final PublicProjectService publicProjectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicProjectManagementDTO createProject(@RequestBody PublicProjectManagementDTO projectDTO) {
        return publicProjectService.createProject(projectDTO);
    }

    @PutMapping("/{id}")
    public PublicProjectManagementDTO updateProject(@PathVariable Long id, @RequestBody PublicProjectManagementDTO projectDTO) {
        return publicProjectService.updateProject(id, projectDTO);
    }

    @GetMapping("/{id}")
    public PublicProjectManagementDTO getProjectById(@PathVariable Long id) {
        return publicProjectService.getProjectById(id);
    }

    @GetMapping
    public List<PublicProjectManagementDTO> getAllProjects() {
        return publicProjectService.getAllProjects();
    }

    @GetMapping("/status")
    public List<PublicProjectManagementDTO> getProjectsByStatus(@RequestParam ProjectStatus status) {
        return publicProjectService.getProjectsByStatus(status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id) {
        publicProjectService.deleteProject(id);
    }

    @GetMapping("/search")
    public List<PublicProjectManagementDTO> getProjectsByStatusAndLocation(
            @RequestParam ProjectStatus status,
            @RequestParam String location) {
        return publicProjectService.getProjectsByStatusAndLocation(status, location);
    }
}