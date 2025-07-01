

# NotificationParams

5.2.14 This datatype represents the parameters that allow to convey the details of a notification. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**attributes** | **List&lt;String&gt;** | Entity Attribute Names (Properties or Relationships) to be included in the notification payload body. If undefined it will mean all Attributes.  |  [optional] |
|**sysAttrs** | **Boolean** | If true, the system generated attributes createdAt and modifiedAt are included in the response payload body, in the case of a deletion also deletedAt.  |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | Conveys the representation format of the entities delivered at notification time. By default, it will be in the normalized format.  |  [optional] |
|**showChanges** | **Boolean** | If true the previous value (previousValue) of Properties or languageMap (previousLanguageMap) of Language Properties or object (previousObject) of Relationships is provided in addition to the current one. This requires that it exists, i.e. in case of modifications and deletions,  but not in the case of creations. showChanges cannot be true in case format is \&quot;keyValues\&quot;.  |  [optional] |
|**endpoint** | [**Endpoint**](Endpoint.md) |  |  |
|**status** | [**StatusEnum**](#StatusEnum) | Status of the Notification. It shall be \&quot;ok\&quot; if the last attempt to notify the subscriber succeeded. It shall be \&quot;failed\&quot; if the last attempt to notify the subscriber failed.  |  [optional] |
|**timesSent** | **BigDecimal** | Number of times that the notification has been sent. Provided by the system when querying the details of a subscription.  |  [optional] |
|**timesFailed** | **BigDecimal** | Number of times an unsuccessful response (or timeout) has been received when deliverying the notification. Provided by the system when querying the details of a subscription.  |  [optional] |
|**lastNotification** | **OffsetDateTime** | Timestamp corresponding to the instant when the last notification has been sent. Provided by the system when querying the details of a subscription.  |  [optional] |
|**lastFailure** | **OffsetDateTime** | Timestamp corresponding to the instant when the last notification resulting in failure (for instance, in the HTTP binding, an HTTP response code different than 200) has been sent. Provided by the system when querying the details of a subscription.  |  [optional] |
|**lastSuccess** | **OffsetDateTime** | Timestamp corresponding to the instant when the last successful (200 OK response) notification has been sent. Provided by the system when querying the details of a subscription.  |  [optional] |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| NORMALIZED | &quot;normalized&quot; |
| CONCISE | &quot;concise&quot; |
| KEY_VALUES | &quot;keyValues&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| OK | &quot;ok&quot; |
| FAILED | &quot;failed&quot; |



