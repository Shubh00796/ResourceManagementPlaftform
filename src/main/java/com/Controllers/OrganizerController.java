package com.Controllers;

import com.DTOS.OrganizerDTO;
import com.Services.OrganizerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @GetMapping
    public ResponseEntity<List<OrganizerDTO>> getAllOrganizers() {
        List<OrganizerDTO> organizers = organizerService.getAllOrganizers();
        return ResponseEntity.ok(organizers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerDTO> getOrganizerById(@PathVariable Long id) {
        OrganizerDTO organizer = organizerService.getOrganizerById(id);
        return ResponseEntity.ok(organizer);
    }

    @PostMapping
    public ResponseEntity<OrganizerDTO> createOrganizer(@RequestBody @Valid OrganizerDTO organizer) {
        OrganizerDTO createdOrganizer = organizerService.createOrganizer(organizer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganizer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizerDTO> updateOrganizer(@PathVariable Long id, @RequestBody @Valid OrganizerDTO organizer) {
        OrganizerDTO updatedOrganizer = organizerService.updateOrganizer(organizer);
        return ResponseEntity.ok(updatedOrganizer); // Single return statement
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<OrganizerDTO>> getOrganizersByName(@PathVariable String name) {
        List<OrganizerDTO> organizers = organizerService.getOrganizersByName(name);
        return ResponseEntity.ok(organizers);
    }
}