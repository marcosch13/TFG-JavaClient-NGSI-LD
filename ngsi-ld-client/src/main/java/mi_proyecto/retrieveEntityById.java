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
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);

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

            System.out.println("\n[+] Consultando entidad con id: " + entityUri);
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
