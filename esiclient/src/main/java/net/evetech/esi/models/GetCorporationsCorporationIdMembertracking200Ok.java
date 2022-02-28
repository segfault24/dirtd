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
public class GetCorporationsCorporationIdMembertracking200Ok {
  @SerializedName("base_id")
  private Integer baseId = null;

  @SerializedName("character_id")
  private Integer characterId = null;

  @SerializedName("location_id")
  private Long locationId = null;

  @SerializedName("logoff_date")
  private OffsetDateTime logoffDate = null;

  @SerializedName("logon_date")
  private OffsetDateTime logonDate = null;

  @SerializedName("ship_type_id")
  private Integer shipTypeId = null;

  @SerializedName("start_date")
  private OffsetDateTime startDate = null;

  public GetCorporationsCorporationIdMembertracking200Ok baseId(Integer baseId) {
    this.baseId = baseId;
    return this;
  }

   /**
   * base_id integer
   * @return baseId
  **/
  @ApiModelProperty(value = "base_id integer")
  public Integer getBaseId() {
    return baseId;
  }

  public void setBaseId(Integer baseId) {
    this.baseId = baseId;
  }

  public GetCorporationsCorporationIdMembertracking200Ok characterId(Integer characterId) {
    this.characterId = characterId;
    return this;
  }

   /**
   * character_id integer
   * @return characterId
  **/
  @ApiModelProperty(required = true, value = "character_id integer")
  public Integer getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
  }

  public GetCorporationsCorporationIdMembertracking200Ok locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * location_id integer
   * @return locationId
  **/
  @ApiModelProperty(value = "location_id integer")
  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public GetCorporationsCorporationIdMembertracking200Ok logoffDate(OffsetDateTime logoffDate) {
    this.logoffDate = logoffDate;
    return this;
  }

   /**
   * logoff_date string
   * @return logoffDate
  **/
  @ApiModelProperty(value = "logoff_date string")
  public OffsetDateTime getLogoffDate() {
    return logoffDate;
  }

  public void setLogoffDate(OffsetDateTime logoffDate) {
    this.logoffDate = logoffDate;
  }

  public GetCorporationsCorporationIdMembertracking200Ok logonDate(OffsetDateTime logonDate) {
    this.logonDate = logonDate;
    return this;
  }

   /**
   * logon_date string
   * @return logonDate
  **/
  @ApiModelProperty(value = "logon_date string")
  public OffsetDateTime getLogonDate() {
    return logonDate;
  }

  public void setLogonDate(OffsetDateTime logonDate) {
    this.logonDate = logonDate;
  }

  public GetCorporationsCorporationIdMembertracking200Ok shipTypeId(Integer shipTypeId) {
    this.shipTypeId = shipTypeId;
    return this;
  }

   /**
   * ship_type_id integer
   * @return shipTypeId
  **/
  @ApiModelProperty(value = "ship_type_id integer")
  public Integer getShipTypeId() {
    return shipTypeId;
  }

  public void setShipTypeId(Integer shipTypeId) {
    this.shipTypeId = shipTypeId;
  }

  public GetCorporationsCorporationIdMembertracking200Ok startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * start_date string
   * @return startDate
  **/
  @ApiModelProperty(value = "start_date string")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdMembertracking200Ok getCorporationsCorporationIdMembertracking200Ok = (GetCorporationsCorporationIdMembertracking200Ok) o;
    return Objects.equals(this.baseId, getCorporationsCorporationIdMembertracking200Ok.baseId) &&
        Objects.equals(this.characterId, getCorporationsCorporationIdMembertracking200Ok.characterId) &&
        Objects.equals(this.locationId, getCorporationsCorporationIdMembertracking200Ok.locationId) &&
        Objects.equals(this.logoffDate, getCorporationsCorporationIdMembertracking200Ok.logoffDate) &&
        Objects.equals(this.logonDate, getCorporationsCorporationIdMembertracking200Ok.logonDate) &&
        Objects.equals(this.shipTypeId, getCorporationsCorporationIdMembertracking200Ok.shipTypeId) &&
        Objects.equals(this.startDate, getCorporationsCorporationIdMembertracking200Ok.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseId, characterId, locationId, logoffDate, logonDate, shipTypeId, startDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdMembertracking200Ok {\n");
    
    sb.append("    baseId: ").append(toIndentedString(baseId)).append("\n");
    sb.append("    characterId: ").append(toIndentedString(characterId)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    logoffDate: ").append(toIndentedString(logoffDate)).append("\n");
    sb.append("    logonDate: ").append(toIndentedString(logonDate)).append("\n");
    sb.append("    shipTypeId: ").append(toIndentedString(shipTypeId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
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

