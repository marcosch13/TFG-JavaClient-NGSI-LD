

# Feature

5.2.29 This data type represents a spatially bounded Entity in GeoJSON format, as mandated by IETF RFC 7946. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Entity id.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | GeoJSON Type.  |  |
|**geometry** | [**Geometry**](Geometry.md) |  |  |
|**properties** | **FeatureProperties** |  |  |
|**atContext** | [**LdContext**](LdContext.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| FEATURE | &quot;Feature&quot; |



