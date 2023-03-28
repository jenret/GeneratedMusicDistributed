package user.userdelete.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * User
 */

@Validated
public class User {

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("userAddress")
  private Address userAddress = null;

  @JsonProperty("songsOwned")
  private Songs songsOwned = null;

  @JsonProperty("songsMade")
  private Songs songsMade = null;

  public User() {
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User supplied username
   * @return username
   **/
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * User supplied password
   * @return password
   **/
  
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * User first name
   * @return firstName
   **/

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * User last name
   * @return lastName
   **/

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * User email address
   * @return email
   **/

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User userAddress(Address userAddress) {
    this.userAddress = userAddress;
    return this;
  }

  /**
   * Get userAddress
   * @return userAddress
   **/

  public Address getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(Address userAddress) {
    this.userAddress = userAddress;
  }

  public User songsOwned(Songs songsOwned) {
    this.songsOwned = songsOwned;
    return this;
  }

  /**
   * Get songsOwned
   * @return songsOwned
   **/

  public Songs getSongsOwned() {
    return songsOwned;
  }

  public void setSongsOwned(Songs songsOwned) {
    this.songsOwned = songsOwned;
  }

  public User songsMade(Songs songsMade) {
    this.songsMade = songsMade;
    return this;
  }

  /**
   * Get songsMade
   * @return songsMade
   **/

  public Songs getSongsMade() {
    return songsMade;
  }

  public void setSongsMade(Songs songsMade) {
    this.songsMade = songsMade;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return
        Objects.equals(this.username, user.username) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.userAddress, user.userAddress) &&
        Objects.equals(this.songsOwned, user.songsOwned) &&
        Objects.equals(this.songsMade, user.songsMade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, firstName, lastName, email, userAddress, songsOwned, songsMade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");

    sb.append("\"username\": ").append("\"" + toIndentedString(username) + "\"").append(",\n");
    sb.append("\"password\": ").append("\"" + toIndentedString(password) + "\"").append(",\n");
    sb.append("\"firstName\": ").append("\"" + toIndentedString(firstName) + "\"").append(",\n");
    sb.append("\"lastName\": ").append("\"" + toIndentedString(lastName) + "\"").append(",\n");
    sb.append("\"email\": ").append("\"" + toIndentedString(email) + "\"").append(",\n");
    sb.append("\"userAddress\": ").append(toIndentedString(userAddress)).append(",\n");
    sb.append("\"songsOwned\": ").append(toIndentedString(songsOwned)).append(",\n");
    sb.append("\"songsMade\": ").append(toIndentedString(songsMade)).append("\n");
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
