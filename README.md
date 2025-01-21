# Web Flux Exo

---
## Executing project
Before you run this project be sure to have Docker installed.
When Docker is installed run in ``~/webfluxExo/``
```ps
docker-compose up -d
```

## Exercises

### Ex 1 - Endpoints
| Verb | Route        | Desc                                                     |
|------|--------------|----------------------------------------------------------|
| GET  | /api/number  | return a flux of number from 1 to 5                      |
| GET  | /api/welcome | return a mono containing ``Welcome to Project Reactor!`` |

### Ex 2 - Endpoints
| Verb | Route                  | Desc                                                            |
|------|------------------------|-----------------------------------------------------------------|
| GET  | /api/processed-numbers | return a flux of even number contain in a (1;10) multiply by 10 |

### Ex 3 - Endpoints
| Verb | Route               | Desc                                             |
|------|---------------------|--------------------------------------------------|
| GET  | /api/error-resume   | return a flux broken by an error                 |
| GET  | /api/error-continue | return a flux where the second member is ignored |
### Ex 4 - Endpoints
| Verb | Route         | Desc                   |
|------|---------------|------------------------|
| GET  | /api/articles | return 3 article title |
### Ex 5 - Endpoints
| Verb   | Route           | Desc                                                                                                                                                                    |
|--------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | /api/tasks      | return a flux containing all task                                                                                                                                       |
| GET    | /api/tasks/{id} | return a mono containing the task corresponding to `{id}` or an empty mono if not found                                                                                 |
| POST   | /api/tasks/     | require a `Task` and return the task saved                                                                                                                              |
| PUT    | /api/tasks/{id} | require a `Task` and return the task corresponding to `{id}` or an empty mono if not found, some fields can be set to `null` to not change the original `Task`'s fields |
| DELETE | /api/tasks/{id} | return `Deleted Task#{id}` after deleting the task corresponding to `{id}` or `Task#{id} not found!` if not found                                                       |

#### json example for `Task`
```json
{
  "id": 2,
  "description": "Restriction of Upper Vein with Intraluminal Device, Percutaneous Approach",
  "completed": true
}
```

### Ex 6 - Endpoints
| Verb   | Route                           | Desc                                                                                                                     |
|--------|---------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| GET    | /api/books                      | return a flux containing all book                                                                                        |
| GET    | /api/books/{id}                 | return a mono containing the book corresponding to `{id}` or an empty mono if not found                                  |
| POST   | /api/books/                     | require a `Book` and return the book saved                                                                               |
| GET    | /api/books/search?title={title} | return a flux of `Books` that the title contains `{title}`. if `?title={title}` is omitted return the list of all books. |
| DELETE | /api/books/{id}                 | return `Deleted Book#{id}` after deleting the bok corresponding to `{id}` or an empty Mono if not found  if not found.   |

#### json example for `Book`
```json
{
  "isbn": "9788412098570",
  "title": "Mausritter",
  "author": "Isaac Williams"
}
```
### Ex 7 - Endpoints
| Verb   | Route           | Desc                                                                                                                                      |
|--------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | /api/users      | return a flux containing all users                                                                                                        |
| GET    | /api/users/{id} | return a mono containing the user corresponding to `{id}`                                                                                 |
| POST   | /api/users/     | require a `User` and return the user saved                                                                                                |
| PUT    | /api/users/{id} | require a `User` and return the user corresponding to `{id}`, some fields can be set to `null` to not change the original `User`'s fields |
| DELETE | /api/users/{id} | delete the user corresponding to `{id}`                                                                                                   |

#### json example for `User`
```json
{
  "id": "678f9b70fa707570378de990",
  "name": "toto",
  "email": "toto@mail.doe",
  "active": true
}
```