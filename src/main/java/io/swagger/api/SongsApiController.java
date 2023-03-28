package io.swagger.api;

import io.swagger.configuration.SongCreateProducer;
import io.swagger.configuration.SongDeleteProducer;
import io.swagger.configuration.SongUpdateProducer;
import io.swagger.model.Song;
import io.swagger.model.Songs;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.repositories.SongJpaRepository;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-04T01:37:48.013595613Z[GMT]")
@RestController
public class SongsApiController implements SongsApi {

    private static final Logger log = LoggerFactory.getLogger(SongsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private SongJpaRepository repo;

    @Autowired
    private SongCreateProducer createProducer;

    @Autowired
    private SongDeleteProducer deleteProducer;

    @Autowired
    private SongUpdateProducer updateProducer;

    @org.springframework.beans.factory.annotation.Autowired
    public SongsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Songs> deleteSong(@Parameter(in = ParameterIn.PATH, description = "Song name of song that needs to be deleted", required=true, schema=@Schema()) @PathVariable("songName") String songName) {
        try {
            Song song = repo.findSongBySongName(songName);
            deleteProducer.send(song.toString());
            return getSongs();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Songs>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Song> getSongByArtist(@Parameter(in = ParameterIn.PATH, description = "Song artist", required=true, schema=@Schema()) @PathVariable("artist") String artist) {
        try {
            Song song = repo.findSongByArtist(artist);
            return new ResponseEntity<Song>(song, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Song>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Song> getSongByName(@Parameter(in = ParameterIn.PATH, description = "Song Name", required=true, schema=@Schema()) @PathVariable("songName") String songName) {
        try {
            Song song = repo.findSongBySongName(songName);
            return new ResponseEntity<Song>(song, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Song>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Songs> getSongs() {
        try {
            List<Song> songs = repo.findAll();
            Songs songList = new Songs();
            for(Song song: songs){
                songList.add(song);
            }

            return new ResponseEntity<Songs>(songList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Songs>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Songs> postSong(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Song body) {
        try {
            createProducer.send(body.toString());
            return getSongs();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Songs>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Song> updateSongByName(@Parameter(in = ParameterIn.PATH, description = "Song name of song that needs to be updated", required=true, schema=@Schema()) @PathVariable("songName") String songName,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Song body) {
        try {
            Song song = repo.findSongBySongName(songName);
            String message = "{ \n" + "songToChange: " +  song.toString() + ",\n changesMade: " + body + "\n }";
            updateProducer.send(message);
            return getSongByArtist(song.getArtist());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Song>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
