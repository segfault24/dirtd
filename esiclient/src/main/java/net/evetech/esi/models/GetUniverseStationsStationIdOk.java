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
import java.util.ArrayList;
import java.util.List;
import net.evetech.esi.models.GetUniverseStationsStationIdPosition;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetUniverseStationsStationIdOk {
  @SerializedName("max_dockable_ship_volume")
  private Float maxDockableShipVolume = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("office_rental_cost")
  private Float officeRentalCost = null;

  @SerializedName("owner")
  private Integer owner = null;

  @SerializedName("position")
  private GetUniverseStationsStationIdPosition position = null;

  @SerializedName("race_id")
  private Integer raceId = null;

  @SerializedName("reprocessing_efficiency")
  private Float reprocessingEfficiency = null;

  @SerializedName("reprocessing_stations_take")
  private Float reprocessingStationsTake = null;

  /**
   * service string
   */
  @JsonAdapter(ServicesEnum.Adapter.class)
  public enum ServicesEnum {
    BOUNTY_MISSIONS("bounty-missions"),
    
    ASSASINATION_MISSIONS("assasination-missions"),
    
    COURIER_MISSIONS("courier-missions"),
    
    INTERBUS("interbus"),
    
    REPROCESSING_PLANT("reprocessing-plant"),
    
    REFINERY("refinery"),
    
    MARKET("market"),
    
    BLACK_MARKET("black-market"),
    
    STOCK_EXCHANGE("stock-exchange"),
    
    CLONING("cloning"),
    
    SURGERY("surgery"),
    
    DNA_THERAPY("dna-therapy"),
    
    REPAIR_FACILITIES("repair-facilities"),
    
    FACTORY("factory"),
    
    LABRATORY("labratory"),
    
    GAMBLING("gambling"),
    
    FITTING("fitting"),
    
    PAINTSHOP("paintshop"),
    
    NEWS("news"),
    
    STORAGE("storage"),
    
    INSURANCE("insurance"),
    
    DOCKING("docking"),
    
    OFFICE_RENTAL("office-rental"),
    
    JUMP_CLONE_FACILITY("jump-clone-facility"),
    
    LOYALTY_POINT_STORE("loyalty-point-store"),
    
    NAVY_OFFICES("navy-offices"),
    
    SECURITY_OFFICES("security-offices");

    private String value;

    ServicesEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ServicesEnum fromValue(String text) {
      for (ServicesEnum b : ServicesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ServicesEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ServicesEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ServicesEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ServicesEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("services")
  private List<ServicesEnum> services = new ArrayList<ServicesEnum>();

  @SerializedName("station_id")
  private Integer stationId = null;

  @SerializedName("system_id")
  private Integer systemId = null;

  @SerializedName("type_id")
  private Integer typeId = null;

  public GetUniverseStationsStationIdOk maxDockableShipVolume(Float maxDockableShipVolume) {
    this.maxDockableShipVolume = maxDockableShipVolume;
    return this;
  }

   /**
   * max_dockable_ship_volume number
   * @return maxDockableShipVolume
  **/
  @ApiModelProperty(required = true, value = "max_dockable_ship_volume number")
  public Float getMaxDockableShipVolume() {
    return maxDockableShipVolume;
  }

  public void setMaxDockableShipVolume(Float maxDockableShipVolume) {
    this.maxDockableShipVolume = maxDockableShipVolume;
  }

  public GetUniverseStationsStationIdOk name(String name) {
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

  public GetUniverseStationsStationIdOk officeRentalCost(Float officeRentalCost) {
    this.officeRentalCost = officeRentalCost;
    return this;
  }

   /**
   * office_rental_cost number
   * @return officeRentalCost
  **/
  @ApiModelProperty(required = true, value = "office_rental_cost number")
  public Float getOfficeRentalCost() {
    return officeRentalCost;
  }

  public void setOfficeRentalCost(Float officeRentalCost) {
    this.officeRentalCost = officeRentalCost;
  }

  public GetUniverseStationsStationIdOk owner(Integer owner) {
    this.owner = owner;
    return this;
  }

   /**
   * ID of the corporation that controls this station
   * @return owner
  **/
  @ApiModelProperty(value = "ID of the corporation that controls this station")
  public Integer getOwner() {
    return owner;
  }

  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public GetUniverseStationsStationIdOk position(GetUniverseStationsStationIdPosition position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @ApiModelProperty(required = true, value = "")
  public GetUniverseStationsStationIdPosition getPosition() {
    return position;
  }

  public void setPosition(GetUniverseStationsStationIdPosition position) {
    this.position = position;
  }

  public GetUniverseStationsStationIdOk raceId(Integer raceId) {
    this.raceId = raceId;
    return this;
  }

   /**
   * race_id integer
   * @return raceId
  **/
  @ApiModelProperty(value = "race_id integer")
  public Integer getRaceId() {
    return raceId;
  }

  public void setRaceId(Integer raceId) {
    this.raceId = raceId;
  }

  public GetUniverseStationsStationIdOk reprocessingEfficiency(Float reprocessingEfficiency) {
    this.reprocessingEfficiency = reprocessingEfficiency;
    return this;
  }

   /**
   * reprocessing_efficiency number
   * @return reprocessingEfficiency
  **/
  @ApiModelProperty(required = true, value = "reprocessing_efficiency number")
  public Float getReprocessingEfficiency() {
    return reprocessingEfficiency;
  }

  public void setReprocessingEfficiency(Float reprocessingEfficiency) {
    this.reprocessingEfficiency = reprocessingEfficiency;
  }

  public GetUniverseStationsStationIdOk reprocessingStationsTake(Float reprocessingStationsTake) {
    this.reprocessingStationsTake = reprocessingStationsTake;
    return this;
  }

   /**
   * reprocessing_stations_take number
   * @return reprocessingStationsTake
  **/
  @ApiModelProperty(required = true, value = "reprocessing_stations_take number")
  public Float getReprocessingStationsTake() {
    return reprocessingStationsTake;
  }

  public void setReprocessingStationsTake(Float reprocessingStationsTake) {
    this.reprocessingStationsTake = reprocessingStationsTake;
  }

  public GetUniverseStationsStationIdOk services(List<ServicesEnum> services) {
    this.services = services;
    return this;
  }

  public GetUniverseStationsStationIdOk addServicesItem(ServicesEnum servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

   /**
   * services array
   * @return services
  **/
  @ApiModelProperty(required = true, value = "services array")
  public List<ServicesEnum> getServices() {
    return services;
  }

  public void setServices(List<ServicesEnum> services) {
    this.services = services;
  }

  public GetUniverseStationsStationIdOk stationId(Integer stationId) {
    this.stationId = stationId;
    return this;
  }

   /**
   * station_id integer
   * @return stationId
  **/
  @ApiModelProperty(required = true, value = "station_id integer")
  public Integer getStationId() {
    return stationId;
  }

  public void setStationId(Integer stationId) {
    this.stationId = stationId;
  }

  public GetUniverseStationsStationIdOk systemId(Integer systemId) {
    this.systemId = systemId;
    return this;
  }

   /**
   * The solar system this station is in
   * @return systemId
  **/
  @ApiModelProperty(required = true, value = "The solar system this station is in")
  public Integer getSystemId() {
    return systemId;
  }

  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  public GetUniverseStationsStationIdOk typeId(Integer typeId) {
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
    GetUniverseStationsStationIdOk getUniverseStationsStationIdOk = (GetUniverseStationsStationIdOk) o;
    return Objects.equals(this.maxDockableShipVolume, getUniverseStationsStationIdOk.maxDockableShipVolume) &&
        Objects.equals(this.name, getUniverseStationsStationIdOk.name) &&
        Objects.equals(this.officeRentalCost, getUniverseStationsStationIdOk.officeRentalCost) &&
        Objects.equals(this.owner, getUniverseStationsStationIdOk.owner) &&
        Objects.equals(this.position, getUniverseStationsStationIdOk.position) &&
        Objects.equals(this.raceId, getUniverseStationsStationIdOk.raceId) &&
        Objects.equals(this.reprocessingEfficiency, getUniverseStationsStationIdOk.reprocessingEfficiency) &&
        Objects.equals(this.reprocessingStationsTake, getUniverseStationsStationIdOk.reprocessingStationsTake) &&
        Objects.equals(this.services, getUniverseStationsStationIdOk.services) &&
        Objects.equals(this.stationId, getUniverseStationsStationIdOk.stationId) &&
        Objects.equals(this.systemId, getUniverseStationsStationIdOk.systemId) &&
        Objects.equals(this.typeId, getUniverseStationsStationIdOk.typeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxDockableShipVolume, name, officeRentalCost, owner, position, raceId, reprocessingEfficiency, reprocessingStationsTake, services, stationId, systemId, typeId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUniverseStationsStationIdOk {\n");
    
    sb.append("    maxDockableShipVolume: ").append(toIndentedString(maxDockableShipVolume)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    officeRentalCost: ").append(toIndentedString(officeRentalCost)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    raceId: ").append(toIndentedString(raceId)).append("\n");
    sb.append("    reprocessingEfficiency: ").append(toIndentedString(reprocessingEfficiency)).append("\n");
    sb.append("    reprocessingStationsTake: ").append(toIndentedString(reprocessingStationsTake)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    stationId: ").append(toIndentedString(stationId)).append("\n");
    sb.append("    systemId: ").append(toIndentedString(systemId)).append("\n");
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

