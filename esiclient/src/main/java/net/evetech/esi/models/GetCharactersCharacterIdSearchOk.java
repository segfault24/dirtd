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

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-27T23:34:00.171-05:00")
public class GetCharactersCharacterIdSearchOk {
  @SerializedName("agent")
  private List<Integer> agent = null;

  @SerializedName("alliance")
  private List<Integer> alliance = null;

  @SerializedName("character")
  private List<Integer> character = null;

  @SerializedName("constellation")
  private List<Integer> constellation = null;

  @SerializedName("corporation")
  private List<Integer> corporation = null;

  @SerializedName("faction")
  private List<Integer> faction = null;

  @SerializedName("inventory_type")
  private List<Integer> inventoryType = null;

  @SerializedName("region")
  private List<Integer> region = null;

  @SerializedName("solar_system")
  private List<Integer> solarSystem = null;

  @SerializedName("station")
  private List<Integer> station = null;

  @SerializedName("structure")
  private List<Long> structure = null;

  public GetCharactersCharacterIdSearchOk agent(List<Integer> agent) {
    this.agent = agent;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addAgentItem(Integer agentItem) {
    if (this.agent == null) {
      this.agent = new ArrayList<Integer>();
    }
    this.agent.add(agentItem);
    return this;
  }

   /**
   * agent array
   * @return agent
  **/
  @ApiModelProperty(value = "agent array")
  public List<Integer> getAgent() {
    return agent;
  }

  public void setAgent(List<Integer> agent) {
    this.agent = agent;
  }

  public GetCharactersCharacterIdSearchOk alliance(List<Integer> alliance) {
    this.alliance = alliance;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addAllianceItem(Integer allianceItem) {
    if (this.alliance == null) {
      this.alliance = new ArrayList<Integer>();
    }
    this.alliance.add(allianceItem);
    return this;
  }

   /**
   * alliance array
   * @return alliance
  **/
  @ApiModelProperty(value = "alliance array")
  public List<Integer> getAlliance() {
    return alliance;
  }

  public void setAlliance(List<Integer> alliance) {
    this.alliance = alliance;
  }

  public GetCharactersCharacterIdSearchOk character(List<Integer> character) {
    this.character = character;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addCharacterItem(Integer characterItem) {
    if (this.character == null) {
      this.character = new ArrayList<Integer>();
    }
    this.character.add(characterItem);
    return this;
  }

   /**
   * character array
   * @return character
  **/
  @ApiModelProperty(value = "character array")
  public List<Integer> getCharacter() {
    return character;
  }

  public void setCharacter(List<Integer> character) {
    this.character = character;
  }

  public GetCharactersCharacterIdSearchOk constellation(List<Integer> constellation) {
    this.constellation = constellation;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addConstellationItem(Integer constellationItem) {
    if (this.constellation == null) {
      this.constellation = new ArrayList<Integer>();
    }
    this.constellation.add(constellationItem);
    return this;
  }

   /**
   * constellation array
   * @return constellation
  **/
  @ApiModelProperty(value = "constellation array")
  public List<Integer> getConstellation() {
    return constellation;
  }

  public void setConstellation(List<Integer> constellation) {
    this.constellation = constellation;
  }

  public GetCharactersCharacterIdSearchOk corporation(List<Integer> corporation) {
    this.corporation = corporation;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addCorporationItem(Integer corporationItem) {
    if (this.corporation == null) {
      this.corporation = new ArrayList<Integer>();
    }
    this.corporation.add(corporationItem);
    return this;
  }

   /**
   * corporation array
   * @return corporation
  **/
  @ApiModelProperty(value = "corporation array")
  public List<Integer> getCorporation() {
    return corporation;
  }

  public void setCorporation(List<Integer> corporation) {
    this.corporation = corporation;
  }

  public GetCharactersCharacterIdSearchOk faction(List<Integer> faction) {
    this.faction = faction;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addFactionItem(Integer factionItem) {
    if (this.faction == null) {
      this.faction = new ArrayList<Integer>();
    }
    this.faction.add(factionItem);
    return this;
  }

   /**
   * faction array
   * @return faction
  **/
  @ApiModelProperty(value = "faction array")
  public List<Integer> getFaction() {
    return faction;
  }

  public void setFaction(List<Integer> faction) {
    this.faction = faction;
  }

  public GetCharactersCharacterIdSearchOk inventoryType(List<Integer> inventoryType) {
    this.inventoryType = inventoryType;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addInventoryTypeItem(Integer inventoryTypeItem) {
    if (this.inventoryType == null) {
      this.inventoryType = new ArrayList<Integer>();
    }
    this.inventoryType.add(inventoryTypeItem);
    return this;
  }

   /**
   * inventory_type array
   * @return inventoryType
  **/
  @ApiModelProperty(value = "inventory_type array")
  public List<Integer> getInventoryType() {
    return inventoryType;
  }

  public void setInventoryType(List<Integer> inventoryType) {
    this.inventoryType = inventoryType;
  }

  public GetCharactersCharacterIdSearchOk region(List<Integer> region) {
    this.region = region;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addRegionItem(Integer regionItem) {
    if (this.region == null) {
      this.region = new ArrayList<Integer>();
    }
    this.region.add(regionItem);
    return this;
  }

   /**
   * region array
   * @return region
  **/
  @ApiModelProperty(value = "region array")
  public List<Integer> getRegion() {
    return region;
  }

  public void setRegion(List<Integer> region) {
    this.region = region;
  }

  public GetCharactersCharacterIdSearchOk solarSystem(List<Integer> solarSystem) {
    this.solarSystem = solarSystem;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addSolarSystemItem(Integer solarSystemItem) {
    if (this.solarSystem == null) {
      this.solarSystem = new ArrayList<Integer>();
    }
    this.solarSystem.add(solarSystemItem);
    return this;
  }

   /**
   * solar_system array
   * @return solarSystem
  **/
  @ApiModelProperty(value = "solar_system array")
  public List<Integer> getSolarSystem() {
    return solarSystem;
  }

  public void setSolarSystem(List<Integer> solarSystem) {
    this.solarSystem = solarSystem;
  }

  public GetCharactersCharacterIdSearchOk station(List<Integer> station) {
    this.station = station;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addStationItem(Integer stationItem) {
    if (this.station == null) {
      this.station = new ArrayList<Integer>();
    }
    this.station.add(stationItem);
    return this;
  }

   /**
   * station array
   * @return station
  **/
  @ApiModelProperty(value = "station array")
  public List<Integer> getStation() {
    return station;
  }

  public void setStation(List<Integer> station) {
    this.station = station;
  }

  public GetCharactersCharacterIdSearchOk structure(List<Long> structure) {
    this.structure = structure;
    return this;
  }

  public GetCharactersCharacterIdSearchOk addStructureItem(Long structureItem) {
    if (this.structure == null) {
      this.structure = new ArrayList<Long>();
    }
    this.structure.add(structureItem);
    return this;
  }

   /**
   * structure array
   * @return structure
  **/
  @ApiModelProperty(value = "structure array")
  public List<Long> getStructure() {
    return structure;
  }

  public void setStructure(List<Long> structure) {
    this.structure = structure;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdSearchOk getCharactersCharacterIdSearchOk = (GetCharactersCharacterIdSearchOk) o;
    return Objects.equals(this.agent, getCharactersCharacterIdSearchOk.agent) &&
        Objects.equals(this.alliance, getCharactersCharacterIdSearchOk.alliance) &&
        Objects.equals(this.character, getCharactersCharacterIdSearchOk.character) &&
        Objects.equals(this.constellation, getCharactersCharacterIdSearchOk.constellation) &&
        Objects.equals(this.corporation, getCharactersCharacterIdSearchOk.corporation) &&
        Objects.equals(this.faction, getCharactersCharacterIdSearchOk.faction) &&
        Objects.equals(this.inventoryType, getCharactersCharacterIdSearchOk.inventoryType) &&
        Objects.equals(this.region, getCharactersCharacterIdSearchOk.region) &&
        Objects.equals(this.solarSystem, getCharactersCharacterIdSearchOk.solarSystem) &&
        Objects.equals(this.station, getCharactersCharacterIdSearchOk.station) &&
        Objects.equals(this.structure, getCharactersCharacterIdSearchOk.structure);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agent, alliance, character, constellation, corporation, faction, inventoryType, region, solarSystem, station, structure);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdSearchOk {\n");
    
    sb.append("    agent: ").append(toIndentedString(agent)).append("\n");
    sb.append("    alliance: ").append(toIndentedString(alliance)).append("\n");
    sb.append("    character: ").append(toIndentedString(character)).append("\n");
    sb.append("    constellation: ").append(toIndentedString(constellation)).append("\n");
    sb.append("    corporation: ").append(toIndentedString(corporation)).append("\n");
    sb.append("    faction: ").append(toIndentedString(faction)).append("\n");
    sb.append("    inventoryType: ").append(toIndentedString(inventoryType)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    solarSystem: ").append(toIndentedString(solarSystem)).append("\n");
    sb.append("    station: ").append(toIndentedString(station)).append("\n");
    sb.append("    structure: ").append(toIndentedString(structure)).append("\n");
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

