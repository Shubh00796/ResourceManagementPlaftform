package com.Repository;


import com.Domian.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    Optional<ResourceEntity> findByName(String name);

    List<ResourceEntity> findByCategory(String category);

    List<ResourceEntity> findByAvailable(Boolean available);


    List<ResourceEntity> findByOwnerId(Long ownerId);
}