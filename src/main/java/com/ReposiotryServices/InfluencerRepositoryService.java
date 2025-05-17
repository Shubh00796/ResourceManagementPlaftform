package com.ReposiotryServices;

import com.Domian.InfluencerEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Repository.InfluencerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class InfluencerRepositoryService {
    private final InfluencerRepository influencerRepository;

    public List<InfluencerEntity> getAllInfluencers() {
        return influencerRepository.findAll();
    }

    public InfluencerEntity getInfluencerById(Long id) {
        return influencerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id withb given Influence not found" + id));
    }

    public List<InfluencerEntity> getBySocialMediaPlatform(String socialMediaPlatform) {
        return influencerRepository.findBySocialMediaPlatform(socialMediaPlatform);
    }

    public InfluencerEntity createInfluencer(InfluencerEntity influencer) {
        return getInfluencerEntity(influencer);
    }


    public InfluencerEntity updateInfluencer(InfluencerEntity influencer) {
        return getInfluencerEntity(influencer);
    }

    public void deleteInfluencer(Long id) {
        influencerRepository.deleteById(id);
    }

    private InfluencerEntity getInfluencerEntity(InfluencerEntity influencer) {
        return influencerRepository.save(influencer);
    }

}
