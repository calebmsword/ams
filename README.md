# Bank Account Management System Backend

NOTE: This repo contains the back-end of our project. The front-end is not yet created but the link to it will be provided when it is!

## Project Description

Bank Account Management System is a simple app for users to manage finances in their bank accounts.

## Technologies Used

- Java
- Spring Boot
- mySQL
- JUnit

## Getting Started

This section will be written eventually :p

Potential improvements will be written eventually :p

## Features & Usage

The following API calls can be made. The list below applies to ALL endpoints:

- A `:` in front of a portion of the path means to replace that section with
  your desired value.
- Unless otherwise indicated, no body should be included.
- All request/response bodies must be in JSON.
- Any dates must be sent as a string in
  [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format.
  For example, Friday 6 August 2021 would be sent as `'2021-08-06'`.

### HTTP Codes to Expect

| Code | Meaning               | Usage                                                                                                                                                                                            |
| ---- | --------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 200  | OK                    | Should be returned on everything but `POST` requests                                                                                                                                             |
| 201  | Created               | Should only be returned on `POST` requests)                                                                                                                                                      |
| 400  | Bad Request           | Will be returned if there is an error with your syntax, an error in the types you used in the body of the message, or if you violated a database constraint (such as a foreign key relationship) |
| 500  | Internal Server Error | Will be returned if the database is unreachable                                                                                                                                                  |

_Any code returned not in this list indicates that something has gone wrong._

### Batch

- `GET` to `/user` will get all Users
- `POST` to `/user` will create a new User (will be unconfirmed);
  requires the following body:
  ```JSON
  {
    "password": String,
    "roleId": number
  }
  ```

## Contributors

- [Caleb Sword](https://github.com/calebmsword)

## License

[![MIT](https://img.shields.io/github/license/RevatureRobert/2106Jun07RNCN-2-p2-be?style=for-the-badge)](https://github.com/Perfect-Personnel-Placement/backend/blob/cce792fb7b2227d101d330f048cc7a3d8ff762ec/LICENSE)
