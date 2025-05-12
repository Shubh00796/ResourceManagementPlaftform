package com.Services;

import com.DTOS.ResourceDTO;
import com.Domian.UserEntity;

import java.util.List;

public interface ResourceService {
    List<ResourceDTO> getAllResources();

    ResourceDTO getResourceById(Long id);

    ResourceDTO createResource(ResourceDTO resource);

    ResourceDTO updateResource(ResourceDTO resource);

    void deleteResource(Long id);

    List<ResourceDTO> getAvailableResources(Boolean available);

    List<ResourceDTO> getSharedResourcesByUser(Long ownerId);
}