package com.bourgeois.launcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private String elasticLocation;
	private String elasticHost;
	private String kibanaLocation;
	private String kibanaHost;
	private String pathLog;
	private String plugin;

	public Configuration() {
		final Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			elasticLocation = prop.getProperty("elastic.location");
			elasticHost = prop.getProperty("elastic.host");
			kibanaLocation = prop.getProperty("kibana.location");
			kibanaHost = prop.getProperty("kibana.host");
			pathLog = prop.getProperty("path.log");
			plugin = prop.getProperty("elastic.plugin");

		} catch (final IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ===============================
	// Getters and Setters
	// ===============================
	public String getElasticLocation() {
		return elasticLocation;
	}

	public String getPlugin() {
		return plugin;
	}

	public void setPlugin(String plugin) {
		this.plugin = plugin;
	}

	public String getElasticHost() {
		return elasticHost;
	}

	public String getKibanaLocation() {
		return kibanaLocation;
	}

	public String getKibanaHost() {
		return kibanaHost;
	}
	public String getPathLog() {
		return pathLog;
	}

} // end of class
