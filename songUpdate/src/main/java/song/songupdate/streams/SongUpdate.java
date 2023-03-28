package song.songupdate.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import song.songupdate.model.Song;
import song.songupdate.model.UpdateSong;
import song.songupdate.repositories.SongJpaRepository;


@Component
public class SongUpdate {

    @Autowired
    private SongJpaRepository repo;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "songupdate", groupId = "songupdate")
    public void listenGroupUsers(String message) {
        System.out.println("Received Message in group songupdate: " + message);

        try {
            UpdateSong updatedSong = objectMapper.readValue(message, UpdateSong.class);
            System.out.println(updatedSong.toString());

            Song songToChange = updatedSong.getSongToChange();
            Song newSong = updatedSong.getChangesMade();

            Song song = repo.findSongByArtist(songToChange.getArtist());
            song.setSongName(newSong.getSongName());
            song.setYear(newSong.getYear());
            song.setPrice(newSong.getPrice());
            song.setSongFile(newSong.getSongFile());
            repo.save(song);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}