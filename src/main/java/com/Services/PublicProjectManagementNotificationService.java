package com.Services;


import com.DTOS.PublicProjectManagementNotificationDTO;

import java.time.LocalDate;
import java.util.List;

public interface PublicProjectManagementNotificationService {

    PublicProjectManagementNotificationDTO createNotification(PublicProjectManagementNotificationDTO notificationDTO);

    PublicProjectManagementNotificationDTO updateNotification(Long id, PublicProjectManagementNotificationDTO notificationDTO);

    PublicProjectManagementNotificationDTO getNotificationById(Long id);

    List<PublicProjectManagementNotificationDTO> getAllNotifications();

    List<PublicProjectManagementNotificationDTO> getNotificationsByUserId(Long userId);

    List<PublicProjectManagementNotificationDTO> getNotificationsByProjectId(Long projectId);

    List<PublicProjectManagementNotificationDTO> getNotificationsByViewed(Boolean viewed);

    List<PublicProjectManagementNotificationDTO> getNotificationsByTimestamp(LocalDate timestamp);

    void deleteNotification(Long id);
}