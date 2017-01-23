package com.mongodb;

import static spark.Spark.halt;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkFormHandling {

	public static void main(final String[] args) {
		// Configure Freemarker
		@SuppressWarnings("deprecation")
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");
		
		// Configure routes
		Spark.get("/", new Route(){
			@Override
			public Object handle(final Request request, final Response response) throws Exception {
				try {
					final Map<String, Object> fruitsMap = new HashMap<String, Object>();
					fruitsMap.put("fruits",
							Arrays.asList("apple", "orange", "banana", "peach"));
					final Template fruitPickerTemplate = configuration.getTemplate("fruitPicker.ftl");
					final StringWriter writer = new StringWriter();
					fruitPickerTemplate.process(fruitsMap, writer);
					return writer;
				} catch (final Exception e) {
					halt(500);
					return null;
				}
			}
		});
	}

}
