

# BatchEntityError

5.2.17 This datatype represents an error raised (associated to a particular Entity) during the execution of a batch or distributed operation. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**entityId** | **URI** | Entity Id corresponding to the Entity in error.  |  |
|**registrationId** | **URI** | Registration Id corresponding to a failed distributed operation (optional).  |  [optional] |
|**error** | [**ProblemDetails**](ProblemDetails.md) |  |  |



