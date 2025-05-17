package com.Repository;

import com.Domian.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a WHERE a.songIds IN :songIds")
    List<Album> findBySongIds(@Param("songIds") List<Long> songIds);

    @Query("SELECT a FROM Album a WHERE a.artistIds IN :artistIds")
    List<Album> findByArtistIds(@Param("artistIds") List<Long> artistIds);
}