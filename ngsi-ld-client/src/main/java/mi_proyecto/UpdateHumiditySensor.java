package mi_proyecto;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.Entity;
import org.openapitools.client.model.Humidity;
import org.openapitools.client.model.HumiditySensor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.Scanner;
import java.math.BigDecimal;

public class UpdateHumiditySensor {
    public static void main(String[] args) {
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : null;
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nuevo valor de temperatura: ");
            BigDecimal nuevaHumedad = new BigDecimal(scanner.nextLine());

            /*HumiditySensor sensor = new HumiditySensor();
            sensor.setHumidity(new Humidity()
                .type(Humidity.TypeEnum.PROPERTY)
                .value(nuevaHumedad) 
                .unitCode("P1")
            );*/

            Entity fragmento = new Entity();

            fragmento.putAdditionalProperty("humidity", nuevaHumedad);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);

            URI entityId = new URI("urn:ngsi-ld:HumiditySensor:" + idFormateado);
            ApiResponse<Void> response = apiInstance.appendAttrsWithHttpInfo(entityId, null, null, null, null, null, fragmento);
            System.out.println("respuesta: " + response.getStatusCode());
            
            
        } catch (Exception e) {
            System.err.println("Error al actualizar el sensor de temperatura:");
            e.printStackTrace();
        }
    }


    
}
