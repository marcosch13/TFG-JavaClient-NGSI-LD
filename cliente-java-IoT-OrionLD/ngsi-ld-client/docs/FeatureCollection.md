

# FeatureCollection

5.2.30 This data type represents a list of spatially bounded Entities in GeoJSON format, as mandated by IETF RFC 7946. 

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



