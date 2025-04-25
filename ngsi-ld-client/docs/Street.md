

# Street

NGSI-LD LanguageProperty Type. The vehicle street. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | Node type.  |  [optional] |
|**languageMap** | **Object** |  |  |
|**observedAt** | **OffsetDateTime** | It is defined as the temporal Property at which a certain Property or Relationship became valid or was observed. For example, a temperature Value was measured by the sensor at this point in time.  |  [optional] |
|**datasetId** | **URI** | It allows identifying a set or group of property values.  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**instanceId** | **URI** | A URI uniquely identifying a Property instance, as mandated by (see clause 4.5.7). System generated.  |  [optional] [readonly] |
|**previousLanguageMap** | **Object** | Previous Language Property languageMap. Only used in notifications, if the showChanges  option is explicitly requested.  |  [optional] [readonly] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| LANGUAGE_PROPERTY | &quot;LanguageProperty&quot; |



