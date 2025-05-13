package com.ServiceImpl;

import com.DTOS.OrganizerDTO;
import com.Domian.OrganizerEntity;
import com.Mapper.OrganizerMapper;
import com.ReposiotryServices.OrganizerRepositoryService;
import com.Services.OrganizerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {
    private final OrganizerRepositoryService repositoryService;
    private final OrganizerMapper mapper;
    private final Validator validator;

    @Override
    public List<OrganizerDTO> getAllOrganizers() {
        return repositoryService.getAllOrganizers().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrganizerDTO getOrganizerById(Long id) {
        OrganizerEntity organizerEntity = repositoryService.getOrganizerById(id);
        return mapper.toDto(organizerEntity);
    }

    @Override
    @Transactional
    public OrganizerDTO createOrganizer(OrganizerDTO organizer) {
        OrganizerEntity organizerEntity = mapper.toEntity(organizer);
        validateOrganizer(organizerEntity);
        OrganizerEntity organizerSavedToRepo = repositoryService.createOrganizer(organizerEntity);


        return mapper.toDto(organizerSavedToRepo);
    }

    @Override
    @Transactional
    public OrganizerDTO updateOrganizer(OrganizerDTO organizer) {
        OrganizerEntity existingOrganizer = repositoryService.getOrganizerById(organizer.getId());
        mapper.updateEntityFromDto(organizer, existingOrganizer);
        validateOrganizer(existingOrganizer);
        OrganizerEntity updatedOrganizer = repositoryService.updateOrganizer(existingOrganizer);
        return mapper.toDto(updatedOrganizer);
    }

    @Override
    public void deleteOrganizer(Long id) {
        repositoryService.deleteOrganizer(id);

    }

    @Override
    public List<OrganizerDTO> getOrganizersByName(String name) {
        return repositoryService.getOrganizersByName(name).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    private void validateOrganizer(OrganizerEntity organizerEntity) {
        Set<ConstraintViolation<OrganizerEntity>> violations = validator.validate(organizerEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
