# TrainTicketBookingApp
Train Ticket Booking App which allows to book tickets between London and France.

## Features

- Purchase a train ticket from London to France for $20.
- Generate a receipt with details including departure, destination, user information, and price paid.
- Allocate a seat to the user in either section A or section B.
- View the details of the receipt for a user.
- View users and their allocated seats by section.
- Remove a user from the train.
- Modify a user's seat.

## Endpoints

### 1) Purchase a Ticket

- **URL**: `/api/purchase`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
      "firstName": "Ambikadas",
      "lastName": "Chirammel",
      "email": "ambikadas@outlook.com"
  }
- **Response**:
  ```json
  {
    "from": "London",
    "to": "France",
    "user": {
        "firstName": "Ambikadas",
        "lastName": "Chirammel",
        "email": "ambikadas@outlook.com",
        "seat": "A1"
    },
    "price": 20.0
  }
  
## 2) Get Ticket
## URL: /api/ticket/{email}
## Method: GET
- **Response**:
  ```json
  {
      "from": "London",
    "to": "France",
    "user": {
        "firstName": "Ambikadas",
        "lastName": "Chirammel",
        "email": "ambikadas@outlook.com",
        "seat": "A1"
    },
    "price": 20.0
  }

## 3) View Users by Section
## URL: /api/users/{section}
## Method: GET
- **Response**:
  ```json
  {
    "ambikadas@outlook.com": {
        "firstName": "Ambikadas",
        "lastName": "Chirammel",
        "email": "ambikadas@outlook.com",
        "seat": "A1"
    }
  }

## 4) Remove User from train
## URL: /api/user/{email}
## Method: DELETE

## 5) Modify User Seat
## URL: /api/user/seat
## Method: PUT
## Request Params:
## email: User's email
## newSeat: New seat allocation


