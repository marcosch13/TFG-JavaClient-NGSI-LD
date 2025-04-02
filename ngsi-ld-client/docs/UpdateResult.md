

# UpdateResult

5.2.18 This datatype represents the result of Attribute update (append or update) operations in the NGSI-LD API regardless of whether local or distributed. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**updated** | **List&lt;String&gt;** | List of Attributes (represented by their Name) that were appended or updated.  |  |
|**notUpdated** | [**List&lt;NotUpdatedDetails&gt;**](NotUpdatedDetails.md) | List which contains the Attributes (represented by their Name) that were not updated, together with the reason for not being updated.  |  |



