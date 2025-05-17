package com.ServiceImpl;

import com.DTOS.EventDTO;
import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import com.Domian.EventEntity;
import com.Mapper.EventMapper;
import com.Repository.OrganizerRepository;
import com.ReposiotryServices.EventRepositoryService;
import com.Services.EventService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepositoryService repositoryService;
    private final EventMapper mapper;
    private final OrganizerRepository repository;
    private final Validator validator;

    @Override
    public List<EventDTO> getAllEvents() {
        return repositoryService.retriveAllEventsFromRepo()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        EventEntity eventEntity = repositoryService.retriveEventByIdFromRepo(id);
        return mapper.toDto(eventEntity);
    }

    @Override
    public EventDTO createEvent(EventDTO event) {
        extracted(event);
        EventEntity eventEntity = mapper.toEntity(event);
        validateEvnet(eventEntity);
        EventEntity eventSavedToRepo = repositoryService.saveEventToRepo(eventEntity);

        return mapper.toDto(eventSavedToRepo);
    }

    private void extracted(EventDTO event) {
        if (event.getOrganizerId() == null) {
            throw new RuntimeException("Organizer ID is required to create an event");
        }
        if (!repository.existsById(event.getOrganizerId())) {
            throw new RuntimeException("Organizer with ID " + event.getOrganizerId() + " does not exist");
        }
    }

    @Override
    public EventDTO updateEvent(EventDTO event) {
        EventEntity existingEntity = repositoryService.retriveEventByIdFromRepo(event.getId());
        mapper.updateEntityFromDto(event, existingEntity);
        EventEntity updatedEventEntity = repositoryService.saveEventToRepo(existingEntity);

        return mapper.toDto(updatedEventEntity);
    }

    @Override
    public void deleteEvent(Long id) {
        repositoryService.deleteEvent(id);
    }

    @Override
    public List<EventDTO> getEventsByOrganizerId(Long organizerId) {
        return repositoryService.retriveEventBuOrganizersId(organizerId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getEventsByCategory(EventCategory category) {
        return repositoryService.retriveEventByCategory(category)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getEventsByStatus(Status status) {
        return repositoryService.retriveEvnetByStatus(status)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getEventsByTitle(String title) {
        return repositoryService.retriveEventsByTitle(title)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

    }

    private void validateEvnet(EventEntity event) {
        Set<ConstraintViolation<EventEntity>> violations = validator.validate(event);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
