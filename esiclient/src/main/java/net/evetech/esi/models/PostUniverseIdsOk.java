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
import java.util.ArrayList;
import java.util.List;
import net.evetech.esi.models.PostUniverseIdsAgent;
import net.evetech.esi.models.PostUniverseIdsAlliance;
import net.evetech.esi.models.PostUniverseIdsCharacter;
import net.evetech.esi.models.PostUniverseIdsConstellation;
import net.evetech.esi.models.PostUniverseIdsCorporation;
import net.evetech.esi.models.PostUniverseIdsFaction;
import net.evetech.esi.models.PostUniverseIdsInventoryType;
import net.evetech.esi.models.PostUniverseIdsRegion;
import net.evetech.esi.models.PostUniverseIdsStation;
import net.evetech.esi.models.PostUniverseIdsSystem;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class PostUniverseIdsOk {
  @SerializedName("agents")
  private List<PostUniverseIdsAgent> agents = null;

  @SerializedName("alliances")
  private List<PostUniverseIdsAlliance> alliances = null;

  @SerializedName("characters")
  private List<PostUniverseIdsCharacter> characters = null;

  @SerializedName("constellations")
  private List<PostUniverseIdsConstellation> constellations = null;

  @SerializedName("corporations")
  private List<PostUniverseIdsCorporation> corporations = null;

  @SerializedName("factions")
  private List<PostUniverseIdsFaction> factions = null;

  @SerializedName("inventory_types")
  private List<PostUniverseIdsInventoryType> inventoryTypes = null;

  @SerializedName("regions")
  private List<PostUniverseIdsRegion> regions = null;

  @SerializedName("stations")
  private List<PostUniverseIdsStation> stations = null;

  @SerializedName("systems")
  private List<PostUniverseIdsSystem> systems = null;

  public PostUniverseIdsOk agents(List<PostUniverseIdsAgent> agents) {
    this.agents = agents;
    return this;
  }

  public PostUniverseIdsOk addAgentsItem(PostUniverseIdsAgent agentsItem) {
    if (this.agents == null) {
      this.agents = new ArrayList<PostUniverseIdsAgent>();
    }
    this.agents.add(agentsItem);
    return this;
  }

   /**
   * agents array
   * @return agents
  **/
  @ApiModelProperty(value = "agents array")
  public List<PostUniverseIdsAgent> getAgents() {
    return agents;
  }

  public void setAgents(List<PostUniverseIdsAgent> agents) {
    this.agents = agents;
  }

  public PostUniverseIdsOk alliances(List<PostUniverseIdsAlliance> alliances) {
    this.alliances = alliances;
    return this;
  }

  public PostUniverseIdsOk addAlliancesItem(PostUniverseIdsAlliance alliancesItem) {
    if (this.alliances == null) {
      this.alliances = new ArrayList<PostUniverseIdsAlliance>();
    }
    this.alliances.add(alliancesItem);
    return this;
  }

   /**
   * alliances array
   * @return alliances
  **/
  @ApiModelProperty(value = "alliances array")
  public List<PostUniverseIdsAlliance> getAlliances() {
    return alliances;
  }

  public void setAlliances(List<PostUniverseIdsAlliance> alliances) {
    this.alliances = alliances;
  }

  public PostUniverseIdsOk characters(List<PostUniverseIdsCharacter> characters) {
    this.characters = characters;
    return this;
  }

  public PostUniverseIdsOk addCharactersItem(PostUniverseIdsCharacter charactersItem) {
    if (this.characters == null) {
      this.characters = new ArrayList<PostUniverseIdsCharacter>();
    }
    this.characters.add(charactersItem);
    return this;
  }

   /**
   * characters array
   * @return characters
  **/
  @ApiModelProperty(value = "characters array")
  public List<PostUniverseIdsCharacter> getCharacters() {
    return characters;
  }

  public void setCharacters(List<PostUniverseIdsCharacter> characters) {
    this.characters = characters;
  }

  public PostUniverseIdsOk constellations(List<PostUniverseIdsConstellation> constellations) {
    this.constellations = constellations;
    return this;
  }

  public PostUniverseIdsOk addConstellationsItem(PostUniverseIdsConstellation constellationsItem) {
    if (this.constellations == null) {
      this.constellations = new ArrayList<PostUniverseIdsConstellation>();
    }
    this.constellations.add(constellationsItem);
    return this;
  }

   /**
   * constellations array
   * @return constellations
  **/
  @ApiModelProperty(value = "constellations array")
  public List<PostUniverseIdsConstellation> getConstellations() {
    return constellations;
  }

  public void setConstellations(List<PostUniverseIdsConstellation> constellations) {
    this.constellations = constellations;
  }

  public PostUniverseIdsOk corporations(List<PostUniverseIdsCorporation> corporations) {
    this.corporations = corporations;
    return this;
  }

  public PostUniverseIdsOk addCorporationsItem(PostUniverseIdsCorporation corporationsItem) {
    if (this.corporations == null) {
      this.corporations = new ArrayList<PostUniverseIdsCorporation>();
    }
    this.corporations.add(corporationsItem);
    return this;
  }

   /**
   * corporations array
   * @return corporations
  **/
  @ApiModelProperty(value = "corporations array")
  public List<PostUniverseIdsCorporation> getCorporations() {
    return corporations;
  }

  public void setCorporations(List<PostUniverseIdsCorporation> corporations) {
    this.corporations = corporations;
  }

  public PostUniverseIdsOk factions(List<PostUniverseIdsFaction> factions) {
    this.factions = factions;
    return this;
  }

  public PostUniverseIdsOk addFactionsItem(PostUniverseIdsFaction factionsItem) {
    if (this.factions == null) {
      this.factions = new ArrayList<PostUniverseIdsFaction>();
    }
    this.factions.add(factionsItem);
    return this;
  }

   /**
   * factions array
   * @return factions
  **/
  @ApiModelProperty(value = "factions array")
  public List<PostUniverseIdsFaction> getFactions() {
    return factions;
  }

  public void setFactions(List<PostUniverseIdsFaction> factions) {
    this.factions = factions;
  }

  public PostUniverseIdsOk inventoryTypes(List<PostUniverseIdsInventoryType> inventoryTypes) {
    this.inventoryTypes = inventoryTypes;
    return this;
  }

  public PostUniverseIdsOk addInventoryTypesItem(PostUniverseIdsInventoryType inventoryTypesItem) {
    if (this.inventoryTypes == null) {
      this.inventoryTypes = new ArrayList<PostUniverseIdsInventoryType>();
    }
    this.inventoryTypes.add(inventoryTypesItem);
    return this;
  }

   /**
   * inventory_types array
   * @return inventoryTypes
  **/
  @ApiModelProperty(value = "inventory_types array")
  public List<PostUniverseIdsInventoryType> getInventoryTypes() {
    return inventoryTypes;
  }

  public void setInventoryTypes(List<PostUniverseIdsInventoryType> inventoryTypes) {
    this.inventoryTypes = inventoryTypes;
  }

  public PostUniverseIdsOk regions(List<PostUniverseIdsRegion> regions) {
    this.regions = regions;
    return this;
  }

  public PostUniverseIdsOk addRegionsItem(PostUniverseIdsRegion regionsItem) {
    if (this.regions == null) {
      this.regions = new ArrayList<PostUniverseIdsRegion>();
    }
    this.regions.add(regionsItem);
    return this;
  }

   /**
   * regions array
   * @return regions
  **/
  @ApiModelProperty(value = "regions array")
  public List<PostUniverseIdsRegion> getRegions() {
    return regions;
  }

  public void setRegions(List<PostUniverseIdsRegion> regions) {
    this.regions = regions;
  }

  public PostUniverseIdsOk stations(List<PostUniverseIdsStation> stations) {
    this.stations = stations;
    return this;
  }

  public PostUniverseIdsOk addStationsItem(PostUniverseIdsStation stationsItem) {
    if (this.stations == null) {
      this.stations = new ArrayList<PostUniverseIdsStation>();
    }
    this.stations.add(stationsItem);
    return this;
  }

   /**
   * stations array
   * @return stations
  **/
  @ApiModelProperty(value = "stations array")
  public List<PostUniverseIdsStation> getStations() {
    return stations;
  }

  public void setStations(List<PostUniverseIdsStation> stations) {
    this.stations = stations;
  }

  public PostUniverseIdsOk systems(List<PostUniverseIdsSystem> systems) {
    this.systems = systems;
    return this;
  }

  public PostUniverseIdsOk addSystemsItem(PostUniverseIdsSystem systemsItem) {
    if (this.systems == null) {
      this.systems = new ArrayList<PostUniverseIdsSystem>();
    }
    this.systems.add(systemsItem);
    return this;
  }

   /**
   * systems array
   * @return systems
  **/
  @ApiModelProperty(value = "systems array")
  public List<PostUniverseIdsSystem> getSystems() {
    return systems;
  }

  public void setSystems(List<PostUniverseIdsSystem> systems) {
    this.systems = systems;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostUniverseIdsOk postUniverseIdsOk = (PostUniverseIdsOk) o;
    return Objects.equals(this.agents, postUniverseIdsOk.agents) &&
        Objects.equals(this.alliances, postUniverseIdsOk.alliances) &&
        Objects.equals(this.characters, postUniverseIdsOk.characters) &&
        Objects.equals(this.constellations, postUniverseIdsOk.constellations) &&
        Objects.equals(this.corporations, postUniverseIdsOk.corporations) &&
        Objects.equals(this.factions, postUniverseIdsOk.factions) &&
        Objects.equals(this.inventoryTypes, postUniverseIdsOk.inventoryTypes) &&
        Objects.equals(this.regions, postUniverseIdsOk.regions) &&
        Objects.equals(this.stations, postUniverseIdsOk.stations) &&
        Objects.equals(this.systems, postUniverseIdsOk.systems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(agents, alliances, characters, constellations, corporations, factions, inventoryTypes, regions, stations, systems);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostUniverseIdsOk {\n");
    
    sb.append("    agents: ").append(toIndentedString(agents)).append("\n");
    sb.append("    alliances: ").append(toIndentedString(alliances)).append("\n");
    sb.append("    characters: ").append(toIndentedString(characters)).append("\n");
    sb.append("    constellations: ").append(toIndentedString(constellations)).append("\n");
    sb.append("    corporations: ").append(toIndentedString(corporations)).append("\n");
    sb.append("    factions: ").append(toIndentedString(factions)).append("\n");
    sb.append("    inventoryTypes: ").append(toIndentedString(inventoryTypes)).append("\n");
    sb.append("    regions: ").append(toIndentedString(regions)).append("\n");
    sb.append("    stations: ").append(toIndentedString(stations)).append("\n");
    sb.append("    systems: ").append(toIndentedString(systems)).append("\n");
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

