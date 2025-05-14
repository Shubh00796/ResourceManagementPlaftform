package com.Controllers;


import com.DTOS.PublicProjectManagementMilestoneDTO;
import com.Domian.Enums.MilestoneStatus;
import com.Services.PublicProjectManagementMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestones")
@RequiredArgsConstructor
public class PublicProjectManagementMilestoneController {

    private final PublicProjectManagementMilestoneService milestoneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicProjectManagementMilestoneDTO createMilestone(@RequestBody PublicProjectManagementMilestoneDTO milestoneDTO) {
        return milestoneService.createMilestone(milestoneDTO);
    }

    @PutMapping("/{id}")
    public PublicProjectManagementMilestoneDTO updateMilestone(@PathVariable Long id, @RequestBody PublicProjectManagementMilestoneDTO milestoneDTO) {
        return milestoneService.updateMilestone(id, milestoneDTO);
    }

    @GetMapping("/{id}")
    public PublicProjectManagementMilestoneDTO getMilestoneById(@PathVariable Long id) {
        return milestoneService.getMilestoneById(id);
    }

    @GetMapping
    public List<PublicProjectManagementMilestoneDTO> getAllMilestones() {
        return milestoneService.getAllMilestones();
    }

    @GetMapping("/project/{projectId}")
    public List<PublicProjectManagementMilestoneDTO> getMilestonesByProjectId(@PathVariable Long projectId) {
        return milestoneService.getMilestonesByProjectId(projectId);
    }

    @GetMapping("/status")
    public List<PublicProjectManagementMilestoneDTO> getMilestonesByStatus(@RequestParam MilestoneStatus status) {
        return milestoneService.getMilestonesByStatus(status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMilestone(@PathVariable Long id) {
        milestoneService.deleteMilestone(id);
    }
}