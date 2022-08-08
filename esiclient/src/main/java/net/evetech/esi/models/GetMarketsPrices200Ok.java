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
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetMarketsPrices200Ok {
  @SerializedName("adjusted_price")
  private Double adjustedPrice = null;

  @SerializedName("average_price")
  private Double averagePrice = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetMarketsPrices200Ok adjustedPrice(Double adjustedPrice) {
    this.adjustedPrice = adjustedPrice;
    return this;
  }

   /**
   * adjusted_price number
   * @return adjustedPrice
  **/
  @ApiModelProperty(value = "adjusted_price number")
  public Double getAdjustedPrice() {
    return adjustedPrice;
  }

  public void setAdjustedPrice(Double adjustedPrice) {
    this.adjustedPrice = adjustedPrice;
  }

  public GetMarketsPrices200Ok averagePrice(Double averagePrice) {
    this.averagePrice = averagePrice;
    return this;
  }

   /**
   * average_price number
   * @return averagePrice
  **/
  @ApiModelProperty(value = "average_price number")
  public Double getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public GetMarketsPrices200Ok typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * type_id integer
   * @return typeId
  **/
  @ApiModelProperty(required = true, value = "type_id integer")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetMarketsPrices200Ok getMarketsPrices200Ok = (GetMarketsPrices200Ok) o;
    return Objects.equals(this.adjustedPrice, getMarketsPrices200Ok.adjustedPrice) &&
        Objects.equals(this.averagePrice, getMarketsPrices200Ok.averagePrice) &&
        Objects.equals(this.typeId, getMarketsPrices200Ok.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adjustedPrice, averagePrice, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMarketsPrices200Ok {\n");
    
    sb.append("    adjustedPrice: ").append(toIndentedString(adjustedPrice)).append("\n");
    sb.append("    averagePrice: ").append(toIndentedString(averagePrice)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
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

