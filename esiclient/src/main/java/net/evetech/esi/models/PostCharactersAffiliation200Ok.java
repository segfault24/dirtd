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
public class PostCharactersAffiliation200Ok {
  @SerializedName("alliance_id")
  private Integer allianceId = null;

  @SerializedName("character_id")
  private Integer characterId = null;

  @SerializedName("corporation_id")
  private Integer corporationId = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  public PostCharactersAffiliation200Ok allianceId(Integer allianceId) {
    this.allianceId = allianceId;
    return this;
  }

   /**
   * The character&#39;s alliance ID, if their corporation is in an alliance
   * @return allianceId
  **/
  @ApiModelProperty(value = "The character's alliance ID, if their corporation is in an alliance")
  public Integer getAllianceId() {
    return allianceId;
  }

  public void setAllianceId(Integer allianceId) {
    this.allianceId = allianceId;
  }

  public PostCharactersAffiliation200Ok characterId(Integer characterId) {
    this.characterId = characterId;
    return this;
  }

   /**
   * The character&#39;s ID
   * @return characterId
  **/
  @ApiModelProperty(required = true, value = "The character's ID")
  public Integer getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
  }

  public PostCharactersAffiliation200Ok corporationId(Integer corporationId) {
    this.corporationId = corporationId;
    return this;
  }

   /**
   * The character&#39;s corporation ID
   * @return corporationId
  **/
  @ApiModelProperty(required = true, value = "The character's corporation ID")
  public Integer getCorporationId() {
    return corporationId;
  }

  public void setCorporationId(Integer corporationId) {
    this.corporationId = corporationId;
  }

  public PostCharactersAffiliation200Ok factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * The character&#39;s faction ID, if their corporation is in a faction
   * @return factionId
  **/
  @ApiModelProperty(value = "The character's faction ID, if their corporation is in a faction")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostCharactersAffiliation200Ok postCharactersAffiliation200Ok = (PostCharactersAffiliation200Ok) o;
    return Objects.equals(this.allianceId, postCharactersAffiliation200Ok.allianceId) &&
        Objects.equals(this.characterId, postCharactersAffiliation200Ok.characterId) &&
        Objects.equals(this.corporationId, postCharactersAffiliation200Ok.corporationId) &&
        Objects.equals(this.factionId, postCharactersAffiliation200Ok.factionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allianceId, characterId, corporationId, factionId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostCharactersAffiliation200Ok {\n");
    
    sb.append("    allianceId: ").append(toIndentedString(allianceId)).append("\n");
    sb.append("    characterId: ").append(toIndentedString(characterId)).append("\n");
    sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
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
