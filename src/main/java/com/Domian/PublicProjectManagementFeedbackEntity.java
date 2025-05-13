package com.Domian;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PublicProjectManagementFeedbackEntity {
    private Long id;
    @NotNull(message = "Project ID is required")
    private Long projectId;
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotBlank(message = "Comment is required")
    private String comment;
    @NotNull(message = "Rating is required")
    private int rating;
    @NotNull(message = "Submission date is required")
    private LocalDate submissionDate;
}