package mi_proyecto;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

        OffsetDateTime observedAt = OffsetDateTime.now().withNano(0);




            ApiClient apiClient = Configuration.getDefaultApiClient();
            apiClient.setBasePath("http://localhost:1026/ngsi-ld/v1");
            ContextInformationConsumptionApi consumoApi = new ContextInformationConsumptionApi(apiClient);
            ContextInformationProvisionApi apiInstance = new ContextInformationProvisionApi(apiClient);
            boolean existeCompany = false;
            boolean existeCamara = false;
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
            


        //Entidades Person:
                
                System.out.println("Cuantas personas quieres registrar?");
                int numPersonas = Integer.parseInt(scanner.nextLine());

                for(int i = 0; i < numPersonas; i++){
                    System.out.print("Introduce el nombre de la persona: ");
                    String nombre = scanner.nextLine();
                    existePerson = false;

                    try {
                        URI entityUri4 = new URI("urn:ngsi-ld:Person:" + nombre);
                        QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                        entityUri4, null, null, null, null, null, null, null, null);
                        existePerson = true;
                    } catch (ApiException e){}
    
                    if(existePerson){
                        System.out.println("La persona ya estaba registrada.");
                    }else{
                        Person person = new Person();
                        person.putAdditionalProperty("id", "urn:ngsi-ld:Person:" + nombre);
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

                    try {
                        URI entityUri5 = new URI("urn:ngsi-ld:City:" + nombreCiudad);
                        QueryEntity200ResponseInner entidad = consumoApi.retrieveEntity(
                        entityUri5, null, null, null, null, null, null, null, null);
                        existeCity = true;
                    } catch (ApiException e){}

                    if(existeCity){
                        System.out.println("La ciudad ya está registrada.");
                    }else{
                        city.putAdditionalProperty("id", "urn:ngsi-ld:City:" + nombreCiudad);
                        city.setType(City.TypeEnum.CITY);
                        city.setName(new Name().value(nombreCiudad));

                        String jsonCi = city.toJson();

                        QueryEntity200ResponseInner entityCi = QueryEntity200ResponseInner.fromJson(jsonCi);

                        ApiResponse<Void> responseCi = apiInstance.createEntityWithHttpInfo(null, null, null, entityCi);

                        System.out.println("Código de respuesta: " + responseCi.getStatusCode());
                    }
                }
            
            //Entidad Vehicle:
                System.out.println("Nombre del propietario del vehiculo:");
                String nombrePropietario = scanner.nextLine();

                IsParked isParked = new IsParked();
                URI entityUri6 = new URI("urn:ngsi-ld:OffStreetParking:" + nombreParkingComprobado);
                isParked.setObject(entityUri6);
                isParked.setObjectType(new URI("OffStreetParking")); //esta bien?? recibe una uri pero que uri hay que poner?
                isParked.setObservedAt(observedAt);

                ProvidedBy providedBy2 = new ProvidedBy();
                providedBy2.setObject(new URI("urn:ngsi-ld:Person:" + nombrePropietario));
                isParked.setProvidedBy(providedBy2);

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


                //Route route = new Route();
                

                System.out.println("¿Por cuantas ciudades pasa tu ruta?");
                int numCiudadesRuta = Integer.parseInt(scanner.nextLine());
                
                /*List<Object> rutaUris = new ArrayList<>();
                for (int i = 0; i < numCiudadesRuta; i++) {
                    System.out.print("Introduce el nombre de la " + (i + 1) + "ª ciudad: ");
                    String nombreCiudad = scanner.nextLine();

                    rutaUris.add("urn:ngsi-ld:City:" + nombreCiudad);

                }
                route.setObjectList(rutaUris);
                route.setObjectType(new URI("City"));*/

                 
                /*List<Map<String, String>> rutaUris = new ArrayList<>();

                for (int i = 0; i < numCiudadesRuta; i++) {
                    System.out.print("Introduce el nombre de la " + (i + 1) + "ª ciudad: ");
                    String nombreCiudad = scanner.nextLine();
                
                    Map<String, String> ciudadMap = new HashMap<>();
                    ciudadMap.put("object", "urn:ngsi-ld:City:" + nombreCiudad);  
                    rutaUris.add(ciudadMap);
                }
                
                Map<String, Object> routeAttr = new HashMap<>();
                routeAttr.put("type", "Property");  
                Map<String, Object> innerValue = new HashMap<>();
                innerValue.put("type", "ListRelationship");
                innerValue.put("objectList", rutaUris);
                innerValue.put("objectType", "City");

                routeAttr.put("value", innerValue);*/

                List<String> rutaUris = new ArrayList<>();
                for (int i = 0; i < numCiudadesRuta; i++) {
                    System.out.print("Introduce el nombre de la " + (i+1) + "ª ciudad: ");
                    String nombreCiudad = scanner.nextLine();
                    rutaUris.add("urn:ngsi-ld:City:" + nombreCiudad);
                }

                Map<String,Object> routeAttr = new HashMap<>();
                routeAttr.put("type", "Relationship");
                routeAttr.put("object", rutaUris);
                
                

                /* 
                List<Object> rutaUris = new ArrayList<>();
                for (int i = 0; i < numCiudadesRuta; i++) {
                    System.out.print("Introduce el nombre de la " + (i + 1) + "ª ciudad: ");
                    String nombreCiudad = scanner.nextLine();

                    Map<String, Object> ciudadMap = new HashMap<>();
                    ciudadMap.put("type", "Relationship"); 
                    ciudadMap.put("object", "urn:ngsi-ld:City:" + nombreCiudad);

                    rutaUris.add(ciudadMap);
                }
                route.setObjectList(rutaUris);
                route.setObjectType(new URI("City"));*/
                /* 
                List<Map<String, Object>> rutaUris = new ArrayList<>();

                for (int i = 0; i < numCiudadesRuta; i++) {
                    System.out.print("Introduce el nombre de la " + (i + 1) + "ª ciudad: ");
                    String nombreCiudad = scanner.nextLine();

                    Map<String, Object> ciudadMap = new HashMap<>();
                    ciudadMap.put("type", "Relationship");
                    ciudadMap.put("object", "urn:ngsi-ld:City:" + nombreCiudad);

                    rutaUris.add(ciudadMap);
                }

                Map<String, Object> routeAttr = new HashMap<>();
                routeAttr.put("type", "ListRelationship");
                routeAttr.put("objectList", rutaUris);
                routeAttr.put("objectType", "City");*/





                Vehicle vehicle = new Vehicle(); 
                 
                    System.out.print("Introduce la matrícula del vehículo: ");
                    String matricula = scanner.nextLine();
                    
                    vehicle.putAdditionalProperty("id", "urn:ngsi-ld:Vehicle:" + matricula);
                    vehicle.setType(Vehicle.TypeEnum.VEHICLE);
                    System.out.println("Introduce la marca del vehículo: ");
                    String marca = scanner.nextLine();
                    vehicle.setBrandName(new BrandName().value(marca));
                    System.out.println("Introduce la calle: "); //calle donde esta empadronado o????
                    String calle = scanner.nextLine();
                    //vehicle.setStreet();
                    vehicle.setIsParked(isParked);
                    vehicle.setPassengers(passengers);
                    
                    System.out.println("Introduce la categoría del vehículo: ");
                    String categoria = scanner.nextLine();

                    //vehicle.setCategory(new Category().vocab(categoria));
                    Map<String, Object> categoryAttr = new HashMap<>();
                    categoryAttr.put("type", "Property");
                    categoryAttr.put("value", categoria);
                    vehicle.putAdditionalProperty("category", categoryAttr);

                    //vehicle.setTyreTreadDepths(new TyreTreadDepths().valueList(Arrays.asList("300", "300", "120", "120")));
                    /*Map<String, Object> tyreAttr = new HashMap<>();
                    tyreAttr.put("type", "Property");
                    tyreAttr.put("value", Arrays.asList("300", "300", "120", "120"));
                    tyreAttr.put("unitCode", "MMT"); 

                    //vehicle.putAdditionalProperty("tyreTreadDepths", tyreAttr);*/
                    Map<String,Object> tyreAttr = new HashMap<>();
                    tyreAttr.put("type",  "Property");
                    tyreAttr.put("value", Arrays.asList("300","300","120","120"));
                    tyreAttr.put("unitCode", "MMT");

                    vehicle.putAdditionalProperty("tyreTreadDepths", tyreAttr);

                    vehicle.putAdditionalProperty("route", routeAttr);

                
                String jsonV = vehicle.toJson();
                System.out.println("JSON del vehículo: " + jsonV);
                QueryEntity200ResponseInner entityV = QueryEntity200ResponseInner.fromJson(jsonV);
                ApiResponse<Void> responseV = apiInstance.createEntityWithHttpInfo(null, null, null, entityV);
                System.out.println("Código de respuesta: " + responseV.getStatusCode());

    } catch (Exception e) {
        e.printStackTrace();
    } }
    
}
