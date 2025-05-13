package com.Services;



import com.DTOS.PublicProjectManagementMilestoneDTO;
import com.Domian.Enums.MilestoneStatus;

import java.util.List;

public interface PublicProjectManagementMilestoneService {

    PublicProjectManagementMilestoneDTO createMilestone(PublicProjectManagementMilestoneDTO milestoneDTO);

    PublicProjectManagementMilestoneDTO updateMilestone(Long id, PublicProjectManagementMilestoneDTO milestoneDTO);

    PublicProjectManagementMilestoneDTO getMilestoneById(Long id);

    List<PublicProjectManagementMilestoneDTO> getAllMilestones();

    List<PublicProjectManagementMilestoneDTO> getMilestonesByProjectId(Long projectId);

    List<PublicProjectManagementMilestoneDTO> getMilestonesByStatus(MilestoneStatus status);

    void deleteMilestone(Long id);
}