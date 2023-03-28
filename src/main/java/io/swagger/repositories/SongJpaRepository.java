package io.swagger.repositories;

import io.swagger.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongJpaRepository extends MongoRepository<Song, String> {
    Song findSongBySongName(String s);

    Song findSongByArtist(String s);
}