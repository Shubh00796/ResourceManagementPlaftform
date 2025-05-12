package com.ReposiotryServices;

import com.DTOS.ResourceDTO;
import com.Domian.ResourceEntity;
import com.Domian.UserEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.ResourceRepository;
import com.Services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.ref.ReferenceQueue;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResourceRepositoryService {
    private final ResourceRepository repository;

    public List<ResourceEntity> getAllResources() {
        return repository.findAll();
    }

    public ResourceEntity getResourceById(Long id) {
        return getOredElseThrow(id);
    }


    public ResourceEntity createResource(ResourceEntity resourceEntity) {
        return repository.save(resourceEntity);
    }


    public void deleteResource(Long id) {
        repository.deleteById(id);
    }

    public List<ResourceEntity> getAvailableResources(Boolean available) {
        return repository.findByAvailable(available);
    }

    public List<ResourceEntity> getSharedResourcesByUser(Long ownerId) {
        return repository.findByOwnerId(ownerId);
    }

    private ResourceEntity getOredElseThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id with given Resource Not Found"));
    }
}
