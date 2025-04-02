package mi_proyecto;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class DeleteIotDevice {
    public static void main(String[] args) {
        try {
            
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            String entityId = "urn:ngsi-ld:IotDevice:" + idFormateado;
            System.out.println("[+] Borrando entidad con ID: " + entityId);

            //petición DELETE al context broker
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities/" + entityId))
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .DELETE()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + response.statusCode());
            String body = response.body();
            if (body != null && !body.isBlank()) {
                System.out.println("Response body: " + body);
            }
        } catch (Exception e) {
            System.err.println("Error al borrar la entidad:");
            e.printStackTrace();
        }
    }
}
