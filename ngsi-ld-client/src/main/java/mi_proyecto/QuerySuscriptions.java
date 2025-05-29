package mi_proyecto;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.*;



public class QuerySuscriptions {
    public static void main(String[] args) {

        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            ContextInformationSubscriptionApi subscriptionApi = new ContextInformationSubscriptionApi(apiClient);

            var response = subscriptionApi.querySubscriptionWithHttpInfo(null, null, null, null,null,null);
            for (var subscription : response.getData()) {
                System.out.println(subscription.toJson());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear la suscripción: " + e.getMessage());
        }

        
    }
}
