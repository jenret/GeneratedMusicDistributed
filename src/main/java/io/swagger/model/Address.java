package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address of the user
 */
@Schema(description = "Address of the user")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-04T01:37:48.013595613Z[GMT]")


public class Address   {
  @JsonProperty("street")
  private String street = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("zipCode")
  private Integer zipCode = null;

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * User street address
   * @return street
   **/
  @Schema(example = "455 W 600 E", description = "User street address")
  
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
  @Schema(example = "Salt Lake City", description = "User city address")
  
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
  @Schema(example = "UT", description = "User state address")
  
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
  @Schema(example = "84663", description = "User zip code address")
  
    public Integer getZipCode() {
    return zipCode;
  }

  public void setZipCode(Integer zipCode) {
    this.zipCode = zipCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
