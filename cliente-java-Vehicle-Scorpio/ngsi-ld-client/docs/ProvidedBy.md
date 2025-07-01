

# ProvidedBy

NGSI-LD Relationship type to identify the entity that provides something (i.e., the identifier of an NGSI-LD Entity of particular type). 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Node type.  |  [optional] |
|**_object** | **URI** |  |  |
|**observedAt** | **OffsetDateTime** | It is defined as the temporal Property at which a certain Property or Relationship became valid or was observed. For example, a temperature Value was measured by the sensor at this point in time.  |  [optional] |
|**datasetId** | **URI** | It allows identifying a set or group of target relationship objects.  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**instanceId** | **URI** | A URI uniquely identifying a Relationship instance (see clause 4.5.8). System generated.  |  [optional] [readonly] |
|**previousObject** | **URI** | Previous Relationship&#39;s target object. Only used in notifications, if the showChanges  option is explicitly requested.  |  [optional] [readonly] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| RELATIONSHIP | &quot;Relationship&quot; |



