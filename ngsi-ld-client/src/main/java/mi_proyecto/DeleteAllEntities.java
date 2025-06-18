package mi_proyecto;

import java.util.List;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;

public class DeleteAllEntities {
    public static void main(String[] args) {
        try{
            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi api = new ContextInformationProvisionApi(apiClient);

            List<QueryEntity200ResponseInner> entidades = apiInstance.queryEntity(
                    null, null, null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, true, null, null);
            System.out.println("Entidades encontradas: " + entidades.size());
                    

            for (QueryEntity200ResponseInner e : entidades) {
                api.deleteEntityWithHttpInfo(e.getId(), null, null, null, null);
            }
        }catch (Exception e) {
        System.out.println("Error al eliminar las entidades: " + e.getMessage());
        } 




}}
