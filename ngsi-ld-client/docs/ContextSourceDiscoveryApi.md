# ContextSourceDiscoveryApi

All URIs are relative to *https://localhost:443/ngsi-ld/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**queryCSR**](ContextSourceDiscoveryApi.md#queryCSR) | **GET** /csourceRegistrations | Discover Csource registrations  |
| [**retrieveCSR**](ContextSourceDiscoveryApi.md#retrieveCSR) | **GET** /csourceRegistrations/{registrationId} | Csource registration retrieval by id  |


<a id="queryCSR"></a>
# **queryCSR**
> List&lt;QueryCSR200ResponseInner&gt; queryCSR(id, type, idPattern, attrs, q, csf, geometry, georel, coordinates, geoproperty, timeproperty, timerel, timeAt, endTimeAt, geometryProperty, lang, scopeQ, options, limit, count, local, link, ngSILDTenant)

Discover Csource registrations 

5.10.2 Query Context Source Registrations.  This operation allows discovering context source registrations from an NGSI-LD system. The behaviour of the discovery of context source registrations differs significantly from the querying of entities as described in clause 5.7.2. The approach is that the client submits a query for entities as described in clause 5.7.2, but instead of receiving the Entity information, it receives a list of Context Source Registrations describing Context Sources that possibly have some of the requested Entity information. This means that the requested Entities and Attributes are matched against the &#39;information&#39; property as described in clause 5.12.  If no temporal query is present, only Context Source Registrations for Context Sources providing latest information, i.e. without specified time intervals, are considered. If a temporal query is present only Context Source Registrations with matching time intervals, i.e. observationInterval or managementInterval, are considered. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextSourceDiscoveryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextSourceDiscoveryApi apiInstance = new ContextSourceDiscoveryApi(defaultClient);
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
    String timeproperty = "observedAt"; // String | Allowed values: \"observedAt\", \"createdAt\", \"modifiedAt\" and \"deletedAt\". If not specified, the default is \"observedAt\". (See clause 4.8) 
    String timerel = "before"; // String | Allowed values: \"before\", \"after\", \"between\" 
    OffsetDateTime timeAt = OffsetDateTime.now(); // OffsetDateTime | It shall be a DateTime. Cardinality shall be 1 if timerel is present. String representing the timeAt parameter as defined by clause 4.11. 
    OffsetDateTime endTimeAt = OffsetDateTime.now(); // OffsetDateTime | It shall be a DateTime. Cardinality shall be 1 if timerel is equal to \"between\". String representing the endTimeAt parameter as defined by clause 4.11. 
    String geometryProperty = "geometryProperty_example"; // String | 4.5.16.1 Top-level \"geometry\" field selection algorithm.  A parameter of the request (named \"geometryProperty\") may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \"location\" shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field. 
    String lang = "lang_example"; // String | It is used to reduce languageMaps to a string or string array property in a single preferred language. 
    String scopeQ = "scopeQ_example"; // String | Scope query (see clause 4.19). 
    List<OptionsSysAttrs> options = Arrays.asList(); // List<OptionsSysAttrs> | 
    Integer limit = 56; // Integer | 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter. 
    Boolean count = true; // Boolean | 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \"limit\" URI parameter), the total number of matching results (e.g. number of Entities) is returned. 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      List<QueryCSR200ResponseInner> result = apiInstance.queryCSR(id, type, idPattern, attrs, q, csf, geometry, georel, coordinates, geoproperty, timeproperty, timerel, timeAt, endTimeAt, geometryProperty, lang, scopeQ, options, limit, count, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextSourceDiscoveryApi#queryCSR");
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
| **timeproperty** | **String**| Allowed values: \&quot;observedAt\&quot;, \&quot;createdAt\&quot;, \&quot;modifiedAt\&quot; and \&quot;deletedAt\&quot;. If not specified, the default is \&quot;observedAt\&quot;. (See clause 4.8)  | [optional] [default to observedAt] [enum: observedAt, createdAt, modifiedAt, deletedAt] |
| **timerel** | **String**| Allowed values: \&quot;before\&quot;, \&quot;after\&quot;, \&quot;between\&quot;  | [optional] [enum: before, after, between] |
| **timeAt** | **OffsetDateTime**| It shall be a DateTime. Cardinality shall be 1 if timerel is present. String representing the timeAt parameter as defined by clause 4.11.  | [optional] |
| **endTimeAt** | **OffsetDateTime**| It shall be a DateTime. Cardinality shall be 1 if timerel is equal to \&quot;between\&quot;. String representing the endTimeAt parameter as defined by clause 4.11.  | [optional] |
| **geometryProperty** | **String**| 4.5.16.1 Top-level \&quot;geometry\&quot; field selection algorithm.  A parameter of the request (named \&quot;geometryProperty\&quot;) may be used to indicate the name of the GeoProperty to be selected.  If this parameter is not present, then the default name of \&quot;location\&quot; shall be used.  In the case of GeoJSON Entity representation, this parameter indicates which GeoProperty to use for the toplevel geometry field.  | [optional] |
| **lang** | **String**| It is used to reduce languageMaps to a string or string array property in a single preferred language.  | [optional] |
| **scopeQ** | **String**| Scope query (see clause 4.19).  | [optional] |
| **options** | [**List&lt;OptionsSysAttrs&gt;**](OptionsSysAttrs.md)|  | [optional] |
| **limit** | **Integer**| 6.3.10 Pagination behaviour. It defines the limit to the number of NGSI-LD Elements that shall be retrieved at a maximum as mandated by clause 5.5.9. The value 0 is only allowed in combination with the count URI parameter.  | [optional] |
| **count** | **Boolean**| 6.3.13 Counting number of results. If true, then a special HTTP header (NGSILD-Results-Count) is set in the response. Regardless of how many entities are actually returned (maybe due to the \&quot;limit\&quot; URI parameter), the total number of matching results (e.g. number of Entities) is returned.  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**List&lt;QueryCSR200ResponseInner&gt;**](QueryCSR200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the query result as an array of context source registrations.  |  * NGSILD-Results-Count -  <br>  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

<a id="retrieveCSR"></a>
# **retrieveCSR**
> QueryCSR200ResponseInner retrieveCSR(registrationId, options, local, link, ngSILDTenant)

Csource registration retrieval by id 

5.10.1 Retrieve Context Source Registration.  This operation allows retrieving a specific context source registration from an NGSI-LD system. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ContextSourceDiscoveryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:443/ngsi-ld/v1");

    ContextSourceDiscoveryApi apiInstance = new ContextSourceDiscoveryApi(defaultClient);
    URI registrationId = new URI(); // URI | Id (URI) of the context source registration.
    List<OptionsSysAttrs> options = Arrays.asList(); // List<OptionsSysAttrs> | 
    Boolean local = true; // Boolean | 6.3.18 Limiting Distributed Operations. If local=true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4). 
    URI link = new URI(); // URI | 6.3.5 JSON-LD @context resolution  In summary, from a developer's perspective, for POST, PATCH and PUT operations, if MIME type is \"application/ld+json\", then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \"application/json\", then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header. 
    String ngSILDTenant = "ngSILDTenant_example"; // String | 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted. 
    try {
      QueryCSR200ResponseInner result = apiInstance.retrieveCSR(registrationId, options, local, link, ngSILDTenant);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContextSourceDiscoveryApi#retrieveCSR");
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
| **registrationId** | **URI**| Id (URI) of the context source registration. | |
| **options** | [**List&lt;OptionsSysAttrs&gt;**](OptionsSysAttrs.md)|  | [optional] |
| **local** | **Boolean**| 6.3.18 Limiting Distributed Operations. If local&#x3D;true then no Context Source Registrations shall be considered as matching to avoid cascading distributed operations (see clause 4.3.6.4).  | [optional] |
| **link** | **URI**| 6.3.5 JSON-LD @context resolution  In summary, from a developer&#39;s perspective, for POST, PATCH and PUT operations, if MIME type is \&quot;application/ld+json\&quot;, then the associated @context shall be provided only as part of the request payload body. Likewise, if MIME type is \&quot;application/json\&quot;, then the associated @context shall be provided only by using the JSON-LD Link header. No mixes are allowed, i.e. mixing options shall result in HTTP response errors. Implementations should provide descriptive error messages when these situations arise.  In contrast, GET and DELETE operations always take their input @context from the JSON-LD Link Header.  | [optional] |
| **ngSILDTenant** | **String**| 6.3.14 Tenant specification. The tenant to which the NGSI-LD HTTP operation is targeted.  | [optional] |

### Return type

[**QueryCSR200ResponseInner**](QueryCSR200ResponseInner.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/json+ld

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A response body containing the JSON-LD representation of the target subscription.  |  * NGSILD-Warning -  <br>  |
| **400** | It is used to indicate that the request or its content is incorrect, see clause 6.3.2. In the returned ProblemDetails structure, the \&quot;detail\&quot; attribute should convey more information about the error.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |
| **404** | It is used when a client provided an entity identifier (URI) not known to the system, see clause 6.3.2.  |  * NGSILD-Tenant -  <br>  * NGSILD-Warning -  <br>  |

