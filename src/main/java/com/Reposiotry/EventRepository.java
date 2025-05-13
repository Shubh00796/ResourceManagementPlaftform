package com.Reposiotry;

import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import com.Domian.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    // Method for retrieving events by organizer ID
    List<EventEntity> findByOrganizerId(Long organizerId);

    // Method for retrieving events by category
    List<EventEntity> findByCategory(EventCategory category);

    // Method for retrieving events by status
    List<EventEntity> findByStatus(Status status);

    // Method for retrieving events by title (case-insensitive)
    List<EventEntity> findByTitleContainingIgnoreCase(String title);
}