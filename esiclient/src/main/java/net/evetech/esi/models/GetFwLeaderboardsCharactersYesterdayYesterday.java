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
 * yesterday object
 */
@ApiModel(description = "yesterday object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetFwLeaderboardsCharactersYesterdayYesterday {
  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("character_id")
  private Integer characterId = null;

  public GetFwLeaderboardsCharactersYesterdayYesterday amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount of kills
   * @return amount
  **/
  @ApiModelProperty(value = "Amount of kills")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public GetFwLeaderboardsCharactersYesterdayYesterday characterId(Integer characterId) {
    this.characterId = characterId;
    return this;
  }

   /**
   * character_id integer
   * @return characterId
  **/
  @ApiModelProperty(value = "character_id integer")
  public Integer getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFwLeaderboardsCharactersYesterdayYesterday getFwLeaderboardsCharactersYesterdayYesterday = (GetFwLeaderboardsCharactersYesterdayYesterday) o;
    return Objects.equals(this.amount, getFwLeaderboardsCharactersYesterdayYesterday.amount) &&
        Objects.equals(this.characterId, getFwLeaderboardsCharactersYesterdayYesterday.characterId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, characterId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwLeaderboardsCharactersYesterdayYesterday {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    characterId: ").append(toIndentedString(characterId)).append("\n");
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

