package mi_proyecto;

import java.net.URI;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationProvisionApi;

public class deleteEntity {
    @SuppressWarnings("ConvertToStringSwitch")
    public static void main(String[] args) {
        try {
            
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);
           
            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Elige el tipo de entidad (1: IotDevice   2: HumiditySensor    3: TemperatureSensor)");
            String tipo = scanner.nextLine();
            URI entityUri = null;
            if(tipo.equals("1")){
                entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
            }else if(tipo.equals("2")){
                entityUri = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
            }else if(tipo.equals("3")){
                entityUri = new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado);
            }

            System.out.println("\n[+] Eliminando entidad con id: " + entityUri);
          
            ApiResponse<Void> response = apiInstance.deleteEntityWithHttpInfo(
            entityUri, null, null, null, null);
            System.out.println("respuesta: " + response.getStatusCode());

            
        } catch (Exception e) {
            System.err.println("Error al borrar la entidad:");
            e.printStackTrace();
        }
    }
}
