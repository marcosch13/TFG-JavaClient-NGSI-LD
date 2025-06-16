package mi_proyecto;

import org.openapitools.client.model.HasHumiditySensor;
import org.openapitools.client.model.HasTemperatureSensor;
import org.openapitools.client.model.QueryEntity200ResponseInner;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.Entity;
import org.openapitools.client.Configuration;

import java.net.URI;
import java.util.Scanner;

public class UpdateIotEntity{
    public static void main(String[] args){
        try {

            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            String tempSensorId = (args != null && args.length > 1) ? args[1]: null;
            String humSensorId = (args != null && args.length > 2) ? args[2] : null;

            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);
            String idFormateado2 = null;
            String idFormateado3 = null;

            if(tempSensorId != null){
                int num2 = Integer.parseInt(tempSensorId);
                idFormateado2 = String.format("%03d", num2);
            }
            
            if(humSensorId != null){
                int num3 = Integer.parseInt(humSensorId);
                idFormateado3 = String.format("%03d", num3);
            }

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            boolean existe = false;

            try {
                URI entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce la descripción para el dispositivo IoT: ");
            String descripcion = scanner.nextLine();    

            Entity fragmento = new Entity();

            if(tempSensorId != null){
            //Crear relación con el sensor de temperatura
            HasTemperatureSensor tempSensor = new HasTemperatureSensor();
            tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
            tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + idFormateado2);
            fragmento.putAdditionalProperty("hasTemperatureSensor", tempSensor);
            }
            if(humSensorId != null){
            //Crear relación con el sensor de humedad
            HasHumiditySensor humSensor = new HasHumiditySensor();
            humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
            humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + idFormateado3);
            fragmento.putAdditionalProperty("hasHumiditySensor", humSensor);
            }

            
            fragmento.putAdditionalProperty("description", descripcion);

            
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            URI entityId = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
            ApiResponse<Void> response = apiInstance.appendAttrsWithHttpInfo(entityId, null, null, null, null, null, fragmento);
            System.out.println("respuesta: " + response.getStatusCode());
            
        }  
        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
}