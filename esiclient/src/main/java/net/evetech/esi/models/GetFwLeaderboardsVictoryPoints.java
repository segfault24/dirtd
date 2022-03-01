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
import java.util.ArrayList;
import java.util.List;
import net.evetech.esi.models.GetFwLeaderboardsActiveTotalActiveTotal1;
import net.evetech.esi.models.GetFwLeaderboardsLastWeekLastWeek1;
import net.evetech.esi.models.GetFwLeaderboardsYesterdayYesterday1;

/**
 * Top 4 rankings of factions by victory points from yesterday, last week and in total
 */
@ApiModel(description = "Top 4 rankings of factions by victory points from yesterday, last week and in total")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetFwLeaderboardsVictoryPoints {
  @SerializedName("active_total")
  private List<GetFwLeaderboardsActiveTotalActiveTotal1> activeTotal = new ArrayList<GetFwLeaderboardsActiveTotalActiveTotal1>();

  @SerializedName("last_week")
  private List<GetFwLeaderboardsLastWeekLastWeek1> lastWeek = new ArrayList<GetFwLeaderboardsLastWeekLastWeek1>();

  @SerializedName("yesterday")
  private List<GetFwLeaderboardsYesterdayYesterday1> yesterday = new ArrayList<GetFwLeaderboardsYesterdayYesterday1>();

  public GetFwLeaderboardsVictoryPoints activeTotal(List<GetFwLeaderboardsActiveTotalActiveTotal1> activeTotal) {
    this.activeTotal = activeTotal;
    return this;
  }

  public GetFwLeaderboardsVictoryPoints addActiveTotalItem(GetFwLeaderboardsActiveTotalActiveTotal1 activeTotalItem) {
    this.activeTotal.add(activeTotalItem);
    return this;
  }

   /**
   * Top 4 ranking of factions active in faction warfare by total victory points. A faction is considered \&quot;active\&quot; if they have participated in faction warfare in the past 14 days
   * @return activeTotal
  **/
  @ApiModelProperty(required = true, value = "Top 4 ranking of factions active in faction warfare by total victory points. A faction is considered \"active\" if they have participated in faction warfare in the past 14 days")
  public List<GetFwLeaderboardsActiveTotalActiveTotal1> getActiveTotal() {
    return activeTotal;
  }

  public void setActiveTotal(List<GetFwLeaderboardsActiveTotalActiveTotal1> activeTotal) {
    this.activeTotal = activeTotal;
  }

  public GetFwLeaderboardsVictoryPoints lastWeek(List<GetFwLeaderboardsLastWeekLastWeek1> lastWeek) {
    this.lastWeek = lastWeek;
    return this;
  }

  public GetFwLeaderboardsVictoryPoints addLastWeekItem(GetFwLeaderboardsLastWeekLastWeek1 lastWeekItem) {
    this.lastWeek.add(lastWeekItem);
    return this;
  }

   /**
   * Top 4 ranking of factions by victory points in the past week
   * @return lastWeek
  **/
  @ApiModelProperty(required = true, value = "Top 4 ranking of factions by victory points in the past week")
  public List<GetFwLeaderboardsLastWeekLastWeek1> getLastWeek() {
    return lastWeek;
  }

  public void setLastWeek(List<GetFwLeaderboardsLastWeekLastWeek1> lastWeek) {
    this.lastWeek = lastWeek;
  }

  public GetFwLeaderboardsVictoryPoints yesterday(List<GetFwLeaderboardsYesterdayYesterday1> yesterday) {
    this.yesterday = yesterday;
    return this;
  }

  public GetFwLeaderboardsVictoryPoints addYesterdayItem(GetFwLeaderboardsYesterdayYesterday1 yesterdayItem) {
    this.yesterday.add(yesterdayItem);
    return this;
  }

   /**
   * Top 4 ranking of factions by victory points in the past day
   * @return yesterday
  **/
  @ApiModelProperty(required = true, value = "Top 4 ranking of factions by victory points in the past day")
  public List<GetFwLeaderboardsYesterdayYesterday1> getYesterday() {
    return yesterday;
  }

  public void setYesterday(List<GetFwLeaderboardsYesterdayYesterday1> yesterday) {
    this.yesterday = yesterday;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetFwLeaderboardsVictoryPoints getFwLeaderboardsVictoryPoints = (GetFwLeaderboardsVictoryPoints) o;
    return Objects.equals(this.activeTotal, getFwLeaderboardsVictoryPoints.activeTotal) &&
        Objects.equals(this.lastWeek, getFwLeaderboardsVictoryPoints.lastWeek) &&
        Objects.equals(this.yesterday, getFwLeaderboardsVictoryPoints.yesterday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activeTotal, lastWeek, yesterday);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetFwLeaderboardsVictoryPoints {\n");
    
    sb.append("    activeTotal: ").append(toIndentedString(activeTotal)).append("\n");
    sb.append("    lastWeek: ").append(toIndentedString(lastWeek)).append("\n");
    sb.append("    yesterday: ").append(toIndentedString(yesterday)).append("\n");
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

