

package mi_proyecto;

import java.net.URI;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;

public class updateParking{
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);


            System.out.println("Que parking desea actualizar?");
            String nombreParking = scanner.nextLine();
            URI entityUri3 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
            boolean existeParking = false;
            try {
                QueryEntity200ResponseInner entidadParking = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
                existeParking = true;
            } catch (ApiException e){}
            if(existeParking){
                System.out.println("El nombre del parking es corecto");
            }else{
                System.out.println("El parking no existe, por favor registrelo primero");
                return;
            }

           


            
            QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
            
            Entity editable = Entity.fromJson(entidad.toJson());
            
            Map<String, Object> atributos = editable.getAdditionalProperties();
            for (String key : atributos.keySet()) {
                System.out.println("Atributo:" + key);
            }
            System.out.println("¿Cuantas propiedades quieres actualizar?");
            int numPropiedades = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numPropiedades; i++) {
                System.out.print("¿Qué propiedad quieres actualizar?: ");
                String propiedad = scanner.nextLine();
                if (atributos.containsKey(propiedad)) {
                    if(propiedad.equals("name")){
                        Name name = new Name();
                        System.out.println("Introduce el nuevo nombre del parking");
                        String nuevoValor = scanner.nextLine();
                        name.setValue(nuevoValor);
                        editable.putAdditionalProperty("name", name);
                    }else if(propiedad.equals("totalSpotNumber")){
                        TotalSpotNumber totalSpotNumber = new TotalSpotNumber();
                        System.out.println("Introduce el nuevo número total de plazas");
                        BigDecimal nuevoValor = new BigDecimal(scanner.nextLine());  
                        totalSpotNumber.setValue(nuevoValor);
                        editable.putAdditionalProperty("totalSpotNumber", totalSpotNumber);
                    }
                }else {
                    System.out.println("Esa propiedad no existe en la entidad.");
                }
            }
            ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(entidad.getId(), null, null, null, null,editable);

            System.out.println("Código de respuesta: " + response.getStatusCode());

        
        

            
        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
    
}
