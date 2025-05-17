package com.ReposiotryServices;

import com.Domian.Artist;
import com.Exceptions.ResourceNotFoundException;
import com.Repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArtistRepositoryService {
    private final ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }


    public Artist getArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id with given resourve not found" + id));
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }


    public List<Artist> findArtistsByAlbumIds(List<Long> albumIds) {
        return artistRepository.findByAlbumIds(albumIds);
    }

    public List<Artist> findArtistsBySongIds(List<Long> songIds) {
        return artistRepository.findABySongIds(songIds);
    }
}
