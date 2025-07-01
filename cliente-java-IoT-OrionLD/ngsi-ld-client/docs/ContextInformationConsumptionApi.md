# ContextInformationConsumptionApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**queryBatch**](ContextInformationConsumptionApi.md#queryBatch) | **POST** /entityOperations/query | Query entities based on POST  |
| [**queryEntity**](ContextInformationConsumptionApi.md#queryEntity) | **GET** /entities | Query entities  |
| [**retrieveAttrTypeInfo**](ContextInformationConsumptionApi.md#retrieveAttrTypeInfo) | **GET** /attributes/{attrId} | Details about available attribute  |
| [**retrieveAttrTypes**](ContextInformationConsumptionApi.md#retrieveAttrTypes) | **GET** /attributes | Available attributes  |
| [**retrieveEntity**](ContextInformationConsumptionApi.md#retrieveEntity) | **GET** /entities/{entityId} | Entity retrieval by id  |
| [**retrieveEntityTypeInfo**](ContextInformationConsumptionApi.md#retrieveEntityTypeInfo) | **GET** /types/{type} | Details about available entity type  |
| [**retrieveEntityTypes**](ContextInformationConsumptionApi.md#retrieveEntityTypes) | **GET** /types | Retrieve available entity types   |


<a id="queryBatch"></a>
# **queryBatch**
> List&lt;QueryEntity200ResponseInner&gt; queryBatch(count, limit, local, options, link, ngSILDTenant, query)

Query entities based on POST 

5.7.2 Query Entity (batch entity queries only).  This operation allows querying an NGSI-LD system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    Boolean count = true; // Boolean | 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \"limit\" URI parameter), the total number of matching results (e.g. number of Entities) is returned. 
    Integer limit = 56; // Integer | 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    List<OptionsRepresentation> options = Arrays.asList(); // List<OptionsRepresentation> | 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    Query query = new Query(); // Query | Payload body in the request contains a JSON-LD object which represents the query to be performed.
    try {
      List<QueryEntity200ResponseInner> result = apiInstance.queryBatch(count, limit, local, options, link, ngSILDTenant, query);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#queryBatch");
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
| **count** | **Boolean**| 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \&quot;limit\&quot; URI parameter), the total number of matching results (e.g. number of Entities) is returned.  | [optional] |
| **limit** | **Integer**| 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **options** | [**List&lt;OptionsRepresentation&gt;**](OptionsRepresentation.md)|  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |
| **query** | [**Query**](Query.md)| Payload body in the request contains a JSON-LD object which represents the query to be performed. | [optional] |

### Return type

[**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/json+ld
 - **Accept**: application/json, application/json+ld, application/geo+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the query result as a list of Entities.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="queryEntity"></a>
# **queryEntity**
> List&lt;QueryEntity200ResponseInner&gt; queryEntity(id, type, idPattern, attrs, q, csf, geometry, georel, coordinates, geoproperty, geometryProperty, lang, scopeQ, limit, count, options, local, link, ngSILDTenant)

Query entities 

5.7.2 Query Entities (excluding batch entity queries).  This operation allows querying an NGSI-LD system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    List<URI> id = Arrays.asList(); // List<URI> | List of entity ids to be retrieved.
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    String idPattern = "idPattern_example"; // String | Regular expression that shall be matched by entity ids.
    List<String> attrs = Arrays.asList(); // List<String> | List of Attributes to be matched by the Entity and included in the response. If the Entity does not have any of the Attributes in attrs, then a 404 Not Found shall be retrieved. If attrs is not specified, no matching is performed and all Attributes related to the Entity shall be retrieved. 
    String q = "q_example"; // String | Query as per clause 4.9. 
    String csf = "csf_example"; // String | Context Source filter as per clause 4.9.
    String geometry = "Point"; // String | Geometry as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present. 
    QueryEntityGeorelParameter georel = new QueryEntityGeorelParameter(); // QueryEntityGeorelParameter | Geo relationship as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present. 
    QueryEntityCoordinatesParameter coordinates = new QueryEntityCoordinatesParameter(); // QueryEntityCoordinatesParameter | Coordinates serialized as a string as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present. 
    String geoproperty = "location"; // String | The name of the Property that contains the geospatial data that will be used to resolve the geoquery. By default, will be location (see clause 4.7). It shall be ignored unless a geoquery is present. 
    String geometryProperty = "geometryProperty_example"; // String | 4.5.16.1 Top-level \"geometry\" field selection algorithm.  A parameter of the request (named \"geometryProperty\") may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \"location\" shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field. 
    String lang = "lang_example"; // String | It is used to reduce languageMaps to a string or string array property in a single preferred language. 
    String scopeQ = "scopeQ_example"; // String | Scope query (see clause 4.19). 
    Integer limit = 56; // Integer | 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter. 
    Boolean count = true; // Boolean | 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \"limit\" URI parameter), the total number of matching results (e.g. number of Entities) is returned. 
    List<QueryEntityOptionsParameterInner> options = Arrays.asList(); // List<QueryEntityOptionsParameterInner> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      List<QueryEntity200ResponseInner> result = apiInstance.queryEntity(id, type, idPattern, attrs, q, csf, geometry, georel, coordinates, geoproperty, geometryProperty, lang, scopeQ, limit, count, options, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#queryEntity");
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
| **id** | [**List&lt;URI&gt;**](URI.md)| List of entity ids to be retrieved. | [optional] |
| **type** | **String**| Selection of Entity Types as per clause 4.17.  | [optional] |
| **idPattern** | **String**| Regular expression that shall be matched by entity ids. | [optional] |
| **attrs** | [**List&lt;String&gt;**](String.md)| List of Attributes to be matched by the Entity and included in the response. If the Entity does not have any of the Attributes in attrs, then a 404 Not Found shall be retrieved. If attrs is not specified, no matching is performed and all Attributes related to the Entity shall be retrieved.  | [optional] |
| **q** | **String**| Query as per clause 4.9.  | [optional] |
| **csf** | **String**| Context Source filter as per clause 4.9. | [optional] |
| **geometry** | **String**| Geometry as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present.  | [optional] [enum: Point, MultiPoint, LineString, MultiLineString, Polygon, MultiPolygon] |
| **georel** | [**QueryEntityGeorelParameter**](.md)| Geo relationship as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present.  | [optional] |
| **coordinates** | [**QueryEntityCoordinatesParameter**](.md)| Coordinates serialized as a string as per clause 4.10. It is part of geoquery. It shall be one if geometry or georel are present.  | [optional] |
| **geoproperty** | **String**| The name of the Property that contains the geospatial data that will be used to resolve the geoquery. By default, will be location (see clause 4.7). It shall be ignored unless a geoquery is present.  | [optional] [default to location] [enum: location, observationSpace, operationSpace] |
| **geometryProperty** | **String**| 4.5.16.1 Top-level \&quot;geometry\&quot; field selection algorithm.  A parameter of the request (named \&quot;geometryProperty\&quot;) may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \&quot;location\&quot; shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field.  | [optional] |
| **lang** | **String**| It is used to reduce languageMaps to a string or string array property in a single preferred language.  | [optional] |
| **scopeQ** | **String**| Scope query (see clause 4.19).  | [optional] |
| **limit** | **Integer**| 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter.  | [optional] |
| **count** | **Boolean**| 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \&quot;limit\&quot; URI parameter), the total number of matching results (e.g. number of Entities) is returned.  | [optional] |
| **options** | [**List&lt;QueryEntityOptionsParameterInner&gt;**](QueryEntityOptionsParameterInner.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**List&lt;QueryEntity200ResponseInner&gt;**](QueryEntity200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld, application/geo+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the query result as a list of entities, unless the Accept Header indicates that the Entities are to be rendered as GeoJSON.  If the Accept Header indicates that the Entities are to be rendered as GeoJSON, a response body containing the query result as GeoJSON FeatureCollection is returned.  |  * NGSILD-Results-Count -  <br>  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **501** | It is used by Registered Context Sources to indicate that the data format  of the request is unsupported see clause 6.3.7.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveAttrTypeInfo"></a>
# **retrieveAttrTypeInfo**
> Attribute retrieveAttrTypeInfo(attrId, local, link, ngSILDTenant)

Details about available attribute 

5.7.10 Retrieve Available Attribute Information.  This operation allows retrieving detailed attribute information about a specified NGSI-LD attribute that belongs to entity instances existing within the NGSI-LD system. The detailed representation includes the attribute name (as short name if available in the provided @context) and the type names for which entity instances exist that have the respective attribute, a count of available attribute instances and a list of types the attribute can have (e.g. Property, Relationship or GeoProperty). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    URI attrId = new URI(); // URI | Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      Attribute result = apiInstance.retrieveAttrTypeInfo(attrId, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#retrieveAttrTypeInfo");
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
| **attrId** | **URI**| Name of the attribute for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided.  | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**Attribute**](Attribute.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the detailed information about the available attribute.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveAttrTypes"></a>
# **retrieveAttrTypes**
> RetrieveAttrTypes200Response retrieveAttrTypes(details, local, link, ngSILDTenant)

Available attributes 

5.7.8 Retrieve Available Attributes.  This operation allows retrieving a list of NGSI-LD attributes that belong to entity instances existing within the NGSI- LD system.  5.7.9 Retrieve Details of Available Attributes.  This operation allows retrieving a list with a detailed representation of NGSI-LD  attributes that belong to entity instances existing within the NGSI-LD system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    Boolean details = true; // Boolean | If true, then detailed attribute information represented as an array with elements of the Attribute data structure (clause 5.2.28) is to be returned. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      RetrieveAttrTypes200Response result = apiInstance.retrieveAttrTypes(details, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#retrieveAttrTypes");
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
| **details** | **Boolean**| If true, then detailed attribute information represented as an array with elements of the Attribute data structure (clause 5.2.28) is to be returned.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**RetrieveAttrTypes200Response**](RetrieveAttrTypes200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the AttributeList (clause 5.2.27) is to be returned, unless details&#x3D;true is specified.  If details&#x3D;true is specified, a response body containing a JSON-LD array with elements of the Attribute data structure (clause 5.2.28) is to be returned.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveEntity"></a>
# **retrieveEntity**
> QueryEntity200ResponseInner retrieveEntity(entityId, type, attrs, geometryProperty, lang, options, local, link, ngSILDTenant)

Entity retrieval by id 

5.7.1 Retrieve Entity.  This operation allows retrieving an NGSI-LD Entity. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    URI entityId = new URI(); // URI | Id (URI) of the entity to be retrieved.
    String type = "type_example"; // String | Selection of Entity Types as per clause 4.17. 
    List<String> attrs = Arrays.asList(); // List<String> | List of Attributes to be matched by the Entity and included in the response. If the Entity does not have any of the Attributes in attrs, then a 404 Not Found shall be retrieved. If attrs is not specified, no matching is performed and all Attributes related to the Entity shall be retrieved. 
    String geometryProperty = "geometryProperty_example"; // String | 4.5.16.1 Top-level \"geometry\" field selection algorithm.  A parameter of the request (named \"geometryProperty\") may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \"location\" shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field. 
    String lang = "lang_example"; // String | It is used to reduce languageMaps to a string or string array property in a single preferred language. 
    List<QueryEntityOptionsParameterInner> options = Arrays.asList(); // List<QueryEntityOptionsParameterInner> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      QueryEntity200ResponseInner result = apiInstance.retrieveEntity(entityId, type, attrs, geometryProperty, lang, options, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#retrieveEntity");
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
| **attrs** | [**List&lt;String&gt;**](String.md)| List of Attributes to be matched by the Entity and included in the response. If the Entity does not have any of the Attributes in attrs, then a 404 Not Found shall be retrieved. If attrs is not specified, no matching is performed and all Attributes related to the Entity shall be retrieved.  | [optional] |
| **geometryProperty** | **String**| 4.5.16.1 Top-level \&quot;geometry\&quot; field selection algorithm.  A parameter of the request (named \&quot;geometryProperty\&quot;) may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \&quot;location\&quot; shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field.  | [optional] |
| **lang** | **String**| It is used to reduce languageMaps to a string or string array property in a single preferred language.  | [optional] |
| **options** | [**List&lt;QueryEntityOptionsParameterInner&gt;**](QueryEntityOptionsParameterInner.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**QueryEntity200ResponseInner**](QueryEntity200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld, application/geo+json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the target entity containing the selected Attributes, unless the Accept Header indicates that the Entity is to be rendered as GeoJSON.  If the Accept Header indicates that the Entity is to be rendered as GeoJSON, a GeoJSON Feature is returned.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **501** | It is used by Registered Context Sources to indicate that the data format  of the request is unsupported see clause 6.3.7.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveEntityTypeInfo"></a>
# **retrieveEntityTypeInfo**
> EntityTypeInfo retrieveEntityTypeInfo(type, local, link, ngSILDTenant)

Details about available entity type 

5.7.7 Retrieve Available Entity Type information.  This operation allows retrieving detailed entity type information about a specified NGSI-LD entity type for which entity instances exist within the NGSI-LD system. The detailed representation includes the type name (as short name if available in the provided @context), the count of available entity instances and details about attributes that existing instances of this entity type have, including their name (as short name if available in the provided @context) and a list of types the attribute can have (e.g. Property, Relationship or GeoProperty). 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    URI type = new URI(); // URI | Name of the entity type for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      EntityTypeInfo result = apiInstance.retrieveEntityTypeInfo(type, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#retrieveEntityTypeInfo");
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
| **type** | **URI**| Name of the entity type for which detailed information is to be retrieved. The Fully Qualified Name (FQN) as well as the short name can be used, given that the latter is part of the JSON-LD @context provided.  | |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**EntityTypeInfo**](EntityTypeInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the detailed information about the available entity type.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveEntityTypes"></a>
# **retrieveEntityTypes**
> RetrieveEntityTypes200Response retrieveEntityTypes(details, local, link, ngSILDTenant)

Retrieve available entity types  

5.7.5 Retrieve Available Entity Types.  This operation allows retrieving a list of NGSI-LD entity types for which entity instances exist within the NGSI-LD system.  5.7.6  Retrieve Details of Available Entity Types.  This operation allows retrieving a list with a detailed representation of NGSI-LD entity types for which entity instances exist within the NGSI-LD system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextInformationConsumptionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(defaultClient);
    Boolean details = true; // Boolean | If true, then detailed entity type information represented as an array with elements of the Entity Type data structure (clause 5.2.25) is to be returned. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      RetrieveEntityTypes200Response result = apiInstance.retrieveEntityTypes(details, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextInformationConsumptionApi#retrieveEntityTypes");
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
| **details** | **Boolean**| If true, then detailed entity type information represented as an array with elements of the Entity Type data structure (clause 5.2.25) is to be returned.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**RetrieveEntityTypes200Response**](RetrieveEntityTypes200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the EntityTypeList (clause 5.2.24) is to be returned, unless details&#x3D;true is specified.  If details&#x3D;true is specified, a response body containing a JSON-LD array with elements of the EntityType data structure (clause 5.2.25) is to be returned.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

