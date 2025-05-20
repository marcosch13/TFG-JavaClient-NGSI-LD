package mi_proyecto;

import java.util.Scanner;

public class consola {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while(opcion != 0){
            System.out.println("*****Menú de pruebas para entidades NGSI-LD*****");
            System.out.println("1: Crear parking");
            System.out.println("2: Crear vehículo");
            System.out.println("3: Actualizar availableSpotNumbers");
            System.out.println("4: Borrar todas las entidades");
            System.out.println("5:consultar entidades");
            System.out.println("6:actualizar parking");
            System.out.println("7:actualizar vehículo");
            System.out.println("8: Consultar entidad por id");
            System.out.println("0: Salir");
            System.out.print("Selecciona una opción: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }if(opcion == 1){

                System.out.println("\n[+] Crear parking"); 
                createParking.main(null);

            }else if(opcion == 2) {

                System.out.println("Crear vehículo");
                createVehicle.main(null);

            }else if(opcion == 3) {
                addAvailableSpot.main(null);

            }else if(opcion == 4) {
                deleteAllEntities.main(null);

            }else if(opcion == 5) {

                System.out.println("Consultando entidades");
                queryEntities.main(null);

            }else if(opcion == 6) {
                
                System.out.println("Actualizando parking");
                updateParking.main(null);

            }else if(opcion == 7) {
                
                System.out.println("Actualizando vehículo");
                updateVehicle.main(null);

            }else if(opcion == 8) {
                
                retrieveEntitiesById.main(null);

            }else if(opcion == 0) {
                System.out.println("Saliendo del programa...");
                System.exit(0);
            }else{
                System.out.println("Opción no válida.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
    

