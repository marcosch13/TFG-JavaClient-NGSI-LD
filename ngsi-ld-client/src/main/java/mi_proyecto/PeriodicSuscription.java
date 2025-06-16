package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationSubscriptionApi;
import org.openapitools.client.model.CreateSubscriptionRequest;
import org.openapitools.client.model.Endpoint;
import org.openapitools.client.model.EntitySelector;
import org.openapitools.client.model.NotificationParams;
import org.openapitools.client.ApiResponse;

public class PeriodicSuscription {

    public static void main(String[] args) {

        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationSubscriptionApi subscriptionApi = new ContextInformationSubscriptionApi(apiClient);


            Endpoint endpoint = new Endpoint();
            endpoint.setUri(new URI("http://scorpio-notifier-tester:8084/notify"));
            endpoint.setNotifierInfo(null); //si no me da error
            endpoint.setReceiverInfo(null); //si no me da error


            NotificationParams notificationParams = new NotificationParams();
            notificationParams.setEndpoint(endpoint);
            notificationParams.setFormat(NotificationParams.FormatEnum.NORMALIZED);
            notificationParams.setAttributes(Arrays.asList("humidity", "temperature")); 

            //profe: attributes=["temperature", "humidity"], sysAttrs=True
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("A que tipo de sensor quieres suscribirte? \n humedad \n temperatura ");
            String tipoEntidad = scanner.nextLine();

            String tipo = "";
            if(tipoEntidad.equals("humedad")){
                tipo = "HumiditySensor";
            }else if(tipoEntidad.equals("temperatura")){
                tipo = "TemperatureSensor";
            }
            EntitySelector Entity = new EntitySelector();
            Entity.setType(tipo);

            System.out.println("Introduce el número final de ID de la entidad: ");
            String NumeroId = scanner.nextLine();

            String letra = "";
            if (tipoEntidad.equals("humedad")) {
                letra = "H";
            }else if (tipoEntidad.equals("temperatura")) {
                letra = "T";
            }

            CreateSubscriptionRequest subscription = new CreateSubscriptionRequest();

            subscription.setType(CreateSubscriptionRequest.TypeEnum.SUBSCRIPTION);
            subscription.setId(new URI("urn:ngsi-ld:Subscription:Periodic:" + letra + NumeroId));
            subscription.setNotification(notificationParams);
            subscription.setEntities(Arrays.asList(Entity));
            subscription.setDescription("Subscripción periodica a :");
            subscription.setTimeInterval(new BigDecimal(10));//esepcificar por el usuario
            subscription.setIsActive(true);
            subscription.setNotificationTrigger(null);
            subscription.setWatchedAttributes(null);

            System.out.println("Suscripción JSON:\n" + subscription.toJson());

            ApiResponse<Void> response = subscriptionApi.createSubscriptionWithHttpInfo(null, null, null, subscription);
            System.out.println("Response: " + response.getData());
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear la suscripción: " + e.getMessage());
        }

        
    }
    
}
