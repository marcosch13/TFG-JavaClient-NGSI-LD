# ContextInformationSubscriptionApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubscription**](ContextInformationSubscriptionApi.md#createSubscription) | **POST** /subscriptions | Create Subscription  |
| [**deleteSubscription**](ContextInformationSubscriptionApi.md#deleteSubscription) | **DELETE** /subscriptions/{subscriptionId} | Subscription deletion by id  |
| [**querySubscription**](ContextInformationSubscriptionApi.md#querySubscription) | **GET** /subscriptions | Retrieve list of Subscriptions  |
| [**retrieveSubscription**](ContextInformationSubscriptionApi.md#retrieveSubscription) | **GET** /subscriptions/{subscriptionId} | Subscription retrieval by id  |
| [**updateSubscription**](ContextInformationSubscriptionApi.md#updateSubscription) | **PATCH** /subscriptions/{subscriptionId} | Subscription update by id  |


<a id="createSubscription"></a>
# **createSubscription**
> createSubscription(local, link, ngSILDTenant, createSubscriptionRequest)

Create Subscription 

5.8.1 Create subscription.  This operation allows creating a new subscription. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationSubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationSubscriptionApi apiInstance = new ContextInformationSubscriptionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    CreateSubscriptionRequest createSubscriptionRequest = new CreateSubscriptionRequest(); // CreateSubscriptionRequest | 
    try {
      apiInstance.createSubscription(local, link, ngSILDTenant, createSubscriptionRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationSubscriptionApi#createSubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **createSubscriptionRequest** | [**CreateSubscriptionRequest**](CreateSubscriptionRequest.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/json+ld
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created subscription resource.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **409** | It is used to indicate that the entity or an exclusive or redirect registration defining the entity already exists, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  |

<a id="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(subscriptionId, local, link, ngSILDTenant)

Subscription deletion by id 

5.8.5 Delete Subscription.  This operation allows deleting an existing subscription. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationSubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationSubscriptionApi apiInstance = new ContextInformationSubscriptionApi(defaultClient);
    URI subscriptionId = new URI(); // URI | Id (URI) of the concerned subscription.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteSubscription(subscriptionId, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationSubscriptionApi#deleteSubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionId** | **URI**| Id (URI) of the concerned subscription. | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="querySubscription"></a>
# **querySubscription**
> List&lt;QuerySubscription200ResponseInner&gt; querySubscription(options, limit, count, local, link, ngSILDTenant)

Retrieve list of Subscriptions 

5.8.4 Query Subscriptions.  This operation allows querying existing Subscriptions. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationSubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationSubscriptionApi apiInstance = new ContextInformationSubscriptionApi(defaultClient);
    List<OptionsSysAttrs> options = Arrays.asList(); // List<OptionsSysAttrs> | 
    Integer limit = 56; // Integer | 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter. 
    Boolean count = true; // Boolean | 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \"limit\" URI parameter), the total number of matching results (e.g. number of Entities) is returned. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      List<QuerySubscription200ResponseInner> result = apiInstance.querySubscription(options, limit, count, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationSubscriptionApi#querySubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **options** | [**List&lt;OptionsSysAttrs&gt;**](OptionsSysAttrs.md)|  | [optional] |
| **limit** | **Integer**| 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter.  | [optional] |
| **count** | **Boolean**| 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \&quot;limit\&quot; URI parameter), the total number of matching results (e.g. number of Entities) is returned.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**List&lt;QuerySubscription200ResponseInner&gt;**](QuerySubscription200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing a list of subscriptions.  |  * NGSILD-Tenant -  <br>  * NGSILD-Results-Count -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveSubscription"></a>
# **retrieveSubscription**
> QuerySubscription200ResponseInner retrieveSubscription(subscriptionId, options, local, link, ngSILDTenant)

Subscription retrieval by id 

5.8.3 Retrieve Subscription.  This operation allows retrieving an existing subscription. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationSubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationSubscriptionApi apiInstance = new ContextInformationSubscriptionApi(defaultClient);
    URI subscriptionId = new URI(); // URI | Id (URI) of the concerned subscription.
    List<OptionsSysAttrs> options = Arrays.asList(); // List<OptionsSysAttrs> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      QuerySubscription200ResponseInner result = apiInstance.retrieveSubscription(subscriptionId, options, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationSubscriptionApi#retrieveSubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionId** | **URI**| Id (URI) of the concerned subscription. | |
| **options** | [**List&lt;OptionsSysAttrs&gt;**](OptionsSysAttrs.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**QuerySubscription200ResponseInner**](QuerySubscription200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the target subscription.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="updateSubscription"></a>
# **updateSubscription**
> updateSubscription(subscriptionId, local, link, ngSILDTenant, subscription)

Subscription update by id 

5.8.2 Update Subscription.  This operation allows updating an existing subscription. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationSubscriptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationSubscriptionApi apiInstance = new ContextInformationSubscriptionApi(defaultClient);
    URI subscriptionId = new URI(); // URI | Id (URI) of the concerned subscription.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Subscription subscription = new Subscription(); // Subscription | 
    try {
      apiInstance.updateSubscription(subscriptionId, local, link, ngSILDTenant, subscription);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationSubscriptionApi#updateSubscription");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionId** | **URI**| Id (URI) of the concerned subscription. | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **subscription** | [**Subscription**](Subscription.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/json+ld
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | No Content.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

