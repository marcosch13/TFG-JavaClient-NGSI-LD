package mi_proyecto;

import org.openapitools.client.model.*;
import org.openapitools.client.model.Endpoint.AcceptEnum;

import java.net.URI;
import java.util.Arrays;

import org.openapitools.client.ApiClient;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.*;



public class AddSuscription {
    public static void main(String[] args) {

        try {

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationSubscriptionApi subscriptionApi = new ContextInformationSubscriptionApi(apiClient);


            Endpoint endpoint = new Endpoint();
            endpoint.setUri(new URI("http://scorpio-notifier-tester:8084/notify"));
            //endpoint.setAccept(AcceptEnum.APPLICATION_LD_JSON);
            //endpoint.setUri(new URI("http://localhost:8084/notify"));
            endpoint.setNotifierInfo(null); 
            endpoint.setReceiverInfo(null); 


            NotificationParams notificationParams = new NotificationParams();
            notificationParams.setEndpoint(endpoint);
            notificationParams.setFormat(NotificationParams.FormatEnum.NORMALIZED);
            notificationParams.setAttributes(Arrays.asList("humidity")); 

            //profe: attributes=["temperature", "humidity"], sysAttrs=True
            

            EntitySelector EntidadesSeleccionadas = new EntitySelector();
            EntidadesSeleccionadas.setType("HumiditySensor");


            CreateSubscriptionRequest subscription = new CreateSubscriptionRequest();

            subscription.setType(CreateSubscriptionRequest.TypeEnum.SUBSCRIPTION);
            subscription.setNotification(notificationParams);
            subscription.setEntities(Arrays.asList(EntidadesSeleccionadas));
            subscription.setDescription("Subscripción a cambios en los sensores de humedad");
            subscription.setWatchedAttributes(Arrays.asList("humidity"));
            subscription.setIsActive(true);
            subscription.setNotificationTrigger(null);

            System.out.println("Suscripción JSON:\n" + subscription.toJson());

            var response = subscriptionApi.createSubscriptionWithHttpInfo(null, null, null, subscription);
            System.out.println("Response: " + response.getData());
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al crear la suscripción: " + e.getMessage());
        }

        
    }
}