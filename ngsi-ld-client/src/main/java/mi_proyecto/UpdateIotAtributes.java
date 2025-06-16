package mi_proyecto;

import java.net.URI;
import java.util.Map;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.Entity;
import org.openapitools.client.model.HasHumiditySensor;
import org.openapitools.client.model.HasTemperatureSensor;
import org.openapitools.client.model.QueryEntity200ResponseInner;

public class UpdateIotAtributes {
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
                URI entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {


            URI entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
            
            Entity editable = Entity.fromJson(entidad.toJson());
            
            Map<String, Object> atributos = editable.getAdditionalProperties();
            for (String key : atributos.keySet()) {
                System.out.println("Atributo:" + key);
            }

            System.out.print("¿Qué propiedad quieres actualizar?: ");
            String propiedad = scanner.nextLine();

            if (atributos.containsKey(propiedad)) {
                System.out.print("Introduce el nuevo valor para '" + propiedad + "': ");
                String nuevoValor = scanner.nextLine();

                if(propiedad.equals("hasTemperatureSensor")){
                    HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                    tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                    tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + nuevoValor);
                    editable.putAdditionalProperty("hasTemperatureSensor", tempSensor);
                }else if(propiedad.equals("hasHumiditySensor")){
                    HasHumiditySensor humSensor = new HasHumiditySensor();
                    humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                    humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + nuevoValor);
                    editable.putAdditionalProperty("hasHumiditySensor", humSensor);
                }else{
                    editable.putAdditionalProperty(propiedad, nuevoValor);
                }

                
                ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(entidad.getId(), null, null, null, null,editable);

                System.out.println("Código de respuesta: " + response.getStatusCode());
            } else {
                System.out.println("Esa propiedad no existe en la entidad.");
            }
        }

            
        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
}
