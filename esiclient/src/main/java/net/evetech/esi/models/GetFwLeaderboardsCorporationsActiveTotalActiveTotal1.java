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
 * active_total object
 */
@ApiModel(description = "active_total object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetFwLeaderboardsCorporationsActiveTotalActiveTotal1 {
  @SerializedName("amount")
  private Integer amount = null;

  @SerializedName("corporation_id")
  private Integer corporationId = null;

  public GetFwLeaderboardsCorporationsActiveTotalActiveTotal1 amount(Integer amount) {
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

  public GetFwLeaderboardsCorporationsActiveTotalActiveTotal1 corporationId(Integer corporationId) {
    this.corporationId = corporationId;
    return this;
  }

   /**
   * corporation_id integer
   * @return corporationId
  **/
  @ApiModelProperty(value = "corporation_id integer")
  public Integer getCorporationId() {
    return corporationId;
  }

  public void setCorporationId(Integer corporationId) {
    this.corporationId = corporationId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFwLeaderboardsCorporationsActiveTotalActiveTotal1 getFwLeaderboardsCorporationsActiveTotalActiveTotal1 = (GetFwLeaderboardsCorporationsActiveTotalActiveTotal1) o;
    return Objects.equals(this.amount, getFwLeaderboardsCorporationsActiveTotalActiveTotal1.amount) &&
        Objects.equals(this.corporationId, getFwLeaderboardsCorporationsActiveTotalActiveTotal1.corporationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, corporationId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwLeaderboardsCorporationsActiveTotalActiveTotal1 {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
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

