package com.mongodb;

import freemarker.template.Configuration;

public class SparkFormHandling {

	public static void main(final String[] args) {
		// Configure Freemarker
		@SuppressWarnings("deprecation")
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(SparkFormHandling.class, "/");
	}

}
