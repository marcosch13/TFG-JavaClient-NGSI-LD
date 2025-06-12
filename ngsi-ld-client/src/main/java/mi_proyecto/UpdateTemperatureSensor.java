package mi_proyecto;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.Entity;
import org.openapitools.client.model.QueryEntity200ResponseInner;

import java.net.URI;
import java.util.Scanner;
import java.math.BigDecimal;

public class UpdateTemperatureSensor {
    public static void main(String[] args) {
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : null;
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            Scanner scanner = new Scanner(System.in);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            boolean existe = false;

            try {
                URI entityUri = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {
                System.out.print("Introduce el nuevo valor de temperatura: ");
                BigDecimal nuevaTemperatura = new BigDecimal(scanner.nextLine());

                Entity fragmento = new Entity();

                fragmento.putAdditionalProperty("temperature", nuevaTemperatura);

                ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

                URI entityId = new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado);
                ApiResponse<Void> response = apiInstance.appendAttrsWithHttpInfo(entityId, null, null, null, null, null, fragmento);
                System.out.println("respuesta: " + response.getStatusCode());
            } else {
                System.out.println("La entidad no existe.");
            }

            
            
        } catch (Exception e) {
            System.err.println("Error al actualizar el sensor de temperatura:");
            e.printStackTrace();
        }
    }
}