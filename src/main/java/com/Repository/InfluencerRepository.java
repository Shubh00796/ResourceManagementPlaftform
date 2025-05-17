package com.Repository;

import com.Domian.InfluencerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfluencerRepository extends JpaRepository<InfluencerEntity, Long> {

    List<InfluencerEntity> findBySocialMediaPlatform(String socialMediaPlatform);

}