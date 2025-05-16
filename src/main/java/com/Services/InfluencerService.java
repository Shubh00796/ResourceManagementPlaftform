package com.Services;

import com.DTOS.InfluencerDTO;

import java.util.List;

public interface InfluencerService {

    List<InfluencerDTO> getAllInfluencers();

    InfluencerDTO getInfluencerById(Long id);

    InfluencerDTO createInfluencer(InfluencerDTO influencer);

    InfluencerDTO updateInfluencer(InfluencerDTO influencer);

    void deleteInfluencer(Long id);
}