package mi_proyecto;

import org.openapitools.client.model.HasHumiditySensor;
import org.openapitools.client.model.HasTemperatureSensor;
import org.openapitools.client.model.IotDevice;
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
            Scanner scanner = new Scanner(System.in);
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

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

                System.out.print("¿Qué propiedad quieres añadir a la entidad? :  hasTemperatureSensor, hasHumiditySensor");
                String propiedadElegida = scanner.nextLine();

                
                IotDevice fragmento = new IotDevice();

                if(propiedadElegida.equals("hasTemperatureSensor")){
                    System.out.println("Introduce el id del sensor de temperatura: ");
                    String identificador = scanner.nextLine();
                    HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                    tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                    tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + identificador);
                    fragmento.setHasTemperatureSensor(tempSensor);
                }else if(propiedadElegida.equals("hasHumiditySensor")){
                    System.out.println("Introduce el id del sensor de humedad: ");
                    String identificador = scanner.nextLine();
                    HasHumiditySensor humSensor = new HasHumiditySensor();
                    humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                    humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + identificador);
                    fragmento.setHasHumiditySensor(humSensor);
                }
                

                Entity fragmentoEntity = Entity.fromJson(fragmento.toJson());


            
                ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

                URI entityId = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
                ApiResponse<Void> response = apiInstance.appendAttrsWithHttpInfo(entityId, null, null, null, null, null, fragmentoEntity);
                System.out.println("respuesta: " + response.getStatusCode());
            
            }  
        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
}