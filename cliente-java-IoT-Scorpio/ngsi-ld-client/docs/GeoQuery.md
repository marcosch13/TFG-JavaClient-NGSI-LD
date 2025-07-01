

# GeoQuery

5.2.13 This datatype represents a geoquery used for Subscriptions. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**geometry** | **String** | Type of the reference geometry.  |  |
|**coordinates** | [**GeoQueryCoordinates**](GeoQueryCoordinates.md) |  |  |
|**georel** | **String** | Geo-relationship (near, within, etc.).  |  |
|**geoproperty** | **String** | Specifies the GeoProperty to which the GeoQuery is to be applied. If not present, the default GeoProperty is location.  |  [optional] |



