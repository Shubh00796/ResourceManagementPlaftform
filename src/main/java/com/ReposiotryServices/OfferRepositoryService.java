package com.ReposiotryServices;

import com.Domian.OfferEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OfferRepositoryService {
    private final OfferRepository offerRepository;

    public List<OfferEntity> getAllOffers() {
        return offerRepository.findAll();
    }

    public OfferEntity getOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given offer not found" + id));
    }

    public OfferEntity createOffer(OfferEntity offer) {
        return offerRepository.save(offer);
    }

    public OfferEntity updateOffer(OfferEntity offer) {
        return offerRepository.save(offer);
    }

    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    public List<OfferEntity> getOffersByInfluencerId(Long influencerId) {
        return offerRepository.findByInfluencerId(influencerId);
    }

    public List<OfferEntity> getOffersByBrandId(Long brandId) {
        return offerRepository.findByBrandId(brandId);
    }

    public OfferEntity saveOffer(OfferEntity offerEntity) {
        return offerRepository.save(offerEntity);
    }
}