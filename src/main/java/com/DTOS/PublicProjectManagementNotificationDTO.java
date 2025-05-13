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
public class PublicProjectManagementNotificationDTO {

    private Long id;
    private Long userId;
    private Long projectId;
    private String message;
    private LocalDate timestamp;
    private Boolean viewed;
}