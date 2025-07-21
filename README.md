<h1 align="center"> ForoHub Challenge ONE ✉️ </h1>

![Static Badge](https://img.shields.io/badge/version%201.0.0-gray) ![Java](https://img.shields.io/badge/Java-17%2B-blue.svg) ![Badge en Desarollo](https://img.shields.io/badge/status-en%20desarrollo-darkgreen) ![Last commit](https://img.shields.io/github/last-commit/fullbuster-t/ForoHub)

Proyecto backend desarrollado como tercer challenge en Oracle Next Education. Se centra en la creación de foros en donde los participantes pueden hacer y contestar preguntas sobre los temas que les sean de interes.

<h2> Descripción del proyecto 📃</h2> 

El programa permite a los usuarios crear topicos, responder en ellos y editar topicos y respuestas.

**Las opciones con las que cuenta el programa son las siguientes:**
1. Crear topicos
2. Mostrar una lista de los topicos creados
3. Consulta de topicos en especifico
4. Actualizar topicos
5. Eliminación de topicos
6. Aunteticación/autorización para restringir el acceso a la información por medio de JWT

<h2> Tecnologías 📂</h2>

**Lenguaje de desarrollo:**
Java usando jdk 17

**Dependencias:**
Se hace uso de las siguientes dependencias:

*Spring Boot*:
* Lombok
* spring-boot-starter-data-jpa: para integrar Spring Data JPA y gestionar la persistencia de datos.

*Base de datos y JPA*
* spring-boot-starter-data-jpa: para la integración con JPA y realizar operaciones CRUD sobre las entidades.
* mysql: para el almacenamiento de datos

*Otras dependencias*
* jwt: json web token para el manejo de autenticación de usuarios
* jakarta.persistence-api: para las anotaciones de persistencia (como @Entity y @Id) y la integración con JPA.
* spring-boot-starter: dependencia base para un proyecto de Spring Boot que incluye los elementos fundamentales.

**Arquitectura:**
Modelo basado en capas:
- Capa de API: contiene los controladores REST y las configuraciones de seguridad
- Capa de dominio: se encarga de definir las entidades, repositorios y DTOs
- Capa e ianfraestructura: incluye configuración referente a la base de datos

<h2> Cómo ejecutar el programa 💻</h2>

**Requisitos previos:**
1. JDK 17 o superior.
2. Maven o Gradle para la gestión de dependencias.
3. MySQL como base de datos.

**Ejecución del proyecto:**
1. Clona el repositorio usando:
```bash
git clone https://github.com/fullbuster-t/ForoHub.git
```
2. Configura la base de datos: crea una base de datos en MySQL y actualiza las credenciales en el fichero application.properties
```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/{nombre de tu base de datos}
    spring.datasource.username={usuario}
    spring.datasource.password={contraseña}
    spring.jpa.hibernate.ddl-auto=update
```
3. Si estás usando algún IDE de desarrollo, basta con correr la aplicación.

<h2> Autor 🙋</h2>

<img src="https://avatars.githubusercontent.com/fullbuster-t?v=4" width="115" style="border-radius: 50%;">

Fullbuster - SoftDev 🇲🇽

