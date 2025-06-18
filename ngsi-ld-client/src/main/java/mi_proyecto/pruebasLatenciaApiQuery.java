package mi_proyecto;

import java.net.URI;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;

public class pruebasLatenciaApiQuery {

    public static void main(String[] args) {
        int repeticiones = 1000;
        String archivo = "latenciasApiQuery.csv";
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
            writer.println("iteracion,latencia_ms");

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);
    
            for (int i = 0; i < repeticiones; i++) {
                try {
                    long inicio = System.nanoTime();
                    //Instant timestampInicio = Instant.now();
    
                    //query entidad
                    
                    

                    URI entityId = new URI("urn:ngsi-ld:IotDevice:001");

                    List<URI> idList = Collections.singletonList(entityId);
                    List<QueryEntity200ResponseInner> response = apiInstance.queryEntity(
                        idList, null, null, null, null, null, null, null, null, null, null, 
                        null, null, null, null, null, null, null, null
                    );



    
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