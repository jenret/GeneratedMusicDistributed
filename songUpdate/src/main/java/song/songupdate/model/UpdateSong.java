package song.songupdate.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSong {

    private Song songToChange;
    private Song changesMade;

    public UpdateSong() {
    }

    public UpdateSong(Song songToChange, Song changesMade) {
        this.songToChange = songToChange;
        this.changesMade = changesMade;
    }

    @Override
    public String toString() {
        return "Song to change: " + songToChange + "\n Changes made: " + changesMade;
    }
}
