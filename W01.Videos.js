BSON plays the role of a canonical (i.e., "unique") representation of documents shared across all drivers and tools.

In Mongo, documents are organized into collections, that are organized into databases.

A collection in a database represents a "namespace".
Ex:
> video.movies

When working with CRUD operations in the Mongo shell we allways work with the global variable "db".
"db" is a global variable that holds a reference to the database we are currently using.

> use video
> db.movies.insertOne({ "title": "Jaws", "year": 1975, "imdb": "tt0073195" })
{
	"acknowledged" : true, // The write operation was acknowledged and succeded
	"insertedId" : ObjectId("56754fa1223.....13be935") // What unique identifier was assigned to the document.
}

> db.movies.insertOne({ "title": "Mad Max 2: The Road Warrior", "year": 1981, "imdb": "tt0082694" })
> db.movies.insertOne({ "title": "Raiders of the Lost Ark", "year": 1981, "imdb": "tt0082971" })
> db.movies.find().pretty()
// Each document must have an unique _id (ObjectId is an addition value type supported by BSON)

// The take away I want you to have is that, at the heart of the query language for MongoDB is a "query by example" strategy.
> db.movies.find({})
> db.movies.find({ "title": "Jaws" }).pretty()
> db.movies.find({ "year": 1981 }).pretty()

// The return value of "find" is not simply an array of documents. It is instead, a cursor object.

> var c = db.movies.find()
> c.hasNext()
> c.next() // grab the next document and outputs


///////////////////////////////////////////////////////////////////////////////

Maven (build tool)
Installing and Using Maven

POM (Project Object Model)

> mvn
> mvn archetype:generate
> history
> mvn clean compile exec:java -Dexec.mainClass=com.mongodb.App


https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=intellij+idea+community

Download IntelliJ IDEA
File > Import Project...
// Navegar até o arquivo pom.xml do projeto a ser importado.















