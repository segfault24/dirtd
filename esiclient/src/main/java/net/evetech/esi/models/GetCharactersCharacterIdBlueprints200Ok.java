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
public class GetCharactersCharacterIdBlueprints200Ok {
  @SerializedName("item_id")
  private Long itemId = null;

  /**
   * Type of the location_id
   */
  @JsonAdapter(LocationFlagEnum.Adapter.class)
  public enum LocationFlagEnum {
    AUTOFIT("AutoFit"),
    
    CARGO("Cargo"),
    
    CORPSEBAY("CorpseBay"),
    
    DRONEBAY("DroneBay"),
    
    FLEETHANGAR("FleetHangar"),
    
    DELIVERIES("Deliveries"),
    
    HIDDENMODIFIERS("HiddenModifiers"),
    
    HANGAR("Hangar"),
    
    HANGARALL("HangarAll"),
    
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
    
    HISLOT0("HiSlot0"),
    
    HISLOT1("HiSlot1"),
    
    HISLOT2("HiSlot2"),
    
    HISLOT3("HiSlot3"),
    
    HISLOT4("HiSlot4"),
    
    HISLOT5("HiSlot5"),
    
    HISLOT6("HiSlot6"),
    
    HISLOT7("HiSlot7"),
    
    ASSETSAFETY("AssetSafety"),
    
    LOCKED("Locked"),
    
    UNLOCKED("Unlocked"),
    
    IMPLANT("Implant"),
    
    QUAFEBAY("QuafeBay"),
    
    RIGSLOT0("RigSlot0"),
    
    RIGSLOT1("RigSlot1"),
    
    RIGSLOT2("RigSlot2"),
    
    RIGSLOT3("RigSlot3"),
    
    RIGSLOT4("RigSlot4"),
    
    RIGSLOT5("RigSlot5"),
    
    RIGSLOT6("RigSlot6"),
    
    RIGSLOT7("RigSlot7"),
    
    SHIPHANGAR("ShipHangar"),
    
    SPECIALIZEDFUELBAY("SpecializedFuelBay"),
    
    SPECIALIZEDOREHOLD("SpecializedOreHold"),
    
    SPECIALIZEDGASHOLD("SpecializedGasHold"),
    
    SPECIALIZEDMINERALHOLD("SpecializedMineralHold"),
    
    SPECIALIZEDSALVAGEHOLD("SpecializedSalvageHold"),
    
    SPECIALIZEDSHIPHOLD("SpecializedShipHold"),
    
    SPECIALIZEDSMALLSHIPHOLD("SpecializedSmallShipHold"),
    
    SPECIALIZEDMEDIUMSHIPHOLD("SpecializedMediumShipHold"),
    
    SPECIALIZEDLARGESHIPHOLD("SpecializedLargeShipHold"),
    
    SPECIALIZEDINDUSTRIALSHIPHOLD("SpecializedIndustrialShipHold"),
    
    SPECIALIZEDAMMOHOLD("SpecializedAmmoHold"),
    
    SPECIALIZEDCOMMANDCENTERHOLD("SpecializedCommandCenterHold"),
    
    SPECIALIZEDPLANETARYCOMMODITIESHOLD("SpecializedPlanetaryCommoditiesHold"),
    
    SPECIALIZEDMATERIALBAY("SpecializedMaterialBay"),
    
    SUBSYSTEMSLOT0("SubSystemSlot0"),
    
    SUBSYSTEMSLOT1("SubSystemSlot1"),
    
    SUBSYSTEMSLOT2("SubSystemSlot2"),
    
    SUBSYSTEMSLOT3("SubSystemSlot3"),
    
    SUBSYSTEMSLOT4("SubSystemSlot4"),
    
    SUBSYSTEMSLOT5("SubSystemSlot5"),
    
    SUBSYSTEMSLOT6("SubSystemSlot6"),
    
    SUBSYSTEMSLOT7("SubSystemSlot7"),
    
    FIGHTERBAY("FighterBay"),
    
    FIGHTERTUBE0("FighterTube0"),
    
    FIGHTERTUBE1("FighterTube1"),
    
    FIGHTERTUBE2("FighterTube2"),
    
    FIGHTERTUBE3("FighterTube3"),
    
    FIGHTERTUBE4("FighterTube4"),
    
    MODULE("Module");

    private String value;

    LocationFlagEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LocationFlagEnum fromValue(String text) {
      for (LocationFlagEnum b : LocationFlagEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LocationFlagEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LocationFlagEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LocationFlagEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LocationFlagEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("location_flag")
  private LocationFlagEnum locationFlag = null;

  @SerializedName("location_id")
  private Long locationId = null;

  @SerializedName("material_efficiency")
  private Integer materialEfficiency = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("runs")
  private Integer runs = null;

  @SerializedName("time_efficiency")
  private Integer timeEfficiency = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCharactersCharacterIdBlueprints200Ok itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * Unique ID for this item.
   * @return itemId
  **/
  @ApiModelProperty(required = true, value = "Unique ID for this item.")
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public GetCharactersCharacterIdBlueprints200Ok locationFlag(LocationFlagEnum locationFlag) {
    this.locationFlag = locationFlag;
    return this;
  }

   /**
   * Type of the location_id
   * @return locationFlag
  **/
  @ApiModelProperty(required = true, value = "Type of the location_id")
  public LocationFlagEnum getLocationFlag() {
    return locationFlag;
  }

  public void setLocationFlag(LocationFlagEnum locationFlag) {
    this.locationFlag = locationFlag;
  }

  public GetCharactersCharacterIdBlueprints200Ok locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * References a station, a ship or an item_id if this blueprint is located within a container. If the return value is an item_id, then the Character AssetList API must be queried to find the container using the given item_id to determine the correct location of the Blueprint.
   * @return locationId
  **/
  @ApiModelProperty(required = true, value = "References a station, a ship or an item_id if this blueprint is located within a container. If the return value is an item_id, then the Character AssetList API must be queried to find the container using the given item_id to determine the correct location of the Blueprint.")
  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public GetCharactersCharacterIdBlueprints200Ok materialEfficiency(Integer materialEfficiency) {
    this.materialEfficiency = materialEfficiency;
    return this;
  }

   /**
   * Material Efficiency Level of the blueprint.
   * minimum: 0
   * maximum: 25
   * @return materialEfficiency
  **/
  @ApiModelProperty(required = true, value = "Material Efficiency Level of the blueprint.")
  public Integer getMaterialEfficiency() {
    return materialEfficiency;
  }

  public void setMaterialEfficiency(Integer materialEfficiency) {
    this.materialEfficiency = materialEfficiency;
  }

  public GetCharactersCharacterIdBlueprints200Ok quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * A range of numbers with a minimum of -2 and no maximum value where -1 is an original and -2 is a copy. It can be a positive integer if it is a stack of blueprint originals fresh from the market (e.g. no activities performed on them yet).
   * minimum: -2
   * @return quantity
  **/
  @ApiModelProperty(required = true, value = "A range of numbers with a minimum of -2 and no maximum value where -1 is an original and -2 is a copy. It can be a positive integer if it is a stack of blueprint originals fresh from the market (e.g. no activities performed on them yet).")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public GetCharactersCharacterIdBlueprints200Ok runs(Integer runs) {
    this.runs = runs;
    return this;
  }

   /**
   * Number of runs remaining if the blueprint is a copy, -1 if it is an original.
   * minimum: -1
   * @return runs
  **/
  @ApiModelProperty(required = true, value = "Number of runs remaining if the blueprint is a copy, -1 if it is an original.")
  public Integer getRuns() {
    return runs;
  }

  public void setRuns(Integer runs) {
    this.runs = runs;
  }

  public GetCharactersCharacterIdBlueprints200Ok timeEfficiency(Integer timeEfficiency) {
    this.timeEfficiency = timeEfficiency;
    return this;
  }

   /**
   * Time Efficiency Level of the blueprint.
   * minimum: 0
   * maximum: 20
   * @return timeEfficiency
  **/
  @ApiModelProperty(required = true, value = "Time Efficiency Level of the blueprint.")
  public Integer getTimeEfficiency() {
    return timeEfficiency;
  }

  public void setTimeEfficiency(Integer timeEfficiency) {
    this.timeEfficiency = timeEfficiency;
  }

  public GetCharactersCharacterIdBlueprints200Ok typeId(Integer typeId) {
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
    GetCharactersCharacterIdBlueprints200Ok getCharactersCharacterIdBlueprints200Ok = (GetCharactersCharacterIdBlueprints200Ok) o;
    return Objects.equals(this.itemId, getCharactersCharacterIdBlueprints200Ok.itemId) &&
        Objects.equals(this.locationFlag, getCharactersCharacterIdBlueprints200Ok.locationFlag) &&
        Objects.equals(this.locationId, getCharactersCharacterIdBlueprints200Ok.locationId) &&
        Objects.equals(this.materialEfficiency, getCharactersCharacterIdBlueprints200Ok.materialEfficiency) &&
        Objects.equals(this.quantity, getCharactersCharacterIdBlueprints200Ok.quantity) &&
        Objects.equals(this.runs, getCharactersCharacterIdBlueprints200Ok.runs) &&
        Objects.equals(this.timeEfficiency, getCharactersCharacterIdBlueprints200Ok.timeEfficiency) &&
        Objects.equals(this.typeId, getCharactersCharacterIdBlueprints200Ok.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, locationFlag, locationId, materialEfficiency, quantity, runs, timeEfficiency, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdBlueprints200Ok {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    locationFlag: ").append(toIndentedString(locationFlag)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    materialEfficiency: ").append(toIndentedString(materialEfficiency)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    runs: ").append(toIndentedString(runs)).append("\n");
    sb.append("    timeEfficiency: ").append(toIndentedString(timeEfficiency)).append("\n");
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

