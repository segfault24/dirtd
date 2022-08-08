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
import net.evetech.esi.models.GetCharactersCharacterIdPlanetsPlanetIdHead;

/**
 * extractor_details object
 */
@ApiModel(description = "extractor_details object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails {
  @SerializedName("cycle_time")
  private Integer cycleTime = null;

  @SerializedName("head_radius")
  private Float headRadius = null;

  @SerializedName("heads")
  private List<GetCharactersCharacterIdPlanetsPlanetIdHead> heads = new ArrayList<GetCharactersCharacterIdPlanetsPlanetIdHead>();

  @SerializedName("product_type_id")
  private Integer productTypeId = null;

  @SerializedName("qty_per_cycle")
  private Integer qtyPerCycle = null;

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails cycleTime(Integer cycleTime) {
    this.cycleTime = cycleTime;
    return this;
  }

   /**
   * in seconds
   * @return cycleTime
  **/
  @ApiModelProperty(value = "in seconds")
  public Integer getCycleTime() {
    return cycleTime;
  }

  public void setCycleTime(Integer cycleTime) {
    this.cycleTime = cycleTime;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails headRadius(Float headRadius) {
    this.headRadius = headRadius;
    return this;
  }

   /**
   * head_radius number
   * @return headRadius
  **/
  @ApiModelProperty(value = "head_radius number")
  public Float getHeadRadius() {
    return headRadius;
  }

  public void setHeadRadius(Float headRadius) {
    this.headRadius = headRadius;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails heads(List<GetCharactersCharacterIdPlanetsPlanetIdHead> heads) {
    this.heads = heads;
    return this;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails addHeadsItem(GetCharactersCharacterIdPlanetsPlanetIdHead headsItem) {
    this.heads.add(headsItem);
    return this;
  }

   /**
   * heads array
   * @return heads
  **/
  @ApiModelProperty(required = true, value = "heads array")
  public List<GetCharactersCharacterIdPlanetsPlanetIdHead> getHeads() {
    return heads;
  }

  public void setHeads(List<GetCharactersCharacterIdPlanetsPlanetIdHead> heads) {
    this.heads = heads;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails productTypeId(Integer productTypeId) {
    this.productTypeId = productTypeId;
    return this;
  }

   /**
   * product_type_id integer
   * @return productTypeId
  **/
  @ApiModelProperty(value = "product_type_id integer")
  public Integer getProductTypeId() {
    return productTypeId;
  }

  public void setProductTypeId(Integer productTypeId) {
    this.productTypeId = productTypeId;
  }

  public GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails qtyPerCycle(Integer qtyPerCycle) {
    this.qtyPerCycle = qtyPerCycle;
    return this;
  }

   /**
   * qty_per_cycle integer
   * @return qtyPerCycle
  **/
  @ApiModelProperty(value = "qty_per_cycle integer")
  public Integer getQtyPerCycle() {
    return qtyPerCycle;
  }

  public void setQtyPerCycle(Integer qtyPerCycle) {
    this.qtyPerCycle = qtyPerCycle;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails getCharactersCharacterIdPlanetsPlanetIdExtractorDetails = (GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails) o;
    return Objects.equals(this.cycleTime, getCharactersCharacterIdPlanetsPlanetIdExtractorDetails.cycleTime) &&
        Objects.equals(this.headRadius, getCharactersCharacterIdPlanetsPlanetIdExtractorDetails.headRadius) &&
        Objects.equals(this.heads, getCharactersCharacterIdPlanetsPlanetIdExtractorDetails.heads) &&
        Objects.equals(this.productTypeId, getCharactersCharacterIdPlanetsPlanetIdExtractorDetails.productTypeId) &&
        Objects.equals(this.qtyPerCycle, getCharactersCharacterIdPlanetsPlanetIdExtractorDetails.qtyPerCycle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cycleTime, headRadius, heads, productTypeId, qtyPerCycle);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdPlanetsPlanetIdExtractorDetails {\n");
    
    sb.append("    cycleTime: ").append(toIndentedString(cycleTime)).append("\n");
    sb.append("    headRadius: ").append(toIndentedString(headRadius)).append("\n");
    sb.append("    heads: ").append(toIndentedString(heads)).append("\n");
    sb.append("    productTypeId: ").append(toIndentedString(productTypeId)).append("\n");
    sb.append("    qtyPerCycle: ").append(toIndentedString(qtyPerCycle)).append("\n");
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

