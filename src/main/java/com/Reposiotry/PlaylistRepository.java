package com.Reposiotry;

import com.Domian.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("SELECT p FROM Playlist p WHERE p.songIds IN :songIds")
    List<Playlist> findPlaylistsBySongIds(@Param("songIds") List<Long> songIds);
}