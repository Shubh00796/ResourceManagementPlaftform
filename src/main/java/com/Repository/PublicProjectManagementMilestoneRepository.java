package com.Repository;

import com.Domian.Enums.MilestoneStatus;
import com.Domian.PublicProjectManagementMilestoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PublicProjectManagementMilestoneRepository extends JpaRepository<PublicProjectManagementMilestoneEntity, Long> {

    List<PublicProjectManagementMilestoneEntity> findByProjectId(Long projectId);

    List<PublicProjectManagementMilestoneEntity> findByStatus(MilestoneStatus status);

    List<PublicProjectManagementMilestoneEntity> findByDueDate(LocalDate dueDate);
}