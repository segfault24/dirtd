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
import java.util.ArrayList;
import java.util.List;
import net.evetech.esi.models.GetCharactersCharacterIdClonesHomeLocation;
import net.evetech.esi.models.GetCharactersCharacterIdClonesJumpClone;
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdClonesOk {
  @SerializedName("home_location")
  private GetCharactersCharacterIdClonesHomeLocation homeLocation = null;

  @SerializedName("jump_clones")
  private List<GetCharactersCharacterIdClonesJumpClone> jumpClones = new ArrayList<GetCharactersCharacterIdClonesJumpClone>();

  @SerializedName("last_clone_jump_date")
  private OffsetDateTime lastCloneJumpDate = null;

  @SerializedName("last_station_change_date")
  private OffsetDateTime lastStationChangeDate = null;

  public GetCharactersCharacterIdClonesOk homeLocation(GetCharactersCharacterIdClonesHomeLocation homeLocation) {
    this.homeLocation = homeLocation;
    return this;
  }

   /**
   * Get homeLocation
   * @return homeLocation
  **/
  @ApiModelProperty(value = "")
  public GetCharactersCharacterIdClonesHomeLocation getHomeLocation() {
    return homeLocation;
  }

  public void setHomeLocation(GetCharactersCharacterIdClonesHomeLocation homeLocation) {
    this.homeLocation = homeLocation;
  }

  public GetCharactersCharacterIdClonesOk jumpClones(List<GetCharactersCharacterIdClonesJumpClone> jumpClones) {
    this.jumpClones = jumpClones;
    return this;
  }

  public GetCharactersCharacterIdClonesOk addJumpClonesItem(GetCharactersCharacterIdClonesJumpClone jumpClonesItem) {
    this.jumpClones.add(jumpClonesItem);
    return this;
  }

   /**
   * jump_clones array
   * @return jumpClones
  **/
  @ApiModelProperty(required = true, value = "jump_clones array")
  public List<GetCharactersCharacterIdClonesJumpClone> getJumpClones() {
    return jumpClones;
  }

  public void setJumpClones(List<GetCharactersCharacterIdClonesJumpClone> jumpClones) {
    this.jumpClones = jumpClones;
  }

  public GetCharactersCharacterIdClonesOk lastCloneJumpDate(OffsetDateTime lastCloneJumpDate) {
    this.lastCloneJumpDate = lastCloneJumpDate;
    return this;
  }

   /**
   * last_clone_jump_date string
   * @return lastCloneJumpDate
  **/
  @ApiModelProperty(value = "last_clone_jump_date string")
  public OffsetDateTime getLastCloneJumpDate() {
    return lastCloneJumpDate;
  }

  public void setLastCloneJumpDate(OffsetDateTime lastCloneJumpDate) {
    this.lastCloneJumpDate = lastCloneJumpDate;
  }

  public GetCharactersCharacterIdClonesOk lastStationChangeDate(OffsetDateTime lastStationChangeDate) {
    this.lastStationChangeDate = lastStationChangeDate;
    return this;
  }

   /**
   * last_station_change_date string
   * @return lastStationChangeDate
  **/
  @ApiModelProperty(value = "last_station_change_date string")
  public OffsetDateTime getLastStationChangeDate() {
    return lastStationChangeDate;
  }

  public void setLastStationChangeDate(OffsetDateTime lastStationChangeDate) {
    this.lastStationChangeDate = lastStationChangeDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdClonesOk getCharactersCharacterIdClonesOk = (GetCharactersCharacterIdClonesOk) o;
    return Objects.equals(this.homeLocation, getCharactersCharacterIdClonesOk.homeLocation) &&
        Objects.equals(this.jumpClones, getCharactersCharacterIdClonesOk.jumpClones) &&
        Objects.equals(this.lastCloneJumpDate, getCharactersCharacterIdClonesOk.lastCloneJumpDate) &&
        Objects.equals(this.lastStationChangeDate, getCharactersCharacterIdClonesOk.lastStationChangeDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homeLocation, jumpClones, lastCloneJumpDate, lastStationChangeDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdClonesOk {\n");
    
    sb.append("    homeLocation: ").append(toIndentedString(homeLocation)).append("\n");
    sb.append("    jumpClones: ").append(toIndentedString(jumpClones)).append("\n");
    sb.append("    lastCloneJumpDate: ").append(toIndentedString(lastCloneJumpDate)).append("\n");
    sb.append("    lastStationChangeDate: ").append(toIndentedString(lastStationChangeDate)).append("\n");
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

