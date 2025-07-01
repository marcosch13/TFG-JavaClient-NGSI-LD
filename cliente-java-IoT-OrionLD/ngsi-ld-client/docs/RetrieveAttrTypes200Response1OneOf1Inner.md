

# RetrieveAttrTypes200Response1OneOf1Inner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Full URI of attribute name.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type.  |  |
|**attributeName** | **String** | Name of the attribute, short name if contained in @context.  |  |
|**attributeCount** | **BigDecimal** | Number of attribute instances with this attribute name.  |  [optional] |
|**attributeTypes** | **List&lt;String&gt;** | List of attribute types (e.g. Property, Relationship, GeoProperty) for which entity instances exist, which contain an attribute with this name.  |  [optional] |
|**typeNames** | **List&lt;String&gt;** | List of entity type names for which entity instances exist containing attributes that have the respective name.  |  [optional] |
|**atContext** | [**LdContext**](LdContext.md) |  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ATTRIBUTE | &quot;Attribute&quot; |



