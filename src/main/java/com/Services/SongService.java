package com.Services;

import com.DTOS.SongDTO;

import java.util.List;

public interface SongService {
    List<SongDTO> getAllSongs();

    SongDTO getSongById(Long id);

    SongDTO createSong(SongDTO songDTO);

    SongDTO updateSong(SongDTO songDTO);

    void deleteSong(Long id);

    List<SongDTO> findSongsByAlbumId(Long albumId);

    List<SongDTO> findSongsByArtistIds(List<Long> artistIds);
}