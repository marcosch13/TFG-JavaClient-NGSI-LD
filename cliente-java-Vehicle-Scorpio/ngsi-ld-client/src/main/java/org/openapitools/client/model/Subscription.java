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
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.EntitySelector;
import org.openapitools.client.model.GeoQuery;
import org.openapitools.client.model.NotificationParams;
import org.openapitools.client.model.SubscriptionOnChange;
import org.openapitools.client.model.SubscriptionPeriodic;
import org.openapitools.client.model.TemporalQuery;



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
public class Subscription extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Subscription.class.getName());

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!Subscription.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'Subscription' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<SubscriptionOnChange> adapterSubscriptionOnChange = gson.getDelegateAdapter(this, TypeToken.get(SubscriptionOnChange.class));
            final TypeAdapter<SubscriptionPeriodic> adapterSubscriptionPeriodic = gson.getDelegateAdapter(this, TypeToken.get(SubscriptionPeriodic.class));

            return (TypeAdapter<T>) new TypeAdapter<Subscription>() {
                @Override
                public void write(JsonWriter out, Subscription value) throws IOException {
                    if (value == null || value.getActualInstance() == null) {
                        elementAdapter.write(out, null);
                        return;
                    }

                    // check if the actual instance is of the type `SubscriptionOnChange`
                    if (value.getActualInstance() instanceof SubscriptionOnChange) {
                        JsonElement element = adapterSubscriptionOnChange.toJsonTree((SubscriptionOnChange)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    // check if the actual instance is of the type `SubscriptionPeriodic`
                    if (value.getActualInstance() instanceof SubscriptionPeriodic) {
                        JsonElement element = adapterSubscriptionPeriodic.toJsonTree((SubscriptionPeriodic)value.getActualInstance());
                        elementAdapter.write(out, element);
                        return;
                    }
                    throw new IOException("Failed to serialize as the type doesn't match oneOf schemas: SubscriptionOnChange, SubscriptionPeriodic");
                }

                @Override
                public Subscription read(JsonReader in) throws IOException {
                    Object deserialized = null;
                    JsonElement jsonElement = elementAdapter.read(in);

                    int match = 0;
                    ArrayList<String> errorMessages = new ArrayList<>();
                    TypeAdapter actualAdapter = elementAdapter;

                    // deserialize SubscriptionOnChange
                    try {
                        // validate the JSON object to see if any exception is thrown
                        SubscriptionOnChange.validateJsonElement(jsonElement);
                        actualAdapter = adapterSubscriptionOnChange;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'SubscriptionOnChange'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for SubscriptionOnChange failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'SubscriptionOnChange'", e);
                    }
                    // deserialize SubscriptionPeriodic
                    try {
                        // validate the JSON object to see if any exception is thrown
                        SubscriptionPeriodic.validateJsonElement(jsonElement);
                        actualAdapter = adapterSubscriptionPeriodic;
                        match++;
                        log.log(Level.FINER, "Input data matches schema 'SubscriptionPeriodic'");
                    } catch (Exception e) {
                        // deserialization failed, continue
                        errorMessages.add(String.format("Deserialization for SubscriptionPeriodic failed with `%s`.", e.getMessage()));
                        log.log(Level.FINER, "Input data does not match schema 'SubscriptionPeriodic'", e);
                    }

                    if (match == 1) {
                        Subscription ret = new Subscription();
                        ret.setActualInstance(actualAdapter.fromJsonTree(jsonElement));
                        return ret;
                    }

                    throw new IOException(String.format("Failed deserialization for Subscription: %d classes match result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", match, errorMessages, jsonElement.toString()));
                }
            }.nullSafe();
        }
    }

    // store a list of schema names defined in oneOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public Subscription() {
        super("oneOf", Boolean.FALSE);
    }

    public Subscription(Object o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("SubscriptionOnChange", SubscriptionOnChange.class);
        schemas.put("SubscriptionPeriodic", SubscriptionPeriodic.class);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return Subscription.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas:
     * SubscriptionOnChange, SubscriptionPeriodic
     *
     * It could be an instance of the 'oneOf' schemas.
     */
    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof SubscriptionOnChange) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof SubscriptionPeriodic) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be SubscriptionOnChange, SubscriptionPeriodic");
    }

    /**
     * Get the actual instance, which can be the following:
     * SubscriptionOnChange, SubscriptionPeriodic
     *
     * @return The actual instance (SubscriptionOnChange, SubscriptionPeriodic)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `SubscriptionOnChange`. If the actual instance is not `SubscriptionOnChange`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `SubscriptionOnChange`
     * @throws ClassCastException if the instance is not `SubscriptionOnChange`
     */
    public SubscriptionOnChange getSubscriptionOnChange() throws ClassCastException {
        return (SubscriptionOnChange)super.getActualInstance();
    }

    /**
     * Get the actual instance of `SubscriptionPeriodic`. If the actual instance is not `SubscriptionPeriodic`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `SubscriptionPeriodic`
     * @throws ClassCastException if the instance is not `SubscriptionPeriodic`
     */
    public SubscriptionPeriodic getSubscriptionPeriodic() throws ClassCastException {
        return (SubscriptionPeriodic)super.getActualInstance();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to Subscription
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        // validate oneOf schemas one by one
        int validCount = 0;
        ArrayList<String> errorMessages = new ArrayList<>();
        // validate the json string with SubscriptionOnChange
        try {
            SubscriptionOnChange.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for SubscriptionOnChange failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        // validate the json string with SubscriptionPeriodic
        try {
            SubscriptionPeriodic.validateJsonElement(jsonElement);
            validCount++;
        } catch (Exception e) {
            errorMessages.add(String.format("Deserialization for SubscriptionPeriodic failed with `%s`.", e.getMessage()));
            // continue to the next one
        }
        if (validCount != 1) {
            throw new IOException(String.format("The JSON string is invalid for Subscription with oneOf schemas: SubscriptionOnChange, SubscriptionPeriodic. %d class(es) match the result, expected 1. Detailed failure message for oneOf schemas: %s. JSON: %s", validCount, errorMessages, jsonElement.toString()));
        }
    }

    /**
     * Create an instance of Subscription given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of Subscription
     * @throws IOException if the JSON string is invalid with respect to Subscription
     */
    public static Subscription fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, Subscription.class);
    }

    /**
     * Convert an instance of Subscription to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

