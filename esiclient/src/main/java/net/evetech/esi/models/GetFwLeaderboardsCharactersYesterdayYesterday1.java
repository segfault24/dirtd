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
 * yesterday object
 */
@ApiModel(description = "yesterday object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetFwLeaderboardsCharactersYesterdayYesterday1 {
  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("character_id")
  private Integer characterId = null;

  public GetFwLeaderboardsCharactersYesterdayYesterday1 amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount of victory points
   * @return amount
  **/
  @ApiModelProperty(value = "Amount of victory points")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public GetFwLeaderboardsCharactersYesterdayYesterday1 characterId(Integer characterId) {
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
    GetFwLeaderboardsCharactersYesterdayYesterday1 getFwLeaderboardsCharactersYesterdayYesterday1 = (GetFwLeaderboardsCharactersYesterdayYesterday1) o;
    return Objects.equals(this.amount, getFwLeaderboardsCharactersYesterdayYesterday1.amount) &&
        Objects.equals(this.characterId, getFwLeaderboardsCharactersYesterdayYesterday1.characterId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, characterId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwLeaderboardsCharactersYesterdayYesterday1 {\n");
    
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
