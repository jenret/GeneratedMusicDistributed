package song.songcreate.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import song.songcreate.model.Song;
import song.songcreate.repositories.SongJpaRepository;


@Component
public class SongCreate {

    @Autowired
    private SongJpaRepository repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "songcreate", groupId = "songcreate")
    public void listenGroupSongs(String message) {
        System.out.println("Received Message in group songcreate: " + message);

        try {
            Song song = objectMapper.readValue(message, Song.class);
            System.out.println("song mapped: " + song);

            repo.save(song);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}