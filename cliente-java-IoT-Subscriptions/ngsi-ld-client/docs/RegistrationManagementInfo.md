

# RegistrationManagementInfo

5.2.34 This type represents the data to alter the default behaviour of a Context Broker when making a distributed operation request to a registered Context Source. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**localOnly** | **Boolean** | If localOnly&#x3D;true then distributed operations associated to this Context Source Registration will act only on data held directly by the registered Context Source itself (see clause 4.3.6.4).  |  [optional] |
|**cacheDuration** | **String** | Minimal period of time which shall elapse between two consecutive context information consumption operations (as defined in clause 5.7) related to the same context data will occur. If the cacheDuration latency period has not been reached, a cached value for the entity or its attributes shall be returned where available.  |  [optional] |
|**timeout** | **BigDecimal** | Maximum period of time in milliseconds which may elapse before a forwarded request is assumed to have failed.  |  [optional] |
|**cooldown** | **BigDecimal** | Minimum period of time in milliseconds which shall elapse before attempting to make a subsequent forwarded request to the same endpoint after failure. If requests are received before the cooldown period has expired, a timeout error response for the registration is automatically returned.  |  [optional] |



