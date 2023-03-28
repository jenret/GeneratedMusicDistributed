package song.songupdate.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Address of the user
 */
@Validated
public class Address   {

  @JsonProperty("street")
  private String street = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("zipCode")
  private Integer zipCode = null;

  public Address() {
  }

  public Address(String street, String city, String state, Integer zipCode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * User street address
   * @return street
   **/

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * User city address
   * @return city
   **/

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address state(String state) {
    this.state = state;
    return this;
  }

  /**
   * User state address
   * @return state
   **/

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Address zipCode(Integer zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * User zip code address
   * @return zipCode
   **/

  public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.street, address.street) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.state, address.state) &&
        Objects.equals(this.zipCode, address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");

    sb.append("\"street\": ").append("\"" + toIndentedString(street) + "\"").append(",\n");
    sb.append("\"city\": ").append("\"" + toIndentedString(city) + "\"").append(",\n");
    sb.append("\"state\": ").append("\"" + toIndentedString(state) + "\"").append(",\n");
    sb.append("\"zipCode\": ").append(toIndentedString(zipCode)).append("\n");
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
