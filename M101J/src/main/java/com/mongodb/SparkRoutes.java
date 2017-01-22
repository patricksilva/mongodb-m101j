package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkRoutes {

	public static void main(String[] args) {
		
		Spark.get("/", new Route() {

			@Override
			public Object handle(final Request arg0, final Response arg1) throws Exception {
				
				return null;
			}
			
		});

	}

}
