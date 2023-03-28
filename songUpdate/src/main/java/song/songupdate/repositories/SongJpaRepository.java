package song.songupdate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import song.songupdate.model.Song;

public interface SongJpaRepository extends MongoRepository<Song, String> {
    Song findSongBySongName(String s);

    Song findSongByArtist(String s);
}