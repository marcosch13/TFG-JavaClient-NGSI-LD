# JsonLdContextApiApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createContext**](JsonLdContextApiApi.md#createContext) | **POST** /jsonldContexts | Add a user @context to the internal cache  |
| [**deleteContext**](JsonLdContextApiApi.md#deleteContext) | **DELETE** /jsonldContexts/{contextId} | Delete one specific @context from internal cache, possibly re-inserting a freshly downloaded copy of it  |
| [**listContexts**](JsonLdContextApiApi.md#listContexts) | **GET** /jsonldContexts | List all cached @contexts  |
| [**retrieveContext**](JsonLdContextApiApi.md#retrieveContext) | **GET** /jsonldContexts/{contextId} | Serve one specific user @context  |


<a id="createContext"></a>
# **createContext**
> createContext(ngSILDTenant, createContextRequest)

Add a user @context to the internal cache 

5.13.2 Add @context.  With this operation, a client can ask the Broker to store the full content of a specific @context, by giving it to the Broker. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.JsonLdContextApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    JsonLdContextApiApi apiInstance = new JsonLdContextApiApi(defaultClient);
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    CreateContextRequest createContextRequest = new CreateContextRequest(); // CreateContextRequest | Payload body in the request contains a JSON object that has a root node named @context, which represents a JSON-LD \"local\" context. 
    try {
      apiInstance.createContext(ngSILDTenant, createContextRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling JsonLdContextApiApi#createContext");
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
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **createContextRequest** | [**CreateContextRequest**](CreateContextRequest.md)| Payload body in the request contains a JSON object that has a root node named @context, which represents a JSON-LD \&quot;local\&quot; context.  | [optional] |

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
| **201** | The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the local URI of the added @context.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteContext"></a>
# **deleteContext**
> deleteContext(contextId, reload, ngSILDTenant)

Delete one specific @context from internal cache, possibly re-inserting a freshly downloaded copy of it 

5.13.5 Delete and Reload @context  With this operation, a client supplies a local identifier to the Broker, indicating a stored @context, that the Broker shall remove from its storage. For @contexts of kind \&quot;Cached\&quot; this can also be the original URL the Broker downloaded the @context from. If the entry in the local storage that corresponds to the identifier is itself an array of @contexts, this operation will not delete the children, i.e. the @contexts in the array, but just the entry. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.JsonLdContextApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    JsonLdContextApiApi apiInstance = new JsonLdContextApiApi(defaultClient);
    URI contextId = new URI(); // URI | Local identifier of the @context to be managed (served or deleted). For @contexts of kind \"Cached\" this can also be the original URL the Broker downloaded the @context from. 
    Boolean reload = true; // Boolean | Indicates to perform a download and replace of the @context, as specified in clause 5.13.5.4. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteContext(contextId, reload, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling JsonLdContextApiApi#deleteContext");
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
| **contextId** | **URI**| Local identifier of the @context to be managed (served or deleted). For @contexts of kind \&quot;Cached\&quot; this can also be the original URL the Broker downloaded the @context from.  | |
| **reload** | **Boolean**| Indicates to perform a download and replace of the @context, as specified in clause 5.13.5.4.  | [optional] |
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
| **503** | It is used when re-downloading fails.  |  * NGSILD-Tenant -  <br>  |

<a id="listContexts"></a>
# **listContexts**
> ListContexts200Response listContexts(details, kind, ngSILDTenant)

List all cached @contexts 

5.13.3 List @contexts.  With this operation a client can obtain a list of URLs that represent all of the @contexts stored in the local context store of the Broker. Each URL can be used to download the corresponding @context, and, in case the @context&#39;s kind is \&quot;Cached\&quot;, it shall be the original URL the Broker downloaded the @context from.  In case a \&quot;details\&quot; flag is set to true, the client obtains a list of JSON objects, each representing information (metadata) about an @context currently stored by the Broker. Each JSON object contains information about the @context&#39;s original URL (if any), its local identifier in the Broker&#39;s storage, its kind (\&quot;Cached\&quot;, \&quot;Hosted\&quot; and \&quot;ImplicitlyCreated\&quot;), its creation timestamp, its expiry date (if \&quot;Cached\&quot;), and additional optional information. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.JsonLdContextApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    JsonLdContextApiApi apiInstance = new JsonLdContextApiApi(defaultClient);
    Boolean details = true; // Boolean | Whether a list of URLs or a more detailed list of JSON Objects is requested.
    String kind = "Cached"; // String | Can be either \"Cached\", \"Hosted\", or \"ImplicitlyCreated\". 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      ListContexts200Response result = apiInstance.listContexts(details, kind, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling JsonLdContextApiApi#listContexts");
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
| **details** | **Boolean**| Whether a list of URLs or a more detailed list of JSON Objects is requested. | [optional] |
| **kind** | **String**| Can be either \&quot;Cached\&quot;, \&quot;Hosted\&quot;, or \&quot;ImplicitlyCreated\&quot;.  | [optional] [enum: Cached, Hosted, ImplicitlyCreated] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**ListContexts200Response**](ListContexts200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing a list of URLs or a list of JSON Objects, as defined in clause 5.13.3.5, representing metadata about stored @contexts.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveContext"></a>
# **retrieveContext**
> RetrieveContext200Response retrieveContext(contextId, details, ngSILDTenant)

Serve one specific user @context 

5.13.4 Serve @context.  With this operation a client can obtain the full content of a specific @context (only for @contexts of kind \&quot;Hosted\&quot; or \&quot;ImplicitlyCreated\&quot;), which is currently stored in the Broker&#39;s internal storage, or its metadata (for all kinds of stored @contexts). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.JsonLdContextApiApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    JsonLdContextApiApi apiInstance = new JsonLdContextApiApi(defaultClient);
    URI contextId = new URI(); // URI | Local identifier of the @context to be managed (served or deleted). For @contexts of kind \"Cached\" this can also be the original URL the Broker downloaded the @context from. 
    Boolean details = true; // Boolean | Whether a list of URLs or a more detailed list of JSON Objects is requested.
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      RetrieveContext200Response result = apiInstance.retrieveContext(contextId, details, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling JsonLdContextApiApi#retrieveContext");
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
| **contextId** | **URI**| Local identifier of the @context to be managed (served or deleted). For @contexts of kind \&quot;Cached\&quot; this can also be the original URL the Broker downloaded the @context from.  | |
| **details** | **Boolean**| Whether a list of URLs or a more detailed list of JSON Objects is requested. | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**RetrieveContext200Response**](RetrieveContext200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | If the parameter details is False or missing, response body contains a JSON object that has a root node named @context, which represents a JSON-LD \&quot;local context\&quot;. If the parameter details is True, response body contains a JSON object as defined in clause 5.13.4.5, which metadata of a JSON-LD \&quot;local context\&quot;.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **422** | It is used to indicate that the operation is not available, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

