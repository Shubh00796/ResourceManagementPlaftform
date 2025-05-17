package com.Repository;

import com.Domian.PublicProjectManagementFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PublicProjectManagementFeedbackRepository extends JpaRepository<PublicProjectManagementFeedbackEntity, Long> {

    List<PublicProjectManagementFeedbackEntity> findByProjectId(Long projectId);

    List<PublicProjectManagementFeedbackEntity> findByUserId(Long userId);

    List<PublicProjectManagementFeedbackEntity> findBySubmissionDate(LocalDate submissionDate);
}