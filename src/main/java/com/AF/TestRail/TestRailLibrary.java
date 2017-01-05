package com.AF.TestRail;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import Libraries.LibrariesExtensions;

public class TestRailLibrary extends LibrariesExtensions {

	public static APIClient client = new APIClient("https://autogravity.testrail.com/");

	public static Logger log = Logger.getLogger(TestRailLibrary.class);

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public static void main(String [] args) throws Exception{
	// //updateresult(15, 1239, false);
	//
	// }

	public static APIClient testrailsapiLogin() {
		APIClient client = new APIClient("https://autogravity.testrail.com/");
		client.setUser("francisco@autogravity.com");
		client.setPassword("Autogravity!@#4");
		return client;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void updateresult(String testrun, int casenumber, boolean value)
			throws MalformedURLException, IOException, APIException {
		int testrunvalid = LibrariesExtensions.convertstringtoInt(testrun);
		APIClient client = new APIClient("https://autogravity.testrail.com/");
		client.setUser("francisco@autogravity.com");
		client.setPassword("Autogravity!@#4");
		JSONObject c = (JSONObject) client.sendGet("/get_case/" + casenumber);
		log.info("Suite ID: " + c.get("suite_id"));
		log.info("ID: " + c.get("id"));
		log.info("Title: " + c.get("title"));
		log.info("Priority ID: " + c.get("priority_id"));
		log.info("Refs: " + c.get("refs"));
		HashMap data = new HashMap();
		if (value == true) {
			data.put("status_id", new Integer(1));
			data.put("comment", "Test passed." + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		} else if (value == false) {
			data.put("status_id", new Integer(5));
			data.put("comment", "Test case failed." + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		}
		// else if( value == "blocked"){
		// data.put("status_id", new Integer(2));
		// data.put("comment", "Test blocked." + Timestamp());
		// c = (JSONObject) client.sendPost("add_result_for_case/"+ testrunvalid
		// +"/" + casenumber, data);
		// }
		client.sendGet("/get_results_for_case/" + testrunvalid + "/" + casenumber);
		String getstatus = c.get("status_id").toString();
		int status = Integer.parseInt(getstatus);
		switch (status) {
		case 1:
			log.info("Status ID: " + status + " -------Passed");
			break;

		case 2:
			log.info("Status ID: " + status + " -------Blocked");
			break;

		case 3:
			log.info("Status ID: " + status + " -------Untested");
			break;

		case 4:
			log.info("Status ID: " + status + " -------Retest");
			break;

		case 5:
			log.info("Status ID: " + status + " -------Failed");
			break;

		default:
			log.info("No status available");
		}
	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static void updateresult(String testrun, int casenumber, String blocked)
//			throws MalformedURLException, IOException, APIException {
//		int testrunvalid = LibrariesExtensions.convertstringtoInt(testrun);
//		APIClient client = new APIClient("https://autogravity.testrail.com/");
//		client.setUser("francisco@autogravity.com");
//		client.setPassword("Autogravity!@#4");
//		JSONObject c = (JSONObject) client.sendGet("/get_case/" + casenumber);
//		log.info("Suite ID: " + c.get("suite_id"));
//		log.info("ID: " + c.get("id"));
//		log.info("Title: " + c.get("title"));
//		log.info("Priority ID: " + c.get("priority_id"));
//		log.info("Refs: " + c.get("refs"));
//		HashMap data = new HashMap();
//		if (blocked == "blocked") {
//			data.put("status_id", new Integer(2));
//			data.put("comment", "Test passed." + Timestamp());
//			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
//		}
//		// else if (blocked == false){
//		// data.put("status_id", new Integer(5));
//		// data.put("comment", "Test case failed." + Timestamp());
//		// c = (JSONObject) client.sendPost("add_result_for_case/"+ testrunvalid
//		// +"/" + casenumber, data);
//		// }
//		// else if( value == "blocked"){
//		// data.put("status_id", new Integer(2));
//		// data.put("comment", "Test blocked." + Timestamp());
//		// c = (JSONObject) client.sendPost("add_result_for_case/"+ testrunvalid
//		// +"/" + casenumber, data);
//		// }
//		client.sendGet("/get_results_for_case/" + testrunvalid + "/" + casenumber);
//		String getstatus = c.get("status_id").toString();
//		int status = Integer.parseInt(getstatus);
//		switch (status) {
//		case 1:
//			log.info("Status ID: " + status + " -------Passed");
//			break;
//
//		case 2:
//			log.info("Status ID: " + status + " -------Blocked");
//			break;
//
//		case 3:
//			log.info("Status ID: " + status + " -------Untested");
//			break;
//
//		case 4:
//			log.info("Status ID: " + status + " -------Retest");
//			break;
//
//		case 5:
//			log.info("Status ID: " + status + " -------Failed");
//			break;
//
//		default:
//			log.info("No status available");
//		}
//	}

	public static void updateresult(String testrun, int casenumber, int status, String message)
			throws MalformedURLException, IOException, APIException {
		int testrunvalid = LibrariesExtensions.convertstringtoInt(testrun);
		APIClient client = new APIClient("https://autogravity.testrail.com/");
		client.setUser("francisco@autogravity.com");
		client.setPassword("Autogravity!@#4");
		JSONObject c = (JSONObject) client.sendGet("/get_case/" + casenumber);
		// log.info("Suite ID: " + c.get("suite_id"));
		//log.info("ID: " + c.get("id"));
		log.info("Title: " + c.get("title"));
		// log.info("Priority ID: " + c.get("priority_id"));
		//log.info("Refs: " + c.get("refs"));
		HashMap data = new HashMap();
		if (status == 1) {
			data.put("status_id", new Integer(1));
			data.put("comment", "Test passed.\n" + message + "\n" + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		} else if (status == 2) {
			data.put("status_id", new Integer(2));
			data.put("comment", "Test blocked.\n" + message + "\n" + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		} /*
			 * else if (status == 3) { data.put("status_id", new Integer(3));
			 * data.put("comment", "Untested." + Timestamp()); c = (JSONObject)
			 * client.sendPost("add_result_for_case/" + testrunvalid + "/" +
			 * casenumber, data); }
			 */ else if (status == 4) {
			data.put("status_id", new Integer(4));
			data.put("comment", "Retested.\n" + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		} else if (status == 5) {
			data.put("status_id", new Integer(5));
			data.put("comment", "Test case failed.\n" + message + "\n" + Timestamp());
			c = (JSONObject) client.sendPost("add_result_for_case/" + testrunvalid + "/" + casenumber, data);
		}
		client.sendGet("/get_results_for_case/" + testrunvalid + "/" + casenumber);
		switch (status) {
		case 1:
			log.info("Status ID: " + status + " ---Passed");
			break;
		case 2:
			log.info("Status ID: " + status + " ---Blocked");
			break;

		case 3:
			log.info("Status ID: " + status + " ---Untested");
			break;

		case 4:
			log.info("Status ID: " + status + " ---Retest");
			break;

		case 5:
			log.info("Status ID: " + status + " ---Failed");
			break;

		default:
			log.info("Missing Result!");
		}
		//log.info("\n");
	}

	public static void addtestcase() {
	}

	public static void getcaseresults(String apicall, int tcnumber) throws IOException, APIException {
		// TODO: Get case results
	}

}
