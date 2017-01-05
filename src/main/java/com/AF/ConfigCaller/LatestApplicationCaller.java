package com.AF.ConfigCaller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LatestApplicationCaller {

	protected Properties prop = null;
	protected InputStream input = new FileInputStream("src/main/resources/LatestAppData.properties");

	public LatestApplicationCaller() throws IOException {
		prop = new Properties();
		prop.load(input);
	}

	public String getappNumber() {
		return prop.getProperty("appNumber");
	}

	public String getsubmittedEmail() {
		return prop.getProperty("submittedEmail");
	}

}
