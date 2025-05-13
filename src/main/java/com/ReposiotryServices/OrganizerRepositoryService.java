package com.ReposiotryServices;

import com.Domian.OrganizerEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrganizerRepositoryService {
    private final OrganizerRepository organizerRepository;


    public List<OrganizerEntity> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public OrganizerEntity getOrganizerById(Long id) {
        return getOrganizerEntity(id);
    }


    public OrganizerEntity createOrganizer(OrganizerEntity organizer) {
        return organizerRepository.save(organizer);
    }
    public OrganizerEntity updateOrganizer(OrganizerEntity organizer) {
        return organizerRepository.save(organizer);
    }


    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }


    public List<OrganizerEntity> getOrganizersByName(String name) {
        return organizerRepository.findByNameContainingIgnoreCase(name);
    }

    private OrganizerEntity getOrganizerEntity(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given organizer not found" + id));
    }
}
