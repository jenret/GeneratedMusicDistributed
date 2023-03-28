package song.songdelete.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import song.songdelete.model.Song;
import song.songdelete.repositories.SongJpaRepository;


@Component
public class SongDelete {

    @Autowired
    private SongJpaRepository repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "songdelete", groupId = "songdelete")
    public void listenGroupUsers(String message) {
        System.out.println("Received Message in group songdelete: " + message);

        try {
            Song song = objectMapper.readValue(message, Song.class);
            System.out.println("song mapped: " + song);

            repo.deleteSongBySongName(song.getSongName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}