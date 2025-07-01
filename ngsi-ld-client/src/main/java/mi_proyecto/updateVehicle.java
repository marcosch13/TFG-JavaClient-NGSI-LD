package mi_proyecto;

import java.math.BigDecimal;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.ZoneOffset;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.api.ContextInformationConsumptionApi;
import org.openapitools.client.api.ContextInformationProvisionApi;
import org.openapitools.client.model.*;


public class updateVehicle {

    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            OffsetDateTime observedAt = OffsetDateTime.now(ZoneOffset.UTC).withNano(0);

            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
            apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
            apiClient.addDefaultHeader("Accept", "application/ld+json");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);


            System.out.println("Introduzca la matrícula del vehículo que desea actualizar?");
            String matricula = scanner.nextLine();
            URI entityUri3 = new URI("urn:ngsi-ld:Vehicle:" + matricula);
            boolean existeVehicle = false;
            try {
                QueryEntity200ResponseInner entidadVehicle = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
                existeVehicle = true;
            } catch (ApiException e){}
            if(existeVehicle){
                System.out.println("El vehículo es corecto");
            }else{
                System.out.println("El vehículo no existe, por favor registrelo primero");
                return;
            }
      
            QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                entityUri3, null, null, null, null, null, null, null, null);
            
            Entity editable = Entity.fromJson(entidad.toJson());

            //imprimir entidad para poder verla antes de modificarla
            
            Map<String, Object> atributos = editable.getAdditionalProperties();
            
            System.out.println("¿Cuantas propiedades quieres actualizar?");
            int numPropiedades = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numPropiedades; i++) {
                System.out.println("Propiedades disponibles: " + atributos.keySet());
                System.out.print("¿Qué propiedad quieres actualizar?: ");
                String propiedad = scanner.nextLine();
                if (atributos.containsKey(propiedad)) {

                    if(propiedad.equals("brandName")){ 
                        BrandName brandname = new BrandName();
                        System.out.println("Introduce el nuevo nombre de la marca");
                        String nuevoValor = scanner.nextLine();
                        brandname.setValue(nuevoValor);
                        editable.putAdditionalProperty("brandName", brandname);

                    }else if(propiedad.equals("passengers")){
                        Passengers passengers = new Passengers();
                        passengers.setObjectType(new URI("Person"));
                        System.out.println("¿Cuántos pasajeros quieres modificar?");
                        int numPasajeros = Integer.parseInt(scanner.nextLine());
                        List<URI> passengerUris = new ArrayList<>();
                        for (int j = 0; j < numPasajeros; j++) {
                            System.out.print("Introduce el nombre del pasajero " + (j + 1) + ": ");
                            String nombrePasajero = scanner.nextLine();

                            URI pasajeroUri = new URI("urn:ngsi-ld:Person:" + nombrePasajero);
                            passengerUris.add(pasajeroUri);
                        }
                        passengers.setObject(passengerUris);
                        editable.putAdditionalProperty("passengers", passengers);

                    }else if(propiedad.equals("route")){
                        System.out.println("¿Por cuantas ciudades pasa tu ruta?");
                        int numCiudadesRuta = Integer.parseInt(scanner.nextLine());

                        Route route = new Route();
                        List<Object> rutaUris = new ArrayList<>();
                        for (int j = 0; j < numCiudadesRuta; j++) {
                            System.out.print("Introduce el nombre de la " + (j+1) + "ª ciudad: ");
                            String nombreCiudad = scanner.nextLine();
                            rutaUris.add("urn:ngsi-ld:City:" + nombreCiudad);
                        }
                        route.setObjectList(rutaUris);
                        editable.putAdditionalProperty("route", route);
    
                    }else if(propiedad.equals("street")){
                        System.out.println("Introduce la calle: "); 
                        String calle = scanner.nextLine();
                        Street street = new Street();
                        street.setType(Street.TypeEnum.LANGUAGE_PROPERTY);
                        Map<String, String> streetLanguageMap = new HashMap<>();
                        streetLanguageMap.put("es", calle);
                        street.setLanguageMap(streetLanguageMap);
                        editable.putAdditionalProperty("street", street);
                        
                    }else if(propiedad.equals("isParked")){
                        System.out.println("En que parking esta aparcado el vehículo?");
                        String nombreParking = scanner.nextLine();
                        boolean existeParking = false;

                        try {
                            URI entityUri4 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
                            QueryEntity200ResponseInner entidadParkingComprobar = consumoApi.retrieveEntity(
                            entityUri4, null, null, null, null, null, null, null, null);
                            existeParking = true;
                        } catch (ApiException e){}
                        if(existeParking){
                            System.out.println("El parking existe.");
                        }else{
                            System.out.println("El parking no existe, por favor registrelo primero.");
                            return;
                        }
                        System.out.println("Nombre del propietario del vehiculo:");
                        String nombrePropietario = scanner.nextLine();
                        ProvidedBy providedBy = new ProvidedBy(); 
                        providedBy.setObject(new URI("urn:ngsi-ld:Person:" + nombrePropietario));
                        //Atributo isParked:
                        IsParked isParked = new IsParked();
                        URI entityUri6 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
                        isParked.setObject(entityUri6);
                        isParked.setObjectType(new URI("OffStreetParking")); 
                        isParked.setObservedAt(observedAt);
                        isParked.setProvidedBy(providedBy);

                        editable.putAdditionalProperty("isParked", isParked);    
                        
                    }else if(propiedad.equals("category")){
                        System.out.println("Introduce la categoría del vehículo: ");
                        String categoria = scanner.nextLine();
                        Category category = new Category();
                        category.setVocab(categoria);
                        editable.putAdditionalProperty("category", category);
                        
                    }else if(propiedad.equals("tyreTreadDepths")){
                        System.out.println("Introduce la profundidad de los neumáticos delanteros: ");
                        String nuevoValorDelanteros = scanner.nextLine();
                        System.out.println("Introduce la profundidad de los neumáticos traseros: ");
                        String nuevoValorTraseros = scanner.nextLine();
                        TyreTreadDepths depths = new TyreTreadDepths();
                        depths.addValueListItem(nuevoValorDelanteros);
                        depths.addValueListItem(nuevoValorDelanteros);
                        depths.addValueListItem(nuevoValorTraseros);
                        depths.addValueListItem(nuevoValorTraseros);
                        editable.putAdditionalProperty("tyreTreadDepths", depths);
                    }
                }else {
                    System.out.println("Esa propiedad no existe en la entidad.");
                }
            }

            ApiResponse<Void> response = apiInstance.updateEntityWithHttpInfo(entidad.getId(), null, null, null, null,editable);

            System.out.println("Código de respuesta: " + response.getStatusCode());

        
        

        }catch (Exception e) {
            System.err.println("Error al actualizar la entidad:");
            e.printStackTrace();
        }
    }
    
}
