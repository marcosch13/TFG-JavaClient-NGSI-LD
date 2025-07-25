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
import java.math.BigDecimal;
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
 * 5.2.34 This type represents the data to alter the default behaviour of a Context Broker when making a distributed operation request to a registered Context Source. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-25T11:21:26.751408096Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class RegistrationManagementInfo {
  public static final String SERIALIZED_NAME_LOCAL_ONLY = "localOnly";
  @SerializedName(SERIALIZED_NAME_LOCAL_ONLY)
  @javax.annotation.Nullable
  private Boolean localOnly;

  public static final String SERIALIZED_NAME_CACHE_DURATION = "cacheDuration";
  @SerializedName(SERIALIZED_NAME_CACHE_DURATION)
  @javax.annotation.Nullable
  private String cacheDuration;

  public static final String SERIALIZED_NAME_TIMEOUT = "timeout";
  @SerializedName(SERIALIZED_NAME_TIMEOUT)
  @javax.annotation.Nullable
  private BigDecimal timeout;

  public static final String SERIALIZED_NAME_COOLDOWN = "cooldown";
  @SerializedName(SERIALIZED_NAME_COOLDOWN)
  @javax.annotation.Nullable
  private BigDecimal cooldown;

  public RegistrationManagementInfo() {
  }

  public RegistrationManagementInfo localOnly(@javax.annotation.Nullable Boolean localOnly) {
    this.localOnly = localOnly;
    return this;
  }

  /**
   * If localOnly&#x3D;true then distributed operations associated to this Context Source Registration will act only on data held directly by the registered Context Source itself (see clause 4.3.6.4). 
   * @return localOnly
   */
  @javax.annotation.Nullable
  public Boolean getLocalOnly() {
    return localOnly;
  }

  public void setLocalOnly(@javax.annotation.Nullable Boolean localOnly) {
    this.localOnly = localOnly;
  }


  public RegistrationManagementInfo cacheDuration(@javax.annotation.Nullable String cacheDuration) {
    this.cacheDuration = cacheDuration;
    return this;
  }

  /**
   * Minimal period of time which shall elapse between two consecutive context information consumption operations (as defined in clause 5.7) related to the same context data will occur. If the cacheDuration latency period has not been reached, a cached value for the entity or its attributes shall be returned where available. 
   * @return cacheDuration
   */
  @javax.annotation.Nullable
  public String getCacheDuration() {
    return cacheDuration;
  }

  public void setCacheDuration(@javax.annotation.Nullable String cacheDuration) {
    this.cacheDuration = cacheDuration;
  }


  public RegistrationManagementInfo timeout(@javax.annotation.Nullable BigDecimal timeout) {
    this.timeout = timeout;
    return this;
  }

  /**
   * Maximum period of time in milliseconds which may elapse before a forwarded request is assumed to have failed. 
   * minimum: 1
   * @return timeout
   */
  @javax.annotation.Nullable
  public BigDecimal getTimeout() {
    return timeout;
  }

  public void setTimeout(@javax.annotation.Nullable BigDecimal timeout) {
    this.timeout = timeout;
  }


  public RegistrationManagementInfo cooldown(@javax.annotation.Nullable BigDecimal cooldown) {
    this.cooldown = cooldown;
    return this;
  }

  /**
   * Minimum period of time in milliseconds which shall elapse before attempting to make a subsequent forwarded request to the same endpoint after failure. If requests are received before the cooldown period has expired, a timeout error response for the registration is automatically returned. 
   * minimum: 1
   * @return cooldown
   */
  @javax.annotation.Nullable
  public BigDecimal getCooldown() {
    return cooldown;
  }

  public void setCooldown(@javax.annotation.Nullable BigDecimal cooldown) {
    this.cooldown = cooldown;
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
   * @return the RegistrationManagementInfo instance itself
   */
  public RegistrationManagementInfo putAdditionalProperty(String key, Object value) {
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
    RegistrationManagementInfo registrationManagementInfo = (RegistrationManagementInfo) o;
    return Objects.equals(this.localOnly, registrationManagementInfo.localOnly) &&
        Objects.equals(this.cacheDuration, registrationManagementInfo.cacheDuration) &&
        Objects.equals(this.timeout, registrationManagementInfo.timeout) &&
        Objects.equals(this.cooldown, registrationManagementInfo.cooldown)&&
        Objects.equals(this.additionalProperties, registrationManagementInfo.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(localOnly, cacheDuration, timeout, cooldown, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistrationManagementInfo {\n");
    sb.append("    localOnly: ").append(toIndentedString(localOnly)).append("\n");
    sb.append("    cacheDuration: ").append(toIndentedString(cacheDuration)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    cooldown: ").append(toIndentedString(cooldown)).append("\n");
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
    openapiFields.add("localOnly");
    openapiFields.add("cacheDuration");
    openapiFields.add("timeout");
    openapiFields.add("cooldown");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to RegistrationManagementInfo
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RegistrationManagementInfo.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RegistrationManagementInfo is not found in the empty JSON string", RegistrationManagementInfo.openapiRequiredFields.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("cacheDuration") != null && !jsonObj.get("cacheDuration").isJsonNull()) && !jsonObj.get("cacheDuration").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `cacheDuration` to be a primitive type in the JSON string but got `%s`", jsonObj.get("cacheDuration").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RegistrationManagementInfo.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RegistrationManagementInfo' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RegistrationManagementInfo> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RegistrationManagementInfo.class));

       return (TypeAdapter<T>) new TypeAdapter<RegistrationManagementInfo>() {
           @Override
           public void write(JsonWriter out, RegistrationManagementInfo value) throws IOException {
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
           public RegistrationManagementInfo read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             JsonObject jsonObj = jsonElement.getAsJsonObject();
             // store additional fields in the deserialized instance
             RegistrationManagementInfo instance = thisAdapter.fromJsonTree(jsonObj);
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
   * Create an instance of RegistrationManagementInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RegistrationManagementInfo
   * @throws IOException if the JSON string is invalid with respect to RegistrationManagementInfo
   */
  public static RegistrationManagementInfo fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RegistrationManagementInfo.class);
  }

  /**
   * Convert an instance of RegistrationManagementInfo to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

