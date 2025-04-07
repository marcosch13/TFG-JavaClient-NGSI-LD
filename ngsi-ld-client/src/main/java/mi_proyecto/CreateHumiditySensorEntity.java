package mi_proyecto;

import org.openapitools.client.model.HumiditySensor;
import org.openapitools.client.model.Humidity;

import java.net.URI;
import java.math.BigDecimal;

import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;

public class CreateHumiditySensorEntity {
    public static void main(String[] args) {
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            //Creo entidad HumiditySensor
            HumiditySensor sensor = new HumiditySensor();
            sensor.setId(new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado));
            sensor.setType(HumiditySensor.TypeEnum.HUMIDITY_SENSOR);
            sensor.setHumidity(new Humidity()
                .type(Humidity.TypeEnum.PROPERTY)
                .value(BigDecimal.valueOf(30.8)) //cual poner?? pongo el del ejemplo de python
                .unitCode("P1")
            );

            // Convertir a JSON
            String json = sensor.toJson();
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
            System.err.println("Error al crear la entidad HumiditySensor:");
            e.printStackTrace();
        }
    }
}
