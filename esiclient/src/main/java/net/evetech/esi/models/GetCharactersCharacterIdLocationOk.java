/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.10.1
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
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetCharactersCharacterIdLocationOk {
  @SerializedName("solar_system_id")
  private Integer solarSystemId = null;

  @SerializedName("station_id")
  private Integer stationId = null;

  @SerializedName("structure_id")
  private Long structureId = null;

  public GetCharactersCharacterIdLocationOk solarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
    return this;
  }

   /**
   * solar_system_id integer
   * @return solarSystemId
  **/
  @ApiModelProperty(required = true, value = "solar_system_id integer")
  public Integer getSolarSystemId() {
    return solarSystemId;
  }

  public void setSolarSystemId(Integer solarSystemId) {
    this.solarSystemId = solarSystemId;
  }

  public GetCharactersCharacterIdLocationOk stationId(Integer stationId) {
    this.stationId = stationId;
    return this;
  }

   /**
   * station_id integer
   * @return stationId
  **/
  @ApiModelProperty(value = "station_id integer")
  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public GetCharactersCharacterIdLocationOk structureId(Long structureId) {
    this.structureId = structureId;
    return this;
  }

   /**
   * structure_id integer
   * @return structureId
  **/
  @ApiModelProperty(value = "structure_id integer")
  public Long getStructureId() {
    return structureId;
  }

  public void setStructureId(Long structureId) {
    this.structureId = structureId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdLocationOk getCharactersCharacterIdLocationOk = (GetCharactersCharacterIdLocationOk) o;
    return Objects.equals(this.solarSystemId, getCharactersCharacterIdLocationOk.solarSystemId) &&
        Objects.equals(this.stationId, getCharactersCharacterIdLocationOk.stationId) &&
        Objects.equals(this.structureId, getCharactersCharacterIdLocationOk.structureId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(solarSystemId, stationId, structureId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdLocationOk {\n");
    
    sb.append("    solarSystemId: ").append(toIndentedString(solarSystemId)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    structureId: ").append(toIndentedString(structureId)).append("\n");
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
