package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;
import org.openapitools.client.model.Temperature;
import org.openapitools.client.model.TemperatureSensor;

public class CreateTemperatureSensorEntity {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            boolean existe = false;

            try {
                URI entityUri = new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {
                System.out.println("La entidad ya existe. ¿Desea sobreescribirla? (s/n)");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.println("Se procederá a sobreescribir la entidad.");
                    UpdateTemperatureSensor.main(new String[]{idFormateado});
                } else {
                    System.out.println("No se sobreescribirá la entidad.");
                    return;
                }
            }else{

                // Creo entidad TemperatureSensor
                TemperatureSensor sensor = new TemperatureSensor();
                sensor.setId(new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado));
                sensor.setType(TemperatureSensor.TypeEnum.TEMPERATURE_SENSOR);
                sensor.setTemperature(new Temperature()
                    .type(Temperature.TypeEnum.PROPERTY)
                    .value(BigDecimal.valueOf(27.9)) 
                    .unitCode("CEL")
                );

                // Convertir a JSON
                String json = sensor.toJson();
                System.out.println("Payload JSON:\n" + json);

                
                //Paso a entidad NGSI-LD genérica
                QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(json);

                ContextInformationProvisionApi api = new ContextInformationProvisionApi(apiClient);

                //Crear la entidad usando la API
                ApiResponse<Void> response = api.createEntityWithHttpInfo(null, null, null, entity);

                //obtener respuesta del context broker y mostrarla
                System.out.println("Código de respuesta: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.err.println("Error al crear la entidad TemperatureSensor:");
            e.printStackTrace();
        }
    }
    
}
