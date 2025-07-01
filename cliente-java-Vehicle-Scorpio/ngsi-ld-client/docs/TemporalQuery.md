

# TemporalQuery

5.2.21 This datatype represents a temporal query. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timerel** | [**TimerelEnum**](#TimerelEnum) | Allowed values: \&quot;before\&quot;, \&quot;after\&quot; and \&quot;between\&quot;.  |  |
|**timeAt** | **OffsetDateTime** | It shall be a DateTime.  |  |
|**endTimeAt** | **OffsetDateTime** | It shall be a DateTime. Cardinality shall be 1 if timerel is equal to \&quot;between\&quot;.  |  [optional] |
|**timeproperty** | [**TimepropertyEnum**](#TimepropertyEnum) | Allowed values: \&quot;observedAt\&quot;, \&quot;createdAt\&quot;, \&quot;modifiedAt\&quot; and \&quot;deletedAt\&quot;. If not specified, the default is \&quot;observedAt\&quot;. (See clause 4.8).  |  [optional] |



## Enum: TimerelEnum

| Name | Value |
|---- | -----|
| BEFORE | &quot;before&quot; |
| AFTER | &quot;after&quot; |
| BETWEEN | &quot;between&quot; |



## Enum: TimepropertyEnum

| Name | Value |
|---- | -----|
| OBSERVED_AT | &quot;observedAt&quot; |
| CREATED_AT | &quot;createdAt&quot; |
| MODIFIED_AT | &quot;modifiedAt&quot; |
| DELETED_AT | &quot;deletedAt&quot; |



