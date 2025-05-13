package com.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicProjectManagementFeedbackDTO {

    private Long id;
    private Long projectId;
    private Long userId;
    private String comment;
    private int rating;
    private LocalDate submissionDate;
}