package mi_proyecto;

import org.openapitools.client.model.IotDevice;
import org.openapitools.client.model.IotDescription;
//import org.openapitools.client.model.HasHumiditySensor;
//import org.openapitools.client.model.HasTemperatureSensor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
//import java.net.http.HttpClient.Version;
import java.time.Duration;

public class CreateIotEntity{
    public static void main(String[] args){
        try {
            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);
            //Creo entidad IotDevice
            IotDevice device = new IotDevice();
            device.setId(new URI("urn:ngsi-ld:IotDevice:" + idFormateado));
            device.setType(IotDevice.TypeEnum.IOT_DEVICE);
            //device.setType("IotDevice");    (ERROR)
            device.setDescription(new IotDescription().value("IoT device with humidity and temperature sensors"));
            //device.setHasHumiditySensor(new HasHumiditySensor().object("urn:ngsi-ld:HumiditySensor:001"));
            //device.setHasTemperatureSensor(new HasTemperatureSensor().object("urn:ngsi-ld:TemperatureSensor:001"));

            //Convertir a JSON
            String json = device.toJson();
            System.out.println("Payload JSON:\n" + json);

            //petición POST al context broker
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
            System.err.println("Error al crear la entidad:");
            e.printStackTrace();
        }
    }
}