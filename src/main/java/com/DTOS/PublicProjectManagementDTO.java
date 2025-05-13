package com.DTOS;

import com.Domian.Enums.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicProjectManagementDTO {

    private Long id;
    private String name;
    private String description;
    private String location;
    private ProjectStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private Double expenditure;
    private Long milestoneId;
    private Long feedbackId;
}