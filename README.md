# TFG-JavaClient-NGSI-LD

Este repositorio contiene 4 ramas en las que se encuentra el cliente java desarrollado en el trabajo, diferenciando entre casos de uso y context broker utilizado.

## Contenido del repositorio

### - Cliente-java-Iot-OrionLD

    Contiene el cliente para el caso de uso de Iot y el Context Broker Orion-LD.

### - Cliente-java-Iot-Scorpio

    Contiene el cliente con el caso de uso de Iot y el Context Broker Scorpio.

### - Cliente-java-Iot-Subscriptions

    Contiene el cliente con el caso de uso de Iot y el Context Broker Scorpio con el servicio de recepción de notifiaciones de las subscripciones a entidades.

### - Cliente-java-Vehicle-Scorpio

    Contiene el cliente con el caso de vehicular y el Context Broker Scorpio.


## Cómo ejecutar los distintos escenarios

### 1. Situarse en el caso que se desea ejecutar
```bash
    cd cliente-java-IoT-Scorpio
```
### 2. Desde la carpeta ngsi-ld-client(en dos terminales distintas) levantar los servicios Docker y compilar el proyecto.
```bash
    #Situarse en la carpeta:
    cd ngsi-ld-client

    #Levantar servicios Docker:
    docker compose up 

    #Compilar:
    mvn clean compile 

    #Ejecutar el script de consola interactiva para poder utilziar los diferentes scripts de prueba del cliente
    mvn exec:java -Dexec.mainClass="mi_proyecto.consola"
```

### 3. En caso de que el servicio Context Broker no arranque correctamente ejecutar este comando antes de ejecutar "docker compose up"

```bash
    docker compose down -v
```
