

# Vehicle

NGSI-LD Entity Type that represents a vehicle. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Entity id.  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | NGSI-LD Entity identifier. It has to be Vehicle. |  |
|**scope** | [**EntityScope**](EntityScope.md) |  |  [optional] |
|**location** | **GeoProperty** |  |  [optional] |
|**observationSpace** | **GeoProperty** |  |  [optional] |
|**operationSpace** | **GeoProperty** |  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**brandName** | [**BrandName**](BrandName.md) |  |  |
|**street** | [**Street**](Street.md) |  |  [optional] |
|**isParked** | [**IsParked**](IsParked.md) |  |  |
|**category** | [**Category**](Category.md) |  |  [optional] |
|**tyreTreadDepths** | [**TyreTreadDepths**](TyreTreadDepths.md) |  |  [optional] |
|**passengers** | [**Passengers**](Passengers.md) |  |  [optional] |
|**route** | [**Route**](Route.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| VEHICLE | &quot;Vehicle&quot; |



