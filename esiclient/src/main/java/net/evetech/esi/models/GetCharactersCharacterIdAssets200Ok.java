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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T20:58:31.116-04:00")
public class GetCharactersCharacterIdAssets200Ok {
  @SerializedName("is_blueprint_copy")
  private Boolean isBlueprintCopy = null;

  @SerializedName("is_singleton")
  private Boolean isSingleton = null;

  @SerializedName("item_id")
  private Long itemId = null;

  /**
   * location_flag string
   */
  @JsonAdapter(LocationFlagEnum.Adapter.class)
  public enum LocationFlagEnum {
    ASSETSAFETY("AssetSafety"),
    
    AUTOFIT("AutoFit"),
    
    BOOSTERBAY("BoosterBay"),
    
    CARGO("Cargo"),
    
    CORPSEBAY("CorpseBay"),
    
    DELIVERIES("Deliveries"),
    
    DRONEBAY("DroneBay"),
    
    FIGHTERBAY("FighterBay"),
    
    FIGHTERTUBE0("FighterTube0"),
    
    FIGHTERTUBE1("FighterTube1"),
    
    FIGHTERTUBE2("FighterTube2"),
    
    FIGHTERTUBE3("FighterTube3"),
    
    FIGHTERTUBE4("FighterTube4"),
    
    FLEETHANGAR("FleetHangar"),
    
    FRIGATEESCAPEBAY("FrigateEscapeBay"),
    
    HANGAR("Hangar"),
    
    HANGARALL("HangarAll"),
    
    HISLOT0("HiSlot0"),
    
    HISLOT1("HiSlot1"),
    
    HISLOT2("HiSlot2"),
    
    HISLOT3("HiSlot3"),
    
    HISLOT4("HiSlot4"),
    
    HISLOT5("HiSlot5"),
    
    HISLOT6("HiSlot6"),
    
    HISLOT7("HiSlot7"),
    
    HIDDENMODIFIERS("HiddenModifiers"),
    
    IMPLANT("Implant"),
    
    LOSLOT0("LoSlot0"),
    
    LOSLOT1("LoSlot1"),
    
    LOSLOT2("LoSlot2"),
    
    LOSLOT3("LoSlot3"),
    
    LOSLOT4("LoSlot4"),
    
    LOSLOT5("LoSlot5"),
    
    LOSLOT6("LoSlot6"),
    
    LOSLOT7("LoSlot7"),
    
    LOCKED("Locked"),
    
    MEDSLOT0("MedSlot0"),
    
    MEDSLOT1("MedSlot1"),
    
    MEDSLOT2("MedSlot2"),
    
    MEDSLOT3("MedSlot3"),
    
    MEDSLOT4("MedSlot4"),
    
    MEDSLOT5("MedSlot5"),
    
    MEDSLOT6("MedSlot6"),
    
    MEDSLOT7("MedSlot7"),
    
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
    
    SKILL("Skill"),
    
    SPECIALIZEDAMMOHOLD("SpecializedAmmoHold"),
    
    SPECIALIZEDASTEROIDHOLD("SpecializedAsteroidHold"),
    
    SPECIALIZEDCOMMANDCENTERHOLD("SpecializedCommandCenterHold"),
    
    SPECIALIZEDFUELBAY("SpecializedFuelBay"),
    
    SPECIALIZEDGASHOLD("SpecializedGasHold"),
    
    SPECIALIZEDICEHOLD("SpecializedIceHold"),
    
    SPECIALIZEDINDUSTRIALSHIPHOLD("SpecializedIndustrialShipHold"),
    
    SPECIALIZEDLARGESHIPHOLD("SpecializedLargeShipHold"),
    
    SPECIALIZEDMATERIALBAY("SpecializedMaterialBay"),
    
    SPECIALIZEDMEDIUMSHIPHOLD("SpecializedMediumShipHold"),
    
    SPECIALIZEDMINERALHOLD("SpecializedMineralHold"),
    
    SPECIALIZEDOREHOLD("SpecializedOreHold"),
    
    SPECIALIZEDPLANETARYCOMMODITIESHOLD("SpecializedPlanetaryCommoditiesHold"),
    
    SPECIALIZEDSALVAGEHOLD("SpecializedSalvageHold"),
    
    SPECIALIZEDSHIPHOLD("SpecializedShipHold"),
    
    SPECIALIZEDSMALLSHIPHOLD("SpecializedSmallShipHold"),
    
    STRUCTUREDEEDBAY("StructureDeedBay"),
    
    SUBSYSTEMBAY("SubSystemBay"),
    
    SUBSYSTEMSLOT0("SubSystemSlot0"),
    
    SUBSYSTEMSLOT1("SubSystemSlot1"),
    
    SUBSYSTEMSLOT2("SubSystemSlot2"),
    
    SUBSYSTEMSLOT3("SubSystemSlot3"),
    
    SUBSYSTEMSLOT4("SubSystemSlot4"),
    
