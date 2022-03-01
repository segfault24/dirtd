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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-02-28T09:30:14.131-05:00")
public class GetCorporationsCorporationIdContacts200Ok {
  @SerializedName("contact_id")
  private Integer contactId = null;

  /**
   * contact_type string
   */
  @JsonAdapter(ContactTypeEnum.Adapter.class)
  public enum ContactTypeEnum {
    CHARACTER("character"),
    
    CORPORATION("corporation"),
    
    ALLIANCE("alliance"),
    
    FACTION("faction");

    private String value;

    ContactTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ContactTypeEnum fromValue(String text) {
      for (ContactTypeEnum b : ContactTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ContactTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ContactTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ContactTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ContactTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("contact_type")
  private ContactTypeEnum contactType = null;

  @SerializedName("is_watched")
  private Boolean isWatched = null;

  @SerializedName("label_ids")
  private List<Long> labelIds = null;

  @SerializedName("standing")
  private Float standing = null;

  public GetCorporationsCorporationIdContacts200Ok contactId(Integer contactId) {
    this.contactId = contactId;
    return this;
  }

   /**
   * contact_id integer
   * @return contactId
  **/
  @ApiModelProperty(required = true, value = "contact_id integer")
  public Integer getContactId() {
    return contactId;
  }

  public void setContactId(Integer contactId) {
    this.contactId = contactId;
  }

  public GetCorporationsCorporationIdContacts200Ok contactType(ContactTypeEnum contactType) {
    this.contactType = contactType;
    return this;
  }

   /**
   * contact_type string
   * @return contactType
  **/
  @ApiModelProperty(required = true, value = "contact_type string")
  public ContactTypeEnum getContactType() {
    return contactType;
  }

  public void setContactType(ContactTypeEnum contactType) {
    this.contactType = contactType;
  }

  public GetCorporationsCorporationIdContacts200Ok isWatched(Boolean isWatched) {
    this.isWatched = isWatched;
    return this;
  }

   /**
   * Whether this contact is being watched
   * @return isWatched
  **/
  @ApiModelProperty(value = "Whether this contact is being watched")
  public Boolean isIsWatched() {
    return isWatched;
  }

  public void setIsWatched(Boolean isWatched) {
    this.isWatched = isWatched;
  }

  public GetCorporationsCorporationIdContacts200Ok labelIds(List<Long> labelIds) {
    this.labelIds = labelIds;
    return this;
  }

  public GetCorporationsCorporationIdContacts200Ok addLabelIdsItem(Long labelIdsItem) {
    if (this.labelIds == null) {
      this.labelIds = new ArrayList<Long>();
    }
    this.labelIds.add(labelIdsItem);
    return this;
  }

   /**
   * label_ids array
   * @return labelIds
  **/
  @ApiModelProperty(value = "label_ids array")
  public List<Long> getLabelIds() {
    return labelIds;
  }

  public void setLabelIds(List<Long> labelIds) {
    this.labelIds = labelIds;
  }

  public GetCorporationsCorporationIdContacts200Ok standing(Float standing) {
    this.standing = standing;
    return this;
  }

   /**
   * Standing of the contact
   * @return standing
  **/
  @ApiModelProperty(required = true, value = "Standing of the contact")
  public Float getStanding() {
    return standing;
  }

  public void setStanding(Float standing) {
    this.standing = standing;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorporationsCorporationIdContacts200Ok getCorporationsCorporationIdContacts200Ok = (GetCorporationsCorporationIdContacts200Ok) o;
    return Objects.equals(this.contactId, getCorporationsCorporationIdContacts200Ok.contactId) &&
        Objects.equals(this.contactType, getCorporationsCorporationIdContacts200Ok.contactType) &&
        Objects.equals(this.isWatched, getCorporationsCorporationIdContacts200Ok.isWatched) &&
        Objects.equals(this.labelIds, getCorporationsCorporationIdContacts200Ok.labelIds) &&
        Objects.equals(this.standing, getCorporationsCorporationIdContacts200Ok.standing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, contactType, isWatched, labelIds, standing);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorporationsCorporationIdContacts200Ok {\n");
    
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    contactType: ").append(toIndentedString(contactType)).append("\n");
    sb.append("    isWatched: ").append(toIndentedString(isWatched)).append("\n");
    sb.append("    labelIds: ").append(toIndentedString(labelIds)).append("\n");
    sb.append("    standing: ").append(toIndentedString(standing)).append("\n");
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

