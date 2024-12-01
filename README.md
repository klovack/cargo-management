# Project Title: Cargo Management System
**Objective**: Build a simplified cargo management application to manage cargo bookings and view cargo details. The project should demonstrate knowledge of Spring Boot for backend development and Angular for the frontend. The system will consist of RESTful APIs, database interaction, and a frontend to interact with the backend.

## Problem Statement
You are tasked with developing a Cargo Management System to manage cargo bookings for an airline company. The system should allow users to:

1. Create a new cargo booking with details such as customer name, cargo weight, destination, and cargo type.
2. Retrieve a list of all bookings.
3. View detailed information for a specific booking.
4. Update a booking (e.g., change cargo weight or destination).
5. Delete a booking.
6. Display a dashboard showing total bookings and aggregated cargo weight.

## Requirements
### Backend (Spring Boot)

- **REST APIs**:

  - Create Booking (POST /api/bookings)
  - Get All Bookings (GET /api/bookings)
  - Get Booking By ID (GET /api/bookings/{id})
  - Update Booking (PUT /api/bookings/{id})
  - Delete Booking (DELETE /api/bookings/{id})
  - Dashboard (GET /api/dashboard) to return:
    - Total number of bookings.
    - Total cargo weight.

- **Database**: Use MongoDB (or any relational database like PostgreSQL/Oracle). The Booking entity should include:

  - id (UUID or auto-generated)
  - customerName (String)
  - cargoType (Enum: FRAGILE, PERISHABLE, STANDARD)
  - cargoWeight (Double)
  - destination (String)
  - bookingDate (LocalDateTime)


- **Key Backend Concepts**:

  - Use Spring Data JPA (or Spring Data MongoDB) for database interactions.
  - Implement validation using @Valid for input data.
  - Handle exceptions with @ControllerAdvice and @ExceptionHandler.
  - Write a service layer to encapsulate business logic.
  - Use @RestController to expose endpoints.


### Frontend (Angular)

- **Pages/Components**:

  - Booking List:
  - Display all bookings in a table with columns for customer name, cargo type, weight, destination, and actions (View, Edit, Delete).
  - Create Booking:
  - Form to create a new booking (validate input fields).
  - Edit Booking:
  - Form to edit an existing booking (pre-filled with current data).
  - Dashboard:
  - Display total bookings and aggregated cargo weight.

- **Key Angular Concepts**:

  - Use PrimeNG for UI components (tables, forms, buttons, etc.).
  - Implement routing with lazy loading.
  - Use HttpClient to call backend APIs.
  - Implement reactive forms for input handling.
  - Handle state management using services.
  - Show loading indicators and error messages.

## Technical Stack

### Backend:

- Spring Boot
- MongoDB or PostgreSQL
- Java/Kotlin
- Maven
- Swagger/OpenAPI (optional, for API documentation)


### Frontend:

- Angular (latest version)
- Angular Material
- RxJS for reactive programming
- SCSS or CSS for styling
