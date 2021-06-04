# Programa de gestió d'una empresa de reserva de vehicles aeris

## 1-Manual d'usuari

### 1-Consultes

Obtenir avions consulta, ens retorna totes les dades que tenim a la taula avions

![Obtenir Avions](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/ObtenirAvions.png)

Obtenir models consulta, ens retorna totes les dades que tenim a la taula models

![Obtenir Models](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/ObtenirModels.png)

Obtenir reserves consulta, ens retorna totes les dades que tenim a la taula reserves

![Obtenir Reserves](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/ObtenirReserves.png)

Obtenir clients consulta, ens retorna totes les dades que tenim a la taula clients

![Obtenir Clients](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/ObtenirClients.png)

Obtenir empleats consulta, ens retorna totes les dades que tenim a la taula empleats

![Obtenir Empleats](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/ObtenirEmpleats.png)

### 2-Afegir Dades

1-Inserim Clients a la base de dades 

![Inserir Clients](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarClientIIJ.png)

1-Client afegit a la base de dades 

![Clients BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarClientBDD.png)

2- Inserim Empleats a la base de dades

![Inserir Empleats](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarEmpleatIIJ.PNG)

2-Empleat afegit a la base de dades

![Empleats BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarEmpleatBDD.png)

3-Inserim un model d'avió a la base de dades 

![Inserir Models](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarModelIIJ.png)

3-Model d'avió afegit a la base de dades

![Models BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarModeBDD.png)

4-Inserim avions a la base de dades

![Inserir Avions](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarAvioIIJ.png)

4-Avió afegit a la base de dades

![Avió BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarAvioBDD.png)

5-Inserim una reserva a la base de dades

![Inserir reserva](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarReservaIIJ.png)

5-Reserva afegida a la base de dades

![Reserva BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/InsertarReservaBDD.png)


### 3-Esborrar Dades

1-Esborrar Clients de la base de dades

![Esborrar Client](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarClientsIJJ.png)

1-Client esborrat de la base de dades

![Clients BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarClientsBDD.png)

2-Esborrar Empleats de la base de dades

![Esborrar Empleat](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarEmpleatIIJ.png)

2-Empleat esborrat de la base de dades

![Empleats BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarEmpleatBDD.png)

3-Esborrar Avió de la base de dades

![Esborrar Avió](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarAvioIIJ.png)

3-Avió esborrat de la base de dades

![Avió BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarAvioBDD.png)

4-Esborrar Reserves de la base de dades

![Esborrar Reserva](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarReservesIIJ.PNG)

4-Reserva esborrada de la base de dades

![Reserva BDD](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/EsborrarReservesBDD.PNG)

## 2-Interficie gráfica
### Accés a l'apliació amb un login simple amb DNI

![login](/images/login.png)

Totes les pestanyes inclouen la taula amb la funció de "Mostrat tots" com es veu a totes les imatges següents, les imatges a continuació són només dels apartats que tenen funcionalitats addicionals.

### Cerca de reserves per el DNI d'un client
![cercaReserves](/images/reservesCercar.png)

### Cerca d'avions disponibles per model (No reservats actualment)
![avionsDisponibles](/images/avionsDisponibles.png)

### Mostrar tots els clients existents
![clientsExistents](/images/clientsMostrarTots.png)

## 3-Vídeo

https://drive.google.com/file/d/1hPO-so587mMtNYDz3wHaRzhqG-c1EUbV/view?usp=sharing

## 3-POO

Hem decidit crear una part del menú que sigui consultes per poder consultar totes les dades que tenim de la base de dades separat per taules, hem creat també un altre part que sigui tant per afegir com per esborrar dades de la base i depenent de la taula que volguem esborrar la seleccionem i ens demana diferents coses 

![POO.png](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/POO.png)


## 4-VCS

A l'hora d'utilitzar GitHub ens hem organitzat de manera que cadascú treballava en diferents funcions que habíem discutit i repartit i s'anaven pujan a GitHub. Tenim dues branques, la main on s'anaven afegint la majoria de les funcionalitats programades junt a un codi per a l'utilització i testeig per consola i la branca javaFX on ha estat treballant en Daniel fent la part gráfica del programa incorporant les funcionalitats programades i afegides a la branca principal, finalment juntant les dos branques per a crear la versió final. No vam tenir cap problema a l'hora d'utilitzar GitHub.

## 5-UML

1-Diagrama de clases versió 1

[Link Captura Diagrama Clases Versio 1](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/diagramaClases.V1.png).

2-Diagrama de clase versió 2

[Link Captura Diagrama Clases Versio 2](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/diagramaClases.V2.png).

3-Diagrama d'Us

[Link Captura Diagrama d'Us](https://github.com/DanielDPM/M3UF4Projecte/blob/main/images/diagramaUs.png).


