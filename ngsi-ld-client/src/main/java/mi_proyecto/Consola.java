package mi_proyecto;

import java.util.Scanner;

public class Consola{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while(opcion != 0){
            System.out.println("*****Menú de pruebas para entidades NGSI-LD*****");
            System.out.println("1: Crear entidad IoT");
            System.out.println("2: Borrar entidad IoT");
            System.out.println("3: Consultar entidades IoT");
            System.out.println("0: Salir");
            System.out.print("Selecciona una opción: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            if(opcion == 1){
                System.out.println("\n[+] Crear entidad IoT");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println("[+] Ejecutando CreateIotDevice con ID: " + idNum + "\n");
                CreateIotDevice.main(new String[]{idNum}); 
            }else if(opcion == 2) {
                System.out.println("\n[+] Borrar entidad IoT");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println("[+] Ejecutando DeleteIotDevice con ID: " + idNum + "\n");
                DeleteIotDevice.main(new String[]{idNum}); 
            }else if(opcion == 3) {
                System.out.println("\n[+] Consultar entidades IoT");
                System.out.println("[+] Ejecutando QueryIotDevices\n");
                QueryIotDevices.main(null); 
            }
            else if(opcion == 0) {
                System.out.println("Saliendo del programa...");
            }else{
                System.out.println("Opción no válida.");
            }

            System.out.println();
        }

        scanner.close();
    }
}
