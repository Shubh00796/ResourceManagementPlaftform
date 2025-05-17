package com.ReposiotryServices;

import com.Domian.PublicProjectManagementFeedbackEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Repository.PublicProjectManagementFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PublicProjectManagementFeedbackRepositoryService {
    private final PublicProjectManagementFeedbackRepository feedbackRepository;

    public PublicProjectManagementFeedbackEntity createFeedback(PublicProjectManagementFeedbackEntity feedbackEntity) {
        return getFeedbackEntity(feedbackEntity);
    }

    private PublicProjectManagementFeedbackEntity getFeedbackEntity(PublicProjectManagementFeedbackEntity feedbackEntity) {
        return feedbackRepository.save(feedbackEntity);
    }

    public PublicProjectManagementFeedbackEntity updateFeedback(PublicProjectManagementFeedbackEntity feedbackEntity) {
        return getFeedbackEntity(feedbackEntity);
    }

    public PublicProjectManagementFeedbackEntity getFeedbackById(Long id) {
        return getPublicProjectManagementFeedbackEntity(id);
    }

    private PublicProjectManagementFeedbackEntity getPublicProjectManagementFeedbackEntity(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given not found" + id));
    }


    public List<PublicProjectManagementFeedbackEntity> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public List<PublicProjectManagementFeedbackEntity> getFeedbacksByProjectId(Long projectId) {
        return feedbackRepository.findByProjectId(projectId);
    }

    public List<PublicProjectManagementFeedbackEntity> getFeedbacksByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }

    public List<PublicProjectManagementFeedbackEntity> getFeedbacksBySubmissionDate(LocalDate submissionDate) {
        return feedbackRepository.findBySubmissionDate(submissionDate);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);

    }
}
