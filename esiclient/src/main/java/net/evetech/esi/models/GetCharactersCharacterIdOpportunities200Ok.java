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
public class GetCharactersCharacterIdOpportunities200Ok {
  @SerializedName("completed_at")
  private OffsetDateTime completedAt = null;

  @SerializedName("task_id")
  private Integer taskId = null;

  public GetCharactersCharacterIdOpportunities200Ok completedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
    return this;
  }

   /**
   * completed_at string
   * @return completedAt
  **/
  @ApiModelProperty(required = true, value = "completed_at string")
  public OffsetDateTime getCompletedAt() {
    return completedAt;
  }

  public void setCompletedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }

  public GetCharactersCharacterIdOpportunities200Ok taskId(Integer taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * task_id integer
   * @return taskId
  **/
  @ApiModelProperty(required = true, value = "task_id integer")
  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdOpportunities200Ok getCharactersCharacterIdOpportunities200Ok = (GetCharactersCharacterIdOpportunities200Ok) o;
    return Objects.equals(this.completedAt, getCharactersCharacterIdOpportunities200Ok.completedAt) &&
        Objects.equals(this.taskId, getCharactersCharacterIdOpportunities200Ok.taskId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(completedAt, taskId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdOpportunities200Ok {\n");
    
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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

