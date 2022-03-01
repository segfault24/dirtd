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
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetCharactersCharacterIdStandings200Ok {
  @SerializedName("from_id")
  private Integer fromId = null;

  /**
   * from_type string
   */
  @JsonAdapter(FromTypeEnum.Adapter.class)
  public enum FromTypeEnum {
    AGENT("agent"),
    
    NPC_CORP("npc_corp"),
    
    FACTION("faction");

    private String value;

    FromTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FromTypeEnum fromValue(String text) {
      for (FromTypeEnum b : FromTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<FromTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FromTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FromTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return FromTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("from_type")
  private FromTypeEnum fromType = null;

  @SerializedName("standing")
  private Float standing = null;

  public GetCharactersCharacterIdStandings200Ok fromId(Integer fromId) {
    this.fromId = fromId;
    return this;
  }

   /**
   * from_id integer
   * @return fromId
  **/
  @ApiModelProperty(required = true, value = "from_id integer")
  public Integer getFromId() {
    return fromId;
  }

  public void setFromId(Integer fromId) {
    this.fromId = fromId;
  }

  public GetCharactersCharacterIdStandings200Ok fromType(FromTypeEnum fromType) {
    this.fromType = fromType;
    return this;
  }

   /**
   * from_type string
   * @return fromType
  **/
  @ApiModelProperty(required = true, value = "from_type string")
  public FromTypeEnum getFromType() {
    return fromType;
  }

  public void setFromType(FromTypeEnum fromType) {
    this.fromType = fromType;
  }

  public GetCharactersCharacterIdStandings200Ok standing(Float standing) {
    this.standing = standing;
    return this;
  }

   /**
   * standing number
   * @return standing
  **/
  @ApiModelProperty(required = true, value = "standing number")
  public Float getStanding() {
    return standing;
  }

  public void setStanding(Float standing) {
    this.standing = standing;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdStandings200Ok getCharactersCharacterIdStandings200Ok = (GetCharactersCharacterIdStandings200Ok) o;
    return Objects.equals(this.fromId, getCharactersCharacterIdStandings200Ok.fromId) &&
        Objects.equals(this.fromType, getCharactersCharacterIdStandings200Ok.fromType) &&
        Objects.equals(this.standing, getCharactersCharacterIdStandings200Ok.standing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromId, fromType, standing);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdStandings200Ok {\n");
    
    sb.append("    fromId: ").append(toIndentedString(fromId)).append("\n");
    sb.append("    fromType: ").append(toIndentedString(fromType)).append("\n");
    sb.append("    standing: ").append(toIndentedString(standing)).append("\n");
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

