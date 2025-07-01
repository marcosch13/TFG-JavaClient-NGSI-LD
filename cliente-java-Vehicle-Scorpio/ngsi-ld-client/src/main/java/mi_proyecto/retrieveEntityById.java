package mi_proyecto;

import java.net.URI;
import java.util.List;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;

public class retrieveEntityById {
    public static void main(String[] args) {
        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Elige el tipo de entidad (1: OffStreetParking   2: Vehicle     3: Person   4: City   5: Camera   6:Company)");
            String tipo = scanner.nextLine();
            URI entityUri = null;
            if(tipo.equals("1")){
                System.out.println("Introduce el nombre del parking:");
                String nombreParking = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
            }else if(tipo.equals("2")){
                System.out.println("Introduce la matrícula del vehículo:");
                String matricula = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:Vehicle:" + matricula);
            }else if(tipo.equals("3")){
                System.out.println("Introduce el nombre de la persona:");
                String nombrePersona = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:Person:" + nombrePersona);
            }else if(tipo.equals("4")){
                System.out.println("Introduce el nombre de la ciudad:");
                String nombreCiudad = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:City:" + nombreCiudad);
            }else if(tipo.equals("5")){
                System.out.println("Introduce el id de la cámara:");
                String idCamara = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:Camera:C" + idCamara);
            }else if(tipo.equals("6")){
                System.out.println("Introduce el nombre de la compañía:");
                String nombreCompania = scanner.nextLine();
                entityUri = new URI("urn:ngsi-ld:Company:" + nombreCompania);
            }

            System.out.println("\n[+] Consultando entidad con id: " + entityUri);
            try {
                QueryEntity200ResponseInner entidad = apiInstance.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null); 
                System.out.println("Entidad encontrada:" + entidad.toJson());
    
            } catch (Exception e) {
                System.out.println("La entidad no existe");
            }
            
                        
        }catch (Exception e) {
            System.err.println("Error al consultar entidades:");
            e.printStackTrace();
        }
    }
}
