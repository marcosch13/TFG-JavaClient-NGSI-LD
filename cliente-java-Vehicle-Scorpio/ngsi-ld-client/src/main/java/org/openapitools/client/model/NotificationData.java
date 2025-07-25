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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.Entity;
import org.openapitools.client.model.Feature;
import org.openapitools.client.model.FeatureCollection;
import org.openapitools.client.model.LdContext;



import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;

import org.openapitools.client.JSON;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-04-25T11:21:26.751408096Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class NotificationData extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(NotificationData.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!NotificationData.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'NotificationData' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

            final Type typeInstanceListEntity = new TypeToken<List<Entity>>(){}.getType();
            final TypeAdapter<List<Entity>> adapterListEntity = (TypeAdapter<List<Entity>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListEntity));
            final TypeAdapter<FeatureCollection> adapterFeatureCollection = gson.getDelegateAdapter(this, TypeToken.get(FeatureCollection.class));

            return (TypeAdapter<T>) new TypeAdapter<NotificationData>() {
                @Override
                public void write(JsonWriter out, NotificationData value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `List<Entity>`
                    if (value.getActualInstance() instanceof List<?>) {
                        List<?> list = (List<?>) value.getActualInstance();
                        if (list.get(0) instanceof Entity) {
                            JsonArray array = adapterListEntity.toJsonTree((List<Entity>)value.getActualInstance()).getAsJsonArray();
                            elementAdapter.write(out, array);
                            return;
                        }
                    }
                    // check if the actual instance is of the type `FeatureCollection`
                    if (value.getActualInstance() instanceof FeatureCollection) {
                        JsonElement element = adapterFeatureCollection.toJsonTree((FeatureCollection)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: FeatureCollection, List<Entity>");
                }

                @Override
                public NotificationData read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize List<Entity>
                    try {
                        // validate the JSON object to see if any exception is thrown
                        if (!jsonElement.isJsonArray()) {
                            throw new IllegalArgumentException(String.format("Expected json element to be a array type in the JSON string but got `%s`", jsonElement.toString()));
                        }

                        JsonArray array = jsonElement.getAsJsonArray();
                        // validate array items
                        for(JsonElement element : array) {
                            Entity.validateJsonElement(element);
                        }
                        actualAdapter = adapterListEntity;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'List<Entity>'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for List<Entity> failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'List<Entity>'", e);
                    }
                    // deserialize FeatureCollection
                    try {
                        // validate the JSON object to see if any exception is thrown
                        FeatureCollection.validateJsonElement(jsonElement);
                        actualAdapter = adapterFeatureCollection;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'FeatureCollection'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for FeatureCollection failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'FeatureCollection'", e);
                    }

                    if (match == 1) {
                        NotificationData ret = new NotificationData();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for NotificationData: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public NotificationData() {
        super("oneOf", Boolean.FALSE);
    }

    public NotificationData(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("List<Entity>", List.class);
        schemas.put("FeatureCollection", FeatureCollection.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return NotificationData.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * FeatureCollection, List<Entity>
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof List<?>) {
            List<?> list = (List<?>) instance;
            if (list.get(0) instanceof Entity) {
                super.setActualInstance(instance);
                return;
            }
        }

        if (instance instanceof FeatureCollection) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be FeatureCollection, List<Entity>");
    }

    /**
     * Get the actual instance, which can be the following:
     * FeatureCollection, List<Entity>
     *
     * @return The actual instance (FeatureCollection, List<Entity>)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<Entity>`. If the actual instance is not `List<Entity>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<Entity>`
     * @throws ClassCastException if the instance is not `List<Entity>`
     */
    public List<Entity> getListEntity() throws ClassCastException {
        return (List<Entity>)super.getActualInstance();
    }

    /**
     * Get the actual instance of `FeatureCollection`. If the actual instance is not `FeatureCollection`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `FeatureCollection`
     * @throws ClassCastException if the instance is not `FeatureCollection`
     */
    public FeatureCollection getFeatureCollection() throws ClassCastException {
        return (FeatureCollection)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to NotificationData
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with List<Entity>
        try {
            if (!jsonElement.isJsonArray()) {
                throw new IllegalArgumentException(String.format("Expected json element to be a array type in the JSON string but got `%s`", jsonElement.toString()));
            }
            JsonArray array = jsonElement.getAsJsonArray();
            // validate array items
            for(JsonElement element : array) {
                Entity.validateJsonElement(element);
            }
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for List<Entity> failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with FeatureCollection
        try {
            FeatureCollection.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for FeatureCollection failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for NotificationData with oneOf schemas: FeatureCollection, List<Entity>. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of NotificationData given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of NotificationData
     * @throws IOException if the JSON string is invalid with respect to NotificationData
     */
    public static NotificationData fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, NotificationData.class);
    }

    /**
     * Convert an instance of NotificationData to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

