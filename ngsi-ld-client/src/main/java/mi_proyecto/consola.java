package mi_proyecto;

import java.util.Scanner;

public class consola{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while(opcion != 0){
            System.out.println("*****Menú de pruebas para entidades NGSI-LD*****");
            System.out.println("1: Crear entidad IoT");
            System.out.println("2: Crear entidad IoT con sensores");
            System.out.println("3: Crear sensor de humedad");
            System.out.println("4: Crear sensor de temperatura");
            System.out.println("5: Consultar entidades IoT");
            System.out.println("6: Actualizar entidad IoT");
            System.out.println("7: Actualizar sensor de temperatura");
            System.out.println("8: Actualizar sensor de humedad");
            System.out.println("9: Borrar entidad IoT");
            System.out.println("10:Borrar sensor de temperatura");
            System.out.println("11:Borrar sensor de humedad");
            System.out.println("12:Upsert de entidad/es");
            System.out.println("13:Borrar todas las entidades");
            System.out.println("14:Actualizar atributos existentes");
            System.out.println("15:Consultar entidad por ID");
            System.out.println("16: Actualizar atributos del sensor de humedad");
            System.out.println("17: Actualizar atributos del sensor de temperatura");
            System.out.println("0: Salir");
            System.out.print("Selecciona una opción: ");

            try{
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            if(opcion == 1){
                System.out.println("\n Crear entidad IoT");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando CreateIotDevice con ID: " + idNum + "\n");
                CreateIotEntity.main(new String[]{idNum}); 
            }else if(opcion == 2){
                System.out.println("\n Crear entidad IoT con sensores");
                System.out.print("Introduce los 3 números de ID (IotId IdTemperatura IdHumedad): ");
                String idNum = scanner.nextLine();
                String[] ids = idNum.trim().split("\\s+");
                System.out.println(" Ejecutando CreateIotEntityWithSensors con IDs: " + String.join(", ", ids) + "\n");
                CreateIotEntityWithSensors.main(ids);
            }else if(opcion == 3){
                System.out.println("\n Crear sensor de humedad");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando CreateHumiditySensorEntity con ID: " + idNum + "\n");
                CreateHumiditySensorEntity.main(new String[]{idNum}); 
            }else if(opcion == 4){
                System.out.println("\n Crear sensor de temperarura");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando CreateTemperatureSensorEntity con ID: " + idNum + "\n");
                CreateTemperatureSensorEntity.main(new String[]{idNum}); 
            }else if(opcion == 5) {
                System.out.println("\n Consultar entidades IoT");
                System.out.println(" Ejecutando QueryIotDevices\n");
                QueryIotEntities.main(null); 
            }else if(opcion == 6){
                System.out.println("\n Actualizar entidad IoT");
                System.out.print("Introduce el ID del dispositivo IoT ");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                UpdateIotEntity.main(new String[]{idNum});
            }else if(opcion == 7){
                System.out.println("\n Actualizar sensor de temperatura");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando UpdateTemperatureSensor con ID: " + idNum + "\n");
                UpdateTemperatureSensor.main(new String[]{idNum}); 
            }else if(opcion == 8){
                System.out.println("\n Actualizar sensor de humedad");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando UpdateHUmiditySensor con ID: " + idNum + "\n");
                UpdateHumiditySensor.main(new String[]{idNum}); 
            }else if(opcion == 9) {
                System.out.println("\n Borrar entidad IoT");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando DeleteIotEntity con ID: " + idNum + "\n");
                DeleteIotEntity.main(new String[]{idNum}); 
            }else if(opcion == 10) {
                System.out.println("\n Borrar sensor de temperatura");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando deleteTemperatureSensor con ID: " + idNum + "\n");
                deleteTemperatureSensor.main(new String[]{idNum}); 
            }else if(opcion == 11) {
                System.out.println("\n Borrar sensor de humedad");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                System.out.println(" Ejecutando deleteHumiditySensor con ID: " + idNum + "\n");
                deleteHumiditySensor.main(new String[]{idNum}); 
            }else if(opcion == 12) {
                System.out.println("\n Upsert entities");
                UpsertIotSensors.main(null);
            }else if(opcion == 13) {
                System.out.println("\n Borrando todas las entidades");
                DeleteAllEntities.main(null);
            }else if(opcion == 14) {
                System.out.println("\n Actualizar atributos existentes");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                UpdateIotAtributes.main(new String[]{idNum});
            }else if(opcion == 15) {
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                retrieveEntityById.main(new String[]{idNum});
            }else if(opcion == 16) {
                System.out.println("\n Actualizar atributos existentes");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                UpdateHumiditySensorAtributes.main(new String[]{idNum});
            }else if(opcion == 17) {
                System.out.println("\n Actualizar atributos existentes");
                System.out.print("Introduce el número de ID: ");
                String idNum = scanner.nextLine();
                UpdateTemperatureSensorAtributes.main(new String[]{idNum});
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
