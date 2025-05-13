package com.ReposiotryServices;

import com.DTOS.EventDTO;
import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import com.Domian.EventEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.EventRepository;
import com.Services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventRepositoryService {
    private final EventRepository eventRepository;

    public List<EventEntity> retriveAllEventsFromRepo() {
        return eventRepository.findAll();
    }

    public EventEntity retriveEventByIdFromRepo(Long id) {
        return findIdByEventOrElseThrow(id);
    }

    private EventEntity findIdByEventOrElseThrow(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id with given event not found" + id));
    }

    public EventEntity saveEventToRepo(EventEntity event) {
        return eventRepository.save(event);
    }


    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<EventEntity> retriveEventBuOrganizersId(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    public List<EventEntity> retriveEventByCategory(EventCategory category) {
        return eventRepository.findByCategory(category);
    }

    public List<EventEntity> retriveEvnetByStatus(Status status) {
        return eventRepository.findByStatus(status);
    }


    public List<EventEntity> retriveEventsByTitle(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }
}
