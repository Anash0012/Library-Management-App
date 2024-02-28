# Library Management System

 This project implements a simple Library Management System using Spring Boot. It allows managing books and users, allocating and deallocating books to users.

## Entities
#### Book 
* Id: Unique identifier of the book.
* Name: Name of the book. Cannot be empty.
* Author: Author of the book. Cannot be empty.
* Publisher: Publisher of the book. Cannot be empty.
* PublishedYear: Year of publication of the book.
* Isbn: ISBN number of the book.
* User: User to whom the book is allocated.
#### User
* Id: Unique identifier of the user.
* Name: Name of the user. Cannot be empty.
* EmailId: Email ID of the user.
* ContactNumber: Contact number of the user.
## Controller Endpoints
#### BookController
* GET /books: Retrieve all books.
* GET /book/id/{id}: Retrieve a book by its ID.
* POST /book: Add a new book.
* POST /books: Add multiple books.
* PUT /book/id/{id}: Update details of an existing book.
* DELETE /book/id/{id}: Delete a book by its ID.
#### UserController
* GET /users: Retrieve all users.
* GET /user/id/{id}: Retrieve a user by its ID.
* POST /user: Add a new user.
* DELETE /user/id/{id}: Delete a user by its ID.
* PUT /user/id/{id}: Update details of an existing user.
* POST /user/userId/{userId}/bookId/{bookId}/allocate: Allocate a book to a user.
* POST /user/userId/{userId}/bookId/{bookId}/deallocate: Deallocate a book from a user.
## Service Layer
* BookService: Provides CRUD operations for books.
* UserService: Provides CRUD operations for users and methods for allocating and deallocating books to users.
## Usage
1. Clone the repository.
2. Open the project in your preferred IDE.
3. Configure the database settings in `application.properties`.
4. Run the application.
5. Access the endpoints using a REST client or browser.
## Dependencies
* Spring Boot
* Spring Data JPA
* Mysql Database (or any other database of your choice)
* Spring Web
* Lombok
Note
Make sure to set up the database according to your configuration before running the application.