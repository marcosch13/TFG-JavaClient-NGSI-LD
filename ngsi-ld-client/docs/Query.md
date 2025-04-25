

# Query

5.2.23 This datatype represents the information that is required in order to convey a query when a \"Query Entities\" operation is to be performed (as per clause 5.7.2). 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type.  |  |
|**entities** | [**List&lt;EntitySelector&gt;**](EntitySelector.md) | Entity ids, id pattern and Entity types that shall be matched by Entities in order to be retrieved.  |  [optional] |
|**attrs** | **List&lt;String&gt;** | List of Attributes that shall be matched by Entities in order to be retrieved. If not present all Attributes will be retrieved.  |  [optional] |
|**q** | **String** | Query that shall be matched by Entities in order to be retrieved.  |  [optional] |
|**geoQ** | [**GeoQuery**](GeoQuery.md) |  |  [optional] |
|**csf** | **String** | Context source filter that shall be matched by Context Source Registrations describing Context Sources to be used for retrieving Entities.  |  [optional] |
|**scopeQ** | **String** | Scope query. |  [optional] |
|**lang** | **String** | Language filter to be applied to the query (clause 4.15). |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| QUERY | &quot;Query&quot; |



