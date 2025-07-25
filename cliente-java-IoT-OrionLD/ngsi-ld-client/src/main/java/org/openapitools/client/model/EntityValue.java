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
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.GeoProperty;
import org.openapitools.client.model.Geometry;
import org.openapitools.client.model.LanguageProperty;
import org.openapitools.client.model.Property;
import org.openapitools.client.model.Relationship;
import org.openapitools.client.model.VocabularyProperty;
import org.openapitools.client.model.VocabularyPropertyPreviousVocab;
import org.openapitools.client.model.VocabularyPropertyVocab;



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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-03-28T12:11:22.919984907Z[Etc/UTC]", comments = "Generator version: 7.13.0-SNAPSHOT")
public class EntityValue extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(EntityValue.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!EntityValue.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'EntityValue' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<Property> adapterProperty = gson.getDelegateAdapter(this, TypeToken.get(Property.class));

            final Type typeInstanceListProperty = new TypeToken<List<Property>>(){}.getType();
            final TypeAdapter<List<Property>> adapterListProperty = (TypeAdapter<List<Property>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListProperty));
            final TypeAdapter<Relationship> adapterRelationship = gson.getDelegateAdapter(this, TypeToken.get(Relationship.class));

            final Type typeInstanceListRelationship = new TypeToken<List<Relationship>>(){}.getType();
            final TypeAdapter<List<Relationship>> adapterListRelationship = (TypeAdapter<List<Relationship>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListRelationship));
            final TypeAdapter<GeoProperty> adapterGeoProperty = gson.getDelegateAdapter(this, TypeToken.get(GeoProperty.class));

            final Type typeInstanceListGeoProperty = new TypeToken<List<GeoProperty>>(){}.getType();
            final TypeAdapter<List<GeoProperty>> adapterListGeoProperty = (TypeAdapter<List<GeoProperty>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListGeoProperty));
            final TypeAdapter<LanguageProperty> adapterLanguageProperty = gson.getDelegateAdapter(this, TypeToken.get(LanguageProperty.class));

            final Type typeInstanceListLanguageProperty = new TypeToken<List<LanguageProperty>>(){}.getType();
            final TypeAdapter<List<LanguageProperty>> adapterListLanguageProperty = (TypeAdapter<List<LanguageProperty>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListLanguageProperty));
            final TypeAdapter<VocabularyProperty> adapterVocabularyProperty = gson.getDelegateAdapter(this, TypeToken.get(VocabularyProperty.class));

            final Type typeInstanceListVocabularyProperty = new TypeToken<List<VocabularyProperty>>(){}.getType();
            final TypeAdapter<List<VocabularyProperty>> adapterListVocabularyProperty = (TypeAdapter<List<VocabularyProperty>>) gson.getDelegateAdapter(this, TypeToken.get(typeInstanceListVocabularyProperty));

            return (TypeAdapter<T>) new TypeAdapter<EntityValue>() {
                @Override
                public void write(JsonWriter out, EntityValue value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `Property`
                    if (value.getActualInstance() instanceof Property) {
                        JsonElement element = adapterProperty.toJsonTree((Property)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `List<Property>`
                    if (value.getActualInstance() instanceof List<?>) {
                        List<?> list = (List<?>) value.getActualInstance();
                        if (list.get(0) instanceof Property) {
                            JsonArray array = adapterListProperty.toJsonTree((List<Property>)value.getActualInstance()).getAsJsonArray();
                            elementAdapter.write(out, array);
                            return;
                        }
                    }
                    // check if the actual instance is of the type `Relationship`
                    if (value.getActualInstance() instanceof Relationship) {
                        JsonElement element = adapterRelationship.toJsonTree((Relationship)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `GeoProperty`
                    if (value.getActualInstance() instanceof GeoProperty) {
                        JsonElement element = adapterGeoProperty.toJsonTree((GeoProperty)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `LanguageProperty`
                    if (value.getActualInstance() instanceof LanguageProperty) {
                        JsonElement element = adapterLanguageProperty.toJsonTree((LanguageProperty)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `VocabularyProperty`
                    if (value.getActualInstance() instanceof VocabularyProperty) {
                        JsonElement element = adapterVocabularyProperty.toJsonTree((VocabularyProperty)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty");
                }

                @Override
                public EntityValue read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize Property
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Property.validateJsonElement(jsonElement);
                        actualAdapter = adapterProperty;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'Property'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Property failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'Property'", e);
                    }
                    // deserialize List<Property>
                    try {
                        // validate the JSON object to see if any exception is thrown
                        if (!jsonElement.isJsonArray()) {
                            throw new IllegalArgumentException(String.format("Expected json element to be a array type in the JSON string but got `%s`", jsonElement.toString()));
                        }

                        JsonArray array = jsonElement.getAsJsonArray();
                        // validate array items
                        for(JsonElement element : array) {
                            Property.validateJsonElement(element);
                        }
                        actualAdapter = adapterListProperty;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'List<Property>'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for List<Property> failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'List<Property>'", e);
                    }
                    // deserialize Relationship
                    try {
                        // validate the JSON object to see if any exception is thrown
                        Relationship.validateJsonElement(jsonElement);
                        actualAdapter = adapterRelationship;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'Relationship'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for Relationship failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'Relationship'", e);
                    }
                    // deserialize GeoProperty
                    try {
                        // validate the JSON object to see if any exception is thrown
                        GeoProperty.validateJsonElement(jsonElement);
                        actualAdapter = adapterGeoProperty;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'GeoProperty'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for GeoProperty failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'GeoProperty'", e);
                    }
                    // deserialize LanguageProperty
                    try {
                        // validate the JSON object to see if any exception is thrown
                        LanguageProperty.validateJsonElement(jsonElement);
                        actualAdapter = adapterLanguageProperty;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'LanguageProperty'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for LanguageProperty failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'LanguageProperty'", e);
                    }
                    // deserialize VocabularyProperty
                    try {
                        // validate the JSON object to see if any exception is thrown
                        VocabularyProperty.validateJsonElement(jsonElement);
                        actualAdapter = adapterVocabularyProperty;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'VocabularyProperty'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for VocabularyProperty failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'VocabularyProperty'", e);
                    }

                    if (match == 1) {
                        EntityValue ret = new EntityValue();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for EntityValue: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public EntityValue() {
        super("oneOf", Boolean.FALSE);
    }

    public EntityValue(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Property", Property.class);
        schemas.put("List<Property>", List.class);
        schemas.put("Relationship", Relationship.class);
        schemas.put("GeoProperty", GeoProperty.class);
        schemas.put("LanguageProperty", LanguageProperty.class);
        schemas.put("VocabularyProperty", VocabularyProperty.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return EntityValue.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof Property) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof List<?>) {
            List<?> list = (List<?>) instance;
            if (list.get(0) instanceof Property) {
                super.setActualInstance(instance);
                return;
            }
        }

        if (instance instanceof Relationship) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof GeoProperty) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof LanguageProperty) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof VocabularyProperty) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty");
    }

    /**
     * Get the actual instance, which can be the following:
     * GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty
     *
     * @return The actual instance (GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `Property`. If the actual instance is not `Property`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Property`
     * @throws ClassCastException if the instance is not `Property`
     */
    public Property getProperty() throws ClassCastException {
        return (Property)super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<Property>`. If the actual instance is not `List<Property>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<Property>`
     * @throws ClassCastException if the instance is not `List<Property>`
     */
    public List<Property> getListProperty() throws ClassCastException {
        return (List<Property>)super.getActualInstance();
    }

    /**
     * Get the actual instance of `Relationship`. If the actual instance is not `Relationship`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `Relationship`
     * @throws ClassCastException if the instance is not `Relationship`
     */
    public Relationship getRelationship() throws ClassCastException {
        return (Relationship)super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<Relationship>`. If the actual instance is not `List<Relationship>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<Relationship>`
     * @throws ClassCastException if the instance is not `List<Relationship>`
     */
    public List<Relationship> getListRelationship() throws ClassCastException {
        return (List<Relationship>)super.getActualInstance();
    }

    /**
     * Get the actual instance of `GeoProperty`. If the actual instance is not `GeoProperty`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `GeoProperty`
     * @throws ClassCastException if the instance is not `GeoProperty`
     */
    public GeoProperty getGeoProperty() throws ClassCastException {
        return (GeoProperty)super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<GeoProperty>`. If the actual instance is not `List<GeoProperty>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<GeoProperty>`
     * @throws ClassCastException if the instance is not `List<GeoProperty>`
     */
    public List<GeoProperty> getListGeoProperty() throws ClassCastException {
        return (List<GeoProperty>)super.getActualInstance();
    }

    /**
     * Get the actual instance of `LanguageProperty`. If the actual instance is not `LanguageProperty`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `LanguageProperty`
     * @throws ClassCastException if the instance is not `LanguageProperty`
     */
    public LanguageProperty getLanguageProperty() throws ClassCastException {
        return (LanguageProperty)super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<LanguageProperty>`. If the actual instance is not `List<LanguageProperty>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<LanguageProperty>`
     * @throws ClassCastException if the instance is not `List<LanguageProperty>`
     */
    public List<LanguageProperty> getListLanguageProperty() throws ClassCastException {
        return (List<LanguageProperty>)super.getActualInstance();
    }

    /**
     * Get the actual instance of `VocabularyProperty`. If the actual instance is not `VocabularyProperty`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `VocabularyProperty`
     * @throws ClassCastException if the instance is not `VocabularyProperty`
     */
    public VocabularyProperty getVocabularyProperty() throws ClassCastException {
        return (VocabularyProperty)super.getActualInstance();
    }

    /**
     * Get the actual instance of `List<VocabularyProperty>`. If the actual instance is not `List<VocabularyProperty>`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `List<VocabularyProperty>`
     * @throws ClassCastException if the instance is not `List<VocabularyProperty>`
     */
    public List<VocabularyProperty> getListVocabularyProperty() throws ClassCastException {
        return (List<VocabularyProperty>)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to EntityValue
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with Property
        try {
            Property.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for Property failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with List<Property>
        try {
            if (!jsonElement.isJsonArray()) {
                throw new IllegalArgumentException(String.format("Expected json element to be a array type in the JSON string but got `%s`", jsonElement.toString()));
            }
            JsonArray array = jsonElement.getAsJsonArray();
            // validate array items
            for(JsonElement element : array) {
                Property.validateJsonElement(element);
            }
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for List<Property> failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with Relationship
        try {
            Relationship.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for Relationship failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with GeoProperty
        try {
            GeoProperty.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for GeoProperty failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with LanguageProperty
        try {
            LanguageProperty.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for LanguageProperty failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with VocabularyProperty
        try {
            VocabularyProperty.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for VocabularyProperty failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for EntityValue with oneOf schemas: GeoProperty, LanguageProperty, List<GeoProperty>, List<LanguageProperty>, List<Property>, List<Relationship>, List<VocabularyProperty>, Property, Relationship, VocabularyProperty. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of EntityValue given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of EntityValue
     * @throws IOException if the JSON string is invalid with respect to EntityValue
     */
    public static EntityValue fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, EntityValue.class);
    }

    /**
     * Convert an instance of EntityValue to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

