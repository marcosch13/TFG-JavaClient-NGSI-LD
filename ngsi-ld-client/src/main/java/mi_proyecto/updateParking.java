

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
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
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
            
            System.out.println("¿Cuantas propiedades quieres actualizar?");
            int numPropiedades = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numPropiedades; i++) {
                System.out.println("Propiedades disponibles: " + atributos.keySet());
                System.out.print("¿Qué propiedad quieres actualizar?: ");
                String propiedad = scanner.nextLine();
                if (atributos.containsKey(propiedad)) {
                    if(propiedad.equals("name")){ //el id no se puede cambiar...
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
                    }else if(propiedad.equals("operatedBy")){
                        System.out.println("Introduce el nombre de la compañia que opera el parking");
                        String idCompany = scanner.nextLine();

                        boolean existeCompany = false;
                        try {
                            URI entityUri = new URI("urn:ngsi-ld:Company:" + idCompany);
                            QueryEntity200ResponseInner entidadComprobar = consumoApi.retrieveEntity(
                            entityUri, null, null, null, null, null, null, null, null);
                            existeCompany = true;
                        } catch (ApiException e){}
                        if(existeCompany){
                            
                            OperatedBy operatedBy = new OperatedBy();
                            operatedBy.setObject("urn:ngsi-ld:Company:" + idCompany);
                            editable.putAdditionalProperty("operatedBy", operatedBy);
                            
                        }else{
                            System.out.println("La compañia no existe.");
                        }
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
