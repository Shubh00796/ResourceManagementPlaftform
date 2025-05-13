package com.Domian;

import com.Domian.Enums.ProjectStatus;
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
public class ProjectEntity {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Status is required")
    private ProjectStatus status;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    @NotNull(message = "Budget is required")
    private Double budget;
    @NotNull(message = "Expenditure is required")
    private Double expenditure;
    @NotNull(message = "Milestones are required")
    private Long milestoneId;
    @NotNull(message = "Feedback IDs are required")
    private Long feedbackId;


}