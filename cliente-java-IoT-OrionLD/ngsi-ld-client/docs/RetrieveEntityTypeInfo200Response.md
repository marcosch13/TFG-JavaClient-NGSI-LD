

# RetrieveEntityTypeInfo200Response


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Fully Qualified Name (FQN) of the entity type being described.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type.  |  |
|**typeName** | **String** | Name of the entity type, short name if contained in @context.  |  |
|**entityCount** | **BigDecimal** | Number of entity instances of this entity type.  |  |
|**attributeDetails** | [**List&lt;Attribute&gt;**](Attribute.md) | List of attributes that entity instances with the specified entity type can have.  |  |
|**atContext** | [**LdContext**](LdContext.md) |  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ENTITY_TYPE_INFO | &quot;EntityTypeInfo&quot; |



