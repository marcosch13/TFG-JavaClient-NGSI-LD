

# RetrieveEntityTypes200Response1OneOf1Inner


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **URI** | Fully Qualified Name (FQN) of the entity type being described.  |  |
|**type** | [**TypeEnum**](#TypeEnum) | JSON-LD @type.  |  |
|**typeName** | **String** | Name of the entity type, short name if contained in @context.  |  |
|**attributeNames** | **List&lt;String&gt;** | List containing the names of attributes that instances of the entity type can have.  |  |
|**atContext** | [**LdContext**](LdContext.md) |  |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| ENTITY_TYPE | &quot;EntityType&quot; |



