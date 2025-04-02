

# Endpoint

5.2.15 This datatype represents the parameters that are required in order to define an endpoint for notifications. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**uri** | **URI** | URI which conveys the endpoint which will receive the notification.  |  |
|**accept** | [**AcceptEnum**](#AcceptEnum) | Intended to convey the MIME type of the notification payload body (JSON, or JSON-LD, or GeoJSON). If not present, default is \&quot;application/json\&quot;.  |  [optional] |
|**timeout** | **BigDecimal** | Maximum period of time in milliseconds which may elapse before a notification is assumed to have failed. The NGSI-LD system can override this value. This only applies if the binding protocol always returns a  response.  |  [optional] |
|**cooldown** | **BigDecimal** | Once a failure has occurred, minimum period of time in milliseconds which shall elapse before attempting to make a subsequent notification to the same endpoint after failure. If requests are received before the cooldown period has expired, no notification is sent.  |  [optional] |
|**receiverInfo** | [**List&lt;KeyValuePair&gt;**](KeyValuePair.md) | Generic {key, value} array to convey optional information to the receiver.  |  [optional] |
|**notifierInfo** | [**List&lt;KeyValuePair&gt;**](KeyValuePair.md) | Generic {key, value} array to set up the communication channel.  |  [optional] |



## Enum: AcceptEnum

| Name | Value |
|---- | -----|
| APPLICATION_JSON | &quot;application/json&quot; |
| APPLICATION_LD_JSON | &quot;application/ld+json&quot; |
| APPLICATION_GEO_JSON | &quot;application/geo+json&quot; |



