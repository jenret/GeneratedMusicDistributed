package song.songcreate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import song.songcreate.model.Song;

public interface SongJpaRepository extends MongoRepository<Song, String> {
    Song findSongBySongName(String s);
}