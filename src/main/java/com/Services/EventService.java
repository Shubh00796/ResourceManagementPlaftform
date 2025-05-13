package com.Services;

import com.DTOS.EventDTO;
import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;

import java.util.List;

public interface EventService {

    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);

    EventDTO createEvent(EventDTO event);

    EventDTO updateEvent(EventDTO event);

    void deleteEvent(Long id);

    List<EventDTO> getEventsByOrganizerId(Long organizerId);

    List<EventDTO> getEventsByCategory(EventCategory category);

    List<EventDTO> getEventsByStatus(Status status);

    List<EventDTO> getEventsByTitle(String title);
}