package Libraries;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;

import com.AF.ConfigCaller.Buildscaller;
import com.AF.ConfigCaller.Propertycaller;

import Libraries.WebAppCoreMethods;
import Libraries.constants;

public class PostResponse {

	public static Logger log = Logger.getLogger(WebAppCoreMethods.class);
	private static Propertycaller data;
	private static constants cons;
	private static Buildscaller bd;

	public static void postResponse(String url, String urlParameters, String appStatus) {
		URL obj;
		try {
			bd = new Buildscaller();
			obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			HttpHeaders head = new HttpHeaders();

			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestMethod("POST");

			String urlParameter = urlParameters;
			String updatedappversion = urlParameter.replace("<replaceAppNumber>", bd.getapplication_number());
			String finalparameterList = updatedappversion.replace("<ReplaceApplicationStatus>", appStatus);
			// Send Post Request
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setDoInput(true);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(finalparameterList);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			log.info("Sending 'Post' request to URL: " + url);
			log.info("Post parameters: " + finalparameterList);
			log.info("Status Code: " + responseCode);

			if (responseCode == HttpsURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				log.info("Response is: " + response);
				LibrariesExtensions.writetoRecorder("MBFS: " + appStatus);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					log.info("Failed in thread sleep");
					e.printStackTrace();
				}
			} else if (responseCode == HttpsURLConnection.HTTP_BAD_REQUEST) {
				log.info("Cannot Process Application, Unknown Error");
			} else {
				log.info("Fail in " + url + " HTTP error code: " + con.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void roadloansPost(String url, String urlParameters) {
		URL obj;
		try {
			bd = new Buildscaller();
			obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			HttpHeaders head = new HttpHeaders();

			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestMethod("POST");

			String urlParameter = urlParameters;
			String updatedappversion = urlParameter.replace("<replaceAppNumber>", bd.getapplication_number());
			// String finalparameterList =
			// updatedappversion.replace("<ReplaceApplicationStatus>",
			// appStatus);
			// Send Post Request
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setDoInput(true);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(updatedappversion);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			log.info("Sending 'Post' request to URL: " + url);
			log.info("Post parameters: " + updatedappversion);
			log.info("Status Code: " + responseCode);

			if (responseCode == HttpsURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				log.info("Response is: " + response);
				LibrariesExtensions.writetoRecorder("Road Loans: Approved");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					log.info("Failed in thread sleep");
					e.printStackTrace();
				}
			} else if (responseCode == HttpsURLConnection.HTTP_BAD_REQUEST) {
				log.info("Cannot Process Application, Unknown Error");
			} else {
				log.info("Fail in " + url + " HTTP error code: " + con.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void firstInvestorsResponse(String url, String urlParameters, String appStatus) {
		URL obj;
		try {
			bd = new Buildscaller();
			obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			HttpHeaders head = new HttpHeaders();

			con.setRequestProperty("Content-Type", "application/xml");
			con.setRequestMethod("POST");

			String urlParameter = urlParameters;
			String updatedappversion = urlParameter.replace("<credit_application_number>", bd.getapplication_number());
			//Possible Status: A = Approved, D = Declined, O = Conditionally Approved, R, N = Pending I, B, OT Ignored 
			String finalparameterList = updatedappversion.replace("<statushere>", appStatus);
			// Send Post Request
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setDoInput(true);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(finalparameterList);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			log.info("Sending 'Post' request to URL: " + url);
			log.info("Post parameters: " + finalparameterList);
			log.info("Status Code: " + responseCode);

			if (responseCode == HttpsURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				log.info("Response is: " + response);
				LibrariesExtensions.writetoRecorder("MBFS: " + appStatus);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					log.info("Failed in thread sleep");
					e.printStackTrace();
				}
			} else if (responseCode == HttpsURLConnection.HTTP_BAD_REQUEST) {
				log.info("Cannot Process Application, Unknown Error");
			} else {
				log.info("Fail in " + url + " HTTP error code: " + con.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
