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
public class PublicProjectManagementNotificationEntity {
    private Long id;
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotNull(message = "Project ID is required")
    private Long projectId;
    @NotBlank(message = "Message is required")
    private String message;
    @NotNull(message = "Timestamp is required")
    private LocalDate timestamp;
    @NotNull(message = "Viewed status is required")
    private Boolean viewed;
}