# **CASH-ONLINE**
## *Backend Exam*

### Context
This is a simple API REST made in Java basically with SpringBoot, Hibernate and a MySQL DB.
It includes users and loans, with their HTTP Methods itself (GET, POST, DELETE). It also has the possibility to paginate and filter the results in the case of the loans.

### Endpoints 

#### ● GET /users
 
#### ● GET /users/{userId}

#### ● DELETE /users/{userId}

#### ● POST /users
     Body:
      {
        "id": 1,
        "email": "test@app.com.ar",
        "first_name": "Pepe"
        "last_name": "Argento"
        "loans": [
          {
            "id": 1,
            "total": 2.500
            "user_id": 1
          }
        ]
      }
*Loans are optional*      
    
#### ● GET /loans
     Params:
        page
        size
        (Optional) user_id 

### Database Model (Tables)
#### Users
| id | email | first_name | last_name |
| -------- | -------- | -------- | -------- |
| 1 | agustinkoszczej@gmail.com | Agustín| Koszczej |
| ... | ... | ... | ... |

#### Loans
| id | total | user_id | 
| -------- | -------- | -------- |
| 1 | 2500 | 1 |
| 2 | 7500 | 1 |
| ... | ... | ... |

## Installation
#### 1. Clone this repo and import it with your favourite IDE (IntelliJ recommended).

#### 2. Download dependencies with Maven.

#### 3. Have a MySQL database created (named 'cash_online' preferably) and a user with the correct permissions (root as default).

#### 4. Edit the [application.properties](https://github.com/agustinkoszczej/api-rest-cash-online/blob/master/src/main/resources/application.properties) with your database configuration:

     spring.datasource.url = jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME?useSSL=false
     spring.datasource.username = 'YOUR_USERNAME' (default: root)
     spring.datasource.password = 'YOUR_PASSWORD' (default: root)
     
#### 5. Run the application!

#### 6. (Optional) Run the tests.

#### 7. (Recommended) Use [Postman](https://www.getpostman.com/) tu CURL, and import [this collection](https://github.com/agustinkoszczej/api-rest-cash-online/blob/master/Cash-Online.postman_collection.json)
    
### Features
* API Rest
* Java 8
* SpringBoot (MVC y JPA)
* Hibernate
* RDBMS (MySQL/MariaDB)
* Unit Testing
* Postman
* IntelliJ
