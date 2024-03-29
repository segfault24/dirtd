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
import net.evetech.esi.models.GetCorporationsCorporationIdDivisionsHangarHangar;
import net.evetech.esi.models.GetCorporationsCorporationIdDivisionsWalletWallet;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCorporationsCorporationIdDivisionsOk {
  @SerializedName("hangar")
  private List<GetCorporationsCorporationIdDivisionsHangarHangar> hangar = null;

  @SerializedName("wallet")
  private List<GetCorporationsCorporationIdDivisionsWalletWallet> wallet = null;

  public GetCorporationsCorporationIdDivisionsOk hangar(List<GetCorporationsCorporationIdDivisionsHangarHangar> hangar) {
    this.hangar = hangar;
    return this;
  }

  public GetCorporationsCorporationIdDivisionsOk addHangarItem(GetCorporationsCorporationIdDivisionsHangarHangar hangarItem) {
    if (this.hangar == null) {
      this.hangar = new ArrayList<GetCorporationsCorporationIdDivisionsHangarHangar>();
    }
    this.hangar.add(hangarItem);
    return this;
  }

   /**
   * hangar array
   * @return hangar
  **/
  @ApiModelProperty(value = "hangar array")
  public List<GetCorporationsCorporationIdDivisionsHangarHangar> getHangar() {
    return hangar;
  }

  public void setHangar(List<GetCorporationsCorporationIdDivisionsHangarHangar> hangar) {
    this.hangar = hangar;
  }

  public GetCorporationsCorporationIdDivisionsOk wallet(List<GetCorporationsCorporationIdDivisionsWalletWallet> wallet) {
    this.wallet = wallet;
    return this;
  }

  public GetCorporationsCorporationIdDivisionsOk addWalletItem(GetCorporationsCorporationIdDivisionsWalletWallet walletItem) {
    if (this.wallet == null) {
      this.wallet = new ArrayList<GetCorporationsCorporationIdDivisionsWalletWallet>();
    }
    this.wallet.add(walletItem);
    return this;
  }

   /**
   * wallet array
   * @return wallet
  **/
  @ApiModelProperty(value = "wallet array")
  public List<GetCorporationsCorporationIdDivisionsWalletWallet> getWallet() {
    return wallet;
  }

  public void setWallet(List<GetCorporationsCorporationIdDivisionsWalletWallet> wallet) {
    this.wallet = wallet;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdDivisionsOk getCorporationsCorporationIdDivisionsOk = (GetCorporationsCorporationIdDivisionsOk) o;
    return Objects.equals(this.hangar, getCorporationsCorporationIdDivisionsOk.hangar) &&
        Objects.equals(this.wallet, getCorporationsCorporationIdDivisionsOk.wallet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hangar, wallet);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdDivisionsOk {\n");
    
    sb.append("    hangar: ").append(toIndentedString(hangar)).append("\n");
    sb.append("    wallet: ").append(toIndentedString(wallet)).append("\n");
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

