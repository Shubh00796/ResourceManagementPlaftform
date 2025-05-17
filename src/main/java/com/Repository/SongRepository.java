package com.Repository;

import com.Domian.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("SELECT s FROM Song s WHERE s.albumId = :albumId")
    List<Song> findByAlbumId(@Param("albumId") Long albumId);

    @Query("SELECT s FROM Song s WHERE s.artistIds IN :artistIds")
    List<Song> findByArtistIds(@Param("artistIds") List<Long> artistIds);
}