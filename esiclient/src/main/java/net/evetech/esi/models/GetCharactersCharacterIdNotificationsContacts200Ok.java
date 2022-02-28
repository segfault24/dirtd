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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-27T23:34:00.171-05:00")
public class GetCharactersCharacterIdNotificationsContacts200Ok {
  @SerializedName("message")
  private String message = null;

  @SerializedName("notification_id")
  private Integer notificationId = null;

  @SerializedName("send_date")
  private OffsetDateTime sendDate = null;

  @SerializedName("sender_character_id")
  private Integer senderCharacterId = null;

  @SerializedName("standing_level")
  private Float standingLevel = null;

  public GetCharactersCharacterIdNotificationsContacts200Ok message(String message) {
    this.message = message;
    return this;
  }

   /**
   * message string
   * @return message
  **/
  @ApiModelProperty(required = true, value = "message string")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GetCharactersCharacterIdNotificationsContacts200Ok notificationId(Integer notificationId) {
    this.notificationId = notificationId;
    return this;
  }

   /**
   * notification_id integer
   * @return notificationId
  **/
  @ApiModelProperty(required = true, value = "notification_id integer")
  public Integer getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Integer notificationId) {
    this.notificationId = notificationId;
  }

  public GetCharactersCharacterIdNotificationsContacts200Ok sendDate(OffsetDateTime sendDate) {
    this.sendDate = sendDate;
    return this;
  }

   /**
   * send_date string
   * @return sendDate
  **/
  @ApiModelProperty(required = true, value = "send_date string")
  public OffsetDateTime getSendDate() {
    return sendDate;
  }

  public void setSendDate(OffsetDateTime sendDate) {
    this.sendDate = sendDate;
  }

  public GetCharactersCharacterIdNotificationsContacts200Ok senderCharacterId(Integer senderCharacterId) {
    this.senderCharacterId = senderCharacterId;
    return this;
  }

   /**
   * sender_character_id integer
   * @return senderCharacterId
  **/
  @ApiModelProperty(required = true, value = "sender_character_id integer")
  public Integer getSenderCharacterId() {
    return senderCharacterId;
  }

  public void setSenderCharacterId(Integer senderCharacterId) {
    this.senderCharacterId = senderCharacterId;
  }

  public GetCharactersCharacterIdNotificationsContacts200Ok standingLevel(Float standingLevel) {
    this.standingLevel = standingLevel;
    return this;
  }

   /**
   * A number representing the standing level the receiver has been added at by the sender. The standing levels are as follows: -10 -&gt; Terrible | -5 -&gt; Bad |  0 -&gt; Neutral |  5 -&gt; Good |  10 -&gt; Excellent
   * @return standingLevel
  **/
  @ApiModelProperty(required = true, value = "A number representing the standing level the receiver has been added at by the sender. The standing levels are as follows: -10 -> Terrible | -5 -> Bad |  0 -> Neutral |  5 -> Good |  10 -> Excellent")
  public Float getStandingLevel() {
    return standingLevel;
  }

  public void setStandingLevel(Float standingLevel) {
    this.standingLevel = standingLevel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdNotificationsContacts200Ok getCharactersCharacterIdNotificationsContacts200Ok = (GetCharactersCharacterIdNotificationsContacts200Ok) o;
    return Objects.equals(this.message, getCharactersCharacterIdNotificationsContacts200Ok.message) &&
        Objects.equals(this.notificationId, getCharactersCharacterIdNotificationsContacts200Ok.notificationId) &&
        Objects.equals(this.sendDate, getCharactersCharacterIdNotificationsContacts200Ok.sendDate) &&
        Objects.equals(this.senderCharacterId, getCharactersCharacterIdNotificationsContacts200Ok.senderCharacterId) &&
        Objects.equals(this.standingLevel, getCharactersCharacterIdNotificationsContacts200Ok.standingLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, notificationId, sendDate, senderCharacterId, standingLevel);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdNotificationsContacts200Ok {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
    sb.append("    sendDate: ").append(toIndentedString(sendDate)).append("\n");
    sb.append("    senderCharacterId: ").append(toIndentedString(senderCharacterId)).append("\n");
    sb.append("    standingLevel: ").append(toIndentedString(standingLevel)).append("\n");
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

