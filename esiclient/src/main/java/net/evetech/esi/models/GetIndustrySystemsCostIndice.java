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
 * cost_indice object
 */
@ApiModel(description = "cost_indice object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T20:58:31.116-04:00")
public class GetIndustrySystemsCostIndice {
  /**
   * activity string
   */
  @JsonAdapter(ActivityEnum.Adapter.class)
  public enum ActivityEnum {
    COPYING("copying"),
    
    DUPLICATING("duplicating"),
    
    INVENTION("invention"),
    
    MANUFACTURING("manufacturing"),
    
    NONE("none"),
    
    REACTION("reaction"),
    
    RESEARCHING_MATERIAL_EFFICIENCY("researching_material_efficiency"),
    
    RESEARCHING_TECHNOLOGY("researching_technology"),
    
    RESEARCHING_TIME_EFFICIENCY("researching_time_efficiency"),
    
    REVERSE_ENGINEERING("reverse_engineering");

    private String value;

    ActivityEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ActivityEnum fromValue(String text) {
      for (ActivityEnum b : ActivityEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ActivityEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ActivityEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ActivityEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ActivityEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("activity")
  private ActivityEnum activity = null;

  @SerializedName("cost_index")
  private Float costIndex = null;

  public GetIndustrySystemsCostIndice activity(ActivityEnum activity) {
    this.activity = activity;
    return this;
  }

   /**
   * activity string
   * @return activity
  **/
  @ApiModelProperty(required = true, value = "activity string")
  public ActivityEnum getActivity() {
    return activity;
  }

  public void setActivity(ActivityEnum activity) {
    this.activity = activity;
  }

  public GetIndustrySystemsCostIndice costIndex(Float costIndex) {
    this.costIndex = costIndex;
    return this;
  }

   /**
   * cost_index number
   * @return costIndex
  **/
  @ApiModelProperty(required = true, value = "cost_index number")
  public Float getCostIndex() {
    return costIndex;
  }

  public void setCostIndex(Float costIndex) {
    this.costIndex = costIndex;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetIndustrySystemsCostIndice getIndustrySystemsCostIndice = (GetIndustrySystemsCostIndice) o;
    return Objects.equals(this.activity, getIndustrySystemsCostIndice.activity) &&
        Objects.equals(this.costIndex, getIndustrySystemsCostIndice.costIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activity, costIndex);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetIndustrySystemsCostIndice {\n");
    
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    costIndex: ").append(toIndentedString(costIndex)).append("\n");
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

