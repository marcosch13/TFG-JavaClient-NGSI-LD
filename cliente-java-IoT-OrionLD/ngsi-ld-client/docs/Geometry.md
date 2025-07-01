

# Geometry

A valid GeoJSON geometry object (as mandated by RFC7946). 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**type** | [**TypeEnum**](#TypeEnum) |  |  [optional] |
|**coordinates** | [**List&lt;GeometryLineString&gt;**](GeometryLineString.md) |  |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| POINT | &quot;Point&quot; |
| MULTI_POINT | &quot;MultiPoint&quot; |
| POLYGON | &quot;Polygon&quot; |
| LINE_STRING | &quot;LineString&quot; |
| MULTI_LINE_STRING | &quot;MultiLineString&quot; |
| MULTI_POLYGON | &quot;MultiPolygon&quot; |



