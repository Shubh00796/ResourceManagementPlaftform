package com.ServiceImpl;

import com.DTOS.PublicProjectManagementMilestoneDTO;
import com.Domian.Enums.MilestoneStatus;
import com.Domian.PublicProjectManagementMilestoneEntity;
import com.Mapper.PublicProjectManagementMilestoneMapper;
import com.ReposiotryServices.PublicProjectManagementMilestoneRepositoryService;
import com.Services.PublicProjectManagementMilestoneService;
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
public class PublicProjectManagementMilestoneServiceImpl implements PublicProjectManagementMilestoneService {
    private final PublicProjectManagementMilestoneRepositoryService repositoryService;
    private final PublicProjectManagementMilestoneMapper mapper;
    private final Validator validator;

    @Override
    public PublicProjectManagementMilestoneDTO createMilestone(PublicProjectManagementMilestoneDTO milestoneDTO) {
        PublicProjectManagementMilestoneEntity publicProjectManagementMilestoneEntity = mapper.toEntity(milestoneDTO);
        validatePublicProjectManagementMilestoneEntity(publicProjectManagementMilestoneEntity);
        PublicProjectManagementMilestoneEntity milestoneEntity = repositoryService.createMilestone(publicProjectManagementMilestoneEntity);

        return mapper.toDto(milestoneEntity);
    }

    @Override
    public PublicProjectManagementMilestoneDTO updateMilestone(Long id, PublicProjectManagementMilestoneDTO milestoneDTO) {
        PublicProjectManagementMilestoneEntity existingMilestone = getPublicProjectManagementMilestoneEntity(id);
        validatePublicProjectManagementMilestoneEntity(existingMilestone);
        mapper.updateEntityFromDto(milestoneDTO, existingMilestone);
        PublicProjectManagementMilestoneEntity publicProjectManagementMilestoneEntity = repositoryService.updateMilestone(existingMilestone);

        return mapper.toDto(publicProjectManagementMilestoneEntity);
    }

    @Override
    public PublicProjectManagementMilestoneDTO getMilestoneById(Long id) {
        PublicProjectManagementMilestoneEntity existingMilestone = getPublicProjectManagementMilestoneEntity(id);

        return mapper.toDto(existingMilestone);
    }

    @Override
    public List<PublicProjectManagementMilestoneDTO> getAllMilestones() {
        return getPublicProjectManagementMilestoneDTOList();
    }

    private List<PublicProjectManagementMilestoneDTO> getPublicProjectManagementMilestoneDTOList() {
        return repositoryService.getAllMilestones()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicProjectManagementMilestoneDTO> getMilestonesByProjectId(Long projectId) {
        return getPublicProjectManagementMilestoneDTOListOfProjectId(projectId);
    }

    private List<PublicProjectManagementMilestoneDTO> getPublicProjectManagementMilestoneDTOListOfProjectId(Long projectId) {
        return repositoryService.getMilestonesByProjectId(projectId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicProjectManagementMilestoneDTO> getMilestonesByStatus(MilestoneStatus status) {
        return repositoryService.getMilestonesByStatus(status)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMilestone(Long id) {
        repositoryService.deleteMilestone(id);

    }

    private void validatePublicProjectManagementMilestoneEntity(PublicProjectManagementMilestoneEntity publicProjectManagementMilestoneEntity) {
        Set<ConstraintViolation<PublicProjectManagementMilestoneEntity>> violations = validator.validate(publicProjectManagementMilestoneEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }


    private PublicProjectManagementMilestoneEntity getPublicProjectManagementMilestoneEntity(Long id) {
        PublicProjectManagementMilestoneEntity existingMilestone = repositoryService.getMilestoneById(id);
        return existingMilestone;
    }

}
