package com.mongodb.m101j.crud;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.m101j.util.Helpers;

public class InsertTest {
	public static void main(final String[] args) {
		final MongoClient 				client 	= new MongoClient();
		final MongoDatabase				db 		= client.getDatabase("course");
		final MongoCollection<Document> coll	= db.getCollection("insertTest");
		
		coll.drop();
		
		final Document smith = new Document()
									.append("name", "Smith")
									.append("age", 30)
									.append("profession", "programmer")
									.append("salary", 3500);
		final Document jones = new Document()
				.append("name", "Jones")
				.append("age", 25)
				.append("profession", "hacker")
				.append("salary", null);
		final Document susana = new Document()
				.append("name", "Susana")
				.append("age", 21)
				.append("profession", "Senior Software Architect")
				.append("salary", 7600);
		
		coll.insertOne(smith);
		coll.insertMany(Arrays.asList(susana, jones));
		
		Helpers.printJson(smith);
		Helpers.printJson(jones);
		
		client.close();
	}
}
