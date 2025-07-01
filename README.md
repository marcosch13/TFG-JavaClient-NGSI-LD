# TFG-JavaClient-NGSI-LD

Este repositorio contiene 4 ramas en las que se encuentra el cliente java desarrollado en el trabajo, diferenciando entre casos de uso y context broker utilizado.

## Contenido del repositorio

### cliente-java-Iot-OrionLD

Contiene el cliente para el caso de uso de Iot y el Context Broker Orion-LD.

### cliente-java-Iot-Scorpio

Contiene el cliente con el caso de uso de Iot y el Context Broker Scorpio.

### cliente-java-Iot-Subscriptions

Contiene el cliente con el caso de uso de Iot y el Context Broker Scorpio con el servicio de recepción de notifiaciones de las subscripciones a entidades.

### cliente-java-Vehicle-Scorpio

Contiene el cliente con el caso de vehicular y el Context Broker Scorpio.


## Cómo ejecutar los distintos escenarios

### 1. Situarse en el caso que se desea ejecutar
    ```bash
    cd cliente-java-IoT-Scorpio
    ```
### 2. Desde la carpeta ngsi-ld-client(en dos terminales distintas) levantar los servicios Docker y compilar el proyecto.
```bash
    cd ngsi-ld-client

    #compilar
    mvn clean compile 

    #Consola interactiva para scripts de prueba del cliente
    mvn exec:java -Dexec.mainClass="mi_proyecto.consola"
    
    #Levantar servicios
    docker compose up 
```

### 3. En caso de que el servicio Context Broker no arranque correctamente ejecutar este comando antes de ejecutar "docker compose up"

```bash
    docker compose down -v
```
