

# TemperatureSensor

NGSI-LD Entity Type that represents a temperature sensor. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Entity id.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | NGSI-LD Entity identifier. It has to be TemperatureSensor. |  |
|**scope** | [**EntityScope**](EntityScope.md) |  |  [optional] |
|**location** | **GeoProperty** |  |  [optional] |
|**observationSpace** | **GeoProperty** |  |  [optional] |
|**operationSpace** | **GeoProperty** |  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**temperature** | [**Temperature**](Temperature.md) |  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEMPERATURE_SENSOR | &quot;TemperatureSensor&quot; |



