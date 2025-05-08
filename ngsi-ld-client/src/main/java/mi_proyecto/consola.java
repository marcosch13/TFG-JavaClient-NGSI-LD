package mi_proyecto;

import java.util.Scanner;

public class consola {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while(opcion != 0){
            System.out.println("*****Menú de pruebas para entidades NGSI-LD*****");
            System.out.println("1: Crear entidad");
            System.out.println("2: Crear vehículo");
            System.out.println("5:consultar entidades");
            System.out.println("0: Salir");
            System.out.print("Selecciona una opción: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }if(opcion == 1){

                System.out.println("\n[+] Crear entidad");
                System.out.print("Introduce el ID de tu compañía, cámara, spotNumber con espacios entre si: ");
                String idV = scanner.nextLine(); 
                String[] ids = idV.trim().split("\\s+");
                createEntity.main(ids);

            }else if(opcion == 2) {

                System.out.println("Crear vehículo");
                createVehicle.main(null);

            }else if(opcion == 5) {

                System.out.println("Consultando entidades");
                queryEntities.main(null);

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
    

