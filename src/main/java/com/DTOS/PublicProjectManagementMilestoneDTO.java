package com.DTOS;

import com.Domian.Enums.MilestoneStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublicProjectManagementMilestoneDTO {

    private Long id;
    private Long projectId;
    private String description;
    private LocalDate dueDate;
    private MilestoneStatus status;
}