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
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCorporationsCorporationIdAlliancehistory200Ok {
  @SerializedName("alliance_id")
  private Integer allianceId = null;

  @SerializedName("is_deleted")
  private Boolean isDeleted = null;

  @SerializedName("record_id")
  private Integer recordId = null;

  @SerializedName("start_date")
  private OffsetDateTime startDate = null;

  public GetCorporationsCorporationIdAlliancehistory200Ok allianceId(Integer allianceId) {
    this.allianceId = allianceId;
    return this;
  }

   /**
   * alliance_id integer
   * @return allianceId
  **/
  @ApiModelProperty(value = "alliance_id integer")
  public Integer getAllianceId() {
    return allianceId;
  }

  public void setAllianceId(Integer allianceId) {
    this.allianceId = allianceId;
  }

  public GetCorporationsCorporationIdAlliancehistory200Ok isDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
    return this;
  }

   /**
   * True if the alliance has been closed
   * @return isDeleted
  **/
  @ApiModelProperty(value = "True if the alliance has been closed")
  public Boolean isIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public GetCorporationsCorporationIdAlliancehistory200Ok recordId(Integer recordId) {
    this.recordId = recordId;
    return this;
  }

   /**
   * An incrementing ID that can be used to canonically establish order of records in cases where dates may be ambiguous
   * @return recordId
  **/
  @ApiModelProperty(required = true, value = "An incrementing ID that can be used to canonically establish order of records in cases where dates may be ambiguous")
  public Integer getRecordId() {
    return recordId;
  }

  public void setRecordId(Integer recordId) {
    this.recordId = recordId;
  }

  public GetCorporationsCorporationIdAlliancehistory200Ok startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * start_date string
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "start_date string")
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
    GetCorporationsCorporationIdAlliancehistory200Ok getCorporationsCorporationIdAlliancehistory200Ok = (GetCorporationsCorporationIdAlliancehistory200Ok) o;
    return Objects.equals(this.allianceId, getCorporationsCorporationIdAlliancehistory200Ok.allianceId) &&
        Objects.equals(this.isDeleted, getCorporationsCorporationIdAlliancehistory200Ok.isDeleted) &&
        Objects.equals(this.recordId, getCorporationsCorporationIdAlliancehistory200Ok.recordId) &&
        Objects.equals(this.startDate, getCorporationsCorporationIdAlliancehistory200Ok.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allianceId, isDeleted, recordId, startDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdAlliancehistory200Ok {\n");
    
    sb.append("    allianceId: ").append(toIndentedString(allianceId)).append("\n");
    sb.append("    isDeleted: ").append(toIndentedString(isDeleted)).append("\n");
    sb.append("    recordId: ").append(toIndentedString(recordId)).append("\n");
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

