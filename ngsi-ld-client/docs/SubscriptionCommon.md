

# SubscriptionCommon

5.2.12 This datatype represents a Context Subscription. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Subscription identifier (JSON-LD @id).  |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type.  |  [optional] |
|**subscriptionName** | **String** | A (short) name given to this Subscription.  |  [optional] |
|**description** | **String** | Subscription description.  |  [optional] |
|**entities** | [**List&lt;EntitySelector&gt;**](EntitySelector.md) | Entities subscribed.  |  [optional] |
|**notificationTrigger** | [**List&lt;NotificationTriggerEnum&gt;**](#List&lt;NotificationTriggerEnum&gt;) | The notification triggers listed indicate what kind of changes shall trigger a notification. If not present, the default is the combination attributeCreated and attributeUpdated. entityUpdated is equivalent to the combination attributeCreated, attributeUpdated and attributeDeleted.  |  [optional] |
|**q** | **String** | Query that shall be met by subscribed entities in order to trigger the notification.  |  [optional] |
|**geoQ** | [**GeoQuery**](GeoQuery.md) |  |  [optional] |
|**csf** | **String** | Context source filter that shall be met by Context Source Registrations describing Context Sources to be used for Entity Subscriptions.  |  [optional] |
|**isActive** | **Boolean** | Allows clients to temporarily pause the subscription by making it inactive. true indicates that the Subscription is under operation. false indicates that the subscription is paused and notifications shall not be delivered.  |  [optional] |
|**notification** | [**NotificationParams**](NotificationParams.md) |  |  [optional] |
|**expiresAt** | **OffsetDateTime** | Expiration date for the subscription.  |  [optional] |
|**temporalQ** | [**TemporalQuery**](TemporalQuery.md) |  |  [optional] |
|**scopeQ** | **String** | Scope query.  |  [optional] |
|**lang** | **String** | Language filter to be applied to the query (clause 4.15).  |  [optional] |
|**createdAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was entered into an NGSI-LD system.  Entity creation timestamp. See clause 4.8.  |  [optional] |
|**modifiedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was last modified in an NGSI-LD system, e.g. in order to correct a previously entered incorrect value.  Entity last modification timestamp. See clause 4.8.  |  [optional] |
|**deletedAt** | **OffsetDateTime** | It is defined as the temporal Property at which the Entity, Property or Relationship was deleted from an NGSI-LD system.  Entity deletion timestamp. See clause 4.8. It is only used in notifications reporting deletions and in the Temporal Representation of Entities (clause 4.5.6), Properties (clause 4.5.7), Relationships (clause 4.5.8) and LanguageProperties (clause 5.2.32).  |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Read-only. Provided by the system when querying the details of a subscription.  |  [optional] [readonly] |
|**jsonldContext** | **URI** | The dereferenceable URI of the JSON-LD @context to be used when sending  a notification resulting from the subscription. If not provided, the @context used for the subscription shall be used as a default.  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| SUBSCRIPTION | &quot;Subscription&quot; |



## Enum: List&lt;NotificationTriggerEnum&gt;

| Name | Value |
|---- | -----|
| ENTITY_CREATED | &quot;entityCreated&quot; |
| ENTITY_UPDATED | &quot;entityUpdated&quot; |
| ENTITY_DELETED | &quot;entityDeleted&quot; |
| ATTRIBUTE_CREATED | &quot;attributeCreated&quot; |
| ATTRIBUTE_UPDATED | &quot;attributeUpdated&quot; |
| ATTRIBUTE_DELETED | &quot;attributeDeleted&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| PAUSED | &quot;paused&quot; |
| EXPIRED | &quot;expired&quot; |



