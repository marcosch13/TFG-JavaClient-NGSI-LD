package mi_proyecto;

import java.net.URI;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class pruebasLatenciaClienteHttp {

    public static void main(String[] args) {
        int repeticiones = 1000;
        String archivo = "latenciasClienteHttp.csv";
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("iteracion;latencia_ms");

            HttpClient client = HttpClient.newHttpClient();
    
            for (int i = 0; i < repeticiones; i++) {
                try {
                    long inicio = System.nanoTime();
                    //Instant timestampInicio = Instant.now();
    
                    //query entidad
                    
                    

                    String entityId = "urn:ngsi-ld:IotDevice:001";
                    

                    HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities?id=" + entityId))
                    .timeout(Duration.ofSeconds(10))
                    .header("Accept", "application/ld+json")
                    .GET()
                    .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    

                    



    
                    //Instant timestampFin = Instant.now();
                    long fin = System.nanoTime();
    
                    double duracionMs = (fin - inicio) / 1_000_000; // convertir ns → ms
    
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