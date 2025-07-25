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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.CreateSubscriptionRequest;
import org.openapitools.client.model.CreateSubscriptionRequest1;
import org.openapitools.client.model.OptionsSysAttrs;
import org.openapitools.client.model.ProblemDetails;
import org.openapitools.client.model.QuerySubscription200ResponseInner;
import org.openapitools.client.model.QuerySubscription200ResponseInner1;
import org.openapitools.client.model.Subscription;
import java.net.URI;
import org.openapitools.client.model.UpdateSubscriptionRequest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ContextSourceRegistrationSubscriptionApi
 */
@Disabled
public class ContextSourceRegistrationSubscriptionApiTest {

    private final ContextSourceRegistrationSubscriptionApi api = new ContextSourceRegistrationSubscriptionApi();

    /**
     * Create subscription to Csource registration 
     *
     * 5.11.2 Create Context Source Registration Subscription.  This operation allows creating a new Context Source Registration Subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createCSRSubscriptionTest() throws ApiException {
        Boolean local = null;
        URI link = null;
        String ngSILDTenant = null;
        CreateSubscriptionRequest createSubscriptionRequest = null;
        api.createCSRSubscription(local, link, ngSILDTenant, createSubscriptionRequest);
        // TODO: test validations
    }

    /**
     * Csource registration subscription deletion by id 
     *
     * 5.11.6 Delete Context Source Registration Subscription.  This operation allows deleting an existing Context Source Registration Subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteCSRSubscriptionTest() throws ApiException {
        URI subscriptionId = null;
        Boolean local = null;
        URI link = null;
        String ngSILDTenant = null;
        api.deleteCSRSubscription(subscriptionId, local, link, ngSILDTenant);
        // TODO: test validations
    }

    /**
     * Retrieval of list of subscriptions to Csource registrations 
     *
     * 5.11.5 Query Context Source Registration Subscriptions.  This operation allows querying existing Context Source Registration Subscriptions. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void queryCSRSubscriptionTest() throws ApiException {
        List<OptionsSysAttrs> options = null;
        Integer limit = null;
        Boolean count = null;
        Boolean local = null;
        URI link = null;
        String ngSILDTenant = null;
        List<QuerySubscription200ResponseInner> response = api.queryCSRSubscription(options, limit, count, local, link, ngSILDTenant);
        // TODO: test validations
    }

    /**
     * Csource registration subscription update by id 
     *
     * 5.11.4 Retrieve Context Source Registration Subscription.  This operation allows retrieving an existing Context Source Registration Subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void retrieveCSRSubscriptionTest() throws ApiException {
        URI subscriptionId = null;
        List<OptionsSysAttrs> options = null;
        Boolean local = null;
        URI link = null;
        String ngSILDTenant = null;
        QuerySubscription200ResponseInner response = api.retrieveCSRSubscription(subscriptionId, options, local, link, ngSILDTenant);
        // TODO: test validations
    }

    /**
     * Csource registration subscription update by id 
     *
     * 5.11.3 Update Context Source Registration Subscription.  This operation allows updating an existing Context Source Registration Subscription. 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateCSRSubscriptionTest() throws ApiException {
        URI subscriptionId = null;
        Boolean local = null;
        URI link = null;
        String ngSILDTenant = null;
        Subscription subscription = null;
        api.updateCSRSubscription(subscriptionId, local, link, ngSILDTenant, subscription);
        // TODO: test validations
    }

}
