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
 * contents object
 */
@ApiModel(description = "contents object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class PutCharactersCharacterIdMailMailIdContents {
  @SerializedName("labels")
  private List<Integer> labels = null;

  @SerializedName("read")
  private Boolean read = null;

  public PutCharactersCharacterIdMailMailIdContents labels(List<Integer> labels) {
    this.labels = labels;
    return this;
  }

  public PutCharactersCharacterIdMailMailIdContents addLabelsItem(Integer labelsItem) {
    if (this.labels == null) {
      this.labels = new ArrayList<Integer>();
    }
    this.labels.add(labelsItem);
    return this;
  }

   /**
   * Labels to assign to the mail. Pre-existing labels are unassigned.
   * @return labels
  **/
  @ApiModelProperty(value = "Labels to assign to the mail. Pre-existing labels are unassigned.")
  public List<Integer> getLabels() {
    return labels;
  }

  public void setLabels(List<Integer> labels) {
    this.labels = labels;
  }

  public PutCharactersCharacterIdMailMailIdContents read(Boolean read) {
    this.read = read;
    return this;
  }

   /**
   * Whether the mail is flagged as read
   * @return read
  **/
  @ApiModelProperty(value = "Whether the mail is flagged as read")
  public Boolean isRead() {
    return read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutCharactersCharacterIdMailMailIdContents putCharactersCharacterIdMailMailIdContents = (PutCharactersCharacterIdMailMailIdContents) o;
    return Objects.equals(this.labels, putCharactersCharacterIdMailMailIdContents.labels) &&
        Objects.equals(this.read, putCharactersCharacterIdMailMailIdContents.read);
  }

  @Override
  public int hashCode() {
    return Objects.hash(labels, read);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutCharactersCharacterIdMailMailIdContents {\n");
    
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    read: ").append(toIndentedString(read)).append("\n");
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

