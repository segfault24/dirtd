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
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-27T23:34:00.171-05:00")
public class GetCorporationCorporationIdMiningExtractions200Ok {
  @SerializedName("chunk_arrival_time")
  private OffsetDateTime chunkArrivalTime = null;

  @SerializedName("extraction_start_time")
  private OffsetDateTime extractionStartTime = null;

  @SerializedName("moon_id")
  private Integer moonId = null;

  @SerializedName("natural_decay_time")
  private OffsetDateTime naturalDecayTime = null;

  @SerializedName("structure_id")
  private Long structureId = null;

  public GetCorporationCorporationIdMiningExtractions200Ok chunkArrivalTime(OffsetDateTime chunkArrivalTime) {
    this.chunkArrivalTime = chunkArrivalTime;
    return this;
  }

   /**
   * The time at which the chunk being extracted will arrive and can be fractured by the moon mining drill. 
   * @return chunkArrivalTime
  **/
  @ApiModelProperty(required = true, value = "The time at which the chunk being extracted will arrive and can be fractured by the moon mining drill. ")
  public OffsetDateTime getChunkArrivalTime() {
    return chunkArrivalTime;
  }

  public void setChunkArrivalTime(OffsetDateTime chunkArrivalTime) {
    this.chunkArrivalTime = chunkArrivalTime;
  }

  public GetCorporationCorporationIdMiningExtractions200Ok extractionStartTime(OffsetDateTime extractionStartTime) {
    this.extractionStartTime = extractionStartTime;
    return this;
  }

   /**
   * The time at which the current extraction was initiated. 
   * @return extractionStartTime
  **/
  @ApiModelProperty(required = true, value = "The time at which the current extraction was initiated. ")
  public OffsetDateTime getExtractionStartTime() {
    return extractionStartTime;
  }

  public void setExtractionStartTime(OffsetDateTime extractionStartTime) {
    this.extractionStartTime = extractionStartTime;
  }

  public GetCorporationCorporationIdMiningExtractions200Ok moonId(Integer moonId) {
    this.moonId = moonId;
    return this;
  }

   /**
   * moon_id integer
   * @return moonId
  **/
  @ApiModelProperty(required = true, value = "moon_id integer")
  public Integer getMoonId() {
    return moonId;
  }

  public void setMoonId(Integer moonId) {
    this.moonId = moonId;
  }

  public GetCorporationCorporationIdMiningExtractions200Ok naturalDecayTime(OffsetDateTime naturalDecayTime) {
    this.naturalDecayTime = naturalDecayTime;
    return this;
  }

   /**
   * The time at which the chunk being extracted will naturally fracture if it is not first fractured by the moon mining drill. 
   * @return naturalDecayTime
  **/
  @ApiModelProperty(required = true, value = "The time at which the chunk being extracted will naturally fracture if it is not first fractured by the moon mining drill. ")
  public OffsetDateTime getNaturalDecayTime() {
    return naturalDecayTime;
  }

  public void setNaturalDecayTime(OffsetDateTime naturalDecayTime) {
    this.naturalDecayTime = naturalDecayTime;
  }

  public GetCorporationCorporationIdMiningExtractions200Ok structureId(Long structureId) {
    this.structureId = structureId;
    return this;
  }

   /**
   * structure_id integer
   * @return structureId
  **/
  @ApiModelProperty(required = true, value = "structure_id integer")
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
    GetCorporationCorporationIdMiningExtractions200Ok getCorporationCorporationIdMiningExtractions200Ok = (GetCorporationCorporationIdMiningExtractions200Ok) o;
    return Objects.equals(this.chunkArrivalTime, getCorporationCorporationIdMiningExtractions200Ok.chunkArrivalTime) &&
        Objects.equals(this.extractionStartTime, getCorporationCorporationIdMiningExtractions200Ok.extractionStartTime) &&
        Objects.equals(this.moonId, getCorporationCorporationIdMiningExtractions200Ok.moonId) &&
        Objects.equals(this.naturalDecayTime, getCorporationCorporationIdMiningExtractions200Ok.naturalDecayTime) &&
        Objects.equals(this.structureId, getCorporationCorporationIdMiningExtractions200Ok.structureId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(chunkArrivalTime, extractionStartTime, moonId, naturalDecayTime, structureId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationCorporationIdMiningExtractions200Ok {\n");
    
    sb.append("    chunkArrivalTime: ").append(toIndentedString(chunkArrivalTime)).append("\n");
    sb.append("    extractionStartTime: ").append(toIndentedString(extractionStartTime)).append("\n");
    sb.append("    moonId: ").append(toIndentedString(moonId)).append("\n");
    sb.append("    naturalDecayTime: ").append(toIndentedString(naturalDecayTime)).append("\n");
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

