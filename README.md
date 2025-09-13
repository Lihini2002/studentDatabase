

````markdown
# Student Management System (Console Version)

A simple **Java console-based application** for managing student records using `Scanner` for input and a `StudentDAO` class for database operations. The program allows users to **add, view, update, and delete student information**.

---

## Features

- **Add Student**: Input name, age, and email to store a new student record.
- **View Students**: Display all student records from the database.
- **Update Student**: Modify an existing student record by providing the student ID.
- **Delete Student**: Remove a student record using the student ID.
- **Input Validation**: Handles invalid input (non-numeric values) gracefully without crashing.
- **Menu-Driven Interface**: Easy-to-use console menu for navigating operations.

---

## Technologies Used

- **Java 8+**
- **JDBC** (via `StudentDAO`) for database interactions
- **Scanner** for console input
- **Exception Handling** (`InputMismatchException`) for robust input validation

---

## Setup Instructions

### 1. Clone the Repository

Open a terminal and run:

```bash
git clone https://github.com/USERNAME/StudentManagementSystem.git
cd StudentManagementSystem
````

### 2. Configure the Database

Create a file named `config.properties` in the `src` folder with the following content:

```properties
db.url=jdbc:mysql://localhost:3306/studentdb
db.user=YOUR_DB_USERNAME
db.password=YOUR_DB_PASSWORD
```

* Replace `YOUR_DB_USERNAME` and `YOUR_DB_PASSWORD` with your MySQL credentials.
* Make sure the MySQL user has access to the `studentdb` database.

### 3. Compile the Project

In the terminal, run:

```bash
javac -cp . src/Mainapplication.java
```

### 4. Run the Application

Run the program using:

```bash
java -cp src Mainapplication
```

---

## Notes

* Requires a working MySQL database and proper credentials in `config.properties`.
* All input is validated for numbers, preventing crashes due to invalid input.
* `StudentDAO` handles the actual database CRUD operations.

---

## Usage

Run the application to see the menu:

```text
===== Student Management System =====
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Exit
Enter your choice:
```

* Enter a number corresponding to the action you want to perform.
* If you enter invalid input (like letters instead of numbers), the program will show a friendly error message and return to the menu.
* Continue performing operations until you choose **Exit**.

```


