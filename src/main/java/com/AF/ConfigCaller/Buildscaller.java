package com.AF.ConfigCaller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Buildscaller {

	protected Properties prop = null;
	protected InputStream input = new FileInputStream("src/main/resources/Builds.properties");

	public Buildscaller() throws IOException {
		prop = new Properties();
		prop.load(input);
	}

	public String getwebappbuildVersion() {
		return prop.getProperty("webappversion");
	}
	
	public String getsupportbuildVersion(){
		return prop.getProperty("supportdashbuildVersion");
	}
	
	public String getapplication_number(){
		return prop.getProperty("application_number");
	}
	
	public String getstagingwebappbuildVersion(){
		return prop.getProperty("stagingwebappbuildVersion");
	}
	
	

}
