package com.Controllers;

import com.DTOS.EventDTO;
import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import com.Services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody @Valid EventDTO event) {
        EventDTO createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody @Valid EventDTO event) {

        EventDTO updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/organizer/{organizerId}")
    public ResponseEntity<List<EventDTO>> getEventsByOrganizerId(@PathVariable Long organizerId) {
        List<EventDTO> events = eventService.getEventsByOrganizerId(organizerId);
        return ResponseEntity.ok(events);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<EventDTO>> getEventsByCategory(@PathVariable String category) {

        List<EventDTO> events = eventService.getEventsByCategory(EventCategory.valueOf(category.toUpperCase()));
        return ResponseEntity.ok(events);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<EventDTO>> getEventsByStatus(@PathVariable String status) {

        List<EventDTO> events = eventService.getEventsByStatus(Status.valueOf(status.toUpperCase()));
        return ResponseEntity.ok(events);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<EventDTO>> getEventsByTitle(@PathVariable String title) {
        List<EventDTO> events = eventService.getEventsByTitle(title);
        return ResponseEntity.ok(events);
    }
}