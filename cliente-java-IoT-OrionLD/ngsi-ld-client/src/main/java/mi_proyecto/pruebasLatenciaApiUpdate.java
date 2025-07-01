package mi_proyecto;

import java.net.URI;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;

public class pruebasLatenciaApiUpdate {

    public static void main(String[] args) {
        int repeticiones = 1000;
        String archivo = "latenciasApiUpdate.csv";
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("iteracion,latencia_ms");

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);
    
            for (int i = 0; i < repeticiones; i++) {
                try {
                    long inicio = System.nanoTime();
                    
                    HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                    tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                    tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:001");
                    HasHumiditySensor humSensor = new HasHumiditySensor();
                    humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                    humSensor.setObject("urn:ngsi-ld:HumiditySensor:001");

                    IotDevice device = new IotDevice();
                    URI id = new URI("urn:ngsi-ld:IotDevice:001");
                    device.setId(id);
                    device.setType(IotDevice.TypeEnum.IOT_DEVICE);
                    device.setDescription(new IotDescription().value("IoT device with humidity and temperature sensors"));
                    device.setHasTemperatureSensor(tempSensor);
                    device.setHasHumiditySensor(humSensor);

                    
                    Entity entidadActualizada = Entity.fromJson(device.toJson());

                    ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(
                        id, null, null, null, null,entidadActualizada);

                    //System.out.println("Respuesta de la API: " + response.getStatusCode());
                    
                    long fin = System.nanoTime();
    
                    double duracionMs = (fin - inicio) / 1_000_000; 
    
                    writer.printf("%d;%.3f\n", i + 1,duracionMs);
    
                    Thread.sleep(100); 
                } catch (Exception e) {
                    System.out.println("Error en la iteración " + (i + 1) + ": " + e.getMessage());
                    writer.printf("%d,ERROR,ERROR,-1\n", i + 1);
                }
            }
    
            System.out.println("Archivo CSV generado con éxito: " + archivo);
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}