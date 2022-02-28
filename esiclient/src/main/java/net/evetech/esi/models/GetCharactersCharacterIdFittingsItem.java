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
 * item object
 */
@ApiModel(description = "item object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-27T23:34:00.171-05:00")
public class GetCharactersCharacterIdFittingsItem {
  /**
   * flag string
   */
  @JsonAdapter(FlagEnum.Adapter.class)
  public enum FlagEnum {
    CARGO("Cargo"),
    
    DRONEBAY("DroneBay"),
    
    FIGHTERBAY("FighterBay"),
    
    HISLOT0("HiSlot0"),
    
    HISLOT1("HiSlot1"),
    
    HISLOT2("HiSlot2"),
    
    HISLOT3("HiSlot3"),
    
    HISLOT4("HiSlot4"),
    
    HISLOT5("HiSlot5"),
    
    HISLOT6("HiSlot6"),
    
    HISLOT7("HiSlot7"),
    
    INVALID("Invalid"),
    
    LOSLOT0("LoSlot0"),
    
    LOSLOT1("LoSlot1"),
    
    LOSLOT2("LoSlot2"),
    
    LOSLOT3("LoSlot3"),
    
    LOSLOT4("LoSlot4"),
    
    LOSLOT5("LoSlot5"),
    
    LOSLOT6("LoSlot6"),
    
    LOSLOT7("LoSlot7"),
    
    MEDSLOT0("MedSlot0"),
    
    MEDSLOT1("MedSlot1"),
    
    MEDSLOT2("MedSlot2"),
    
    MEDSLOT3("MedSlot3"),
    
    MEDSLOT4("MedSlot4"),
    
    MEDSLOT5("MedSlot5"),
    
    MEDSLOT6("MedSlot6"),
    
    MEDSLOT7("MedSlot7"),
    
    RIGSLOT0("RigSlot0"),
    
    RIGSLOT1("RigSlot1"),
    
    RIGSLOT2("RigSlot2"),
    
    SERVICESLOT0("ServiceSlot0"),
    
    SERVICESLOT1("ServiceSlot1"),
    
    SERVICESLOT2("ServiceSlot2"),
    
    SERVICESLOT3("ServiceSlot3"),
    
    SERVICESLOT4("ServiceSlot4"),
    
    SERVICESLOT5("ServiceSlot5"),
    
    SERVICESLOT6("ServiceSlot6"),
    
    SERVICESLOT7("ServiceSlot7"),
    
    SUBSYSTEMSLOT0("SubSystemSlot0"),
    
    SUBSYSTEMSLOT1("SubSystemSlot1"),
    
    SUBSYSTEMSLOT2("SubSystemSlot2"),
    
    SUBSYSTEMSLOT3("SubSystemSlot3");

    private String value;

    FlagEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FlagEnum fromValue(String text) {
      for (FlagEnum b : FlagEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<FlagEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FlagEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FlagEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return FlagEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("flag")
  private FlagEnum flag = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCharactersCharacterIdFittingsItem flag(FlagEnum flag) {
    this.flag = flag;
    return this;
  }

   /**
   * flag string
   * @return flag
  **/
  @ApiModelProperty(required = true, value = "flag string")
  public FlagEnum getFlag() {
    return flag;
  }

  public void setFlag(FlagEnum flag) {
    this.flag = flag;
  }

  public GetCharactersCharacterIdFittingsItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * quantity integer
   * @return quantity
  **/
  @ApiModelProperty(required = true, value = "quantity integer")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public GetCharactersCharacterIdFittingsItem typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * type_id integer
   * @return typeId
  **/
  @ApiModelProperty(required = true, value = "type_id integer")
  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdFittingsItem getCharactersCharacterIdFittingsItem = (GetCharactersCharacterIdFittingsItem) o;
    return Objects.equals(this.flag, getCharactersCharacterIdFittingsItem.flag) &&
        Objects.equals(this.quantity, getCharactersCharacterIdFittingsItem.quantity) &&
        Objects.equals(this.typeId, getCharactersCharacterIdFittingsItem.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flag, quantity, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdFittingsItem {\n");
    
    sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    typeId: ").append(toIndentedString(typeId)).append("\n");
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

