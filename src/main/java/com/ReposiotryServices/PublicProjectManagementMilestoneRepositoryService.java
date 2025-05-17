package com.ReposiotryServices;

import com.Domian.Enums.MilestoneStatus;
import com.Domian.PublicProjectManagementMilestoneEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Repository.PublicProjectManagementMilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PublicProjectManagementMilestoneRepositoryService {
    private final PublicProjectManagementMilestoneRepository publicProjectManagementMilestoneRepository;

    public PublicProjectManagementMilestoneEntity createMilestone(PublicProjectManagementMilestoneEntity managementMilestoneEntity) {
        return publicProjectManagementMilestoneRepository.save(managementMilestoneEntity);
    }

    public PublicProjectManagementMilestoneEntity updateMilestone(PublicProjectManagementMilestoneEntity managementMilestoneEntity) {
        return publicProjectManagementMilestoneRepository.save(managementMilestoneEntity);
    }

    public PublicProjectManagementMilestoneEntity getMilestoneById(Long id) {
        return getPublicProjectManagementMilestoneEntity(id);
    }

    private PublicProjectManagementMilestoneEntity getPublicProjectManagementMilestoneEntity(Long id) {
        return publicProjectManagementMilestoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Id with given Milestone not found" + id)));
    }

    public List<PublicProjectManagementMilestoneEntity> getAllMilestones() {
        return publicProjectManagementMilestoneRepository.findAll();
    }

    public List<PublicProjectManagementMilestoneEntity> getMilestonesByProjectId(Long projectId) {
        return publicProjectManagementMilestoneRepository.findByProjectId(projectId);
    }

    public List<PublicProjectManagementMilestoneEntity> getMilestonesByStatus(MilestoneStatus status) {
        return publicProjectManagementMilestoneRepository.findByStatus(status);
    }

    public void deleteMilestone(Long id) {
        publicProjectManagementMilestoneRepository.deleteById(id);

    }
}
