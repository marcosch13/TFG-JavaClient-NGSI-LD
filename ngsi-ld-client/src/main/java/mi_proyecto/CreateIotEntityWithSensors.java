package mi_proyecto;

import org.openapitools.client.model.IotDevice;
import org.openapitools.client.model.QueryEntity200ResponseInner;
import org.openapitools.client.model.IotDescription;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.HasHumiditySensor;
import org.openapitools.client.model.HasTemperatureSensor;
import java.net.URI;


public class CreateIotEntityWithSensors{
    public static void main(String[] args){
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            String tempSensorId = (args != null && args.length > 1) ? args[1] : "001";
            String humSensorId = (args != null && args.length > 2) ? args[2] : "001";

            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);
            int num2 = Integer.parseInt(tempSensorId);
            String idFormateado2 = String.format("%03d", num2);
            int num3 = Integer.parseInt(humSensorId);
            String idFormateado3 = String.format("%03d", num3);

            //Creo entidad IotDevice
            IotDevice device = new IotDevice();
            device.setId(new URI("urn:ngsi-ld:IotDevice:" + idFormateado));
            device.setType(IotDevice.TypeEnum.IOT_DEVICE);
            device.setDescription(new IotDescription().value("IoT device with humidity and temperature sensors"));

            //Crear relación con el sensor de temperatura
            HasTemperatureSensor tempSensor = new HasTemperatureSensor();
            tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
            tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + idFormateado2);
            
            //Crear relación con el sensor de humedad
            HasHumiditySensor humSensor = new HasHumiditySensor();
            humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
            humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + idFormateado3);

            //Añadir las relaciones a la entidad
            device.setHasTemperatureSensor(tempSensor);
            device.setHasHumiditySensor(humSensor);

            
            //Convertir a JSON
            String json = device.toJson();
            System.out.println("Payload JSON:\n" + json);

            
            //Paso a entidad NGSI-LD genérica
            QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(json);

            // Crear cliente y api
            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationProvisionApi api = new ContextInformationProvisionApi(apiClient);

            //Crear la entidad usando la API
             ApiResponse<Void> response = api.createEntityWithHttpInfo(null, null, null, entity);

            //obtener respuesta del context broker y mostrarla
            System.out.println("Código de respuesta: " + response.getStatusCode());

        } catch (Exception e) {
            System.err.println("Error al crear la entidad:");
            e.printStackTrace();
        }
    }
}