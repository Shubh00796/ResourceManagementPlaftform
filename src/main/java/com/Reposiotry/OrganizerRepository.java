package com.Reposiotry;

import com.Domian.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {

    List<OrganizerEntity> findByNameContainingIgnoreCase(String name);
}