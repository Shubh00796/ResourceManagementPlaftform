package com.Services;

import com.DTOS.OfferDTO;

import java.util.List;

public interface OfferService {

    List<OfferDTO> getAllOffers();

    OfferDTO getOfferById(Long id);

    OfferDTO createOffer(OfferDTO offer);

    OfferDTO updateOffer(OfferDTO offer);

    void deleteOffer(Long id);

    List<OfferDTO> getOffersByInfluencerId(Long influencerId);

    List<OfferDTO> getOffersByBrandId(Long brandId);
}