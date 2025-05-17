package com.ServiceImpl;

import com.DTOS.InfluencerDTO;
import com.Domian.InfluencerEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Mapper.InfluencerMapper;
import com.ReposiotryServices.InfluencerRepositoryService;
import com.Services.InfluencerService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class InfluencerServiceImpl implements InfluencerService {
    private final InfluencerRepositoryService repositoryService;
    private final InfluencerMapper mapper;
    private final Validator validator;

    @Override
    public List<InfluencerDTO> getAllInfluencers() {
        return repositoryService.getAllInfluencers()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InfluencerDTO> getBySocialMediaPlatform(String socialMediaPlatform) {
        return repositoryService.getBySocialMediaPlatform(socialMediaPlatform)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public InfluencerDTO getInfluencerById(Long id) {
        InfluencerEntity influencerEntity = repositoryService.getInfluencerById(id);
        return mapper.toDto(influencerEntity);
    }

    @Override
    public InfluencerDTO createInfluencer(InfluencerDTO influencer) {
        InfluencerEntity influencerEntity = mapper.toEntity(influencer);
        validateInfluencer(influencerEntity);
        InfluencerEntity repositoryServiceInfluencer = repositoryService.createInfluencer(influencerEntity);
        return mapper.toDto(repositoryServiceInfluencer);
    }

    @Override
    public InfluencerDTO updateInfluencer(InfluencerDTO influencer) {
        InfluencerEntity existingInfluencer = repositoryService.getInfluencerById(influencer.getId());
        if (existingInfluencer == null) {
            throw new ResourceNotFoundException("existingInfluencer not found with ID: " + influencer.getId());
        }
        validateInfluencer(existingInfluencer);
        mapper.updateEntityFromDto(influencer, existingInfluencer);
        InfluencerEntity updateInfluencer = repositoryService.updateInfluencer(existingInfluencer);

        return mapper.toDto(updateInfluencer);
    }

    @Override
    public void deleteInfluencer(Long id) {

        Objects.requireNonNull(id, "Offer cannot be null");



        repositoryService.deleteInfluencer(id);

    }

    private void validateInfluencer(InfluencerEntity influencerEntity) {
        Set<ConstraintViolation<InfluencerEntity>> violations = validator.validate(influencerEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
