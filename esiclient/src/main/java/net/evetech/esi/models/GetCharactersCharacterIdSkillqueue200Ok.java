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
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdSkillqueue200Ok {
  @SerializedName("finish_date")
  private OffsetDateTime finishDate = null;

  @SerializedName("finished_level")
  private Integer finishedLevel = null;

  @SerializedName("level_end_sp")
  private Integer levelEndSp = null;

  @SerializedName("level_start_sp")
  private Integer levelStartSp = null;

  @SerializedName("queue_position")
  private Integer queuePosition = null;

  @SerializedName("skill_id")
  private Integer skillId = null;

  @SerializedName("start_date")
  private OffsetDateTime startDate = null;

  @SerializedName("training_start_sp")
  private Integer trainingStartSp = null;

  public GetCharactersCharacterIdSkillqueue200Ok finishDate(OffsetDateTime finishDate) {
    this.finishDate = finishDate;
    return this;
  }

   /**
   * Date on which training of the skill will complete. Omitted if the skill queue is paused.
   * @return finishDate
  **/
  @ApiModelProperty(value = "Date on which training of the skill will complete. Omitted if the skill queue is paused.")
  public OffsetDateTime getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(OffsetDateTime finishDate) {
    this.finishDate = finishDate;
  }

  public GetCharactersCharacterIdSkillqueue200Ok finishedLevel(Integer finishedLevel) {
    this.finishedLevel = finishedLevel;
    return this;
  }

   /**
   * finished_level integer
   * minimum: 0
   * maximum: 5
   * @return finishedLevel
  **/
  @ApiModelProperty(required = true, value = "finished_level integer")
  public Integer getFinishedLevel() {
    return finishedLevel;
  }

  public void setFinishedLevel(Integer finishedLevel) {
    this.finishedLevel = finishedLevel;
  }

  public GetCharactersCharacterIdSkillqueue200Ok levelEndSp(Integer levelEndSp) {
    this.levelEndSp = levelEndSp;
    return this;
  }

   /**
   * level_end_sp integer
   * @return levelEndSp
  **/
  @ApiModelProperty(value = "level_end_sp integer")
  public Integer getLevelEndSp() {
    return levelEndSp;
  }

  public void setLevelEndSp(Integer levelEndSp) {
    this.levelEndSp = levelEndSp;
  }

  public GetCharactersCharacterIdSkillqueue200Ok levelStartSp(Integer levelStartSp) {
    this.levelStartSp = levelStartSp;
    return this;
  }

   /**
   * Amount of SP that was in the skill when it started training it&#39;s current level. Used to calculate % of current level complete.
   * @return levelStartSp
  **/
  @ApiModelProperty(value = "Amount of SP that was in the skill when it started training it's current level. Used to calculate % of current level complete.")
  public Integer getLevelStartSp() {
    return levelStartSp;
  }

  public void setLevelStartSp(Integer levelStartSp) {
    this.levelStartSp = levelStartSp;
  }

  public GetCharactersCharacterIdSkillqueue200Ok queuePosition(Integer queuePosition) {
    this.queuePosition = queuePosition;
    return this;
  }

   /**
   * queue_position integer
   * @return queuePosition
  **/
  @ApiModelProperty(required = true, value = "queue_position integer")
  public Integer getQueuePosition() {
    return queuePosition;
  }

  public void setQueuePosition(Integer queuePosition) {
    this.queuePosition = queuePosition;
  }

  public GetCharactersCharacterIdSkillqueue200Ok skillId(Integer skillId) {
    this.skillId = skillId;
    return this;
  }

   /**
   * skill_id integer
   * @return skillId
  **/
  @ApiModelProperty(required = true, value = "skill_id integer")
  public Integer getSkillId() {
    return skillId;
  }

  public void setSkillId(Integer skillId) {
    this.skillId = skillId;
  }

  public GetCharactersCharacterIdSkillqueue200Ok startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * start_date string
   * @return startDate
  **/
  @ApiModelProperty(value = "start_date string")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public GetCharactersCharacterIdSkillqueue200Ok trainingStartSp(Integer trainingStartSp) {
    this.trainingStartSp = trainingStartSp;
    return this;
  }

   /**
   * training_start_sp integer
   * @return trainingStartSp
  **/
  @ApiModelProperty(value = "training_start_sp integer")
  public Integer getTrainingStartSp() {
    return trainingStartSp;
  }

  public void setTrainingStartSp(Integer trainingStartSp) {
    this.trainingStartSp = trainingStartSp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdSkillqueue200Ok getCharactersCharacterIdSkillqueue200Ok = (GetCharactersCharacterIdSkillqueue200Ok) o;
    return Objects.equals(this.finishDate, getCharactersCharacterIdSkillqueue200Ok.finishDate) &&
        Objects.equals(this.finishedLevel, getCharactersCharacterIdSkillqueue200Ok.finishedLevel) &&
        Objects.equals(this.levelEndSp, getCharactersCharacterIdSkillqueue200Ok.levelEndSp) &&
        Objects.equals(this.levelStartSp, getCharactersCharacterIdSkillqueue200Ok.levelStartSp) &&
        Objects.equals(this.queuePosition, getCharactersCharacterIdSkillqueue200Ok.queuePosition) &&
        Objects.equals(this.skillId, getCharactersCharacterIdSkillqueue200Ok.skillId) &&
        Objects.equals(this.startDate, getCharactersCharacterIdSkillqueue200Ok.startDate) &&
        Objects.equals(this.trainingStartSp, getCharactersCharacterIdSkillqueue200Ok.trainingStartSp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(finishDate, finishedLevel, levelEndSp, levelStartSp, queuePosition, skillId, startDate, trainingStartSp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdSkillqueue200Ok {\n");
    
    sb.append("    finishDate: ").append(toIndentedString(finishDate)).append("\n");
    sb.append("    finishedLevel: ").append(toIndentedString(finishedLevel)).append("\n");
    sb.append("    levelEndSp: ").append(toIndentedString(levelEndSp)).append("\n");
    sb.append("    levelStartSp: ").append(toIndentedString(levelStartSp)).append("\n");
    sb.append("    queuePosition: ").append(toIndentedString(queuePosition)).append("\n");
    sb.append("    skillId: ").append(toIndentedString(skillId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    trainingStartSp: ").append(toIndentedString(trainingStartSp)).append("\n");
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

