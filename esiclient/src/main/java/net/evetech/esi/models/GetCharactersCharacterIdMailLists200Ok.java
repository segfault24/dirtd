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

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdMailLists200Ok {
  @SerializedName("mailing_list_id")
  private Integer mailingListId = null;

  @SerializedName("name")
  private String name = null;

  public GetCharactersCharacterIdMailLists200Ok mailingListId(Integer mailingListId) {
    this.mailingListId = mailingListId;
    return this;
  }

   /**
   * Mailing list ID
   * @return mailingListId
  **/
  @ApiModelProperty(required = true, value = "Mailing list ID")
  public Integer getMailingListId() {
    return mailingListId;
  }

  public void setMailingListId(Integer mailingListId) {
    this.mailingListId = mailingListId;
  }

  public GetCharactersCharacterIdMailLists200Ok name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdMailLists200Ok getCharactersCharacterIdMailLists200Ok = (GetCharactersCharacterIdMailLists200Ok) o;
    return Objects.equals(this.mailingListId, getCharactersCharacterIdMailLists200Ok.mailingListId) &&
        Objects.equals(this.name, getCharactersCharacterIdMailLists200Ok.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mailingListId, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdMailLists200Ok {\n");
    
    sb.append("    mailingListId: ").append(toIndentedString(mailingListId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

