/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.7.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.evetech.esi.models;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-12-11T14:41:27.859-05:00")
public class GetCorporationsCorporationIdKillmailsRecent200Ok {
  @SerializedName("killmail_hash")
  private String killmailHash = null;

  @SerializedName("killmail_id")
  private Integer killmailId = null;

  public GetCorporationsCorporationIdKillmailsRecent200Ok killmailHash(String killmailHash) {
    this.killmailHash = killmailHash;
    return this;
  }

   /**
   * A hash of this killmail
   * @return killmailHash
  **/
  @ApiModelProperty(example = "null", required = true, value = "A hash of this killmail")
  public String getKillmailHash() {
    return killmailHash;
  }

  public void setKillmailHash(String killmailHash) {
    this.killmailHash = killmailHash;
  }

  public GetCorporationsCorporationIdKillmailsRecent200Ok killmailId(Integer killmailId) {
    this.killmailId = killmailId;
    return this;
  }

   /**
   * ID of this killmail
   * @return killmailId
  **/
  @ApiModelProperty(example = "null", required = true, value = "ID of this killmail")
  public Integer getKillmailId() {
    return killmailId;
  }

  public void setKillmailId(Integer killmailId) {
    this.killmailId = killmailId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdKillmailsRecent200Ok getCorporationsCorporationIdKillmailsRecent200Ok = (GetCorporationsCorporationIdKillmailsRecent200Ok) o;
    return Objects.equals(this.killmailHash, getCorporationsCorporationIdKillmailsRecent200Ok.killmailHash) &&
        Objects.equals(this.killmailId, getCorporationsCorporationIdKillmailsRecent200Ok.killmailId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(killmailHash, killmailId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdKillmailsRecent200Ok {\n");
    
    sb.append("    killmailHash: ").append(toIndentedString(killmailHash)).append("\n");
    sb.append("    killmailId: ").append(toIndentedString(killmailId)).append("\n");
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

