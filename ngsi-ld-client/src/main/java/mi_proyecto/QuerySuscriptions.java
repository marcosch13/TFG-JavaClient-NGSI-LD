package mi_proyecto;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.*;



public class QuerySuscriptions {
    public static void main(String[] args) {

        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
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
