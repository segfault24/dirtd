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
import net.evetech.esi.models.GetFwStatsKills;
import net.evetech.esi.models.GetFwStatsVictoryPoints;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-27T23:34:00.171-05:00")
public class GetFwStats200Ok {
  @SerializedName("faction_id")
  private Integer factionId = null;

  @SerializedName("kills")
  private GetFwStatsKills kills = null;

  @SerializedName("pilots")
  private Integer pilots = null;

  @SerializedName("systems_controlled")
  private Integer systemsControlled = null;

  @SerializedName("victory_points")
  private GetFwStatsVictoryPoints victoryPoints = null;

  public GetFwStats200Ok factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * faction_id integer
   * @return factionId
  **/
  @ApiModelProperty(required = true, value = "faction_id integer")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }

  public GetFwStats200Ok kills(GetFwStatsKills kills) {
    this.kills = kills;
    return this;
  }

   /**
   * Get kills
   * @return kills
  **/
  @ApiModelProperty(required = true, value = "")
  public GetFwStatsKills getKills() {
    return kills;
  }

  public void setKills(GetFwStatsKills kills) {
    this.kills = kills;
  }

  public GetFwStats200Ok pilots(Integer pilots) {
    this.pilots = pilots;
    return this;
  }

   /**
   * How many pilots fight for the given faction
   * @return pilots
  **/
  @ApiModelProperty(required = true, value = "How many pilots fight for the given faction")
  public Integer getPilots() {
    return pilots;
  }

  public void setPilots(Integer pilots) {
    this.pilots = pilots;
  }

  public GetFwStats200Ok systemsControlled(Integer systemsControlled) {
    this.systemsControlled = systemsControlled;
    return this;
  }

   /**
   * The number of solar systems controlled by the given faction
   * @return systemsControlled
  **/
  @ApiModelProperty(required = true, value = "The number of solar systems controlled by the given faction")
  public Integer getSystemsControlled() {
    return systemsControlled;
  }

  public void setSystemsControlled(Integer systemsControlled) {
    this.systemsControlled = systemsControlled;
  }

  public GetFwStats200Ok victoryPoints(GetFwStatsVictoryPoints victoryPoints) {
    this.victoryPoints = victoryPoints;
    return this;
  }

   /**
   * Get victoryPoints
   * @return victoryPoints
  **/
  @ApiModelProperty(required = true, value = "")
  public GetFwStatsVictoryPoints getVictoryPoints() {
    return victoryPoints;
  }

  public void setVictoryPoints(GetFwStatsVictoryPoints victoryPoints) {
    this.victoryPoints = victoryPoints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFwStats200Ok getFwStats200Ok = (GetFwStats200Ok) o;
    return Objects.equals(this.factionId, getFwStats200Ok.factionId) &&
        Objects.equals(this.kills, getFwStats200Ok.kills) &&
        Objects.equals(this.pilots, getFwStats200Ok.pilots) &&
        Objects.equals(this.systemsControlled, getFwStats200Ok.systemsControlled) &&
        Objects.equals(this.victoryPoints, getFwStats200Ok.victoryPoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(factionId, kills, pilots, systemsControlled, victoryPoints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwStats200Ok {\n");
    
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
    sb.append("    kills: ").append(toIndentedString(kills)).append("\n");
    sb.append("    pilots: ").append(toIndentedString(pilots)).append("\n");
    sb.append("    systemsControlled: ").append(toIndentedString(systemsControlled)).append("\n");
    sb.append("    victoryPoints: ").append(toIndentedString(victoryPoints)).append("\n");
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

