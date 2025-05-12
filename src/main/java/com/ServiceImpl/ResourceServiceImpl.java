package com.ServiceImpl;

import com.DTOS.ResourceDTO;
import com.Domian.ResourceEntity;
import com.Domian.UserEntity;
import com.Mapper.ResourceMapper;
import com.ReposiotryServices.ResourceRepositoryService;
import com.Services.ResourceService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {
    private final ResourceRepositoryService repositoryService;
    private final ResourceMapper mapper;
    private final Validator validator;

    @Override
    public List<ResourceDTO> getAllResources() {
        return repositoryService.getAllResources()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceDTO getResourceById(Long id) {
        ResourceEntity resourceById = repositoryService.getResourceById(id);
        return mapper.toDto(resourceById);
    }

    @Override
    public ResourceDTO createResource(ResourceDTO resource) {
        ResourceEntity resourceEntity = mapper.toEntity(resource);
        validateResourceEntity(resourceEntity);
        ResourceEntity savedResource = repositoryService.createResource(resourceEntity);
        return mapper.toDto(savedResource);
    }

    @Override
    public ResourceDTO updateResource(ResourceDTO resource) {
        ResourceEntity existingEntity = repositoryService.getResourceById(resource.getId());
        mapper.updateEntityFromDto(resource, existingEntity);
        ResourceEntity updatedResourceEntity = repositoryService.createResource(existingEntity);

        return mapper.toDto(updatedResourceEntity);
    }

    @Override
    public void deleteResource(Long id) {
        repositoryService.deleteResource(id);

    }

    @Override
    public List<ResourceDTO> getAvailableResources(Boolean available) {
        return repositoryService.getAvailableResources(available)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResourceDTO> getSharedResourcesByUser(Long ownerId) {
        return repositoryService.getSharedResourcesByUser(ownerId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private void validateResourceEntity(ResourceEntity resourceEntity) {
        Set<ConstraintViolation<ResourceEntity>> violations = validator.validate(resourceEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }


}
