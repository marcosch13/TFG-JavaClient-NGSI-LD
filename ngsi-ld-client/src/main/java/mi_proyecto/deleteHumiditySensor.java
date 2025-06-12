package mi_proyecto;

import java.net.URI;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class deleteHumiditySensor {
    public static void main(String[] args) {
        try {
            
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            
            
            URI entityId = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
            System.out.println("[+] Borrando entidad con ID: " + entityId);

        
            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

          
            ApiResponse<Void> response = apiInstance.deleteEntityWithHttpInfo(entityId, null, null, null, null);
            System.out.println("respuesta: " + response.getStatusCode());

            
        } catch (Exception e) {
            System.err.println("Error al borrar la entidad:");
            e.printStackTrace();
        }
    }
}
