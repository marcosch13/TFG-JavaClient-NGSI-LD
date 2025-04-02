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

public class CreateIotDevice {
    public static void main(String[] args) {
        try {
            //Creo entidad IotDevice
            IotDevice device = new IotDevice();
            device.setId(new URI("urn:ngsi-ld:IotDevice:002"));
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
                .uri(URI.create("http://localhost:1026/ngsi-ld/v1/entities")) // Cambia al endpoint de tu broker
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .header("Link", "<https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"")
                .POST(BodyPublishers.ofString(json))
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}