/*
 * NGSI-LD OAS
 * OpenAPI Specification for NGSI-LD API.
 *
 * The version of the OpenAPI document: 1.7.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * 5.2.21 This datatype represents a temporal query. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-28T12:11:22.919984907Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class TemporalQuery {
  /**
   * Allowed values: \&quot;before\&quot;, \&quot;after\&quot; and \&quot;between\&quot;. 
   */
  @JsonAdapter(TimerelEnum.Adapter.class)
  public enum TimerelEnum {
    BEFORE("before"),
    
    AFTER("after"),
    
    BETWEEN("between");

    private String value;

    TimerelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TimerelEnum fromValue(String value) {
      for (TimerelEnum b : TimerelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TimerelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TimerelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TimerelEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TimerelEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TimerelEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TIMEREL = "timerel";
  @SerializedName(SERIALIZED_NAME_TIMEREL)
  @javax.annotation.Nonnull
  private TimerelEnum timerel;

  public static final String SERIALIZED_NAME_TIME_AT = "timeAt";
  @SerializedName(SERIALIZED_NAME_TIME_AT)
  @javax.annotation.Nonnull
  private OffsetDateTime timeAt;

  public static final String SERIALIZED_NAME_END_TIME_AT = "endTimeAt";
  @SerializedName(SERIALIZED_NAME_END_TIME_AT)
  @javax.annotation.Nullable
  private OffsetDateTime endTimeAt;

  /**
   * Allowed values: \&quot;observedAt\&quot;, \&quot;createdAt\&quot;, \&quot;modifiedAt\&quot; and \&quot;deletedAt\&quot;. If not specified, the default is \&quot;observedAt\&quot;. (See clause 4.8). 
   */
  @JsonAdapter(TimepropertyEnum.Adapter.class)
  public enum TimepropertyEnum {
    OBSERVED_AT("observedAt"),
    
    CREATED_AT("createdAt"),
    
    MODIFIED_AT("modifiedAt"),
    
    DELETED_AT("deletedAt");

    private String value;

    TimepropertyEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TimepropertyEnum fromValue(String value) {
      for (TimepropertyEnum b : TimepropertyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TimepropertyEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TimepropertyEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TimepropertyEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return TimepropertyEnum.fromValue(value);
      }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      String value = jsonElement.getAsString();
      TimepropertyEnum.fromValue(value);
    }
  }

  public static final String SERIALIZED_NAME_TIMEPROPERTY = "timeproperty";
  @SerializedName(SERIALIZED_NAME_TIMEPROPERTY)
  @javax.annotation.Nullable
  private TimepropertyEnum timeproperty = TimepropertyEnum.OBSERVED_AT;

  public TemporalQuery() {
  }

  public TemporalQuery timerel(@javax.annotation.Nonnull TimerelEnum timerel) {
    this.timerel = timerel;
    return this;
  }

  /**
   * Allowed values: \&quot;before\&quot;, \&quot;after\&quot; and \&quot;between\&quot;. 
   * @return timerel
   */
  @javax.annotation.Nonnull
  public TimerelEnum getTimerel() {
    return timerel;
  }

  public void setTimerel(@javax.annotation.Nonnull TimerelEnum timerel) {
    this.timerel = timerel;
  }


  public TemporalQuery timeAt(@javax.annotation.Nonnull OffsetDateTime timeAt) {
    this.timeAt = timeAt;
    return this;
  }

  /**
   * It shall be a DateTime. 
   * @return timeAt
   */
  @javax.annotation.Nonnull
  public OffsetDateTime getTimeAt() {
    return timeAt;
  }

  public void setTimeAt(@javax.annotation.Nonnull OffsetDateTime timeAt) {
    this.timeAt = timeAt;
  }


  public TemporalQuery endTimeAt(@javax.annotation.Nullable OffsetDateTime endTimeAt) {
    this.endTimeAt = endTimeAt;
    return this;
  }

  /**
   * It shall be a DateTime. Cardinality shall be 1 if timerel is equal to \&quot;between\&quot;. 
   * @return endTimeAt
   */
  @javax.annotation.Nullable
  public OffsetDateTime getEndTimeAt() {
    return endTimeAt;
  }

  public void setEndTimeAt(@javax.annotation.Nullable OffsetDateTime endTimeAt) {
    this.endTimeAt = endTimeAt;
  }


  public TemporalQuery timeproperty(@javax.annotation.Nullable TimepropertyEnum timeproperty) {
    this.timeproperty = timeproperty;
    return this;
  }

  /**
   * Allowed values: \&quot;observedAt\&quot;, \&quot;createdAt\&quot;, \&quot;modifiedAt\&quot; and \&quot;deletedAt\&quot;. If not specified, the default is \&quot;observedAt\&quot;. (See clause 4.8). 
   * @return timeproperty
   */
  @javax.annotation.Nullable
  public TimepropertyEnum getTimeproperty() {
    return timeproperty;
  }

  public void setTimeproperty(@javax.annotation.Nullable TimepropertyEnum timeproperty) {
    this.timeproperty = timeproperty;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the TemporalQuery instance itself
   */
  public TemporalQuery putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemporalQuery temporalQuery = (TemporalQuery) o;
    return Objects.equals(this.timerel, temporalQuery.timerel) &&
        Objects.equals(this.timeAt, temporalQuery.timeAt) &&
        Objects.equals(this.endTimeAt, temporalQuery.endTimeAt) &&
        Objects.equals(this.timeproperty, temporalQuery.timeproperty)&&
        Objects.equals(this.additionalProperties, temporalQuery.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timerel, timeAt, endTimeAt, timeproperty, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemporalQuery {\n");
    sb.append("    timerel: ").append(toIndentedString(timerel)).append("\n");
    sb.append("    timeAt: ").append(toIndentedString(timeAt)).append("\n");
    sb.append("    endTimeAt: ").append(toIndentedString(endTimeAt)).append("\n");
    sb.append("    timeproperty: ").append(toIndentedString(timeproperty)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("timerel");
    openapiFields.add("timeAt");
    openapiFields.add("endTimeAt");
    openapiFields.add("timeproperty");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("timerel");
    openapiRequiredFields.add("timeAt");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to TemporalQuery
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!TemporalQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TemporalQuery is not found in the empty JSON string", TemporalQuery.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : TemporalQuery.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (!jsonObj.get("timerel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `timerel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("timerel").toString()));
      }
      // validate the required field `timerel`
      TimerelEnum.validateJsonElement(jsonObj.get("timerel"));
      if ((jsonObj.get("timeproperty") != null && !jsonObj.get("timeproperty").isJsonNull()) && !jsonObj.get("timeproperty").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `timeproperty` to be a primitive type in the JSON string but got `%s`", jsonObj.get("timeproperty").toString()));
      }
      // validate the optional field `timeproperty`
      if (jsonObj.get("timeproperty") != null && !jsonObj.get("timeproperty").isJsonNull()) {
        TimepropertyEnum.validateJsonElement(jsonObj.get("timeproperty"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TemporalQuery.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TemporalQuery' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TemporalQuery> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TemporalQuery.class));

       return (TypeAdapter<T>) new TypeAdapter<TemporalQuery>() {
           @Override
           public void write(JsonWriter out, TemporalQuery value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additional properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   JsonElement jsonElement = gson.toJsonTree(entry.getValue());
                   if (jsonElement.isJsonArray()) {
                     obj.add(entry.getKey(), jsonElement.getAsJsonArray());
                   } else {
                     obj.add(entry.getKey(), jsonElement.getAsJsonObject());
                   }
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public TemporalQuery read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             JsonObject jsonObj = jsonElement.getAsJsonObject();
             // store additional fields in the deserialized instance
             TemporalQuery instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of TemporalQuery given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TemporalQuery
   * @throws IOException if the JSON string is invalid with respect to TemporalQuery
   */
  public static TemporalQuery fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TemporalQuery.class);
  }

  /**
   * Convert an instance of TemporalQuery to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

