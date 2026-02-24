# 📅 Sistema de Gestión de Reservas API

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![JSON](https://img.shields.io/badge/Data-JSON-lightgrey)

Este proyecto es una API REST robusta diseñada para gestionar el flujo de reservas, optimizando la manipulación de datos mediante la **Stream API** de Java y garantizando la precisión temporal con `LocalDateTime`.

## 🚀 Características

- **Gestión de Fechas Precisa:** Uso de `ISO-8601` para el manejo de `startDate` y `endDate`.
- **Transformación de Datos:** Implementación de `.map()` y `.stream()` para convertir Entidades en DTOs de forma eficiente.
- **Validación de Disponibilidad:** Lógica para evitar solapamiento de horarios.
- **Arquitectura Limpia:** Separación de responsabilidades entre Controladores, Servicios y Repositorios.

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3.x
* **Persistencia:** Spring Data JPA / Hibernate
* **Formateo de Datos:** Jackson (para el manejo de JSON y Fechas)
* **Herramientas:** Gradle, Git, postman
