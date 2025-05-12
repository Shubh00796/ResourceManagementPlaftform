package com.Controllers;

import com.DTOS.ResourceDTO;
import com.Domian.UserEntity;
import com.Services.ResourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        List<ResourceDTO> resources = resourceService.getAllResources();
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable Long id) {
        ResourceDTO resource = resourceService.getResourceById(id);
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> createResource(@RequestBody @Valid ResourceDTO resource) {
        ResourceDTO createdResource = resourceService.createResource(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResourceDTO> updateResource(@PathVariable Long id, @RequestBody @Valid ResourceDTO resource) {
        // Similar note as in BorrowRequestController regarding partial updates
        ResourceDTO updatedResource = resourceService.updateResource(resource);
        return ResponseEntity.ok(updatedResource);
    }

    @GetMapping("/available")
    public ResponseEntity<List<ResourceDTO>> getAvailableResources(@RequestParam Boolean available) {
        List<ResourceDTO> resources = resourceService.getAvailableResources(available);
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/shared/user/{userId}")
    public ResponseEntity<List<ResourceDTO>> getSharedResourcesByUser(@PathVariable Long ownerId) {
        List<ResourceDTO> resources = resourceService.getSharedResourcesByUser(ownerId);
        return ResponseEntity.ok(resources);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }
}