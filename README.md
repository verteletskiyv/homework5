_*initial IDs are 1-61._

**Get All** Books:
```
GET: http://localhost:8080/api/books/
```
**Get All** Genres:
```
GET: http://localhost:8080/api/genres/
```
**Get One** Book:<br>
```
GET: http://localhost:8080/api/books/{id}
```
**Create** a new book:
```
POST: http://localhost:8080/api/books/
e.g. body:
{
    "title": "Book Title",
    "author": "Book Author",
    "yearWritten": 2022,
    "genre": "Biography"
}
```
**Update** a book:<br>
```
PUT: http://localhost:8080/api/books/{id}
e.g. body:
{
    "title": "UPDATED Book Title",
    "author": "UPDATED Book Author",
    "yearWritten": 2023,
    "genre": "Fantasy"
}
```
**Search** by two fields:
``` 
POST: http://localhost:8080/api/books/_search
e.g. body:
{
    "author":"Jack London",
    "genre":"Fantasy",
    "pageNumber":0,
    "pageSize":2
}
```


**Delete** a book:<br>
``` 
DELETE: http://localhost:8080/api/books/{id}
```
