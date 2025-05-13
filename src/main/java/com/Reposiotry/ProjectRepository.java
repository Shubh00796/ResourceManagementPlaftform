package com.Reposiotry;

import com.Domian.Enums.ProjectStatus;
import com.Domian.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> findByStatus(ProjectStatus status);

    List<ProjectEntity> findByFeedbackId(Long feedbackId);

    List<ProjectEntity> findByMilestoneId(Long milestoneId);

    List<ProjectEntity> findByLocation(String location);

    // Example of a custom query using JPQL to find projects by status and location
    @Query("SELECT p FROM ProjectEntity p WHERE p.status = :status AND p.location = :location")
    List<ProjectEntity> findByStatusAndLocation(@Param("status") ProjectStatus status, @Param("location") String location);
}