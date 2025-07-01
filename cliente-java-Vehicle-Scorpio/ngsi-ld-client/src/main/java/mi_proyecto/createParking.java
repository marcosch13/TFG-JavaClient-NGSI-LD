package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;
import org.openapitools.client.Configuration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.time.ZoneOffset;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;




public class createParking {

    public static void main(String[] args){
        try {

            OffsetDateTime observedAt = OffsetDateTime.now(ZoneOffset.UTC).withNano(0);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);
            boolean existeCompany = false;
            boolean existeParking = false;
        
            //Entidad Company:
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nombre de la compañía: ");
            String idCompany = scanner.nextLine();

            try {
                URI entityUri = new URI("urn:ngsi-ld:Company:" + idCompany);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri, null, null, null, null, null, null, null, null);
                existeCompany = true;
            } catch (ApiException e){}

            if(existeCompany){
                System.out.println("La compañía ya existe.");
            }else{
                Company company = new Company();
                company.setType(Company.TypeEnum.COMPANY);
                URI companyUri = new URI("urn:ngsi-ld:Company:" + idCompany);
                company.setId(companyUri);
                

                Name nombre = new Name();
                nombre.setValue("Compañía " + idCompany);
                company.setName(nombre);

                String json = company.toJson();
                QueryEntity200ResponseInner entity = QueryEntity200ResponseInner.fromJson(json);
                ApiResponse<Void> response = apiInstance.createEntityWithHttpInfo(null, null, null, entity);

                System.out.println("Código de respuesta de company: " + response.getStatusCode());
            }
            
            //Entidad camara:  
            System.out.println("¿Cuántas cámaras quieres añadir?");
            int numCamaras = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numCamaras; i++) {
                System.out.print("Introduce el ID de la cámara: ");
                String idCamara = scanner.nextLine();
                boolean existeCamara = false;
                try {
                    URI entityUri2 = new URI("urn:ngsi-ld:Camera:C" + idCamara);
                    QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                    entityUri2, null, null, null, null, null, null, null, null);
                    existeCamara = true;
                } catch (ApiException e){}

                if(existeCamara){
                    System.out.println("La cámara ya existe.");
                }else{
                    Camera camera = new Camera();
                    URI cameraUri = new URI("urn:ngsi-ld:Camera:C" + idCamara);
                    camera.setId(cameraUri);
                    camera.setType(Camera.TypeEnum.CAMERA);
                    Name nombreCamara = new Name();
                    nombreCamara.setValue("Camara " + idCamara); 
                    camera.setName(nombreCamara);

                    String jsonC = camera.toJson();
                    QueryEntity200ResponseInner entityC = QueryEntity200ResponseInner.fromJson(jsonC);
                    ApiResponse<Void> responseC = apiInstance.createEntityWithHttpInfo(null, null, null, entityC);
                    System.out.println("Código de respuesta de cámara: " + responseC.getStatusCode());
                }
            }
                
            //Entidad OffStreetParking:
            System.out.print("Introduce el nombre del parking: ");
            String nombreParking = scanner.nextLine();

            System.out.print("Introduce el número total de plazas: ");
            int numPlazas = Integer.parseInt(scanner.nextLine());

            System.out.print("Introduce un spotNumber disponible: ");
            int spotNumber1 = Integer.parseInt(scanner.nextLine());
            BigDecimal spotNumber = BigDecimal.valueOf(spotNumber1);

            System.out.println("Introduce el id de la cámara que registra el AvailableSpot: ");
            String idCamara = scanner.nextLine();

            boolean existeCamara = false;
            try {
                URI entityUri2 = new URI("urn:ngsi-ld:Camera:C" + idCamara);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri2, null, null, null, null, null, null, null, null);
                existeCamara = true;
            } catch (ApiException e){}

            AvailableSpotNumber availableSpotNumber = new AvailableSpotNumber();
            if(existeCamara){
                availableSpotNumber.setValue(spotNumber);
                availableSpotNumber.setReliability(new Reliability().value(new BigDecimal(0.9)));
                availableSpotNumber.setObservedAt(observedAt); 
            
                URI entityUriProvidedBy = new URI("urn:ngsi-ld:Camera:C" + idCamara);
                ProvidedBy providedBy = new ProvidedBy();
                providedBy.setObject(entityUriProvidedBy);
                providedBy.setType(ProvidedBy.TypeEnum.RELATIONSHIP); 

                availableSpotNumber.setProvidedBy(providedBy);
            }else{
                System.out.println("La cámara no existe.");
            }

            GeometryPoint parkingLocation = new GeometryPoint();
            parkingLocation.setType(GeometryPoint.TypeEnum.POINT);
            parkingLocation.setCoordinates(Arrays.asList(
                BigDecimal.valueOf(-8.5),
                BigDecimal.valueOf(41.2)
            ));

            Geometry geometry = Geometry.fromJson(parkingLocation.toJson());

            GeoProperty geoProperty_location = new GeoProperty();
            geoProperty_location.setType(GeoProperty.TypeEnum.GEO_PROPERTY);
            geoProperty_location.setValue(geometry);

            try {
                URI entityUri3 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
                QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
                existeParking = true;
            } catch (ApiException e){}

            if(existeParking){
                System.out.println("El parking ya existe.");
            }else{
                OffStreetParking parking = new OffStreetParking();

                URI entityPUri = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
                parking.setId(entityPUri);
                parking.setType(OffStreetParking.TypeEnum.OFF_STREET_PARKING);
                parking.setLocation(geoProperty_location);
                parking.setName(new Name().value(nombreParking));

                OperatedBy operatedBy = new OperatedBy();
                operatedBy.setObject("urn:ngsi-ld:Company:" + idCompany);
                parking.setOperatedBy(operatedBy);

                parking.addAvailableSpotNumbersItem(availableSpotNumber);

                TotalSpotNumber totalSpotNumber = new TotalSpotNumber();
                totalSpotNumber.setValue(new BigDecimal(numPlazas));
                parking.setTotalSpotNumber(totalSpotNumber);

                String jsonP = parking.toJson();

                QueryEntity200ResponseInner entityP = QueryEntity200ResponseInner.fromJson(jsonP);

                ApiResponse<Void> responseP = apiInstance.createEntityWithHttpInfo(null, null, null, entityP);

                System.out.println("Código de respuesta: " + responseP.getStatusCode());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
