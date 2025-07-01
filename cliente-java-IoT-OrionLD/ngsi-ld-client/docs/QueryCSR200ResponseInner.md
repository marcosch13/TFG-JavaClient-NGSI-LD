

# QueryCSR200ResponseInner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Unique registration identifier. (JSON-LD @id). There may be multiple registrations per Context Source, i.e. the id is unique per registration.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type Use reserved type for identifying Context Source Registration.  |  |
|**registrationName** | **String** | A name given to this Context Source Registration.  |  [optional] |
|**description** | **String** | A description of this Context Source Registration.  |  [optional] |
|**information** | [**List&lt;RegistrationInfo&gt;**](RegistrationInfo.md) | Describes the Entities, Properties and Relationships for which the Context Source may be able to provide information.  |  |
|**tenant** | **String** | Identifies the tenant that has to be specified in all requests to the Context Source that are related to the information registered in this Context Source Registration. If not present, the default tenant is assumed. Should only be present in systems supporting multi-tenancy.  |  [optional] |
|**observationInterval** | [**TimeInterval**](TimeInterval.md) |  |  [optional] |
|**managementInterval** | [**TimeInterval**](TimeInterval.md) |  |  [optional] |
|**location** | [**Geometry**](Geometry.md) |  |  [optional] |
|**observationSpace** | [**Geometry**](Geometry.md) |  |  [optional] |
|**operationSpace** | [**Geometry**](Geometry.md) |  |  [optional] |
|**expiresAt** | **OffsetDateTime** | Provides an expiration date. When passed the Context Source Registration will become invalid and the Context Source might no longer be available.  |  [optional] |
|**endpoint** | **URI** | Endpoint expressed as dereferenceable URI through which the Context Source exposes its NGSI-LD interface.  |  |
|**contextSourceInfo** | [**List&lt;KeyValuePair&gt;**](KeyValuePair.md) | Generic {key, value} array to convey optional information to provide when contacting the registered Context Source.  |  [optional] |
|**scope** | [**CsourceRegistrationScope**](CsourceRegistrationScope.md) |  |  [optional] |
|**mode** | [**ModeEnum**](#ModeEnum) | The definition of the mode of distributed operation (see clause 4.3.6) supported by the registered Context Source.  |  [optional] |
|**operations** | **List&lt;String&gt;** | The definition limited subset of API operations supported by the registered Context Source.  If undefined, the default set of operations is \&quot;federationOps\&quot; (see clause 4.20).  |  [optional] |
|**refreshRate** | **String** | An indication of the likely period of time to elapse between updates at this registered endpoint. Brokers may optionally use this information to help implement caching.  |  [optional] |
|**management** | [**RegistrationManagementInfo**](RegistrationManagementInfo.md) |  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Read-only. Status of the Registration. It shall be \&quot;ok\&quot; if the last attempt to perform a distributed operation succeeded. It shall be \&quot;failed\&quot; if the last attempt to perform a distributed operation failed.  |  [optional] [readonly] |
|**timesSent** | **BigDecimal** | Number of times that the registration triggered a distributed operation, including failed attempts.  |  [optional] [readonly] |
|**timesFailed** | **BigDecimal** | Number of times that the registration triggered a distributed operation request that failed. |  [optional] [readonly] |
|**lastSuccess** | **OffsetDateTime** | Timestamp corresponding to the instant when the last successfully distributed operation was sent. Created on first successful operation.  |  [optional] [readonly] |
|**lastFailure** | **OffsetDateTime** | Timestamp corresponding to the instant when the last distributed operation resulting in a failure (for instance, in the HTTP binding, an HTTP response code other than 2xx) was returned.  |  [optional] [readonly] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| CONTEXT_SOURCE_REGISTRATION | &quot;ContextSourceRegistration&quot; |



## Enum: ModeEnum

| Name | Value |
|---- | -----|
| INCLUSIVE | &quot;inclusive&quot; |
| EXCLUSIVE | &quot;exclusive&quot; |
| REDIRECT | &quot;redirect&quot; |
| AUXILIARY | &quot;auxiliary&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| OK | &quot;ok&quot; |
| FAILED | &quot;failed&quot; |



