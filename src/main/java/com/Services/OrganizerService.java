package com.Services;

import com.DTOS.OrganizerDTO;

import java.util.List;

public interface OrganizerService {

    List<OrganizerDTO> getAllOrganizers();

    OrganizerDTO getOrganizerById(Long id);

    OrganizerDTO createOrganizer(OrganizerDTO organizer);

    OrganizerDTO updateOrganizer(OrganizerDTO organizer);

    void deleteOrganizer(Long id);

    List<OrganizerDTO> getOrganizersByName(String name);
}