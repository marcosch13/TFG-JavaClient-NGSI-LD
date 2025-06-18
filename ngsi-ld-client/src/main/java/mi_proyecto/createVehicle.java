package mi_proyecto;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


public class createVehicle {
    public static void main(String[] args){
        try {

        Scanner scanner = new Scanner(System.in);
        //OffsetDateTime observedAt = OffsetDateTime.now().withNano(0);
        OffsetDateTime observedAt = OffsetDateTime.now(ZoneOffset.UTC).withNano(0);


        ApiClient apiClient = Configuration.getDefaultApiClient();
        apiClient.setBasePath("http://localhost:9090/ngsi-ld/v1");
        apiClient.addDefaultHeader("Link", "<http://context-catalog:8080/context.jsonld>; rel=\"http://www.w3.org/ns/json-ld#context\"; type=\"application/ld+json\"");
        apiClient.addDefaultHeader("Accept", "application/ld+json");
        ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
        ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);
        boolean existeParking = false;
        boolean existePerson = false;
        boolean existeCity = false;

        String nombreParkingComprobado = null;
        System.out.println("En que parking desea registrar el vehiculo?");
        String nombreParking = scanner.nextLine();
        try {
            URI entityUri3 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParking);
            QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
            entityUri3, null, null, null, null, null, null, null, null);
            existeParking = true;
        } catch (ApiException e){}
        if(existeParking){
            nombreParkingComprobado = nombreParking;
        }else{
            System.out.println("El parking no existe, por favor registrelo primero.");
            return;
        }

        //Entidad Person:
                
            System.out.println("Registra las personas que viajan en el vehiculo:");
            System.out.println("    Cuantas personas quieres registrar?");
            int numPersonas = Integer.parseInt(scanner.nextLine());

            for(int i = 0; i < numPersonas; i++){
                System.out.print("Introduce el nombre de la persona: ");
                String nombre = scanner.nextLine();
                existePerson = false;

                try{
                    URI entityUri4 = new URI("urn:ngsi-ld:Person:" + nombre);
                    QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                    entityUri4, null, null, null, null, null, null, null, null);
                    existePerson = true;
                }catch (ApiException e){}
    
                if(existePerson){
                    System.out.println("La persona ya estaba registrada.");
                }else{
                    Person person = new Person();
                    URI entityUri2 = new URI("urn:ngsi-ld:Person:" + nombre);
                    person.setId(entityUri2);
                    person.setType(Person.TypeEnum.PERSON);
                    person.setName(new Name().value(nombre));
    
                    String jsonPr = person.toJson();
                    QueryEntity200ResponseInner entityPr = QueryEntity200ResponseInner.fromJson(jsonPr);
                    ApiResponse<Void> responsePr = apiInstance.createEntityWithHttpInfo(null, null, null, entityPr);
    
                    System.out.println("Código de respuesta: " + responsePr.getStatusCode());
                    }

            }
            
        //Entidad City:
            System.out.println("Cuantas ciudades quieres registrar?");
            int numCiudades = Integer.parseInt(scanner.nextLine());

            for(int i = 0; i < numCiudades; i++){
                System.out.println("Nombre de la ciudad a registrar:");
                String nombreCiudad = scanner.nextLine();
                City city = new City();

                try{
                    URI entityUri5 = new URI("urn:ngsi-ld:City:" + nombreCiudad);
                    QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                    entityUri5, null, null, null, null, null, null, null, null);
                    existeCity = true;
                }catch(ApiException e){}

                if(existeCity){
                    System.out.println("La ciudad ya está registrada.");
                }else{
                    URI entityUri7 = new URI("urn:ngsi-ld:City:" + nombreCiudad);
                    city.setId(entityUri7);
                    city.setType(City.TypeEnum.CITY);
                    city.setName(new Name().value(nombreCiudad));

                    String jsonCi = city.toJson();
                    QueryEntity200ResponseInner entityCi = QueryEntity200ResponseInner.fromJson(jsonCi);
                    ApiResponse<Void> responseCi = apiInstance.createEntityWithHttpInfo(null, null, null, entityCi);

                    System.out.println("Código de respuesta: " + responseCi.getStatusCode());
                }
            }
            
        //Entidad Vehicle:
        Vehicle vehicle = new Vehicle(); 

            //Atributo providedBy:
            System.out.println("Nombre del propietario del vehiculo:");
            String nombrePropietario = scanner.nextLine();
            ProvidedBy providedBy = new ProvidedBy(); 
            providedBy.setObject(new URI("urn:ngsi-ld:Person:" + nombrePropietario));
            
            //Atributo isParked:
            IsParked isParked = new IsParked();
            URI entityUri6 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParkingComprobado);
            isParked.setObject(entityUri6);
            isParked.setObjectType(new URI("OffStreetParking")); 
            isParked.setObservedAt(observedAt);
            isParked.setProvidedBy(providedBy);

            //Atributo passengers:
            Passengers passengers = new Passengers();
            passengers.setObjectType(new URI("Person"));

            System.out.println("¿Cuántos pasajeros quieres añadir?");
            int numPasajeros = Integer.parseInt(scanner.nextLine());

            List<URI> passengerUris = new ArrayList<>();
            for (int i = 0; i < numPasajeros; i++) {
                System.out.print("Introduce el nombre del pasajero " + (i + 1) + ": ");
                String nombrePasajero = scanner.nextLine();

                URI pasajeroUri = new URI("urn:ngsi-ld:Person:" + nombrePasajero);
                passengerUris.add(pasajeroUri);
            }
            passengers.setObject(passengerUris);
                
            //Atributo route:
            System.out.println("¿Por cuantas ciudades pasa tu ruta?");
            int numCiudadesRuta = Integer.parseInt(scanner.nextLine());

            Route route = new Route();
            List<Object> rutaUris = new ArrayList<>();

            //List<String> rutaUris = new ArrayList<>();
            for (int i = 0; i < numCiudadesRuta; i++) {
                System.out.print("Introduce el nombre de la " + (i+1) + "ª ciudad: ");
                String nombreCiudad = scanner.nextLine();
                rutaUris.add("urn:ngsi-ld:City:" + nombreCiudad);
            }
            //Map<String,Object> routeAttr = new HashMap<>();
            //routeAttr.put("type", "Relationship");
            //routeAttr.put("object", rutaUris);
            route.setObjectList(rutaUris);
            vehicle.setRoute(route);

            //Resto de atributos del vehículo     
            System.out.print("Introduce la matrícula del vehículo: ");
            String matricula = scanner.nextLine();

            URI entityUri8 = new URI("urn:ngsi-ld:Vehicle:" + matricula);
            vehicle.setId(entityUri8);
            vehicle.setType(Vehicle.TypeEnum.VEHICLE);
            System.out.println("Introduce la marca del vehículo: ");
            String marca = scanner.nextLine();
            vehicle.setBrandName(new BrandName().value(marca));
            System.out.println("Introduce la calle: "); 
            String calle = scanner.nextLine();
            
            /*Map<String,Object> street = new HashMap<>();
            street.put("type",  "Property");
            Map<String,String> lm = new HashMap<>();
            lm.put("@none", calle);
            street.put("value", lm);
            vehicle.putAdditionalProperty("street", street);*/
            Street street = new Street();
            street.setType(Street.TypeEnum.LANGUAGE_PROPERTY);
            Map<String, String> streetLanguageMap = new HashMap<>();
            streetLanguageMap.put("es", calle);
            street.setLanguageMap(streetLanguageMap);
            vehicle.setStreet(street);


            
            vehicle.setIsParked(isParked);
            vehicle.setPassengers(passengers);
            
            System.out.println("Introduce la categoría del vehículo: ");
            String categoria = scanner.nextLine();
            /*Map<String, Object> categoryAttr = new HashMap<>();
            categoryAttr.put("type", "Property");
            categoryAttr.put("value", categoria);
            vehicle.putAdditionalProperty("category", categoryAttr);*/

            Category category = new Category();
            category.setVocab(categoria);
            vehicle.setCategory(category);

            System.out.println("Introduce la profundidad de los neumáticos delanteros: ");
            String nuevoValorDelanteros = scanner.nextLine();
            System.out.println("Introduce la profundidad de los neumáticos traseros: ");
            String nuevoValorTraseros = scanner.nextLine();
            
            /*Map<String,Object> tyreAttr = new HashMap<>();
            tyreAttr.put("type",  "Property");
            tyreAttr.put("value", Arrays.asList(nuevoValorDelanteros,nuevoValorDelanteros,nuevoValorTraseros,nuevoValorTraseros));
            tyreAttr.put("unitCode", "MMT");
            vehicle.putAdditionalProperty("tyreTreadDepths", tyreAttr);*/

            TyreTreadDepths depths = new TyreTreadDepths();
            depths.addValueListItem(nuevoValorDelanteros);
            depths.addValueListItem(nuevoValorDelanteros);
            depths.addValueListItem(nuevoValorTraseros);
            depths.addValueListItem(nuevoValorTraseros);
            vehicle.setTyreTreadDepths(depths);
            



            //vehicle.putAdditionalProperty("route", routeAttr);

        String jsonV = vehicle.toJson();
        System.out.println("JSON del vehículo: " + jsonV);
        QueryEntity200ResponseInner entityV = QueryEntity200ResponseInner.fromJson(jsonV);
        ApiResponse<Void> responseV = apiInstance.createEntityWithHttpInfo(null, null, null, entityV);
        System.out.println("Código de respuesta: " + responseV.getStatusCode());

    } catch (Exception e) {
        e.printStackTrace();
    } }  
}
                                