# ContextInformationProvisionApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**appendAttrs**](ContextInformationProvisionApi.md#appendAttrs) | **POST** /entities/{entityId}/attrs | Append Attributes to Entity  |
| [**createBatch**](ContextInformationProvisionApi.md#createBatch) | **POST** /entityOperations/create | Batch Entity Creation  |
| [**createEntity**](ContextInformationProvisionApi.md#createEntity) | **POST** /entities | Entity creation  |
| [**deleteAttrs**](ContextInformationProvisionApi.md#deleteAttrs) | **DELETE** /entities/{entityId}/attrs/{attrId} | Attribute delete  |
| [**deleteBatch**](ContextInformationProvisionApi.md#deleteBatch) | **POST** /entityOperations/delete | Batch Entity Delete  |
| [**deleteEntity**](ContextInformationProvisionApi.md#deleteEntity) | **DELETE** /entities/{entityId} | Entity deletion by id  |
| [**mergeBatch**](ContextInformationProvisionApi.md#mergeBatch) | **POST** /entityOperations/merge | Batch Entity Merge  |
| [**mergeEntity**](ContextInformationProvisionApi.md#mergeEntity) | **PATCH** /entities/{entityId} | Entity merge by id  |
| [**replaceAttrs**](ContextInformationProvisionApi.md#replaceAttrs) | **PUT** /entities/{entityId}/attrs/{attrId} | Attribute replace  |
| [**replaceEntity**](ContextInformationProvisionApi.md#replaceEntity) | **PUT** /entities/{entityId} | Entity replacement by id  |
| [**updateAttrs**](ContextInformationProvisionApi.md#updateAttrs) | **PATCH** /entities/{entityId}/attrs/{attrId} | Partial Attribute Update  |
| [**updateBatch**](ContextInformationProvisionApi.md#updateBatch) | **POST** /entityOperations/update | Batch Entity Update  |
| [**updateEntity**](ContextInformationProvisionApi.md#updateEntity) | **PATCH** /entities/{entityId}/attrs | Update Attributes of an Entity  |
| [**upsertBatch**](ContextInformationProvisionApi.md#upsertBatch) | **POST** /entityOperations/upsert | Batch Entity Creation or Update (Upsert)  |


<a id="appendAttrs"></a>
# **appendAttrs**
> appendAttrs(entityId, type, options, local, link, ngSILDTenant, entity)

Append Attributes to Entity 

5.6.3 Append Entity Attributes.  This operation allows modifying an NGSI-LD Entity by adding new attributes (Properties or Relationships). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    List<OptionsNoOverwrite> options = Arrays.asList(); // List<OptionsNoOverwrite> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Entity entity = new Entity(); // Entity | Entity Fragment containing a complete representation of the Attributes to be added. 
    try {
      apiInstance.appendAttrs(entityId, type, options, local, link, ngSILDTenant, entity);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#appendAttrs");
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
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **options** | [**List&lt;OptionsNoOverwrite&gt;**](OptionsNoOverwrite.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entity** | [**Entity**](Entity.md)| Entity Fragment containing a complete representation of the Attributes to be added.  | [optional] |

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
| **204** | All the Attributes were appended successfully.  |  * NGSILD-Tenant -  <br>  |
| **207** | Only the Attributes included in the response payload body were successfully appended. If no Attributes were successfully updated the updated array of UpdateResult (see clause 5.2.18) will be empty.  If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation.  In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a UpdateResult structure.  Names of the Attributes included in the UpdateResult structure are represented as Fully Qualified Names as per clause 6.3.6.  Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="createBatch"></a>
# **createBatch**
> List&lt;String&gt; createBatch(local, link, ngSILDTenant, queryEntity200ResponseInner)

Batch Entity Creation 

5.6.7 Batch Entity Creation.  This operation allows creating a batch of NGSI-LD Entities. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    List<QueryEntity200ResponseInner> queryEntity200ResponseInner = Arrays.asList(); // List<QueryEntity200ResponseInner> | Array of entities to be created. 
    try {
      List<String> result = apiInstance.createBatch(local, link, ngSILDTenant, queryEntity200ResponseInner);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#createBatch");
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
| **queryEntity200ResponseInner** | [**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)| Array of entities to be created.  | [optional] |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/json+ld
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | If all entities have been successfully created, an array of Strings containing URIs is returned in the response. Each URI represents the Entity Id of a created entity. There is no restriction as to the order of the Entity Ids.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="createEntity"></a>
# **createEntity**
> createEntity(local, link, ngSILDTenant, queryEntity200ResponseInner)

Entity creation 

5.6.1 Create Entity  This operation allows creating a new NGSI-LD Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    QueryEntity200ResponseInner queryEntity200ResponseInner = new QueryEntity200ResponseInner(); // QueryEntity200ResponseInner | Payload body in the request contains a JSON-LD object which represents the entity that is to be created. 
    try {
      apiInstance.createEntity(local, link, ngSILDTenant, queryEntity200ResponseInner);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#createEntity");
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
| **queryEntity200ResponseInner** | [**QueryEntity200ResponseInner**](QueryEntity200ResponseInner.md)| Payload body in the request contains a JSON-LD object which represents the entity that is to be created.  | [optional] |

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
| **201** | The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created entity resource.  |  * Location -  <br>  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **409** | It is used to indicate that the entity or an exclusive or redirect registration defining the entity already exists, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  |
| **422** | It is used to indicate that the operation is not available, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteAttrs"></a>
# **deleteAttrs**
> deleteAttrs(entityId, attrId, deleteAll, datasetId, type, local, link, ngSILDTenant)

Attribute delete 

5.6.5 Delete Entity Attribute.  This operation allows deleting an NGSI-LD Entity&#39;s Attribute (Property or Relationship).  The Attribute itself and all its children shall be deleted. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean deleteAll = true; // Boolean | If true, all attribute instances are deleted. Otherwise (default) only the Attribute instance specified by the datasetId is deleted. In case neither the deleteAll flag nor a datasetId is present, the default Attribute instance is deleted. 
    URI datasetId = new URI(); // URI | Specifies the datasetId of the dataset to be deleted. 
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteAttrs(entityId, attrId, deleteAll, datasetId, type, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#deleteAttrs");
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
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
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
| **207** | Only the Attributes included in the response payload body were successfully appended. If no Attributes were successfully updated the updated array of UpdateResult (see clause 5.2.18) will be empty.  If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation.  In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a UpdateResult structure.  Names of the Attributes included in the UpdateResult structure are represented as Fully Qualified Names as per clause 6.3.6.  Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteBatch"></a>
# **deleteBatch**
> deleteBatch(local, link, ngSILDTenant, requestBody)

Batch Entity Delete 

5.6.10 Batch Entity Delete.  This operation allows deleting a batch of NGSI-LD Entities. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    List<String> requestBody = Arrays.asList(); // List<String> | Array of String (URIs representing Entity IDs) to be deleted. 
    try {
      apiInstance.deleteBatch(local, link, ngSILDTenant, requestBody);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#deleteBatch");
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
| **requestBody** | [**List&lt;String&gt;**](String.md)| Array of String (URIs representing Entity IDs) to be deleted.  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | If all entities existed and have been successfully deleted, there is no payload body in the response.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="deleteEntity"></a>
# **deleteEntity**
> deleteEntity(entityId, type, local, link, ngSILDTenant)

Entity deletion by id 

5.6.6 Delete entity.  This operation allows deleting an NGSI-LD Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      apiInstance.deleteEntity(entityId, type, local, link, ngSILDTenant);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#deleteEntity");
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
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
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
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="mergeBatch"></a>
# **mergeBatch**
> mergeBatch(local, link, ngSILDTenant, queryEntity200ResponseInner)

Batch Entity Merge 

5.6.20 Batch Entity Merge.  This operation allows modification of a batch of NGSI-LD Entities according to the JSON Merge Patch processing rules defined in IETF RFC 7396 by adding new attributes (Properties or Relationships) or modifying or deleting existing attributes associated with an existing Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    List<QueryEntity200ResponseInner> queryEntity200ResponseInner = Arrays.asList(); // List<QueryEntity200ResponseInner> | Array of Entities to be merged. 
    try {
      apiInstance.mergeBatch(local, link, ngSILDTenant, queryEntity200ResponseInner);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#mergeBatch");
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
| **queryEntity200ResponseInner** | [**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)| Array of Entities to be merged.  | [optional] |

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
| **204** | If all entities have been successfully merged, there is no payload body in the response.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="mergeEntity"></a>
# **mergeEntity**
> mergeEntity(entityId, options, type, observedAt, lang, local, link, ngSILDTenant, entity)

Entity merge by id 

5.6.17 Merge Entity.  This operation allows modification of an existing NGSI-LD Entity aligning to the JSON Merge Patch processing rules defined in IETF RFC 7396 by adding new Attributes (Properties or Relationships) or modifying or deleting existing Attributes associated with an existing Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    List<OptionsRepresentation> options = Arrays.asList(); // List<OptionsRepresentation> | 
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    OffsetDateTime observedAt = OffsetDateTime.now(); // OffsetDateTime | When a merge operation applies to a pre-existing Attribute which previously contained an \"observedAt\" sub-attribute, the value held in this query parameter shall be used if no specific \"observedAt\" sub-Attribute is found in the payload body. 
    String lang = "lang_example"; // String | It is used to reduce languageMaps to a string or string array property in a single preferred language. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Entity entity = new Entity(); // Entity | Entity Fragment containing a complete representation of the Attributes to be merged. 
    try {
      apiInstance.mergeEntity(entityId, options, type, observedAt, lang, local, link, ngSILDTenant, entity);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#mergeEntity");
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
| **options** | [**List&lt;OptionsRepresentation&gt;**](OptionsRepresentation.md)|  | [optional] |
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **observedAt** | **OffsetDateTime**| When a merge operation applies to a pre-existing Attribute which previously contained an \&quot;observedAt\&quot; sub-attribute, the value held in this query parameter shall be used if no specific \&quot;observedAt\&quot; sub-Attribute is found in the payload body.  | [optional] |
| **lang** | **String**| It is used to reduce languageMaps to a string or string array property in a single preferred language.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entity** | [**Entity**](Entity.md)| Entity Fragment containing a complete representation of the Attributes to be merged.  | [optional] |

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
| **204** | All the Attributes were merged successfully.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="replaceAttrs"></a>
# **replaceAttrs**
> replaceAttrs(entityId, attrId, local, type, link, ngSILDTenant, replaceAttrsRequest)

Attribute replace 

5.6.19 Attribute Replace.  This operation allows the replacement of a single Attribute (Property or Relationship) within an NGSI-LD Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    ReplaceAttrsRequest replaceAttrsRequest = new ReplaceAttrsRequest(); // ReplaceAttrsRequest | 
    try {
      apiInstance.replaceAttrs(entityId, attrId, local, type, link, ngSILDTenant, replaceAttrsRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#replaceAttrs");
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
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **replaceAttrsRequest** | [**ReplaceAttrsRequest**](ReplaceAttrsRequest.md)|  | [optional] |

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
| **204** | The attribute was replaced successfully.  |  * NGSILD-Tenant -  <br>  |
| **207** | Only the Attributes included in the response payload body were successfully appended. If no Attributes were successfully updated the updated array of UpdateResult (see clause 5.2.18) will be empty.  If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation.  In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a UpdateResult structure.  Names of the Attributes included in the UpdateResult structure are represented as Fully Qualified Names as per clause 6.3.6.  Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="replaceEntity"></a>
# **replaceEntity**
> replaceEntity(entityId, type, local, link, ngSILDTenant, entity)

Entity replacement by id 

5.6.18 Replace Entity.  This operation allows the modification of an existing NGSI-LD Entity by replacing all of the Attributes (Properties or Relationships). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Entity entity = new Entity(); // Entity | Entity Fragment containing a complete representation of the Entity to be replaced. 
    try {
      apiInstance.replaceEntity(entityId, type, local, link, ngSILDTenant, entity);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#replaceEntity");
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
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entity** | [**Entity**](Entity.md)| Entity Fragment containing a complete representation of the Entity to be replaced.  | [optional] |

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
| **204** | The entity was replaced successfully.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="updateAttrs"></a>
# **updateAttrs**
> updateAttrs(entityId, attrId, local, type, link, ngSILDTenant, replaceAttrsRequest)

Partial Attribute Update 

5.6.4 Partial Attribute Update.  This operation allows performing a partial update on an NGSI-LD Entity&#39;s Attribute (Property or Relationship). A partial update only changes the elements provided in an Entity Fragment, leaving the rest as they are. This operation supports the deletion of sub-Attributes but not the deletion of the whole Attribute itself. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    ReplaceAttrsRequest replaceAttrsRequest = new ReplaceAttrsRequest(); // ReplaceAttrsRequest | 
    try {
      apiInstance.updateAttrs(entityId, attrId, local, type, link, ngSILDTenant, replaceAttrsRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#updateAttrs");
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
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **replaceAttrsRequest** | [**ReplaceAttrsRequest**](ReplaceAttrsRequest.md)|  | [optional] |

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
| **207** | Only the Attributes included in the response payload body were successfully appended. If no Attributes were successfully updated the updated array of UpdateResult (see clause 5.2.18) will be empty.  If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation.  In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a UpdateResult structure.  Names of the Attributes included in the UpdateResult structure are represented as Fully Qualified Names as per clause 6.3.6.  Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="updateBatch"></a>
# **updateBatch**
> updateBatch(options, local, link, ngSILDTenant, queryEntity200ResponseInner)

Batch Entity Update 

5.6.9 Batch Entity Update.  This operation allows updating a batch of NGSI-LD Entities. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    List<OptionsNoOverwrite> options = Arrays.asList(); // List<OptionsNoOverwrite> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    List<QueryEntity200ResponseInner> queryEntity200ResponseInner = Arrays.asList(); // List<QueryEntity200ResponseInner> | Array of entities to be updated. 
    try {
      apiInstance.updateBatch(options, local, link, ngSILDTenant, queryEntity200ResponseInner);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#updateBatch");
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
| **options** | [**List&lt;OptionsNoOverwrite&gt;**](OptionsNoOverwrite.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **queryEntity200ResponseInner** | [**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)| Array of entities to be updated.  | [optional] |

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
| **204** | If all entities have been successfully updated, there is no payload body in the response.   |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="updateEntity"></a>
# **updateEntity**
> updateEntity(entityId, local, type, link, ngSILDTenant, entity)

Update Attributes of an Entity 

5.6.2 Update Entity Attributes.  This operation allows modifying an existing NGSI-LD Entity by updating already existing Attributes (Properties or Relationships). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Entity entity = new Entity(); // Entity | Entity Fragment containing a complete representation of the Attributes to be updated. 
    try {
      apiInstance.updateEntity(entityId, local, type, link, ngSILDTenant, entity);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#updateEntity");
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
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **entity** | [**Entity**](Entity.md)| Entity Fragment containing a complete representation of the Attributes to be updated.  | [optional] |

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
| **204** | All the Attributes were appended successfully.  |  * NGSILD-Tenant -  <br>  |
| **207** | Only the Attributes included in the response payload body were successfully appended. If no Attributes were successfully updated the updated array of UpdateResult (see clause 5.2.18) will be empty.  If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation.  In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a UpdateResult structure.  Names of the Attributes included in the UpdateResult structure are represented as Fully Qualified Names as per clause 6.3.6.  Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="upsertBatch"></a>
# **upsertBatch**
> List&lt;String&gt; upsertBatch(options, local, link, ngSILDTenant, queryEntity200ResponseInner)

Batch Entity Creation or Update (Upsert) 

5.6.8 Batch Entity Upsert.  This operation allows creating a batch of NGSI-LD Entities, updating each of them if they already existed. In some database jargon this kind of operation is known as \&quot;upsert\&quot;. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(defaultClient);
    List<OptionsUpsert> options = Arrays.asList(replace); // List<OptionsUpsert> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    List<QueryEntity200ResponseInner> queryEntity200ResponseInner = Arrays.asList(); // List<QueryEntity200ResponseInner> | Array of entities to be created. 
    try {
      List<String> result = apiInstance.upsertBatch(options, local, link, ngSILDTenant, queryEntity200ResponseInner);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationProvisionApi#upsertBatch");
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
| **options** | [**List&lt;OptionsUpsert&gt;**](OptionsUpsert.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **queryEntity200ResponseInner** | [**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)| Array of entities to be created.  | [optional] |

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/json+ld
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | If all entities not existing prior to this request have been successfully created and the others have been successfully updated, an array of String (with the URIs representing the Entity Ids of the created entities only) is returned in the response. There is no restriction as to the order of the Entity Ids. The merely updated entities do not take part in the response (corresponding to 204 No Content returned in the case of updates).  |  * NGSILD-Tenant -  <br>  |
| **204** | If all entities already existed and are successfully updated, there is no payload body in the response.  |  * NGSILD-Tenant -  <br>  |
| **207** | If the entity input data matches to a registration, the relevant parts of the request are forwarded as a distributed operation. In the case when an error response is received back from any distributed operation, a response body containing the result returned from each registration is returned in a BatchOperationResult structure. Errors can occur whenever a distributed operation is unsupported, fails or times out, see clause 6.3.17.  |  * NGSILD-Tenant -  <br>  * Location -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

