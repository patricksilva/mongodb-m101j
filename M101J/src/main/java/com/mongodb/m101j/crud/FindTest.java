package com.mongodb.m101j.crud;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.m101j.util.Helpers;

public class FindTest {
	public static void main(final String[] args) {
		final MongoClient 				client 	= new MongoClient();
		final MongoDatabase				db 		= client.getDatabase("course");
		final MongoCollection<Document> coll	= db.getCollection("findTest");
		
		coll.drop();
		
		// Generates sample data
		for (int i = 0; i < 10; i++) {
			coll.insertOne(new Document("x", i));
		}
		
		System.out.println("Find one:");
		final Document first = coll.find().first();
		Helpers.printJson(first);
		
		System.out.println("Find all with into:");
		final List<Document> all = coll.find().into(new ArrayList<Document>());
		for (final Document curr : all) {
			Helpers.printJson(curr);
		};
		
		System.out.println("Find all with interation");
		final MongoCursor<Document> cursor = coll.find().iterator();
		try {
			while ( cursor.hasNext() ) {
				final Document cur = cursor.next();
				Helpers.printJson(cur);
			}
		} finally {
			// Close the cursor
			cursor.close();
		}
		
		System.out.println("Count");
		final long count = coll.count();
		System.out.println(count);
		
		client.close();
	}
}
