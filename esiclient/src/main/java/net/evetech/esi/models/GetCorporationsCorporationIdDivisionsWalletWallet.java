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
 * wallet object
 */
@ApiModel(description = "wallet object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCorporationsCorporationIdDivisionsWalletWallet {
  @SerializedName("division")
  private Integer division = null;

  @SerializedName("name")
  private String name = null;

  public GetCorporationsCorporationIdDivisionsWalletWallet division(Integer division) {
    this.division = division;
    return this;
  }

   /**
   * division integer
   * minimum: 1
   * maximum: 7
   * @return division
  **/
  @ApiModelProperty(value = "division integer")
  public Integer getDivision() {
    return division;
  }

  public void setDivision(Integer division) {
    this.division = division;
  }

  public GetCorporationsCorporationIdDivisionsWalletWallet name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name string
   * @return name
  **/
  @ApiModelProperty(value = "name string")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdDivisionsWalletWallet getCorporationsCorporationIdDivisionsWalletWallet = (GetCorporationsCorporationIdDivisionsWalletWallet) o;
    return Objects.equals(this.division, getCorporationsCorporationIdDivisionsWalletWallet.division) &&
        Objects.equals(this.name, getCorporationsCorporationIdDivisionsWalletWallet.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(division, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdDivisionsWalletWallet {\n");
    
    sb.append("    division: ").append(toIndentedString(division)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

