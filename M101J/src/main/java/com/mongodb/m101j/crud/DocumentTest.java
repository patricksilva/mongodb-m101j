package com.mongodb.m101j.crud;

import static com.mongodb.m101j.util.Helpers.printJson;

import java.util.Arrays;
import java.util.Date;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.types.ObjectId;

public class DocumentTest {

	public static void main(final String[] args) {
		
		final Document document = new Document()
				.append("str", "MongoDB, Hello")
				.append("int", 42)
				.append("l", 1L)
				.append("double", 1.1)
				.append("b", false)
				.append("date", new Date())
				.append("objectId", new ObjectId())
				.append("null", null)
				// A Bson document can have nested documents, or lists
				.append("embeddedDoc", new Document("x", 0))
				.append("list", Arrays.asList(1, 2, 3)); // 1, 2, 3 could be any objects that the Document class supports. List of lists, list of documents, list of doubles or a mix of types if needed. 
		
		//String str = (String) document.getString("str");
		printJson(document);
		
		// Same thing could be done using a Type-safe based class:
//		final BsonDocument bsonDocument = new BsonDocument("str", new BsonString("MongoDB, Hello"));
		final BsonDocument bsonDocument = new BsonDocument()
				.append("str", new BsonString("MongoDB, Hello"))
				.append("int", new BsonInt64(1000));
//				bsonDocument.append("int", new BsonInt64(1000));
		
		System.out.println(bsonDocument);
		

	}

}
