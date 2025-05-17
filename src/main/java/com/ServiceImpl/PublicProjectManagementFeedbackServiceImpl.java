package com.ServiceImpl;

import com.DTOS.PublicProjectManagementFeedbackDTO;
import com.Domian.PublicProjectManagementFeedbackEntity;
import com.Mapper.PublicProjectManagementFeedbackMapper;
import com.ReposiotryServices.ProjectRepositoryService;
import com.ReposiotryServices.PublicProjectManagementFeedbackRepositoryService;
import com.ReposiotryServices.UserRepositoryService;
import com.Services.PublicProjectManagementFeedbackService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublicProjectManagementFeedbackServiceImpl implements PublicProjectManagementFeedbackService {
    private final UserRepositoryService userRepositoryService;
    private final ProjectRepositoryService projectRepositoryService;
    private final PublicProjectManagementFeedbackRepositoryService publicProjectManagementFeedbackRepositoryService;
    private final PublicProjectManagementFeedbackMapper mapper;
    private final Validator validator;

    @Override
    public PublicProjectManagementFeedbackDTO createFeedback(PublicProjectManagementFeedbackDTO feedbackDTO) {
        validationOfIdsForCreatingFeedback(feedbackDTO);
        PublicProjectManagementFeedbackEntity publicProjectManagementFeedbackEntity = mapper.toEntity(feedbackDTO);
        validatePublicProjectManagementFeedbackEntity(publicProjectManagementFeedbackEntity);
        PublicProjectManagementFeedbackEntity createdFeedback = publicProjectManagementFeedbackRepositoryService.createFeedback(publicProjectManagementFeedbackEntity);
        return mapper.toDto(createdFeedback);

    }

    private void validationOfIdsForCreatingFeedback(PublicProjectManagementFeedbackDTO feedbackDTO) {

        Objects.requireNonNull(feedbackDTO.getProjectId(), "Offer cannot be null");
        Objects.requireNonNull(feedbackDTO.getUserId(), "userID id is required to create an Feedback");


        extracted(feedbackDTO);

    }

    private void extracted(PublicProjectManagementFeedbackDTO feedbackDTO) {
        extracted1(feedbackDTO);
        if (!userRepositoryService.existsById(feedbackDTO.getUserId())) {
            throw new RuntimeException("User with ID " + feedbackDTO.getUserId() + " does not exist");
        }
    }

    private void extracted1(PublicProjectManagementFeedbackDTO feedbackDTO) {
        if (!projectRepositoryService.existsById(feedbackDTO.getProjectId())) {
            throw new RuntimeException("Project with ID " + feedbackDTO.getProjectId() + " does not exist");
        }
    }

    @Override
    public PublicProjectManagementFeedbackDTO updateFeedback(Long id, PublicProjectManagementFeedbackDTO feedbackDTO) {
        PublicProjectManagementFeedbackEntity existingFeedback = getPublicProjectManagementFeedbackEntity(id);
        validatePublicProjectManagementFeedbackEntity(existingFeedback);
        mapper.updateEntityFromDto(feedbackDTO, existingFeedback);
        PublicProjectManagementFeedbackEntity updatedPublicProjectManagementFeedbackEntity = publicProjectManagementFeedbackRepositoryService.updateFeedback(existingFeedback);


        return mapper.toDto(updatedPublicProjectManagementFeedbackEntity);
    }

    private PublicProjectManagementFeedbackEntity getPublicProjectManagementFeedbackEntity(Long id) {
        PublicProjectManagementFeedbackEntity existingFeedback = publicProjectManagementFeedbackRepositoryService.getFeedbackById(id);
        return existingFeedback;
    }

    @Override
    public PublicProjectManagementFeedbackDTO getFeedbackById(Long id) {
        PublicProjectManagementFeedbackEntity existingFeedback = getPublicProjectManagementFeedbackEntity(id);

        return mapper.toDto(existingFeedback);
    }

    @Override
    public List<PublicProjectManagementFeedbackDTO> getAllFeedbacks() {
        return publicProjectManagementFeedbackRepositoryService.getAllFeedbacks()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksByProjectId(Long projectId) {
        return publicProjectManagementFeedbackRepositoryService.getFeedbacksByProjectId(projectId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksByUserId(Long userId) {
        return publicProjectManagementFeedbackRepositoryService.getFeedbacksByUserId(userId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksBySubmissionDate(LocalDate submissionDate) {
        return publicProjectManagementFeedbackRepositoryService.getFeedbacksBySubmissionDate(submissionDate)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFeedback(Long id) {
        publicProjectManagementFeedbackRepositoryService.deleteFeedback(id);

    }

    private void validatePublicProjectManagementFeedbackEntity(PublicProjectManagementFeedbackEntity feedbackEntity) {
        Set<ConstraintViolation<PublicProjectManagementFeedbackEntity>> violations = validator.validate(feedbackEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
