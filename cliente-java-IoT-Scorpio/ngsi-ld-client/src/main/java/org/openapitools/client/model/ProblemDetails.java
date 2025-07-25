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
import java.net.URI;
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
 * The definition of the general \&quot;ProblemDetails\&quot; data structure from IETF RFC 7807 is reproduced inthis structure. Compared to the general framework defined in IETF RFC 7807, the \&quot;status\&quot; and \&quot;detail\&quot; attributes are mandated to be included by the present document, to ensure that the response contains additional textual information about an error. IETF RFC 7807 foresees extensibility of the \&quot;ProblemDetails\&quot; type. It is possible that particular APIs in the present document, or particular implementations, define extensions to define additional attributes that provide more information about the error. The description column only provides some explanation of the meaning to Facilitate understanding of the design. For a full description, see IETF RFC 7807. 
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-28T12:11:22.919984907Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class ProblemDetails {
  public static final String SERIALIZED_NAME_TYPE = "type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  @javax.annotation.Nullable
  private URI type;

  public static final String SERIALIZED_NAME_TITLE = "title";
  @SerializedName(SERIALIZED_NAME_TITLE)
  @javax.annotation.Nullable
  private String title;

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  @javax.annotation.Nonnull
  private Integer status;

  public static final String SERIALIZED_NAME_DETAIL = "detail";
  @SerializedName(SERIALIZED_NAME_DETAIL)
  @javax.annotation.Nonnull
  private String detail;

  public static final String SERIALIZED_NAME_INSTANCE = "instance";
  @SerializedName(SERIALIZED_NAME_INSTANCE)
  @javax.annotation.Nullable
  private URI instance;

  public ProblemDetails() {
  }

  public ProblemDetails type(@javax.annotation.Nullable URI type) {
    this.type = type;
    return this;
  }

  /**
   * A URI reference according to IETF RFC 3986 that identifies the problem type. It is encouraged that the URI provides human-readable documentation for the problem (e.g. using HTML) when dereferenced. When this member is not present, its value is assumed to be \&quot;about:blank\&quot;. 
   * @return type
   */
  @javax.annotation.Nullable
  public URI getType() {
    return type;
  }

  public void setType(@javax.annotation.Nullable URI type) {
    this.type = type;
  }


  public ProblemDetails title(@javax.annotation.Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * A short, human-readable summary of the problem type. It should not change from occurrence to occurrence of the problem, except for purposes of localization. If type is given and other than \&quot;about:blank\&quot;, this attribute shall also be provided. A short, human-readable summary of the problem type.  It SHOULD NOT change from occurrence to occurrence of the problem, except for purposes of localization (e.g., using proactive content negotiation; see [RFC7231], Section 3.4). 
   * @return title
   */
  @javax.annotation.Nullable
  public String getTitle() {
    return title;
  }

  public void setTitle(@javax.annotation.Nullable String title) {
    this.title = title;
  }


  public ProblemDetails status(@javax.annotation.Nonnull Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP status code for this occurrence of the problem. The HTTP status code ([RFC7231], Section 6) generated by the origin server for this occurrence of the problem. 
   * @return status
   */
  @javax.annotation.Nonnull
  public Integer getStatus() {
    return status;
  }

  public void setStatus(@javax.annotation.Nonnull Integer status) {
    this.status = status;
  }


  public ProblemDetails detail(@javax.annotation.Nonnull String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human-readable explanation specific to this occurrence of the problem.  *InvalidRequest: The request associated to the operation is  syntactically invalid or includes wrong content. If an HTTP request  for an operation contains parameters that are incompatible with the  operation, or it contains values of the \&quot;options\&quot; parameter that are  not supported by the operation, an HTTP error response of type  InvalidRequest should be returned.   
   * @return detail
   */
  @javax.annotation.Nonnull
  public String getDetail() {
    return detail;
  }

  public void setDetail(@javax.annotation.Nonnull String detail) {
    this.detail = detail;
  }


  public ProblemDetails instance(@javax.annotation.Nullable URI instance) {
    this.instance = instance;
    return this;
  }

  /**
   * A URI reference that identifies the specific occurrence of the problem. It may yield further information if dereferenced. 
   * @return instance
   */
  @javax.annotation.Nullable
  public URI getInstance() {
    return instance;
  }

  public void setInstance(@javax.annotation.Nullable URI instance) {
    this.instance = instance;
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
   * @return the ProblemDetails instance itself
   */
  public ProblemDetails putAdditionalProperty(String key, Object value) {
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
    ProblemDetails problemDetails = (ProblemDetails) o;
    return Objects.equals(this.type, problemDetails.type) &&
        Objects.equals(this.title, problemDetails.title) &&
        Objects.equals(this.status, problemDetails.status) &&
        Objects.equals(this.detail, problemDetails.detail) &&
        Objects.equals(this.instance, problemDetails.instance)&&
        Objects.equals(this.additionalProperties, problemDetails.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, title, status, detail, instance, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemDetails {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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
    openapiFields.add("type");
    openapiFields.add("title");
    openapiFields.add("status");
    openapiFields.add("detail");
    openapiFields.add("instance");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("status");
    openapiRequiredFields.add("detail");
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to ProblemDetails
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ProblemDetails.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProblemDetails is not found in the empty JSON string", ProblemDetails.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProblemDetails.openapiRequiredFields) {
        if (jsonElement.getAsJsonObject().get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
      }
      if ((jsonObj.get("title") != null && !jsonObj.get("title").isJsonNull()) && !jsonObj.get("title").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
      }
      if (!jsonObj.get("detail").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `detail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("detail").toString()));
      }
      if ((jsonObj.get("instance") != null && !jsonObj.get("instance").isJsonNull()) && !jsonObj.get("instance").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `instance` to be a primitive type in the JSON string but got `%s`", jsonObj.get("instance").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProblemDetails.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProblemDetails' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProblemDetails> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProblemDetails.class));

       return (TypeAdapter<T>) new TypeAdapter<ProblemDetails>() {
           @Override
           public void write(JsonWriter out, ProblemDetails value) throws IOException {
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
           public ProblemDetails read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             JsonObject jsonObj = jsonElement.getAsJsonObject();
             // store additional fields in the deserialized instance
             ProblemDetails instance = thisAdapter.fromJsonTree(jsonObj);
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
   * Create an instance of ProblemDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ProblemDetails
   * @throws IOException if the JSON string is invalid with respect to ProblemDetails
   */
  public static ProblemDetails fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProblemDetails.class);
  }

  /**
   * Convert an instance of ProblemDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

