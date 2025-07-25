package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Scanner;
import java.util.List;
import java.time.ZoneOffset;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;


public class addAvailableSpot {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            OffsetDateTime observedAt = OffsetDateTime.now(ZoneOffset.UTC).withNano(0);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            boolean existeParking = false;
            System.out.println("En que parking desea registrar un AvailableSpotNumber?");
            String nombreParking = scanner.nextLine();

            URI entityUri3 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
            QueryEntity200ResponseInner entidadParking = null;
            try {
                entidadParking = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
                existeParking = true;
            } catch (ApiException e){}

            if(existeParking){
                System.out.println("El nombre del parking es corecto");
            }else{
                System.out.println("El parking no existe, por favor registrelo primero");
                return;
            }

            
            System.out.println("Indica cuántos spots disponibles hay en el parking");
            int numSpots = Integer.parseInt(scanner.nextLine());
            OffStreetParking fragment0 = new OffStreetParking();
            for(int i = 0; i < numSpots; i++) {
                System.out.println("Añadiendo spot " + (i+1) + " de " + numSpots);
                System.out.print("Introduce el id de la cámara que registra el AvailableSpot: ");
                String idCamara = scanner.nextLine();
                
                boolean existeCamara = false;
                try {
                    URI entityUri2 = new URI("urn:ngsi-ld:Camera:C" + idCamara);
                    QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                    entityUri2, null, null, null, null, null, null, null, null);
                    existeCamara = true;
                } catch (ApiException e){}
                if(!existeCamara){
                    System.out.println("La cámara no existe.");
                    continue;
                }

                System.out.print("Introduce el spotNumber disponible: ");
                int spotNumber1 = Integer.parseInt(scanner.nextLine());
                BigDecimal spotNumber = BigDecimal.valueOf(spotNumber1);

                AvailableSpotNumber availableSpotNumber = new AvailableSpotNumber();
                availableSpotNumber.setValue(spotNumber);
                availableSpotNumber.setReliability(new Reliability().value(new BigDecimal(0.95)));
                availableSpotNumber.setObservedAt(observedAt); 

                URI entityUriProvidedBy = new URI("urn:ngsi-ld:Camera:C" + idCamara);

                ProvidedBy providedBy = new ProvidedBy();
                providedBy.setObject(entityUriProvidedBy);

                availableSpotNumber.setProvidedBy(providedBy);

                fragment0.addAvailableSpotNumbersItem( availableSpotNumber );
            }

            Entity fragmento = Entity.fromJson(fragment0.toJson());
            
            ApiResponse<Void> responsePr = apiInstance.updateEntityWithHttpInfo(entityUri3, null, null, null, null, fragmento);

            System.out.println("Código de respuesta: " + responsePr.getStatusCode());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}    
