# Proyecto E-Commerce 🚀

Una solución para el comercio electrónico basada en una arquitectura de microservicios, diseñada para ser escalable, modular y de fácil mantenimiento.

## Tecnologías Utilizadas 🛠️

Este proyecto ha sido desarrollado utilizando las siguientes tecnologías:

![Spring Boot](https://img.icons8.com/color/48/000000/spring-logo.png)
**Spring Boot**: Framework para la creación rápida y robusta de aplicaciones Java.
<br/>

![Spring Cloud](https://img.icons8.com/color/48/000000/cloud.png)
**Spring Cloud**: Conjunto de herramientas que facilitan la gestión y orquestación de microservicios.
<br/>

![Spring Security](https://img.icons8.com/color/48/000000/lock.png)
**Spring Security**: Módulo que aporta el manejo de autorizacion y autenticacion
<br/>

![Eureka](https://img.icons8.com/color/48/000000/network.png)
**Eureka Server**: Servidor de descubrimiento que permite registrar y localizar servicios en la arquitectura.
<br/>

![Docker](https://img.icons8.com/color/48/000000/docker.png)
**Docker**: Contenedorización
<br/>

**Keycloak**: Como proveedor de autenticacion
<br/>

**PostgreSQL**: Sistema de gestión de bases de datos relacional, robusto y confiable para el manejo de usuarios e items del catalogo
<br/>

![Redis](https://img.icons8.com/color/48/000000/redis.png)
**Redis**: Almacenamiento en memoria, de estilo no relacional. Utilizada para el almacenamiento volatil pero veloz en el servicio de carrito
<br/>
Microservicios implementados:
- Eureka-server: Utilizado para la implementación del patron service discovery y registry.
- Api gateway: Funcionando como unica puerta de acceso, permitiendo la implementación de seguridad, control de trafico y enrutamiento.
- Config service: Microservicio para la centralización de configuracion.
- Catalogo service
- Cart-service
- User service
