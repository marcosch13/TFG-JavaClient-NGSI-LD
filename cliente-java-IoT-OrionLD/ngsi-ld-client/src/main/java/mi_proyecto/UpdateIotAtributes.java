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
import org.openapitools.client.model.*;


public class UpdateIotAtributes {
    
    public static void main(String[] args){
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
                
                
                IotDevice editableIot = IotDevice.fromJson(entidad.toJson());

                System.out.print("¿Qué propiedad quieres actualizar?: ");
                if(editableIot.getHasHumiditySensor() != null){   
                    System.out.println("hasHumiditySensor: ");
                } 
                if (editableIot.getHasTemperatureSensor() != null) {
                    System.out.println("hasTemperatureSensor: ");
                }  
                System.out.println("description: ");
                String propiedad = scanner.nextLine();
                

                if (propiedad.equals("hasHumiditySensor") || propiedad.equals("hasTemperatureSensor") || propiedad.equals("description")) {
                    System.out.print("Introduce el nuevo valor para '" + propiedad + "': ");
                    String nuevoValor = scanner.nextLine();

                    if(propiedad.equals("hasTemperatureSensor")){
                        int numH = Integer.parseInt(nuevoValor);
                        String idFormateadoH = String.format("%03d", numH);
                        HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                        tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                        tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + idFormateadoH);
                        editableIot.setHasTemperatureSensor(tempSensor);
                    }else if(propiedad.equals("hasHumiditySensor")){
                        int numT = Integer.parseInt(nuevoValor);
                        String idFormateadoT = String.format("%03d", numT);
                        HasHumiditySensor humSensor = new HasHumiditySensor();
                        humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                        humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + idFormateadoT);
                        editableIot.setHasHumiditySensor(humSensor);
                    }else{
                        editableIot.setDescription(new IotDescription().value(nuevoValor));
                    }
                    
                    Entity entidadActualizada = Entity.fromJson(editableIot.toJson());

                    ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(
                        entityUri, null, null, null, null,entidadActualizada);

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