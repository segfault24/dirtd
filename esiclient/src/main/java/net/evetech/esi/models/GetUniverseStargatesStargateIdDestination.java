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
 * destination object
 */
@ApiModel(description = "destination object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetUniverseStargatesStargateIdDestination {
  @SerializedName("stargate_id")
  private Integer stargateId = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  public GetUniverseStargatesStargateIdDestination stargateId(Integer stargateId) {
    this.stargateId = stargateId;
    return this;
  }

   /**
   * The stargate this stargate connects to
   * @return stargateId
  **/
  @ApiModelProperty(required = true, value = "The stargate this stargate connects to")
  public Integer getStargateId() {
    return stargateId;
  }

  public void setStargateId(Integer stargateId) {
    this.stargateId = stargateId;
  }

  public GetUniverseStargatesStargateIdDestination systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system this stargate connects to
   * @return systemId
  **/
  @ApiModelProperty(required = true, value = "The solar system this stargate connects to")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUniverseStargatesStargateIdDestination getUniverseStargatesStargateIdDestination = (GetUniverseStargatesStargateIdDestination) o;
    return Objects.equals(this.stargateId, getUniverseStargatesStargateIdDestination.stargateId) &&
        Objects.equals(this.systemId, getUniverseStargatesStargateIdDestination.systemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stargateId, systemId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseStargatesStargateIdDestination {\n");
    
    sb.append("    stargateId: ").append(toIndentedString(stargateId)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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