    SUBSYSTEMSLOT5("SubSystemSlot5"),
    
    SUBSYSTEMSLOT6("SubSystemSlot6"),
    
    SUBSYSTEMSLOT7("SubSystemSlot7"),
    
    UNLOCKED("Unlocked"),
    
    WARDROBE("Wardrobe");

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

  /**
   * location_type string
   */
  @JsonAdapter(LocationTypeEnum.Adapter.class)
  public enum LocationTypeEnum {
    STATION("station"),
    
    SOLAR_SYSTEM("solar_system"),
    
    ITEM("item"),
    
    OTHER("other");

    private String value;

    LocationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LocationTypeEnum fromValue(String text) {
      for (LocationTypeEnum b : LocationTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<LocationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LocationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LocationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return LocationTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("location_type")
  private LocationTypeEnum locationType = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCharactersCharacterIdAssets200Ok isBlueprintCopy(Boolean isBlueprintCopy) {
    this.isBlueprintCopy = isBlueprintCopy;
    return this;
  }

   /**
   * is_blueprint_copy boolean
   * @return isBlueprintCopy
  **/
  @ApiModelProperty(value = "is_blueprint_copy boolean")
  public Boolean isIsBlueprintCopy() {
    return isBlueprintCopy;
  }

  public void setIsBlueprintCopy(Boolean isBlueprintCopy) {
    this.isBlueprintCopy = isBlueprintCopy;
  }

  public GetCharactersCharacterIdAssets200Ok isSingleton(Boolean isSingleton) {
    this.isSingleton = isSingleton;
    return this;
  }

   /**
   * is_singleton boolean
   * @return isSingleton
  **/
  @ApiModelProperty(required = true, value = "is_singleton boolean")
  public Boolean isIsSingleton() {
    return isSingleton;
  }

  public void setIsSingleton(Boolean isSingleton) {
    this.isSingleton = isSingleton;
  }

  public GetCharactersCharacterIdAssets200Ok itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

   /**
   * item_id integer
   * @return itemId
  **/
  @ApiModelProperty(required = true, value = "item_id integer")
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public GetCharactersCharacterIdAssets200Ok locationFlag(LocationFlagEnum locationFlag) {
    this.locationFlag = locationFlag;
    return this;
  }

   /**
   * location_flag string
   * @return locationFlag
  **/
  @ApiModelProperty(required = true, value = "location_flag string")
  public LocationFlagEnum getLocationFlag() {
    return locationFlag;
  }

  public void setLocationFlag(LocationFlagEnum locationFlag) {
    this.locationFlag = locationFlag;
  }

  public GetCharactersCharacterIdAssets200Ok locationId(Long locationId) {
    this.locationId = locationId;
    return this;
  }

   /**
   * location_id integer
   * @return locationId
  **/
  @ApiModelProperty(required = true, value = "location_id integer")
  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public GetCharactersCharacterIdAssets200Ok locationType(LocationTypeEnum locationType) {
    this.locationType = locationType;
    return this;
  }

   /**
   * location_type string
   * @return locationType
  **/
  @ApiModelProperty(required = true, value = "location_type string")
  public LocationTypeEnum getLocationType() {
    return locationType;
  }

  public void setLocationType(LocationTypeEnum locationType) {
    this.locationType = locationType;
  }

  public GetCharactersCharacterIdAssets200Ok quantity(Integer quantity) {
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

  public GetCharactersCharacterIdAssets200Ok typeId(Integer typeId) {
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
    GetCharactersCharacterIdAssets200Ok getCharactersCharacterIdAssets200Ok = (GetCharactersCharacterIdAssets200Ok) o;
    return Objects.equals(this.isBlueprintCopy, getCharactersCharacterIdAssets200Ok.isBlueprintCopy) &&
        Objects.equals(this.isSingleton, getCharactersCharacterIdAssets200Ok.isSingleton) &&
        Objects.equals(this.itemId, getCharactersCharacterIdAssets200Ok.itemId) &&
        Objects.equals(this.locationFlag, getCharactersCharacterIdAssets200Ok.locationFlag) &&
        Objects.equals(this.locationId, getCharactersCharacterIdAssets200Ok.locationId) &&
        Objects.equals(this.locationType, getCharactersCharacterIdAssets200Ok.locationType) &&
        Objects.equals(this.quantity, getCharactersCharacterIdAssets200Ok.quantity) &&
        Objects.equals(this.typeId, getCharactersCharacterIdAssets200Ok.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isBlueprintCopy, isSingleton, itemId, locationFlag, locationId, locationType, quantity, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdAssets200Ok {\n");
    
    sb.append("    isBlueprintCopy: ").append(toIndentedString(isBlueprintCopy)).append("\n");
    sb.append("    isSingleton: ").append(toIndentedString(isSingleton)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    locationFlag: ").append(toIndentedString(locationFlag)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    locationType: ").append(toIndentedString(locationType)).append("\n");
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

