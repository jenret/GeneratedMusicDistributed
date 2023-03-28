package user.usercreate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Song
 */
@Validated
public class Song {

  @JsonProperty("songName")
  private String songName = null;

  @JsonProperty("artist")
  private String artist = null;

  @JsonProperty("year")
  private Integer year = null;

  @JsonProperty("price")
  private Float price = null;

  @JsonProperty("songFile")
  private String songFile = null;

  public Song() {
  }

  public Song songName(String songName) {
    this.songName = songName;
    return this;
  }

  /**
   * Name of the song
   * @return songName
   **/

  public String getSongName() {
    return songName;
  }

  public void setSongName(String songName) {
    this.songName = songName;
  }

  public Song artist(String artist) {
    this.artist = artist;
    return this;
  }

  /**
   * Name of song artist
   * @return artist
   **/

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public Song year(Integer year) {
    this.year = year;
    return this;
  }

  /**
   * Year the song came out
   * @return year
   **/

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Song price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Price of the song
   * @return price
   **/

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Song songFile(String songFile) {
    this.songFile = songFile;
    return this;
  }

  /**
   * File containing the song but for now is just a string
   * @return songFile
   **/

  public String getSongFile() {
    return songFile;
  }

  public void setSongFile(String songFile) {
    this.songFile = songFile;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Song song = (Song) o;
    return
        Objects.equals(this.songName, song.songName) &&
        Objects.equals(this.artist, song.artist) &&
        Objects.equals(this.year, song.year) &&
        Objects.equals(this.price, song.price) &&
        Objects.equals(this.songFile, song.songFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(songName, artist, year, price, songFile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");

    sb.append("\"songName\": ").append("\"" + toIndentedString(songName) + "\"").append(",\n");
    sb.append("\"artist\": ").append("\"" + toIndentedString(artist) + "\"").append(",\n");
    sb.append("\"year\": ").append(toIndentedString(year)).append(",\n");
    sb.append("\"price\": ").append(toIndentedString(price)).append(",\n");
    sb.append("\"songFile\": ").append("\"" + toIndentedString(songFile) + "\"").append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
