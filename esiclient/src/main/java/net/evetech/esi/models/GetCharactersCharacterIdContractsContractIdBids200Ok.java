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
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetCharactersCharacterIdContractsContractIdBids200Ok {
  @SerializedName("amount")
  private Float amount = null;

  @SerializedName("bid_id")
  private Integer bidId = null;

  @SerializedName("bidder_id")
  private Integer bidderId = null;

  @SerializedName("date_bid")
  private OffsetDateTime dateBid = null;

  public GetCharactersCharacterIdContractsContractIdBids200Ok amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount bid, in ISK
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "The amount bid, in ISK")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public GetCharactersCharacterIdContractsContractIdBids200Ok bidId(Integer bidId) {
    this.bidId = bidId;
    return this;
  }

   /**
   * Unique ID for the bid
   * @return bidId
  **/
  @ApiModelProperty(required = true, value = "Unique ID for the bid")
  public Integer getBidId() {
    return bidId;
  }

  public void setBidId(Integer bidId) {
    this.bidId = bidId;
  }

  public GetCharactersCharacterIdContractsContractIdBids200Ok bidderId(Integer bidderId) {
    this.bidderId = bidderId;
    return this;
  }

   /**
   * Character ID of the bidder
   * @return bidderId
  **/
  @ApiModelProperty(required = true, value = "Character ID of the bidder")
  public Integer getBidderId() {
    return bidderId;
  }

  public void setBidderId(Integer bidderId) {
    this.bidderId = bidderId;
  }

  public GetCharactersCharacterIdContractsContractIdBids200Ok dateBid(OffsetDateTime dateBid) {
    this.dateBid = dateBid;
    return this;
  }

   /**
   * Datetime when the bid was placed
   * @return dateBid
  **/
  @ApiModelProperty(required = true, value = "Datetime when the bid was placed")
  public OffsetDateTime getDateBid() {
    return dateBid;
  }

  public void setDateBid(OffsetDateTime dateBid) {
    this.dateBid = dateBid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdContractsContractIdBids200Ok getCharactersCharacterIdContractsContractIdBids200Ok = (GetCharactersCharacterIdContractsContractIdBids200Ok) o;
    return Objects.equals(this.amount, getCharactersCharacterIdContractsContractIdBids200Ok.amount) &&
        Objects.equals(this.bidId, getCharactersCharacterIdContractsContractIdBids200Ok.bidId) &&
        Objects.equals(this.bidderId, getCharactersCharacterIdContractsContractIdBids200Ok.bidderId) &&
        Objects.equals(this.dateBid, getCharactersCharacterIdContractsContractIdBids200Ok.dateBid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, bidId, bidderId, dateBid);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdContractsContractIdBids200Ok {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    bidId: ").append(toIndentedString(bidId)).append("\n");
    sb.append("    bidderId: ").append(toIndentedString(bidderId)).append("\n");
    sb.append("    dateBid: ").append(toIndentedString(dateBid)).append("\n");
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

