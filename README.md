# ⚽ Jugadores Backend API

API REST desarrollada con **Spring Boot** para la gestión de jugadores de fútbol, equipos, directores técnicos, títulos y premios.  
Proyecto creado con fines de **aprendizaje y portafolio**, aplicando buenas prácticas de backend.

---

## 🚀 Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3**
- Spring Web MVC
- Spring Data JPA
- **MySQL**
- **MapStruct**
- **Swagger / OpenAPI**
- Hibernate Validator
- Maven

---

## 📦 Funcionalidades principales

- 📋 Listado de jugadores
- 🔍 Búsqueda de jugadores por nombre o apellido
- 🧍‍♂️ Detalle completo de jugador:
    - Equipo actual
    - Trayectoria histórica
    - Títulos ganados
    - Premios obtenidos
- 🏟️ Gestión de equipos
- 🧑‍🏫 Gestión de directores técnicos
- 📚 Documentación interactiva con Swagger

---

## 📌 Ejemplo de respuesta (Jugador)

```json
{
  "id": 1,
  "nombreCompleto": "Juan Pereira",
  "nacionalidad": "Colombiana",
  "posicion": "MEDIOCAMPISTA",
  "edad": 27,
  "valorMercado": 1200000.00,
  "equipoActual": {
    "id": 1,
    "nombre": "Millonarios",
    "liga": "LIGA_BETPLAY"
  },
  "trayectoria": [
    {
      "equipoId": 1,
      "equipoNombre": "Millonarios",
      "fechaInicio": "2022-01-01",
      "fechaFin": null
    }
  ],
  "titulos": [
    {
      "nombre": "Liga BetPlay",
      "tipo": "LIGA",
      "anio": 2023
    }
  ],
  "premios": [
    {
      "nombre": "Goleador Liga",
      "tipo": "GOLEADOR",
      "anio": 2023
    }
  ]
}
