JSON data model advantages:

1. Developer teams can design data models to support common data access patterns.
ex: a team building a news website, can design a data model so that, the most frequently viewed pages, may require only a single query to the database. And can do this in an ellegant way that is fully supported by mongodb.

Contrast with a relational design, which would probably require several joins accross tables, or another ugly means of storying multiples values in single table fields.

Since mongodb data models are not predicated on JOINING data, from multiple tables together, it is much easy to distribute, or SHARD data, accross multiple servers, in unexpensive machines to a few larger more powerfull servers.
Scaling Out: Natively through its sharding feature. And does that in a way thats abstracted away from the application logic. Developers can develop their application in a way they can be agnostic about the deployment they use.
A single node or few or hundreds of nodes makes no difference from the perspective of the application.
In contrast, since JOINS and MULTI-TABLE TRANSACTIONS, are difficult to do in parallel, for a RELATIONAL SYSTEM your best option usually is SCALING UP, aquiring increasingly expensive hardware so the data can be served from a single server.
While not always true, multi-table joins and transactions are typically not missed in a MongoDB database, because the schema design capabilities support models that require atomic reads and writes only to individual documents.

Summary, MongoDB enables application developers to design data models that make sense for their applications.
That is, those that efficiently support common data access patterns.
MongoDB is designed to support agile software engineering practices and meet the scalability and performance needs of modern applications.

```
End to end view of what an application might look like using Java
{
	MongoDB, Mongo(shell), Java Applications { Frameworks:{ SparkJava(inspired by Sinatra), FreeMarker}}

	JVM
	{
		Our code: the Blog (CRUD)
		SparkJava(inspired by Sinatra): it easily set up routs that map to URLs, so that when a request comes in for a particular URL, we can handle it and we can make a response via HTTP.
		FreeMarker: is a templating language that allows us to create HTML views so that we can use Model View Controller type programming, where, you know, the view, which is the User Interface (UI), is separate from the controller, which handles user input in the model, which is the underlying logic of the application.
		Mongo Java Driver: is a library that is going to be linked in and that is actually going to be the part that is sort of making the TCP connections to MongoD for you.
	}

	Normally, for a web request, it would be port 80.
	But in this class we are often going to use 8082 because 80 is reserved, and a little difficult to use that port if you are not root on the computer.
	And then this might go through some sort of network address translation through a Linksys box or something like that.

	The point of this course is not to teach you how to be a web programmer.
	It is really to teach you how to use MongoDB.
	And so the motivating example for some of the work is this blog.
	But we do not expect yout to be able to create this whole thing from scratch for this course.
}
```

### Installing MongoDB

1. Download mongo installer
2. Execute installer
3. Copy path to executables
	C:\Program Files\MongoDB\Server\3.4\bin
4. Add the path to the environment variable path

### Quick set up

1. Create data directory
	Open command shell and type:
	>md \data
	>md \data\db

### Testing the MongoDB installation/configuration

1. On the same command shell, type:
>






