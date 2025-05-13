package com.Services;


import com.DTOS.PublicProjectManagementFeedbackDTO;

import java.time.LocalDate;
import java.util.List;

public interface PublicProjectManagementFeedbackService {

    PublicProjectManagementFeedbackDTO createFeedback(PublicProjectManagementFeedbackDTO feedbackDTO);

    PublicProjectManagementFeedbackDTO updateFeedback(Long id, PublicProjectManagementFeedbackDTO feedbackDTO);

    PublicProjectManagementFeedbackDTO getFeedbackById(Long id);

    List<PublicProjectManagementFeedbackDTO> getAllFeedbacks();

    List<PublicProjectManagementFeedbackDTO> getFeedbacksByProjectId(Long projectId);

    List<PublicProjectManagementFeedbackDTO> getFeedbacksByUserId(Long userId);

    List<PublicProjectManagementFeedbackDTO> getFeedbacksBySubmissionDate(LocalDate submissionDate);

    void deleteFeedback(Long id);
}