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
 * Forbidden model
 */
@ApiModel(description = "Forbidden model")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class Forbidden {
  @SerializedName("error")
  private String error = null;

  @SerializedName("sso_status")
  private Integer ssoStatus = null;

  public Forbidden error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Forbidden message
   * @return error
  **/
  @ApiModelProperty(required = true, value = "Forbidden message")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public Forbidden ssoStatus(Integer ssoStatus) {
    this.ssoStatus = ssoStatus;
    return this;
  }

   /**
   * status code received from SSO
   * @return ssoStatus
  **/
  @ApiModelProperty(value = "status code received from SSO")
  public Integer getSsoStatus() {
    return ssoStatus;
  }

  public void setSsoStatus(Integer ssoStatus) {
    this.ssoStatus = ssoStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Forbidden forbidden = (Forbidden) o;
    return Objects.equals(this.error, forbidden.error) &&
        Objects.equals(this.ssoStatus, forbidden.ssoStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, ssoStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Forbidden {\n");
    
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    ssoStatus: ").append(toIndentedString(ssoStatus)).append("\n");
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

