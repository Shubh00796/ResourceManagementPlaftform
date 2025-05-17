package com.util.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Order(1) // Ensure this listener is executed before any other listeners
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final EntityManager entityManager;

    @Override
    @Transactional
    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createIndexes();
    }

    public void createIndexes() {
        createArtistIdsIndexInSongTable();
//        createArtistAlbumIdsIndex();
//        createArtistSongIdsIndex();
    }

    private void createArtistIdsIndexInSongTable() {
        // Check if the column exists
        if (!doesColumnExist("song", "artist_ids_extracted")) {
            String alterTableQuery = "ALTER TABLE song ADD COLUMN artist_ids_extracted TEXT GENERATED ALWAYS AS (JSON_EXTRACT(artist_ids, '$[*]')) VIRTUAL";
            try {
                entityManager.createNativeQuery(alterTableQuery).executeUpdate();
            } catch (Exception e) {
                // If the column creation fails, it might be due to a concurrent modification.
                // In this case, we can retry the column existence check.
                if (!doesColumnExist("song", "artist_ids_extracted")) {
                    throw e; // Re-throw the exception if the column still doesn't exist.
                }
            }
        }

        // Check if the index exists
        if (!doesIndexExist("song", "song_artist_ids_index")) {
            String createIndexQuery = "CREATE INDEX song_artist_ids_index ON song (artist_ids_extracted(255))";
            try {
                entityManager.createNativeQuery(createIndexQuery).executeUpdate();
            } catch (Exception e) {
                // If the index creation fails, it might be due to a concurrent modification.
                // In this case, we can retry the index existence check.
                if (!doesIndexExist("song", "song_artist_ids_index")) {
                    throw e; // Re-throw the exception if the index still doesn't exist.
                }
            }
        }
    }

//    private void createArtistAlbumIdsIndex() {
//        // Check if the column exists
//        if (!doesColumnExist("artist", "album_ids_extracted")) {
//            String alterTableQuery = "ALTER TABLE artist ADD COLUMN album_ids_extracted TEXT GENERATED ALWAYS AS (JSON_EXTRACT(albumIds, '$[*]')) VIRTUAL";
//            entityManager.createNativeQuery(alterTableQuery).executeUpdate();
//        }
//
//        // Check if the index exists
//        if (!doesIndexExist("artist", "artist_album_ids_index")) {
//            String createIndexQuery = "CREATE INDEX artist_album_ids_index ON artist (album_ids_extracted(255))";
//            entityManager.createNativeQuery(createIndexQuery).executeUpdate();
//        }
//    }
//
//    private void createArtistSongIdsIndex() {
//        // Check if the column exists
//        if (!doesColumnExist("artist", "song_ids_extracted")) {
//            String alterTableQuery = "ALTER TABLE artist ADD COLUMN song_ids_extracted TEXT GENERATED ALWAYS AS (JSON_EXTRACT(songIds, '$[*]')) VIRTUAL";
//            entityManager.createNativeQuery(alterTableQuery).executeUpdate();
//        }
//
//        // Check if the index exists
//        if (!doesIndexExist("artist", "artist_song_ids_index")) {
//            String createIndexQuery = "CREATE INDEX artist_song_ids_index ON artist (song_ids_extracted(255))";
//            entityManager.createNativeQuery(createIndexQuery).executeUpdate();
//        }
//    }

    private boolean doesColumnExist(String tableName, String columnName) {
        String query = "SELECT COUNT(*) FROM information_schema.columns WHERE table_name =? AND column_name =?";
        try {
            Query nativeQuery = entityManager.createNativeQuery(query);
            nativeQuery.setParameter(1, tableName);
            nativeQuery.setParameter(2, columnName);
            return (Integer) nativeQuery.getSingleResult() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean doesIndexExist(String tableName, String indexName) {
        String query = "SELECT COUNT(*) FROM information_schema.statistics WHERE table_name =? AND index_name =?";
        try {
            Query nativeQuery = entityManager.createNativeQuery(query);
            nativeQuery.setParameter(1, tableName);
            nativeQuery.setParameter(2, indexName);
            return (Integer) nativeQuery.getSingleResult() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}