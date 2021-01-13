# Progetto_Programmazione
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

## ROTTE:
GET /{cognome} // elenco domini non filtrati

GET /{cognome}/stats

GET /{cognome}/filter?type=com&nation=it&alive=true

GET /localstats

POST /{cognome}/filter  // Filtro multiplo
{
  "logica":"or",
  "type":{"or":\["com","it","fr","uk"]},
  "alive":{"eq":"true"}
}

