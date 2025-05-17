package com.Repository;


import com.Domian.PublicProjectManagementNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicProjectManagementNotificationRepository extends JpaRepository<PublicProjectManagementNotificationEntity, Long> {

    List<PublicProjectManagementNotificationEntity> findByUserId(Long userId);



}