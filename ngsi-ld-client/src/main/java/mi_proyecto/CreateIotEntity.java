package mi_proyecto;

import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;

import org.openapitools.client.model.IotDevice;
import org.openapitools.client.model.IotDescription;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;

import java.net.URI;
import java.util.Scanner;

public class CreateIotEntity {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            String idNumero = (args != null && args.length > 0) ? args[0] : "1";
            int num = Integer.parseInt(idNumero);
            String idFormateado = String.format("%03d", num);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            boolean existe = false;

            try {
                URI entityUri = new URI("urn:ngsi-ld:IotDevice:" + idFormateado);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existe = true;
            } catch (ApiException e){}

            if (existe) {
                System.out.println("La entidad ya existe. ¿Desea sobreescribirla? (s/n)");
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    System.out.println("Se procederá a sobreescribir la entidad.");
                    UpdateIotEntity.main(new String[]{idFormateado});
                } else {
                    System.out.println("No se sobreescribirá la entidad.");
                    return;
                }
            }else{
                //Creo entidad IotDevice
                IotDevice device = new IotDevice();
                device.setId(new URI("urn:ngsi-ld:IotDevice:" + idFormateado));
                device.setType(IotDevice.TypeEnum.IOT_DEVICE);
                device.setDescription(new IotDescription().value("IoT device **************"));

                //Convertir a JSON
                String json = device.toJson();
                System.out.println("Payload JSON:\n" + json);

                //Paso a entidad NGSI-LD genérica
                QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(json);

                // Crear cliente y api
                ContextInformationProvisionApi api = new ContextInformationProvisionApi(apiClient);

                // Crear la entidad usando la API
                //api.createEntity(false, null, null, entity);
                ApiResponse<Void> response = api.createEntityWithHttpInfo(null, null, null, entity);


                //obtener respuesta del context broker y mostrarla
                System.out.println("Código de respuesta: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.err.println("Error al crear la entidad vía API:");
            e.printStackTrace();
        }
    }
}