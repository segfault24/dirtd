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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T20:58:31.116-04:00")
public class GetCorporationsCorporationIdContainersLogs200Ok {
  /**
   * action string
   */
  @JsonAdapter(ActionEnum.Adapter.class)
  public enum ActionEnum {
    ADD("add"),
    
    ASSEMBLE("assemble"),
    
    CONFIGURE("configure"),
    
    ENTER_PASSWORD("enter_password"),
    
    LOCK("lock"),
    
    MOVE("move"),
    
    REPACKAGE("repackage"),
    
    SET_NAME("set_name"),
    
    SET_PASSWORD("set_password"),
    
    UNLOCK("unlock");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ActionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ActionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ActionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ActionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("action")
  private ActionEnum action = null;

  @SerializedName("character_id")
  private Integer characterId = null;

  @SerializedName("container_id")
  private Long containerId = null;

  @SerializedName("container_type_id")
  private Integer containerTypeId = null;

  /**
   * location_flag string
   */
  @JsonAdapter(LocationFlagEnum.Adapter.class)
  public enum LocationFlagEnum {
    ASSETSAFETY("AssetSafety"),
    
    AUTOFIT("AutoFit"),
    
    BONUS("Bonus"),
    
    BOOSTER("Booster"),
    
    BOOSTERBAY("BoosterBay"),
    
    CAPSULE("Capsule"),
    
    CARGO("Cargo"),
    
    CORPDELIVERIES("CorpDeliveries"),
    
    CORPSAG1("CorpSAG1"),
    
    CORPSAG2("CorpSAG2"),
    
    CORPSAG3("CorpSAG3"),
    
    CORPSAG4("CorpSAG4"),
    
    CORPSAG5("CorpSAG5"),
    
    CORPSAG6("CorpSAG6"),
    
    CORPSAG7("CorpSAG7"),
    
    CRATELOOT("CrateLoot"),
    
    DELIVERIES("Deliveries"),
    
    DRONEBAY("DroneBay"),
    
    DUSTBATTLE("DustBattle"),
    
    DUSTDATABANK("DustDatabank"),
    
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
    
    IMPOUNDED("Impounded"),
    
    JUNKYARDREPROCESSED("JunkyardReprocessed"),
    
    JUNKYARDTRASHED("JunkyardTrashed"),
    
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
    
    OFFICEFOLDER("OfficeFolder"),
    
    PILOT("Pilot"),
    
    PLANETSURFACE("PlanetSurface"),
    
    QUAFEBAY("QuafeBay"),
    
    QUANTUMCOREROOM("QuantumCoreRoom"),
    
    REWARD("Reward"),
    
    RIGSLOT0("RigSlot0"),
    
    RIGSLOT1("RigSlot1"),
    
    RIGSLOT2("RigSlot2"),
    
    RIGSLOT3("RigSlot3"),
    
    RIGSLOT4("RigSlot4"),
    
    RIGSLOT5("RigSlot5"),
    
    RIGSLOT6("RigSlot6"),
    
    RIGSLOT7("RigSlot7"),
    
    SECONDARYSTORAGE("SecondaryStorage"),
    
    SERVICESLOT0("ServiceSlot0"),
    
    SERVICESLOT1("ServiceSlot1"),
    
    SERVICESLOT2("ServiceSlot2"),
    
    SERVICESLOT3("ServiceSlot3"),
    
    SERVICESLOT4("ServiceSlot4"),
    
    SERVICESLOT5("ServiceSlot5"),
    
    SERVICESLOT6("ServiceSlot6"),
    
    SERVICESLOT7("ServiceSlot7"),
    
    SHIPHANGAR("ShipHangar"),
    
    SHIPOFFLINE("ShipOffline"),
    
    SKILL("Skill"),
    
    SKILLINTRAINING("SkillInTraining"),
    
    SPECIALIZEDAMMOHOLD("SpecializedAmmoHold"),
    
    SPECIALIZEDCOMMANDCENTERHOLD("SpecializedCommandCenterHold"),
    
    SPECIALIZEDFUELBAY("SpecializedFuelBay"),
    
    SPECIALIZEDGASHOLD("SpecializedGasHold"),
    
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
    
    STRUCTUREACTIVE("StructureActive"),
    
    STRUCTUREFUEL("StructureFuel"),
    
    STRUCTUREINACTIVE("StructureInactive"),
    
    STRUCTUREOFFLINE("StructureOffline"),
    
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
    
    WALLET("Wallet"),
    
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

  @SerializedName("logged_at")
  private OffsetDateTime loggedAt = null;

  @SerializedName("new_config_bitmask")
  private Integer newConfigBitmask = null;

  @SerializedName("old_config_bitmask")
  private Integer oldConfigBitmask = null;

  /**
   * Type of password set if action is of type SetPassword or EnterPassword
   */
  @JsonAdapter(PasswordTypeEnum.Adapter.class)
  public enum PasswordTypeEnum {
    CONFIG("config"),
    
    GENERAL("general");

    private String value;

    PasswordTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PasswordTypeEnum fromValue(String text) {
      for (PasswordTypeEnum b : PasswordTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PasswordTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PasswordTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PasswordTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return PasswordTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("password_type")
  private PasswordTypeEnum passwordType = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetCorporationsCorporationIdContainersLogs200Ok action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * action string
   * @return action
  **/
  @ApiModelProperty(required = true, value = "action string")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok characterId(Integer characterId) {
    this.characterId = characterId;
    return this;
  }

   /**
   * ID of the character who performed the action.
   * @return characterId
  **/
  @ApiModelProperty(required = true, value = "ID of the character who performed the action.")
  public Integer getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Integer characterId) {
    this.characterId = characterId;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok containerId(Long containerId) {
    this.containerId = containerId;
    return this;
  }

   /**
   * ID of the container
   * @return containerId
  **/
  @ApiModelProperty(required = true, value = "ID of the container")
  public Long getContainerId() {
    return containerId;
  }

  public void setContainerId(Long containerId) {
    this.containerId = containerId;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok containerTypeId(Integer containerTypeId) {
    this.containerTypeId = containerTypeId;
    return this;
  }

   /**
   * Type ID of the container
   * @return containerTypeId
  **/
  @ApiModelProperty(required = true, value = "Type ID of the container")
  public Integer getContainerTypeId() {
    return containerTypeId;
  }

  public void setContainerTypeId(Integer containerTypeId) {
    this.containerTypeId = containerTypeId;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok locationFlag(LocationFlagEnum locationFlag) {
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

  public GetCorporationsCorporationIdContainersLogs200Ok locationId(Long locationId) {
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

  public GetCorporationsCorporationIdContainersLogs200Ok loggedAt(OffsetDateTime loggedAt) {
    this.loggedAt = loggedAt;
    return this;
  }

   /**
   * Timestamp when this log was created
   * @return loggedAt
  **/
  @ApiModelProperty(required = true, value = "Timestamp when this log was created")
  public OffsetDateTime getLoggedAt() {
    return loggedAt;
  }

  public void setLoggedAt(OffsetDateTime loggedAt) {
    this.loggedAt = loggedAt;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok newConfigBitmask(Integer newConfigBitmask) {
    this.newConfigBitmask = newConfigBitmask;
    return this;
  }

   /**
   * new_config_bitmask integer
   * @return newConfigBitmask
  **/
  @ApiModelProperty(value = "new_config_bitmask integer")
  public Integer getNewConfigBitmask() {
    return newConfigBitmask;
  }

  public void setNewConfigBitmask(Integer newConfigBitmask) {
    this.newConfigBitmask = newConfigBitmask;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok oldConfigBitmask(Integer oldConfigBitmask) {
    this.oldConfigBitmask = oldConfigBitmask;
    return this;
  }

   /**
   * old_config_bitmask integer
   * @return oldConfigBitmask
  **/
  @ApiModelProperty(value = "old_config_bitmask integer")
  public Integer getOldConfigBitmask() {
    return oldConfigBitmask;
  }

  public void setOldConfigBitmask(Integer oldConfigBitmask) {
    this.oldConfigBitmask = oldConfigBitmask;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok passwordType(PasswordTypeEnum passwordType) {
    this.passwordType = passwordType;
    return this;
  }

   /**
   * Type of password set if action is of type SetPassword or EnterPassword
   * @return passwordType
  **/
  @ApiModelProperty(value = "Type of password set if action is of type SetPassword or EnterPassword")
  public PasswordTypeEnum getPasswordType() {
    return passwordType;
  }

  public void setPasswordType(PasswordTypeEnum passwordType) {
    this.passwordType = passwordType;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Quantity of the item being acted upon
   * @return quantity
  **/
  @ApiModelProperty(value = "Quantity of the item being acted upon")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public GetCorporationsCorporationIdContainersLogs200Ok typeId(Integer typeId) {
    this.typeId = typeId;
    return this;
  }

   /**
   * Type ID of the item being acted upon
   * @return typeId
  **/
  @ApiModelProperty(value = "Type ID of the item being acted upon")
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
    GetCorporationsCorporationIdContainersLogs200Ok getCorporationsCorporationIdContainersLogs200Ok = (GetCorporationsCorporationIdContainersLogs200Ok) o;
    return Objects.equals(this.action, getCorporationsCorporationIdContainersLogs200Ok.action) &&
        Objects.equals(this.characterId, getCorporationsCorporationIdContainersLogs200Ok.characterId) &&
        Objects.equals(this.containerId, getCorporationsCorporationIdContainersLogs200Ok.containerId) &&
        Objects.equals(this.containerTypeId, getCorporationsCorporationIdContainersLogs200Ok.containerTypeId) &&
        Objects.equals(this.locationFlag, getCorporationsCorporationIdContainersLogs200Ok.locationFlag) &&
        Objects.equals(this.locationId, getCorporationsCorporationIdContainersLogs200Ok.locationId) &&
        Objects.equals(this.loggedAt, getCorporationsCorporationIdContainersLogs200Ok.loggedAt) &&
        Objects.equals(this.newConfigBitmask, getCorporationsCorporationIdContainersLogs200Ok.newConfigBitmask) &&
        Objects.equals(this.oldConfigBitmask, getCorporationsCorporationIdContainersLogs200Ok.oldConfigBitmask) &&
        Objects.equals(this.passwordType, getCorporationsCorporationIdContainersLogs200Ok.passwordType) &&
        Objects.equals(this.quantity, getCorporationsCorporationIdContainersLogs200Ok.quantity) &&
        Objects.equals(this.typeId, getCorporationsCorporationIdContainersLogs200Ok.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, characterId, containerId, containerTypeId, locationFlag, locationId, loggedAt, newConfigBitmask, oldConfigBitmask, passwordType, quantity, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdContainersLogs200Ok {\n");
    
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    characterId: ").append(toIndentedString(characterId)).append("\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
    sb.append("    containerTypeId: ").append(toIndentedString(containerTypeId)).append("\n");
    sb.append("    locationFlag: ").append(toIndentedString(locationFlag)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    loggedAt: ").append(toIndentedString(loggedAt)).append("\n");
    sb.append("    newConfigBitmask: ").append(toIndentedString(newConfigBitmask)).append("\n");
    sb.append("    oldConfigBitmask: ").append(toIndentedString(oldConfigBitmask)).append("\n");
    sb.append("    passwordType: ").append(toIndentedString(passwordType)).append("\n");
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

