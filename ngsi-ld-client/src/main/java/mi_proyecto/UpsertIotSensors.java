package mi_proyecto;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.model.HasTemperatureSensor;

import org.openapitools.client.model.Entity;
import org.openapitools.client.model.HasHumiditySensor;
import org.openapitools.client.model.QueryEntity200ResponseInner;

import java.net.URI;
import java.math.BigDecimal;
import java.util.*;

public class UpsertIotSensors {

    public static void main(String[] args) {
        try {
            

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

                ApiClient apiClient = Configuration.getDefaultApiClient();
                apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
                ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);

                List<QueryEntity200ResponseInner> entidadesQuery = consumoApi.queryEntity(
                    entityIds, "IotDevice", null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, null);

                Entity IotEntity;
                if (!entidadesQuery.isEmpty()) {
                    QueryEntity200ResponseInner entidadOriginal = entidadesQuery.get(0);
                    IotEntity = Entity.fromJson(entidadOriginal.toJson());
                }else{
                    IotEntity = new Entity();
                    IotEntity.putAdditionalProperty("type", "IotDevice");
                    IotEntity.putAdditionalProperty("id", "urn:ngsi-ld:IotDevice:" + idFormateado);
                }
                Entity tempEntity = new Entity();
                tempEntity.putAdditionalProperty("type", "TemperatureSensor");

                Entity humEntity = new Entity();
                humEntity.putAdditionalProperty("type", "HumiditySensor");

                System.out.print("¿Añadir descripción? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    IotEntity.putAdditionalProperty("description", descripcion);
                }

                System.out.print("¿Añadir o modificar sensor de temperatura? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    actualizarTempSensor = true;
                    System.out.print("ID del sensor: ");
                    String tempId = scanner.nextLine(); //meter el formateo?dijimos que no hacia falta

                    System.out.print("Introduce el valor de temperatura: ");
                    BigDecimal nuevaTemperatura = new BigDecimal(scanner.nextLine());
                    tempEntity.putAdditionalProperty("temperature", nuevaTemperatura);

                    tempEntity.putAdditionalProperty("id", "urn:ngsi-ld:TemperatureSensor:" + tempId);

                    HasTemperatureSensor tempSensor = new HasTemperatureSensor();
                    tempSensor.setType(HasTemperatureSensor.TypeEnum.RELATIONSHIP);
                    tempSensor.setObject("urn:ngsi-ld:TemperatureSensor:" + tempId);
                    IotEntity.putAdditionalProperty("hasTemperatureSensor", tempSensor);
                }

                System.out.print("¿Añadir o modificar sensor de humedad? (s/n): ");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    actualizarHumSensor = true;
                    System.out.print("ID del sensor: ");
                    String humId = scanner.nextLine();

                    System.out.print("Introduce el valor de humedad: ");
                    BigDecimal nuevaHumedad = new BigDecimal(scanner.nextLine());
                    humEntity.putAdditionalProperty("humidity", nuevaHumedad);

                    humEntity.putAdditionalProperty("id", "urn:ngsi-ld:HumiditySensor:" + humId);

                    HasHumiditySensor humSensor = new HasHumiditySensor();
                    humSensor.setType(HasHumiditySensor.TypeEnum.RELATIONSHIP);
                    humSensor.setObject("urn:ngsi-ld:HumiditySensor:" + humId);
                    IotEntity.putAdditionalProperty("hasHumiditySensor", humSensor);
                }

                //Convertir a JSON
                String json = IotEntity.toJson();
                System.out.println("Payload JSON:\n" + json);

                String json2 = tempEntity.toJson();
                System.out.println("Payload JSON:\n" + json2);

                String json3 = humEntity.toJson();
                System.out.println("Payload JSON:\n" + json3);

                //Paso a entidad NGSI-LD genérica
                QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(json);
                entidades.add(entity);

                if(actualizarTempSensor){
                    QueryEntity200ResponseInner tempEntityQ = QueryEntity200ResponseInner.fromJson(json2);
                    entidades.add(tempEntityQ);
                }
                if(actualizarHumSensor){
                    QueryEntity200ResponseInner humEntityQ = QueryEntity200ResponseInner.fromJson(json3);
                    entidades.add(humEntityQ);
                }
            }

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            ApiResponse<List<String>> response = apiInstance.upsertBatchWithHttpInfo(null, null, null, null, entidades);

            System.out.println("\nCódigo de respuesta: " + response.getStatusCode());

        } catch (Exception e) {
            System.err.println("Error durante el upsert batch:");
            e.printStackTrace();
        }
    }
}
