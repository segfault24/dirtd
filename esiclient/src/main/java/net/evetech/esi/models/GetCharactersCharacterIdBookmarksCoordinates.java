/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.12
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.evetech.esi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Optional object that is returned if a bookmark was made on a planet or a random location in space.
 */
@ApiModel(description = "Optional object that is returned if a bookmark was made on a planet or a random location in space.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T20:58:31.116-04:00")
public class GetCharactersCharacterIdBookmarksCoordinates {
  @SerializedName("x")
  private Double x = null;

  @SerializedName("y")
  private Double y = null;

  @SerializedName("z")
  private Double z = null;

  public GetCharactersCharacterIdBookmarksCoordinates x(Double x) {
    this.x = x;
    return this;
  }

   /**
   * x number
   * @return x
  **/
  @ApiModelProperty(required = true, value = "x number")
  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public GetCharactersCharacterIdBookmarksCoordinates y(Double y) {
    this.y = y;
    return this;
  }

   /**
   * y number
   * @return y
  **/
  @ApiModelProperty(required = true, value = "y number")
  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  public GetCharactersCharacterIdBookmarksCoordinates z(Double z) {
    this.z = z;
    return this;
  }

   /**
   * z number
   * @return z
  **/
  @ApiModelProperty(required = true, value = "z number")
  public Double getZ() {
    return z;
  }

  public void setZ(Double z) {
    this.z = z;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdBookmarksCoordinates getCharactersCharacterIdBookmarksCoordinates = (GetCharactersCharacterIdBookmarksCoordinates) o;
    return Objects.equals(this.x, getCharactersCharacterIdBookmarksCoordinates.x) &&
        Objects.equals(this.y, getCharactersCharacterIdBookmarksCoordinates.y) &&
        Objects.equals(this.z, getCharactersCharacterIdBookmarksCoordinates.z);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdBookmarksCoordinates {\n");
    
    sb.append("    x: ").append(toIndentedString(x)).append("\n");
    sb.append("    y: ").append(toIndentedString(y)).append("\n");
    sb.append("    z: ").append(toIndentedString(z)).append("\n");
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

