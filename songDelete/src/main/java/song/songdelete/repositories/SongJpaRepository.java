package song.songdelete.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import song.songdelete.model.Song;

public interface SongJpaRepository extends MongoRepository<Song, String> {

    void deleteSongBySongName(String s);
}