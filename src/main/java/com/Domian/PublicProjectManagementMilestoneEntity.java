package com.Domian;

import com.Domian.Enums.MilestoneStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PublicProjectManagementMilestoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long projectId;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
    @NotNull(message = "Status is required")
    private MilestoneStatus status;


}