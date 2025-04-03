package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.openapitools.client.model.Temperature;
import org.openapitools.client.model.TemperatureSensor;

public class CreateTemperatureSensorEntity {

    public static void main(String[] args) {
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            // Creo entidad TemperatureSensor
            TemperatureSensor sensor = new TemperatureSensor();
            sensor.setId(new URI("urn:ngsi-ld:TemperatureSensor:" + idFormateado));
            sensor.setType(TemperatureSensor.TypeEnum.TEMPERATURE_SENSOR);
            sensor.setTemperature(new Temperature()
                .type(Temperature.TypeEnum.PROPERTY)
                .value(BigDecimal.valueOf(27.9)) 
                .unitCode("CEL")
            );

            // Convertir a JSON
            String json = sensor.toJson();
            System.out.println("Payload JSON:\n" + json);

            //POST al context broker
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities"))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .header("Link", "<https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"")
                .POST(BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + response.statusCode());
            String body = response.body();
            if (body != null && !body.isBlank()) {
                System.out.println("Response body: " + body);
            }

        } catch (Exception e) {
            System.err.println("Error al crear la entidad TemperatureSensor:");
            e.printStackTrace();
        }
    }
    
}
