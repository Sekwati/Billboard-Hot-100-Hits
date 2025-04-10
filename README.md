# Billboard Hits - Spring Boot Application

## Overview
Billboard Hits is a Spring Boot-based REST API for managing and retrieving top songs from the Billboard charts. The application interacts with a PostgreSQL database to store song details, allowing users to perform CRUD operations and filter songs based on different criteria.

## Features
- Retrieve all songs from the database
- Search for songs by name, artist, spot, peak position, or weeks on the chart
- Add new songs to the database
- Update existing song details
- Delete songs from the database

## Technologies Used
- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **ORM:** Hibernate (JPA)
- **Build Tool:** Maven
- **Version Control:** Git & GitHub

## Setup and Installation
### Prerequisites
Ensure you have the following installed:
- Java 17 or later
- PostgreSQL
- Maven
- Eclipse (or any preferred IDE with Git integration)
- Git

### Database Configuration
Create a PostgreSQL database named `billboard` and update `application.properties` accordingly:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/billboard
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### Running the Application
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/billboard-hits.git
   cd billboard-hits
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/api/v1/song` | Retrieve all songs |
| GET | `/api/v1/song?songName=Name` | Search songs by name |
| GET | `/api/v1/song?artist=Artist` | Search songs by artist |
| GET | `/api/v1/song?spot=1` | Get songs by spot position |
| GET | `/api/v1/song?peakPosition=1` | Get songs by peak position |
| GET | `/api/v1/song?weeksOnChart=10` | Get songs by weeks on chart |
| POST | `/api/v1/song` | Add a new song |
| PUT | `/api/v1/song` | Update an existing song |
| DELETE | `/api/v1/song/{songName}` | Delete a song by name |

## Future Enhancements
- Improve API efficiency and database indexing
- Implement authentication and authorization
- Build a front-end for user interaction

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request.



