package mi_proyecto;

import java.util.List;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.model.QueryEntity200ResponseInner;

public class queryEntities {

    public static void main(String[] args) {
        try {


            String[] tipos = { "Company", "Camera", "OffStreetParking", "City", "Person", "Vehicle" };
            


            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationConsumptionApi apiInstance = new ContextInformationConsumptionApi(apiClient);

            for (String tipo : tipos) {
                System.out.println("\n[+] Consultando entidades de tipo " + tipo + "...");
                List<QueryEntity200ResponseInner> entidades = apiInstance.queryEntity(
                    null, tipo, null, null, null, null, null, null, null,
                    null, null, null, null, null, null, null, null, null, null);
                
                    System.out.println("→ Total: " + entidades.size() + " entidades encontradas.");
                        for (QueryEntity200ResponseInner entidad : entidades) {
                            System.out.println(entidad.toJson());
                        }
            }
        }
       catch (Exception e) {
            System.err.println("Error al consultar entidades:");
            e.printStackTrace();
        }
    }
}
