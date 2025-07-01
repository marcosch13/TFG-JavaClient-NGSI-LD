# TemporalContextInformationProvisionApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**appendAttrsTemporal**](TemporalContextInformationProvisionApi.md#appendAttrsTemporal) | **POST** /temporal/entities/{entityId}/attrs | Temporal Representation of Entity Attribute instance addition  |
| [**deleteAttrInstanceTemporal**](TemporalContextInformationProvisionApi.md#deleteAttrInstanceTemporal) | **DELETE** /temporal/entities/{entityId}/attrs/{attrId}/{instanceId} | Attribute Instance deletion by instance id  |
| [**deleteAttrsTemporal**](TemporalContextInformationProvisionApi.md#deleteAttrsTemporal) | **DELETE** /temporal/entities/{entityId}/attrs/{attrId} | Attribute from Temporal Representation of Entity deletion  |
| [**deleteTemporal**](TemporalContextInformationProvisionApi.md#deleteTemporal) | **DELETE** /temporal/entities/{entityId} | Temporal Representation of Entity deletion by id  |
| [**updateAttrsTemporal**](TemporalContextInformationProvisionApi.md#updateAttrsTemporal) | **PATCH** /temporal/entities/{entityId}/attrs/{attrId}/{instanceId} | Attribute Instance update  |
| [**upsertTemporal**](TemporalContextInformationProvisionApi.md#upsertTemporal) | **POST** /temporal/entities | Temporal Representation of Entity creation  |


<a id="appendAttrsTemporal"></a>
# **appendAttrsTemporal**
> appendAttrsTemporal(entityId, local, link, ngSILDTenant, entityTemporal)

Temporal Representation of Entity Attribute instance addition 

5.6.12 Add Attributes to Temporal Representation of an Entity.  This operation allows modifying a Temporal Representation of an Entity by adding new Attribute instances. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    EntityTemporal entityTemporal = new EntityTemporal(); // EntityTemporal | 
    try {
      apiInstance.appendAttrsTemporal(entityId, local, link, ngSILDTenant, entityTemporal);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#appendAttrsTemporal");
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
| **entityId** | **URI**| Id (URI) of the entity to be retrieved. | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entityTemporal** | [**EntityTemporal**](EntityTemporal.md)|  | [optional] |

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
| **204** | All the Attributes were added successfully.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteAttrInstanceTemporal"></a>
# **deleteAttrInstanceTemporal**
> deleteAttrInstanceTemporal(entityId, attrId, instanceId, local, link, ngSILDTenant)

Attribute Instance deletion by instance id 

5.6.15 Delete Attribute Instance from Temporal Representation of an Entity.  This operation allows deleting one Attribute instance (Property or Relationship), identified by its instanceId, of a Temporal Representation of an Entity. The Attribute itself and all its child elements shall be deleted. This operation enables the removal of individual Attribute instances that could have been previously added to the Temporal Representation of an Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    URI instanceId = new URI(); // URI | Id (URI) identifying a particular Attribute instance.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteAttrInstanceTemporal(entityId, attrId, instanceId, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#deleteAttrInstanceTemporal");
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
| **entityId** | **URI**| Id (URI) of the entity to be retrieved. | |
| **attrId** | **URI**| Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided.  | |
| **instanceId** | **URI**| Id (URI) identifying a particular Attribute instance. | |
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
| **204** | The attribute instance was delete successfully.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteAttrsTemporal"></a>
# **deleteAttrsTemporal**
> deleteAttrsTemporal(entityId, attrId, deleteAll, datasetId, local, link, ngSILDTenant)

Attribute from Temporal Representation of Entity deletion 

5.6.13 Delete Attributes from Temporal Representation of an Entity.  This operation allows deleting an Attribute (Property or Relationship) of the Temporal Representation of an Entity. The Attribute itself and all its children shall be deleted. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean deleteAll = true; // Boolean | If true, all attribute instances are deleted. Otherwise (default) only the Attribute instance specified by the datasetId is deleted. In case neither the deleteAll flag nor a datasetId is present, the default Attribute instance is deleted. 
    URI datasetId = new URI(); // URI | Specifies the datasetId of the dataset to be deleted. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteAttrsTemporal(entityId, attrId, deleteAll, datasetId, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#deleteAttrsTemporal");
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
| **entityId** | **URI**| Id (URI) of the entity to be retrieved. | |
| **attrId** | **URI**| Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided.  | |
| **deleteAll** | **Boolean**| If true, all attribute instances are deleted. Otherwise (default) only the Attribute instance specified by the datasetId is deleted. In case neither the deleteAll flag nor a datasetId is present, the default Attribute instance is deleted.  | [optional] |
| **datasetId** | **URI**| Specifies the datasetId of the dataset to be deleted.  | [optional] |
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
| **204** | The attribute was deleted successfully.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteTemporal"></a>
# **deleteTemporal**
> deleteTemporal(entityId, local, link, ngSILDTenant)

Temporal Representation of Entity deletion by id 

5.6.16 Delete Temporal Representation of an Entity.  This operation allows deleting the Temporal Representation of an Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteTemporal(entityId, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#deleteTemporal");
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
| **entityId** | **URI**| Id (URI) of the entity to be retrieved. | |
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

<a id="updateAttrsTemporal"></a>
# **updateAttrsTemporal**
> updateAttrsTemporal(entityId, attrId, instanceId, local, link, ngSILDTenant, entityTemporal)

Attribute Instance update 

5.6.14 Partial Update Attribute instance in Temporal Representation of an Entity.  This operation allows modifying a specific Attribute (Property or Relationship) instance, identified by its instanceId, of a Temporal Representation of an Entity.  This operation enables the correction of wrong information that could have been previously added to the Temporal Representation of an Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    URI instanceId = new URI(); // URI | Id (URI) identifying a particular Attribute instance.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    EntityTemporal entityTemporal = new EntityTemporal(); // EntityTemporal | 
    try {
      apiInstance.updateAttrsTemporal(entityId, attrId, instanceId, local, link, ngSILDTenant, entityTemporal);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#updateAttrsTemporal");
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
| **entityId** | **URI**| Id (URI) of the entity to be retrieved. | |
| **attrId** | **URI**| Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided.  | |
| **instanceId** | **URI**| Id (URI) identifying a particular Attribute instance. | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entityTemporal** | [**EntityTemporal**](EntityTemporal.md)|  | [optional] |

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
| **204** | The attribute was updated successfully.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="upsertTemporal"></a>
# **upsertTemporal**
> upsertTemporal(local, link, ngSILDTenant, entityTemporal)

Temporal Representation of Entity creation 

5.6.11 Create or Update Temporal Representation of an Entity.  This operation allows creating or updating (by adding new Attribute instances) a Temporal Representation of an Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TemporalContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    TemporalContextInformationProvisionApi apiInstance = new TemporalContextInformationProvisionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    EntityTemporal entityTemporal = new EntityTemporal(); // EntityTemporal | 
    try {
      apiInstance.upsertTemporal(local, link, ngSILDTenant, entityTemporal);
    } catch (ApiException e) {
      System.err.println("Exception when calling TemporalContextInformationProvisionApi#upsertTemporal");
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
| **entityTemporal** | [**EntityTemporal**](EntityTemporal.md)|  | [optional] |

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
| **201** | Upon creation success, the HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created entity resource.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **204** | Upon update success.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **422** | It is used to indicate that the operation is not available, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

