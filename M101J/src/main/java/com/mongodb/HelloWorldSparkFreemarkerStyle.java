package com.mongodb;

import static spark.Spark.halt;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarkerStyle {
	public static void main(final String[] args) {
		
		/*
		 * This is the Freemarker configuration
		 * */
		@SuppressWarnings("deprecation")
		final Configuration configuration = new Configuration();
		// how to find the freemarker template file
		configuration.setClassForTemplateLoading(
				//resourceLoaderClass, basePackagePath
				HelloWorldSparkFreemarkerStyle.class, "/");

		/*
		 * We defined the rout to be the / to be the root path of our ficticious website.
		 * */
		Spark.get("/", new Route() {
			
			/*
			 * The handle method creates a template for "hello.ftl" (in scr/main/resources/hello.ftl).
			 * 
			 * */
			@Override
			public Object handle(final Request arg0, final Response arg1) throws Exception {
				
				/*
				 * We also created a string writer. That the Freemarker processes the template into. 
				 * */
				final StringWriter writer = new StringWriter();

				try {
					final Template helloTemplate = configuration.getTemplate("hello.ftl");
					
					/*
					 * We defined a map with the "name" "key" and the value os "Fremarker".
					 * */
					final Map<String, Object> helloMap = new HashMap<String, Object>();
					helloMap.put("name", "Freemarker based WebSite!");
					
					/*
					 * We process the template
					 * */
					helloTemplate.process(helloMap, writer);
				} catch (final Exception e) {
					halt(500); 
					e.printStackTrace();
					
				}
				/*
				 * And we return the writer, at the end. 
				 * */
				return writer;
			}
		});
	}
}
