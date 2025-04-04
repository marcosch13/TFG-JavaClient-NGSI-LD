package mi_proyecto;

import org.openapitools.client.model.Temperature;
import org.openapitools.client.model.TemperatureSensor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.util.Scanner;
import java.math.BigDecimal;

public class UpdateTemperatureSensor {
    public static void main(String[] args) {
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : null;
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nuevo valor de temperatura: ");
            BigDecimal nuevaTemperatura = new BigDecimal(scanner.nextLine());

            TemperatureSensor sensor = new TemperatureSensor();
            sensor.setTemperature(new Temperature()
                .type(Temperature.TypeEnum.PROPERTY)
                .value(nuevaTemperatura) 
                .unitCode("CEL")
            );

            String json = sensor.toJson();
            System.out.println("Payload JSON:\n" + json);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities/urn:ngsi-ld:TemperatureSensor:" + idFormateado + "/attrs"))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .header("Link", "<https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"")
                .method("PATCH", BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + response.statusCode());
            String body = response.body();
            if (body != null && !body.isBlank()) {
                System.out.println("Response body: " + body);
            }
            
        } catch (Exception e) {
            System.err.println("Error al actualizar el sensor de temperatura:");
            e.printStackTrace();
        }
    }
}