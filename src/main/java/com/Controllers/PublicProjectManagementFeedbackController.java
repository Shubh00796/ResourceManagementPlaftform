package com.Controllers;


import com.DTOS.PublicProjectManagementFeedbackDTO;
import com.Services.PublicProjectManagementFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class PublicProjectManagementFeedbackController {

    private final PublicProjectManagementFeedbackService feedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PublicProjectManagementFeedbackDTO createFeedback(@RequestBody PublicProjectManagementFeedbackDTO feedbackDTO) {
        return feedbackService.createFeedback(feedbackDTO);
    }

    @PutMapping("/{id}")
    public PublicProjectManagementFeedbackDTO updateFeedback(@PathVariable Long id, @RequestBody PublicProjectManagementFeedbackDTO feedbackDTO) {
        return feedbackService.updateFeedback(id, feedbackDTO);
    }

    @GetMapping("/{id}")
    public PublicProjectManagementFeedbackDTO getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @GetMapping
    public List<PublicProjectManagementFeedbackDTO> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/project/{projectId}")
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksByProjectId(@PathVariable Long projectId) {
        return feedbackService.getFeedbacksByProjectId(projectId);
    }

    @GetMapping("/user/{userId}")
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksByUserId(@PathVariable Long userId) {
        return feedbackService.getFeedbacksByUserId(userId);
    }

    @GetMapping("/date")
    public List<PublicProjectManagementFeedbackDTO> getFeedbacksBySubmissionDate(@RequestParam LocalDate submissionDate) {
        return feedbackService.getFeedbacksBySubmissionDate(submissionDate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}