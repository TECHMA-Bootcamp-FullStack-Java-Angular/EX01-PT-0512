<div align="center"><img width="80%"  src="https://github.com/TECHMA-Bootcamp-FullStack-Java-Angular/dmb-tsys-java-2010-ta15/blob/main/docs/logoDark.png?raw=trueg"  alt="Logo BootCamp" /></div>

# BootCamp T-Systems

![My etiqueta](https://img.shields.io/badge/David%20Maza-DiveCode%F0%9F%90%99-blue) ![UD](https://img.shields.io/badge/TA-26_1-orange)  ![Java Version](https://img.shields.io/badge/SprintBoot-Raillway-red)


#### ### Rules of use 🤜🏼🤛🏼

- Run the clone repository in your terminal:

``git clone https://github.com/TECHMA-Bootcamp-FullStack-Java-Angular/EX01-PT-0512.git``


- Access the folder with the command:

`cd EX01-PT-0512.git `

- Open the repository with your IDE, remember to have the SQL service running

- Update the dependencies and remember to create the databases


# PUEBA TECNICA

1.    Introducción
En el presente proyecto del Bootcamp Full Stack correspondiente a la parte Spring Framework se espera que el alumno demuestre todos los conocimientos adquiridos en desarrollo de APIs. 

2.    Descripción 
Dada la situación sanitaria, una empresa tecnológica ha estado trabajando en remoto desde marzo de 2020. Esto ha implicado que nuestros compañeros hayan perdido el contacto humano que siempre se ha tenido, y es algo que la empresa desea cambiar. 

La empresa quiere dar un impulso a la manera que tienen los trabajadores de relacionarse, permitiendo que contacten entre ellos creando grupos de interés. 

Una primera fase de este proyecto es crear una aplicación web LFG, que permita que los  empleados  puedan  contactar  con  otros  compañeros  para formar grupos para jugar a un videojuego, con el objetivo de poder compartir un rato de ocio afterwork. 

Los requisitos funcionales de la aplicación son los siguientes: 

### RF.1   Los   usuarios   se   tienen   que   poder   registrar   a   la   aplicación, estableciendo un usuario/contraseña. 

POST 
http://localhost:8181/api/v1/user

```{
  "id": 0,
  "username": "string",
  "password": "string",
  "email": "string",
  "worker_code": "string"
}
```

#### RF.2   Los usuarios tienen que autenticarse a la aplicación haciendo login.

http://localhost:8181/login

### RF.3   Los   usuarios  tienen  que  poder  crear  Partídas  (grupos)  para  un determinado videojuego.

POST /api/v1/party

http://localhost:8181/api/v1/party

```
{
  "id": 0,
  "title": "string",
  "meetup": "string",
  "game": {
    "id": 0,
    "title": "string",
    "description": "string"
  },
  "created_by": {
    "id": 0,
    "username": "string",
    "password": "string",
    "email": "string",
    "worker_code": "string"
  }
}

```

### RF.4  Los  usuarios  tienen  que  poder  buscar  Partídas  seleccionando  un videojuego.

GET /api/v1/party/{game_title}

http://localhost:8181/api/v1/party/{game_title}

### RF.5  Los usuarios pueden entrar y salir de una Party. 

POST /api/v1/party_menber

http://localhost:8181/api/v1/party_menber

```
{
  "id": 0,
  "user": {
    "id": 0,
    "username": "string",
    "password": "string",
    "email": "string",
    "worker_code": "string"
  },
  "party": {
    "id": 0,
    "title": "string",
    "meetup": "string",
    "game": {
      "id": 0,
      "title": "string",
      "description": "string"
    },
    "created_by": {
      "id": 0,
      "username": "string",
      "password": "string",
      "email": "string",
      "worker_code": "string"
    }
  }
}

```

DELETE /api/v1/party_menber/{id}

http://localhost:8181/api/v1/party_menber/{id}

### RF.6  Los  usuarios  tienen  que  poder  enviar  mensajes  a  la  Party. Estos mensajes tienen que poder ser editados y borrados por su usuario creador. 

PUT /api/v1/messge/{id}

http://localhost:8181/messge/{id}/{name}

DETETE /api/v1/messge/{id}

http://localhost:8181/messge/{id}/{name}

POST /api/v1/message

http://localhost:8181/api/v1/message
```
{
  "id": 0,
  "content": "string",
  "time_sent": "2023-12-05T16:54:07.665Z",
  "sender": {
    "id": 0,
    "username": "string",
    "password": "string",
    "email": "string",
    "worker_code": "string"
  },
  "party": {
    "id": 0,
    "title": "string",
    "meetup": "string",
    "game": {
      "id": 0,
      "title": "string",
      "description": "string"
    },
    "created_by": {
      "id": 0,
      "username": "string",
      "password": "string",
      "email": "string",
      "worker_code": "string"
    }
  }
}
```

### RF.7  Los mensajes que existan en una Party se tienen que visualizar como un chat común. 

GET /api/v1/messages

http://localhost:8181/api/v1/messages

### RF.8 Los usuarios pueden introducir y modiﬁcar sus datos de perﬁl, por ejemplo, su usuario de Steam. 

POST /api/v1/user

http://localhost:8181/api/v1/user

```
{
  "id": 0,
  "username": "string",
  "password": "string",
  "email": "string",
  "worker_code": "string"
}
```

PUT  /api/v1/user/{id}

http://localhost:8181/api/v1/user{id}

### RF.9 Los usuarios tienen que poder hacer logout de la aplicación web. 

http://localhost:8181/logout


En esta primera fase de proyecto el alumno ha de realizar una  API REST completa,   con   Spring Framework,   que   cumpla   con   los   requisitos   anteriormente planteados. 

Deﬁne los endpoints necesarios para que el backend pueda cumplir con lo establecido, nutriendo las diferentes vistas de frontend. 

Además de de lo mencionado anteriormente el alumno ha de incluir la siguiente funcionalidad: 

Excelente Readme (IMPORTANTE). 
Deploy en Heroku tanto BBDD como API.
OPCIONAL: 

Registro de usuarios.
Login de usuarios + JWT 
Debes adjuntar las URL de los repositorios GIT de cada uno de los ejercicios. Recuerda que tienes fecha límite de entrega. 
