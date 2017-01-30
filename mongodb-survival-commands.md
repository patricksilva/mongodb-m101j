
# MongoDB Survival Commands

## Exibir os databases
> show dbs

## Utilizar um database
> use DATABASENAME

## Exibir as collections
> show collections

## Exibir o database em uso
> db

## Excluir uma collection
> db.moviesScratch.drop()

## Excluir um database
> db.dropDatabase()

## Restaurar um dump
> mongorestore dump

## Importar um JSON

https://docs.mongodb.com/manual/reference/program/mongoimport/

> mongoimport --db users --collection contacts --file contacts.json

## Creating documents
insertOne()
insertMany()
insertMany({ "movie": "Jaws" }, { "ordered": false })

## Creating documents via Update commands ("upserts")

## Read operations

### Equality Searches
db.movieDetails.find( { rated: "PG-13" } ).count()

#### Scalar valued fields
db.movieDetails.find( { rated: "PG-13", year : 2009 } ).count()

#### Nested documents
db.movieDetails.find( { "tomato.meter" : 100 } ).pretty()

#### Array fields

* On the entire array
* Based on any element
* Based on a specific element
* More complex matches using operators (discussed in another lesson)

##### Identifying documents by an exact match to an array of one or more values

For these types of queries, the order of elements matters.

db.movieDetails.find( { "writers": [ "Ethan Coen", "Joel Coen" ] } ).count()

When we want to match any element in an array with a specific value:

db.movieDetails.find( { "actors": "Jeff Bridges" } ).pretty()

db.movieDetails.find( { "actors.0": "Jeff Bridges" } ).pretty()

### Cursors

The find method returns a cursor.
To access documents you need to iterate through the cursor.

var c = db.movieDetails.find();
var doc = function() { return c.hasNext() ? c.next() : null; }

c.objsLeftInBatch();

doc()
doc()
doc()

c.objsLeftInBatch();

Read more at [cursors][1]


### Projection

Is a handy way of reducing the size of the data returned for any one query.

Explicitly include fields in documents returned.

db.movieDetails.find( { "rated": "PG-13" }, { "title": 1 } ).pretty()

Explicitly exclude fields.

db.movieDetails.find( { "rated": "PG-13" }, { "title": 1 } ).pretty()

_id is always returned.

db.movieDetails.find( { "rated": "PG-13" }, { "title": 1, "_id": 0 } ).pretty()


[1]:docs.mongodb.org













"date" : "2015-10-27T22:35:21.908Z",

The return of value of find is not simply an array of objects.
It is instead, a CURSOR OBJECT.

> help
> show dbs
> use [db name]
> show collections
> db.movies.insertOne( { "title" : "Jaws", "year": 1975, "imdb": "tt0073195" } )
> db.movies.insertOne( { "title" : "Mad Max 2: The Road Warrior", "year": 1981, "imdb": "tt0082694" } )
> db.movies.insertOne( { "title" : "Raiders of the Lost Ark", "year": 1981, "imdb": "tt0082971" } )
> db.movies.find({ "year" : 1981}).pretty()
> cursor.hasNext()
> cursor.next()
