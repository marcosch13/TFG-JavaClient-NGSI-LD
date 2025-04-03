package mi_proyecto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class QueryIotEntities {
    public static void main(String[] args) {
        try {

            String[] tipos = { "IotDevice", "TemperatureSensor", "HumiditySensor" };
            
            //petición GET al context broker
            HttpClient client = HttpClient.newHttpClient();
            for (String tipo : tipos) {
                System.out.println("\n[+] Consultando entidades de tipo " + tipo + "...");

                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities?type=" + tipo))
                    .timeout(Duration.ofSeconds(10))
                    .header("Accept", "application/ld+json")
                    .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Response code: " + response.statusCode());
                String body = response.body();
                if (body != null && !body.isBlank()) {
                    System.out.println("Response body: " + body);
                }
            }
        }

            /* 
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities?type=IotDevice"))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/ld+json")
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + response.statusCode());
            String body = response.body();
            if (body != null && !body.isBlank()) {
                System.out.println("Response body: " + body);
            }

        } */
       
        catch (Exception e) {
            System.err.println("Error al consultar entidades:");
            e.printStackTrace();
        }
    }
}