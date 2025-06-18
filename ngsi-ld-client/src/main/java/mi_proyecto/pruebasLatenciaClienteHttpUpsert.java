package mi_proyecto;

import java.net.URI;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;

public class pruebasLatenciaClienteHttpUpsert {

    public static void main(String[] args) {
        int repeticiones = 1000;
        String archivo = "latenciasHttpUpsert.csv";
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("iteracion,latencia_ms");

            HttpClient client = HttpClient.newHttpClient();

            String entityJson = """
                    [
                    {
                        "id": "urn:ngsi-ld:IotDevice:001",
                        "type": "IotDevice",
                        "description": {
                            "type": "Property",
                            "value": "IoT device with humidity and temperature sensors"
                        },
                        "hasTemperatureSensor": {
                            "type": "Relationship",
                            "object": "urn:ngsi-ld:TemperatureSensor:001"
                        },
                        "hasHumiditySensor": {
                            "type": "Relationship",
                            "object": "urn:ngsi-ld:HumiditySensor:001"
                        },
                        "@context": [
                            "https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context.jsonld"
                        ]
                    }
                    ]
                    """;

                    HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:9090/ngsi-ld/v1/entityOperations/upsert"))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/ld+json")
                        .header("Accept", "application/ld+json")
                        .POST(HttpRequest.BodyPublishers.ofString(entityJson))
                        .build();
    
            for (int i = 0; i < repeticiones; i++) {
                try {
                    long inicio = System.nanoTime();




                

                

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    
                    
                   



                    
                    long fin = System.nanoTime();
    
                    double duracionMs = (fin - inicio) / 1_000_000; // convertir ns --> ms
    
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