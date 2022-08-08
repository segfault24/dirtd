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
import net.evetech.esi.models.GetCharactersCharacterIdMailLabelsLabel;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdMailLabelsOk {
  @SerializedName("labels")
  private List<GetCharactersCharacterIdMailLabelsLabel> labels = null;

  @SerializedName("total_unread_count")
  private Integer totalUnreadCount = null;

  public GetCharactersCharacterIdMailLabelsOk labels(List<GetCharactersCharacterIdMailLabelsLabel> labels) {
    this.labels = labels;
    return this;
  }

  public GetCharactersCharacterIdMailLabelsOk addLabelsItem(GetCharactersCharacterIdMailLabelsLabel labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<GetCharactersCharacterIdMailLabelsLabel>();
    }
    this.labels.add(labelsItem);
    return this;
  }

   /**
   * labels array
   * @return labels
  **/
  @ApiModelProperty(value = "labels array")
  public List<GetCharactersCharacterIdMailLabelsLabel> getLabels() {
    return labels;
  }

  public void setLabels(List<GetCharactersCharacterIdMailLabelsLabel> labels) {
    this.labels = labels;
  }

  public GetCharactersCharacterIdMailLabelsOk totalUnreadCount(Integer totalUnreadCount) {
    this.totalUnreadCount = totalUnreadCount;
    return this;
  }

   /**
   * total_unread_count integer
   * minimum: 0
   * @return totalUnreadCount
  **/
  @ApiModelProperty(value = "total_unread_count integer")
  public Integer getTotalUnreadCount() {
    return totalUnreadCount;
  }

  public void setTotalUnreadCount(Integer totalUnreadCount) {
    this.totalUnreadCount = totalUnreadCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdMailLabelsOk getCharactersCharacterIdMailLabelsOk = (GetCharactersCharacterIdMailLabelsOk) o;
    return Objects.equals(this.labels, getCharactersCharacterIdMailLabelsOk.labels) &&
        Objects.equals(this.totalUnreadCount, getCharactersCharacterIdMailLabelsOk.totalUnreadCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(labels, totalUnreadCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdMailLabelsOk {\n");
    
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    totalUnreadCount: ").append(toIndentedString(totalUnreadCount)).append("\n");
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

