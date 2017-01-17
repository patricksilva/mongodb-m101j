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

https://maven.apache.org/install.html

POM (Project Object Model)

#### Criando um novo projeto com auxílio do Maven

> mvn
> mvn archetype:generate

Pressionar "Enter" para escolher o "archetype" default = 909: remote -> org.apache.maven.archetypes:maven-archetype-quickstart (An archetype which contains a sample Maven project.)
Pressionar "Enter" para escolher a verão defaut.
Maven requer um groupId. Similarmente aos pacotes java.
Também requer um artifactId. Um nome para o projeto.


> Define value for property 'groupId': : com.mongodb
> Define value for property 'artifactId': : M101J
> Define value for property 'version':  1.0-SNAPSHOT: :
> Define value for property 'package':  com.mongodb: :




Define value for property 'groupId': : com.mongodb
Define value for property 'artifactId': : M101J
Define value for property 'version':  1.0-SNAPSHOT: :
Define value for property 'package':  com.mongodb: :
Confirm properties configuration:
groupId: com.mongodb
artifactId: M101J
version: 1.0-SNAPSHOT
package: com.mongodb
 Y: :
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.1
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: C:\Users\patrick.silva
[INFO] Parameter: package, Value: com.mongodb
[INFO] Parameter: groupId, Value: com.mongodb
[INFO] Parameter: artifactId, Value: M101J
[INFO] Parameter: packageName, Value: com.mongodb
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: C:\Users\patrick.silva\M101J
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 09:02 min
[INFO] Finished at: 2017-01-17T07:42:44-02:00
[INFO] Final Memory: 13M/94M
[INFO] ------------------------------------------------------------------------


> history
> mvn clean compile exec:java -Dexec.mainClass=com.mongodb.App


https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=intellij+idea+community

Download IntelliJ IDEA
File > Import Project...
// Navegar até o arquivo pom.xml do projeto a ser importado.

1. Get started with web applications framework.

When our goal for this class is to just do the simplest thing possible and chose a framework that has the mininum dependencies and is really easy to get started we decided to use:

www.sparkjava.com/why.html

"Micro Web Framework (not intended to compete with Sinatra, Grafitti, Nancy, Flask, Sammy, etc...)"
"It is totally different paradigm when compared to the overuse of annotations for accomplishing pretty trivial stuff seen in JAX-RS"

Like the mongo java driver, we have to import into your project.
Since it is not in maven repository, we have to tell maven where to download it:

Add the following to pom.xml:

<repository>
	<id>Spark repository</id>
	<url>http://www.sparkjava.com/nexus/content/repositories/spark/</url>
</repository>

Add the spark dependency:
<dependency>
	<groupId>spark</groupId>
	<artifactId>spark</artifactId>
	<version>0.9.9.4-SNAPSHOT</version>
</dependency>





https://university.mongodb.com/courses/MongoDB/M101J/2017_January/courseware/Week_1_Introduction/52549da3e2d4231cc6084010/vertical_22b7b7697881
1:40
