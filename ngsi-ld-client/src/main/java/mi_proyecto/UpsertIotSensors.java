package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;

public class UpsertIotSensors {

    public static void main(String[] args) {
        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);
            
            Scanner scanner = new Scanner(System.in);
            List<QueryEntity200ResponseInner> entidades = new ArrayList<>();

            System.out.print("¿Cuántas entidades deseas crear o actualizar?: ");
            int total = Integer.parseInt(scanner.nextLine());

            boolean actualizarTempSensor = false;
            boolean actualizarHumSensor = false;

            for (int i = 0; i < total; i++) {
                System.out.println("\n[+] Entidad " + (i + 1));

                System.out.print("ID numérico de la entidad: ");
                String idNum = scanner.nextLine();
                String idFormateado = String.format("%03d", Integer.parseInt(idNum));
                List<URI> entityIds = Collections.singletonList(new URI("urn:ngsi-ld:IotDevice:" + idFormateado));

                

                List<QueryEntity200ResponseInner> entidadesQuery = consumoApi.queryEntity(
                    entityIds, "IotDevice", null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, null);

                IotDevice IotEntity;
                if (!entidadesQuery.isEmpty()) {
                    QueryEntity200ResponseInner entidadOriginal = entidadesQuery.get(0);
                    IotEntity = IotDevice.fromJson(entidadOriginal.toJson());
                }else{
                    IotEntity = new IotDevice();
                    IotEntity.setType(IotDevice.TypeEnum.IOT_DEVICE);
                    IotEntity.setId(new URI("urn:ngsi-ld:IotDevice:" + idFormateado));
                }
                TemperatureSensor tempEntity = new TemperatureSensor();
                HumiditySensor humEntity = new HumiditySensor();
                

                System.out.print("¿Añadir o modificar descripción? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.print("Escribe la descripción: ");
                    String descripcion = scanner.nextLine();
                    IotEntity.setDescription(new IotDescription().value(descripcion));
                }

                System.out.print("¿Añadir o modificar sensor de temperatura? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    actualizarTempSensor = true;
                    System.out.print("Introduce el numero final del ID del sensor: ");
                    String tempId = scanner.nextLine(); 
                    int numT = Integer.parseInt(tempId);
                    String idFormateadoT = String.format("%03d", numT);

                    System.out.print("Introduce el valor de la temperatura: ");
                    BigDecimal nuevaTemperatura = new BigDecimal(scanner.nextLine());
                    tempEntity.setTemperature(new Temperature()
                        .type(Temperature.TypeEnum.PROPERTY)
                        .value(nuevaTemperatura) 
                        .unitCode("CEL"));
                    tempEntity.setId(new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateadoT));
                    tempEntity.setType(TemperatureSensor.TypeEnum.TEMPERATURE_SENSOR);

                    HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                    tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                    tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + tempId);
                    IotEntity.setHasTemperatureSensor(tempSensor);
                }

                System.out.print("¿Añadir o modificar sensor de humedad? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    actualizarHumSensor = true;
                    System.out.print("ID del sensor: ");
                    String humId = scanner.nextLine();
                    int numH = Integer.parseInt(humId);
                    String idFormateadoH = String.format("%03d", numH);

                    System.out.print("Introduce el valor de humedad: ");
                    BigDecimal nuevaHumedad = new BigDecimal(scanner.nextLine());
                    humEntity.setHumidity(new Humidity()
                    .type(Humidity.TypeEnum.PROPERTY)
                    .value(nuevaHumedad)
                    .unitCode("P1"));

                    humEntity.setId(new URI("urn:ngsi-ld:HumiditySensor:" + idFormateadoH));
                    humEntity.setType(HumiditySensor.TypeEnum.HUMIDITY_SENSOR);

                    HasHumiditySensor humSensor = new HasHumiditySensor();
                    humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                    humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + humId);
                    IotEntity.setHasHumiditySensor(humSensor);
                }

                //Convertir a JSON
                String jsonIot = IotEntity.toJson();
                System.out.println("Payload JSON:\n" + jsonIot);

                String jsonTSensor = tempEntity.toJson();
                System.out.println("Payload JSON:\n" + jsonTSensor);

                String jsonHSensor = humEntity.toJson();
                System.out.println("Payload JSON:\n" + jsonHSensor);

                //Paso a entidad NGSI-LD genérica
                QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(jsonIot);
                entidades.add(entity);

                if(actualizarTempSensor){
                    QueryEntity200ResponseInner tempEntityQ = QueryEntity200ResponseInner.fromJson(jsonTSensor);
                    entidades.add(tempEntityQ);
                }
                if(actualizarHumSensor){
                    QueryEntity200ResponseInner humEntityQ = QueryEntity200ResponseInner.fromJson(jsonHSensor);
                    entidades.add(humEntityQ);
                }
            }

            
            

            ApiResponse<List<String>> response = apiInstance.upsertBatchWithHttpInfo(null, null, null, null, entidades);
            
            

            System.out.println("\nCódigo de respuesta: " + response.getStatusCode());
            
            if(response.getData() == null || response.getData().isEmpty()) {
                System.out.println("La respuesta está vacía. No hay datos para procesar.");
                
            }else{
                List<String> responseBody = response.getData();
                System.out.println(responseBody);
                System.out.println("Entidades creadas:");
                for (String item : responseBody) {
                    System.out.println(item);
                }
            }
            

            
            

            

        } catch (Exception e) {
            System.err.println("Error durante el upsert batch:");
            e.printStackTrace();
        }
    }
}
