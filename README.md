# ✈️ Spring Boot Project – Airline Booking System

Este proyecto implementa un sistema de gestión de reservas de vuelos utilizando **Spring Boot**, **JPA (Hibernate)** y una base de datos en memoria con **H2**.

Ha sido desarrollado como parte del ejercicio `lab-java-intro-to-jpa`, y se encuentra dentro de la carpeta:

```

lab-java-spring-airline/

```

---

## 📁 Estructura del proyecto

```

lab-java-spring-airline/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/example/airline/
│   │   │   ├── AirlineApplication.java
│   │   │   ├── enums/CustomerStatus.java
│   │   │   ├── models/
│   │   │   │   ├── Customer.java
│   │   │   │   ├── Flight.java
│   │   │   │   └── FlightBooking.java
│   │   │   └── repositories/
│   │   │       ├── CustomerRepository.java
│   │   │       ├── FlightRepository.java
│   │   │       └── FlightBookingRepository.java
│   └── test/java/com/example/airline/
│       └── AirlineApplicationTests.java
└── src/main/resources/application.properties

````

---

## 🧪 Funcionalidades implementadas

### ✅ Entidades (JPA)

- **Customer**
  - `customerName`, `customerStatus` (enum), `totalCustomerMileage`
- **Flight**
  - `flightNumber`, `aircraft`, `totalAircraftSeats`, `flightMileage`
- **FlightBooking**
  - Asociación entre `Customer` y `Flight`

### ✅ Enum

- `CustomerStatus` → `GOLD`, `SILVER`, `NONE`

### ✅ Repositorios

- `CustomerRepository`:
  - `findByCustomerName`
  - `findByCustomerStatus`
- `FlightRepository`:
  - `findByFlightNumber`
  - `findByAircraftContaining`
  - `findByFlightMileageGreaterThan`

---

## 🚀 Cómo ejecutar el proyecto

### ✅ Requisitos

- Java 17
- Maven
- IDE compatible (VS Code, IntelliJ, etc.)

### ▶️ Pasos

1. Abre una terminal en la carpeta `lab-java-spring-airline/`
2. Ejecuta la aplicación con Maven:

```bash
./mvnw spring-boot:run
````

(En Windows puede ser `mvnw.cmd spring-boot:run`)

3. Accede a la consola de H2:

```
http://localhost:8080/h2-console
```

* JDBC URL: `jdbc:h2:mem:testdb`
* Usuario: `sa`
* Contraseña: *(en blanco)*

---

## 🧪 Pruebas incluidas

Ejecutables desde tu IDE o terminal:

```bash
./mvnw test
```

### Tests incluidos:

* Crear clientes y vuelos
* Buscar clientes por nombre y estado
* Buscar vuelos por número, tipo de avión, o distancia
* Verificar integridad de relaciones y persistencia

---

## ✍️ Autora

Mábel Martínez
Proyecto desarrollado como parte del curso de **POO y GBBDD – Ironhack**.
