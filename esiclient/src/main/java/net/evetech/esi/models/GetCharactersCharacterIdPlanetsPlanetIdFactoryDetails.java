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
 * factory_details object
 */
@ApiModel(description = "factory_details object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdPlanetsPlanetIdFactoryDetails {
  @SerializedName("schematic_id")
  private Integer schematicId = null;

  public GetCharactersCharacterIdPlanetsPlanetIdFactoryDetails schematicId(Integer schematicId) {
    this.schematicId = schematicId;
    return this;
  }

   /**
   * schematic_id integer
   * @return schematicId
  **/
  @ApiModelProperty(required = true, value = "schematic_id integer")
  public Integer getSchematicId() {
    return schematicId;
  }

  public void setSchematicId(Integer schematicId) {
    this.schematicId = schematicId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdPlanetsPlanetIdFactoryDetails getCharactersCharacterIdPlanetsPlanetIdFactoryDetails = (GetCharactersCharacterIdPlanetsPlanetIdFactoryDetails) o;
    return Objects.equals(this.schematicId, getCharactersCharacterIdPlanetsPlanetIdFactoryDetails.schematicId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schematicId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdPlanetsPlanetIdFactoryDetails {\n");
    
    sb.append("    schematicId: ").append(toIndentedString(schematicId)).append("\n");
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

