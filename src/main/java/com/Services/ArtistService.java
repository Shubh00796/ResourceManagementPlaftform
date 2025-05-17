package com.Services;

import com.DTOS.ArtistDTO;

import java.util.List;

public interface ArtistService {
    List<ArtistDTO> getAllArtists();

    ArtistDTO getArtistById(Long id);

    ArtistDTO createArtist(ArtistDTO artistDTO);

    ArtistDTO updateArtist(ArtistDTO artistDTO);

    void deleteArtist(Long id);

    List<ArtistDTO> findArtistsByAlbumIds(List<Long> albumIds);

    List<ArtistDTO> findArtistsBySongIds(List<Long> songIds);
}