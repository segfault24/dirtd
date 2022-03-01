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
public class GetCorporationsCorporationIdWallets200Ok {
  @SerializedName("balance")
  private Double balance = null;

  @SerializedName("division")
  private Integer division = null;

  public GetCorporationsCorporationIdWallets200Ok balance(Double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * balance number
   * @return balance
  **/
  @ApiModelProperty(required = true, value = "balance number")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public GetCorporationsCorporationIdWallets200Ok division(Integer division) {
    this.division = division;
    return this;
  }

   /**
   * division integer
   * minimum: 1
   * maximum: 7
   * @return division
  **/
  @ApiModelProperty(required = true, value = "division integer")
  public Integer getDivision() {
    return division;
  }

  public void setDivision(Integer division) {
    this.division = division;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdWallets200Ok getCorporationsCorporationIdWallets200Ok = (GetCorporationsCorporationIdWallets200Ok) o;
    return Objects.equals(this.balance, getCorporationsCorporationIdWallets200Ok.balance) &&
        Objects.equals(this.division, getCorporationsCorporationIdWallets200Ok.division);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance, division);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdWallets200Ok {\n");
    
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
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

