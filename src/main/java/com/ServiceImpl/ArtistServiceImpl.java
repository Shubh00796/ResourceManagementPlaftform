package com.ServiceImpl;

import com.DTOS.ArtistDTO;
import com.Domian.Artist;
import com.Mapper.ArtistMapper;
import com.ReposiotryServices.ArtistRepositoryService;
import com.Services.ArtistService;
import jakarta.persistence.OptimisticLockException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepositoryService repositoryService;
    private final ArtistMapper mapper;
    private final Validator validator;

    @Override
    public List<ArtistDTO> getAllArtists() {
        return repositoryService.getAllArtists()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDTO getArtistById(Long id) {
        Artist repositoryServiceArtistById = repositoryService.getArtistById(id);
        return mapper.toDto(repositoryServiceArtistById);
    }

    @Override
    public ArtistDTO createArtist(ArtistDTO artistDTO) {
        Objects.requireNonNull(artistDTO, "Artist cannot be null");
        artistDTO.setId(null); // Remove the id if set
        artistDTO.setVersion(null);
        Artist artistEntity = mapper.toEntity(artistDTO);
        validateArtist(artistEntity);
        Artist repositoryServiceArtist = repositoryService.createArtist(artistEntity);

        return mapper.toDto(repositoryServiceArtist);
    }

    @Override
    public ArtistDTO updateArtist(ArtistDTO artistDTO) {
        Objects.requireNonNull(artistDTO, "Offer cannot be null");
        Artist existingArtist = repositoryService.getArtistById(artistDTO.getId());
        validateVersion(artistDTO, existingArtist);
        validateArtist(existingArtist);
        mapper.updateEntityFromDto(artistDTO, existingArtist);
        Artist updateArtist = repositoryService.updateArtist(existingArtist);


        return mapper.toDto(updateArtist);
    }

    private static void validateVersion(ArtistDTO artistDTO, Artist existingArtist) {
        if (existingArtist.getVersion() != artistDTO.getVersion()) {
            throw new OptimisticLockException("Artist has been updated by another transaction");
        }
    }

    @Override
    public void deleteArtist(Long id) {
        Objects.requireNonNull(id, "Offer cannot be null");
        repositoryService.deleteArtist(id);

    }

    @Override
    public List<ArtistDTO> findArtistsByAlbumIds(List<Long> albumIds) {
        return repositoryService.findArtistsByAlbumIds(albumIds)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArtistDTO> findArtistsBySongIds(List<Long> songIds) {
        return repositoryService.findArtistsBySongIds(songIds)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private void validateArtist(Artist artist) {
        Set<ConstraintViolation<Artist>> violations = validator.validate(artist);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
