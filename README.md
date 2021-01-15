# Progetto_Programmazione

## ROTTE:

 Tipo di chiamata: |  Chiamata:     |  Descrizione:
------------------ | -------------- | ---------------------------------------------------
GET                    | /{cognome}       | lista dei domini contententi il cognome non filtrati
GET                    | /{cognome}/stats | statistiche dei domini contenenti il cognome
GET                    | /{cognome}/filter?type=com&nation=it&alive=true | lista filtrata dei domini contenti il cognome
GET                    | /localstats      | statistiche dei domini dal file in locale
POST                   | /{cognome}/filter  | lista filtrata dei domini con la possibilità di concatenare più filtri 

La chiamta POST/{cognome}/filter a differenza di quella di tipo GET dà la possibilità di concatenare più filtri.

#### Esempio:

{

  "logica":"or",
  
  "type":{"or":\["com","it","fr","uk"]},
  
  "alive":{"eq":"true"}
  
}

## Diagrammi package e classi UML:

### Diagramma del package controller
 
<img src="UML_img/ControllerPackage.png" width="600">

### Diagramma del package model

<img src="UML_img/ModelPackage.png" width="500">

### Diagramma del package service

<img src="UML_img/ServicePackage.png" width="500">

### Diagramma del package util

<img src="UML_img/UtilPackage.png" width="500">

### Diagramma del package exception

<img src="UML_img/ExceptionPackage.png" width="600">




