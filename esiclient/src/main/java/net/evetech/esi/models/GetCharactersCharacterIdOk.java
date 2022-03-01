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
public class GetCharactersCharacterIdOk {
  @SerializedName("alliance_id")
  private Integer allianceId = null;

  @SerializedName("birthday")
  private OffsetDateTime birthday = null;

  @SerializedName("bloodline_id")
  private Integer bloodlineId = null;

  @SerializedName("corporation_id")
  private Integer corporationId = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("faction_id")
  private Integer factionId = null;

  /**
   * gender string
   */
  @JsonAdapter(GenderEnum.Adapter.class)
  public enum GenderEnum {
    FEMALE("female"),
    
    MALE("male");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<GenderEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final GenderEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public GenderEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return GenderEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("gender")
  private GenderEnum gender = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("race_id")
  private Integer raceId = null;

  @SerializedName("security_status")
  private Float securityStatus = null;

  @SerializedName("title")
  private String title = null;

  public GetCharactersCharacterIdOk allianceId(Integer allianceId) {
    this.allianceId = allianceId;
    return this;
  }

   /**
   * The character&#39;s alliance ID
   * @return allianceId
  **/
  @ApiModelProperty(value = "The character's alliance ID")
  public Integer getAllianceId() {
    return allianceId;
  }

  public void setAllianceId(Integer allianceId) {
    this.allianceId = allianceId;
  }

  public GetCharactersCharacterIdOk birthday(OffsetDateTime birthday) {
    this.birthday = birthday;
    return this;
  }

   /**
   * Creation date of the character
   * @return birthday
  **/
  @ApiModelProperty(required = true, value = "Creation date of the character")
  public OffsetDateTime getBirthday() {
    return birthday;
  }

  public void setBirthday(OffsetDateTime birthday) {
    this.birthday = birthday;
  }

  public GetCharactersCharacterIdOk bloodlineId(Integer bloodlineId) {
    this.bloodlineId = bloodlineId;
    return this;
  }

   /**
   * bloodline_id integer
   * @return bloodlineId
  **/
  @ApiModelProperty(required = true, value = "bloodline_id integer")
  public Integer getBloodlineId() {
    return bloodlineId;
  }

  public void setBloodlineId(Integer bloodlineId) {
    this.bloodlineId = bloodlineId;
  }

  public GetCharactersCharacterIdOk corporationId(Integer corporationId) {
    this.corporationId = corporationId;
    return this;
  }

   /**
   * The character&#39;s corporation ID
   * @return corporationId
  **/
  @ApiModelProperty(required = true, value = "The character's corporation ID")
  public Integer getCorporationId() {
    return corporationId;
  }

  public void setCorporationId(Integer corporationId) {
    this.corporationId = corporationId;
  }

  public GetCharactersCharacterIdOk description(String description) {
    this.description = description;
    return this;
  }

   /**
   * description string
   * @return description
  **/
  @ApiModelProperty(value = "description string")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetCharactersCharacterIdOk factionId(Integer factionId) {
    this.factionId = factionId;
    return this;
  }

   /**
   * ID of the faction the character is fighting for, if the character is enlisted in Factional Warfare
   * @return factionId
  **/
  @ApiModelProperty(value = "ID of the faction the character is fighting for, if the character is enlisted in Factional Warfare")
  public Integer getFactionId() {
    return factionId;
  }

  public void setFactionId(Integer factionId) {
    this.factionId = factionId;
  }

  public GetCharactersCharacterIdOk gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

   /**
   * gender string
   * @return gender
  **/
  @ApiModelProperty(required = true, value = "gender string")
  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public GetCharactersCharacterIdOk name(String name) {
    this.name = name;
    return this;
  }

   /**
   * name string
   * @return name
  **/
  @ApiModelProperty(required = true, value = "name string")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetCharactersCharacterIdOk raceId(Integer raceId) {
    this.raceId = raceId;
    return this;
  }

   /**
   * race_id integer
   * @return raceId
  **/
  @ApiModelProperty(required = true, value = "race_id integer")
  public Integer getRaceId() {
    return raceId;
  }

  public void setRaceId(Integer raceId) {
    this.raceId = raceId;
  }

  public GetCharactersCharacterIdOk securityStatus(Float securityStatus) {
    this.securityStatus = securityStatus;
    return this;
  }

   /**
   * security_status number
   * minimum: -10
   * maximum: 10
   * @return securityStatus
  **/
  @ApiModelProperty(value = "security_status number")
  public Float getSecurityStatus() {
    return securityStatus;
  }

  public void setSecurityStatus(Float securityStatus) {
    this.securityStatus = securityStatus;
  }

  public GetCharactersCharacterIdOk title(String title) {
    this.title = title;
    return this;
  }

   /**
   * The individual title of the character
   * @return title
  **/
  @ApiModelProperty(value = "The individual title of the character")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdOk getCharactersCharacterIdOk = (GetCharactersCharacterIdOk) o;
    return Objects.equals(this.allianceId, getCharactersCharacterIdOk.allianceId) &&
        Objects.equals(this.birthday, getCharactersCharacterIdOk.birthday) &&
        Objects.equals(this.bloodlineId, getCharactersCharacterIdOk.bloodlineId) &&
        Objects.equals(this.corporationId, getCharactersCharacterIdOk.corporationId) &&
        Objects.equals(this.description, getCharactersCharacterIdOk.description) &&
        Objects.equals(this.factionId, getCharactersCharacterIdOk.factionId) &&
        Objects.equals(this.gender, getCharactersCharacterIdOk.gender) &&
        Objects.equals(this.name, getCharactersCharacterIdOk.name) &&
        Objects.equals(this.raceId, getCharactersCharacterIdOk.raceId) &&
        Objects.equals(this.securityStatus, getCharactersCharacterIdOk.securityStatus) &&
        Objects.equals(this.title, getCharactersCharacterIdOk.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allianceId, birthday, bloodlineId, corporationId, description, factionId, gender, name, raceId, securityStatus, title);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdOk {\n");
    
    sb.append("    allianceId: ").append(toIndentedString(allianceId)).append("\n");
    sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
    sb.append("    bloodlineId: ").append(toIndentedString(bloodlineId)).append("\n");
    sb.append("    corporationId: ").append(toIndentedString(corporationId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    factionId: ").append(toIndentedString(factionId)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    raceId: ").append(toIndentedString(raceId)).append("\n");
    sb.append("    securityStatus: ").append(toIndentedString(securityStatus)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
