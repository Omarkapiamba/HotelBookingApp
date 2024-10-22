# HotelBookingApp

- **Work in Progress:** This project is still under active development, with several features and improvements planned for the future.

This application is developed using Java and Spring Boot. It provides functionality to manage hotel bookings, rooms, hotels, and user accounts. Spring Data JPA is used for database operations, allowing easy management of bookings and user data. Currently, the entities have minimal variables to ensure the project remains stable during development, with plans to add more once the project reaches a more stable phase.

# Features

## Admin
- **Login**
- **Manage Bookings**
- **Manage Hotels**
- **Manage Rooms**
- **Manage Users**

## User
- **Registration & Login**
- **Browse Hotels**
- **View Room Availability**
- **Book Rooms**
- **Manage Bookings**

## BookingController
- **Create Booking**
- **Get Booking by ID**
- **Get All Bookings**
- **Update Booking**
- **Delete Booking**

## HotelController
- **Get Hotel by ID**
- **Get All Hotels**
- **Create Hotel**
- **Update Hotel**
- **Delete Hotel**

## RoomController
- **Get Room by ID**
- **Get All Rooms**
- **Get Available Rooms**
- **Create Room**
- **Update Room**
- **Delete Room**

## UserAccountController
- **Get User by ID**
- **Get All Users**
- **Create User**
- **Update User**
- **Delete User**

# Technologies:
- Java 17 or above
- Spring Boot 3.0
- Maven
- MySQL/PostgreSQL (to be added)
- Spring Data JPA
- Docker (to be added)

# Planned Features:
- Fill entities with more variables, such as `checkInDate`, `checkOutDate`, `price`, `roomNumber`.
- Add `RoomType` functionality for rooms (e.g., Single, Double, Suite).
- Add Spring Security with JWT authentication for secure access.
- Implement user authentication and authorization.
- Integration of unit and integration tests.
- Logging for better traceability.
- Payment integration for booking payments.
- Add reviews and ratings for hotels and rooms.
- API documentation.
- Email notifications for booking confirmations.
- Multi-language support.
- Role-based user access.
- Containerization with Docker.
- Frontend development (to be decided later).
