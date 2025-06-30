package mi_proyecto;

import java.net.URI;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;

public class retrieveEntityById {

    public static void main(String[] args) {
        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Elige el tipo de entidad (1: IotDevice  2: HumiditySensor  3: TemperatureSensor)");
            String tipo = scanner.nextLine();
            System.out.println("Indica el número final del id de la entidad: ");
            String id = scanner.nextLine();
            int idNumero = Integer.parseInt(id);
            String idFormateado = String.format("%03d", idNumero);

            URI entityUri = null;
            if(tipo.equals("1")){
                entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
            }else if(tipo.equals("2")){
                entityUri = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
            }else if(tipo.equals("3")){
                entityUri = new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado);
            }

            System.out.println("\n Consultando entidad con id: " + entityUri);
            try {
                QueryEntity200ResponseInner entidad = apiInstance.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null); 
                System.out.println("Entidad encontrada:" + entidad.toJson());
    
            } catch (Exception e) {
                System.out.println("La entidad no existe");
            }
            
                        
            
        }
       
        catch (Exception e) {
            System.err.println("Error al consultar entidades:");
            e.printStackTrace();
        }
    }

    
}
