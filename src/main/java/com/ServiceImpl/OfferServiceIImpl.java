package com.ServiceImpl;

import com.DTOS.BrandDTO;
import com.DTOS.InfluencerDTO;
import com.DTOS.OfferDTO;
import com.Domian.Enums.OfferStatus;
import com.Domian.OfferEntity;
import com.Exceptions.InsufficientBudgetException;
import com.Exceptions.OfferUpdateException;
import com.Exceptions.ResourceNotFoundException;
import com.Mapper.OfferMapper;
import com.ReposiotryServices.OfferRepositoryService;
import com.Services.BrandService;
import com.Services.InfluencerService;
import com.Services.OfferService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OfferServiceIImpl implements OfferService {
    private final OfferRepositoryService repositoryService;
    private final OfferMapper mapper;
    private final BrandService brandService;
    private final InfluencerService influencerService;
    private final Validator validator;

    @Override
    public List<OfferDTO> getAllOffers() {
        return repositoryService.getAllOffers().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OfferDTO getOfferById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Offer ID must not be null");
        }
        OfferEntity offerEntity = repositoryService.getOfferById(id);
        return mapper.toDto(offerEntity);
    }


    @Override
    public OfferDTO createOffer(OfferDTO offer) {
        if (offer.getBrandId() == null) {
            throw new IllegalArgumentException("Brand ID must not be null");
        }
        if (offer.getInfluencerId() == null) {
            throw new IllegalArgumentException("Influencer ID must not be null");
        }


        validateOfferCreationConditions(offer);
        OfferEntity offerEntity = mapper.toEntity(offer);
        validateOffer(offerEntity);

        OfferEntity repositoryServiceOffer = repositoryService.createOffer(offerEntity);


        return mapper.toDto(repositoryServiceOffer);
    }


    @Override
    public OfferDTO updateOffer(OfferDTO offer) {
        if (offer == null) {
            throw new NullPointerException("Offer cannot be null");
        }
        OfferEntity existingOffer = repositoryService.getOfferById(offer.getId());
        checkTheOfferStatus(existingOffer);
        validateOffer(existingOffer);
        mapper.updateEntityFromDto(offer, existingOffer);
        OfferEntity updatedOffer = repositoryService.updateOffer(existingOffer);


        return mapper.toDto(updatedOffer);
    }

    private static void checkTheOfferStatus(OfferEntity existingOffer) {
        if (existingOffer.getStatus() == null || !existingOffer.getStatus().equals(OfferStatus.PENDING)) {
            throw new OfferUpdateException("Cannot update an offer that is not in PENDING status");
        }
    }

    @Override
    public void deleteOffer(Long id) {
        if (id == null) {
            throw new NullPointerException("Offer ID cannot be null");
        }
        repositoryService.deleteOffer(id);

    }

    @Override
    public List<OfferDTO> getOffersByInfluencerId(Long influencerId) {
        return repositoryService.getOffersByInfluencerId(influencerId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<OfferDTO> getOffersByBrandId(Long brandId) {
        return repositoryService.getOffersByBrandId(brandId).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OfferDTO rejectOffer(Long id) {
        OfferEntity offerEntity = repositoryService.getOfferById(id);

        checkTheOfferStatus(offerEntity);
        offerEntity.setStatus(OfferStatus.REJECTED);
        OfferEntity updatedRepositoryServiceOffer = repositoryService.createOffer(offerEntity);
        OfferDTO offerDTO = mapper.toDto(updatedRepositoryServiceOffer);
        return offerDTO;

    }

    @Override
    public OfferDTO acceptOffer(Long id) {
        OfferEntity offerEntity = repositoryService.getOfferById(id);
        checkTheOfferStatus(offerEntity);
        offerEntity.setStatus(OfferStatus.ACCEPTED);

        engagementOfBrandAndInfluencerForMakingTheOfferorAfterTheOffer(offerEntity);

        // Update the offer using the save method (which handles both insert and update)
        OfferEntity updatedRepositoryServiceOffer = repositoryService.saveOffer(offerEntity);
        OfferDTO offerDTO = mapper.toDto(updatedRepositoryServiceOffer);
        return offerDTO;
    }


    private void validateOffer(OfferEntity offerEntity) {
        Set<ConstraintViolation<OfferEntity>> violations = validator.validate(offerEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    private void validateOfferCreationConditions(OfferDTO offer) {
        if (offer == null) {
            throw new NullPointerException("Offer cannot be null");
        }
        if (offer.getBrandId() == null) {
            throw new IllegalArgumentException("Brand ID must not be null");
        }
        if (offer.getInfluencerId() == null) {
            throw new IllegalArgumentException("Influencer ID must not be null");
        }

        InfluencerDTO influencerDTO = influencerService.getInfluencerById(offer.getInfluencerId());
        if (influencerDTO == null) {
            throw new ResourceNotFoundException("Influencer not found with ID: " + offer.getInfluencerId());
        }

        BrandDTO brandDTO = brandService.getBrandById(offer.getBrandId());
        if (brandDTO == null) {
            throw new ResourceNotFoundException("Brand not found with ID: " + offer.getBrandId());
        }

        if (brandDTO.getRemainingBudget() < offer.getAmount()) {
            throw new InsufficientBudgetException("Insufficient budget for the brand to make this offer");
        }
    }

    private void engagementOfBrandAndInfluencerForMakingTheOfferorAfterTheOffer(OfferEntity offerEntity) {
        BrandDTO brandDTO = brandService.getBrandById(offerEntity.getBrandId());

        if (offerEntity.getBrandId() == null) {
            throw new IllegalArgumentException("Brand ID must not be null");
        }

        // Deduct the offer amount from the brand's remaining budget
        brandDTO.setRemainingBudget(brandDTO.getRemainingBudget() - offerEntity.getAmount());
        brandService.updateBrand(brandDTO);

        // Add the offer amount to the influencer's total earnings
        InfluencerDTO influencerDTO = influencerService.getInfluencerById(offerEntity.getInfluencerId());
        influencerDTO.setTotalEarnings(influencerDTO.getTotalEarnings() + offerEntity.getAmount());
        influencerService.updateInfluencer(influencerDTO);
    }
}
