

# NotificationData

The content of the notification as NGSI-LD Entities. See clause 5.2.4.  If the notification has been triggered from a Subscription that has the notification. endpoint.accept field set to application/geo+json then data is returned as a FeatureCollection. In this case, if the notification.endpoint.rece iverInfo contains the key \"Prefer\" and it is set to the value \"body=json\", then the FeatureCollection will not contain an @context field.  If endpoint.accept is not set or holds another value then Entity[] is returned. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) | GeoJSON Type.  |  |
|**features** | [**List&lt;Feature&gt;**](Feature.md) | In the case that no matches are found, \&quot;features\&quot; will be an empty array.  |  [optional] |
|**atContext** | [**LdContext**](LdContext.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| FEATURE_COLLECTION | &quot;FeatureCollection&quot; |



