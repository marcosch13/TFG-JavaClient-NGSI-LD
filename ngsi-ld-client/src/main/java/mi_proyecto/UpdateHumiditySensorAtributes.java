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


public class UpdateHumiditySensorAtributes {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);

            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            boolean existe = false;

            try {
                URI entityUri = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {


                URI entityUri = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
                    QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                    entityUri, null, null, null, null, null, null, null, null);
                
                HumiditySensor editableHum = HumiditySensor.fromJson(entidad.toJson());
                
                System.out.print("¿Qué propiedad quieres actualizar?: ");
                if(editableHum.getHumidity() != null){   
                    System.out.println("humidity: " );
                }
                String propiedad = scanner.nextLine();

                if (propiedad.equals("humidity")) {
                    System.out.print("Introduce el nuevo valor para '" + propiedad + "': ");
                    String nuevoValor = scanner.nextLine();
                    BigDecimal nuevoValorHum = new BigDecimal(nuevoValor);
                    editableHum.setHumidity(new Humidity()
                        .type(Humidity.TypeEnum.PROPERTY)
                        .value(nuevoValorHum)
                        .unitCode("P1"));
                }

                Entity entidadActualizada = Entity.fromJson(editableHum.toJson());

                ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(entidad.getId(), null, null, null, null,entidadActualizada);

                System.out.println("Código de respuesta: " + response.getStatusCode());

            } else {
                System.out.println("Esa propiedad no existe en la entidad.");
            }
        

            
        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
    
}
