package mi_proyecto;

import org.openapitools.client.model.*;
import org.openapitools.client.model.Endpoint.AcceptEnum;

import java.net.URI;
import java.util.Arrays;
import java.util.Scanner;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.*;
import org.openapitools.client.ApiResponse;



public class OnChangeSuscription {
    public static void main(String[] args) {

        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationSubscriptionApi subscriptionApi = new ContextInformationSubscriptionApi(apiClient);

            Scanner scanner = new Scanner(System.in);

            Endpoint endpoint = new Endpoint();
            endpoint.setUri(new URI("http://scorpio-notifier-tester:8084/notify"));
            //endpoint.setAccept(AcceptEnum.APPLICATION_LD_JSON);
            //endpoint.setUri(new URI("http://localhost:8084/notify"));
            endpoint.setNotifierInfo(null); 
            endpoint.setReceiverInfo(null); 


            NotificationParams notificationParams = new NotificationParams();
            notificationParams.setEndpoint(endpoint);
            notificationParams.setFormat(NotificationParams.FormatEnum.NORMALIZED);
            notificationParams.setAttributes(Arrays.asList("humidity", "temperature")); 
            //poner sysattrs ponerlo a true y probar
            //profe: attributes=["temperature", "humidity"], sysAttrs=True
            

            
            System.out.println("A que tipo de entidad quieres suscribirte? \n Iot \n humedad \n temperatura ");
            String tipoEntidad = scanner.nextLine();
            String letra = "";

            String tipo = "";
            if(tipoEntidad.equals("humedad")){
                tipo = "HumiditySensor";
                letra = "H";
            }else if(tipoEntidad.equals("temperatura")){
                tipo = "TemperatureSensor";
                letra = "T";
            }else if(tipoEntidad.equals("Iot")){
                tipo = "IotDevice";
                letra = "I";
            }
            

            System.out.println("Introduce el número final de ID de la entidad: ");
            String NumeroId = scanner.nextLine();
            String NumeroIdFormateado = String.format("%03d", Integer.parseInt(NumeroId));
            URI entityUri = new URI("urn:ngsi-ld:" + tipo + ":"  +NumeroIdFormateado);

            EntitySelector Entity = new EntitySelector();
            Entity.setType(tipo);
            Entity.setId(entityUri);


            CreateSubscriptionRequest subscription = new CreateSubscriptionRequest();

            subscription.setType(CreateSubscriptionRequest.TypeEnum.SUBSCRIPTION);
            subscription.setId(new URI("urn:ngsi-ld:Subscription:OnChange:" + letra + NumeroId));
            subscription.setNotification(notificationParams);
            subscription.setEntities(Arrays.asList(Entity));
            subscription.setDescription("Subscripción basada en cambios");
            subscription.setWatchedAttributes(Arrays.asList("humidity", "temperature", "description"));
            subscription.setIsActive(true);
            subscription.setNotificationTrigger(null);

            System.out.println("Suscripción JSON:\n" + subscription.toJson());

            ApiResponse<Void> response = subscriptionApi.createSubscriptionWithHttpInfo(null, null, null, subscription);
            System.out.println("Response: " + response.getStatusCode());
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear la suscripción: " + e.getMessage());
        }

        
    }
}
