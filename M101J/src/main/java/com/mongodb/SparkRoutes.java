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
				return "Hello World from /!";
			}
		});
		
		Spark.get("/test", new Route() {
			@Override
			public Object handle(final Request arg0, final Response arg1) throws Exception {
				return "This is a /test page";
			}
		});
		
		Spark.get("/echo/:thing", new Route() {
			@Override
			public Object handle(final Request request, final Response resonse) throws Exception {
				return "Hello World from /echo/" + request.params(":thing");
			}
		});

	}

}
