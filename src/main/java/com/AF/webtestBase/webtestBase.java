package com.AF.webtestBase;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.AF.ConfigCaller.Buildscaller;
import com.AF.ConfigCaller.Propertycaller;
import com.AF.webBridge.WebAppBridge;

import Libraries.LibrariesExtensions;
import Libraries.WebDriverLibrary;
import Libraries.constants;

public class webtestBase {

	public static Logger log = Logger.getLogger(webtestBase.class);
	private static constants con;

	// WEB APP
	public void getbuildVersion(String product) {
		try {
			constants con = new constants();
			Propertycaller data = new Propertycaller();
			log.info("Capturing current build version...");
			WebAppBridge.loginwith(null).getcurrentbuildVersion(product);
			
			
//			WebAppBridge.loginwith(null).getcurrentbuildVersion(data.getwebappbuildVersion(),
//					component);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void applicationTest1() {
		con = new constants();
		log.info("\nRunning random make, Loan, California, Approved application...");
		WebAppBridge.loginwith(WebDriverLibrary.randomEmail()).withpassword(con.password()).test1();
	}

	public void mbloanapplication() {
		constants con = new constants();
		log.info("\nSubmitting Loan application for Mercedes...");
		WebAppBridge.loginwith(WebDriverLibrary.randomEmail()).withpassword(con.password()).test2();
	}

	public void leaseapplication() {
		con = new constants();
		log.info("\nSubmitting Lease application for Mercedes...");
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).test3();
	}

	public void leaseapplicationoutsidecalifornia() {
		con = new constants();
		log.info("\nAttempting a MB lease app outside California...");
		WebAppBridge.loginwith(con.validdealeremail()).withpassword(con.password()).test4();
	}

	public void loanapplicationoutsideCalifornia() {
		con = new constants();
		log.info("\nAttempting a MB loan outside California...");
		WebAppBridge.loginwith(con.validdealeremail()).test5();

	}

	public void outsidecaliforniaapplication() {
		con = new constants();
		log.info("\nRunning random make outside california...");
		WebAppBridge.loginwith(con.validdealeremail()).test6();

	}

	public void createaccountinstep3() {
		con = new constants();
		log.info("\nRunning account creation on step 3...");
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).createaccountstep3();
	}

	public void logintoaccountonstep3() {
		constants con = new constants();
		log.info("\nLogging to existing account on step 3...");
		WebAppBridge.loginwith(con.validdealeremail()).withpassword(con.password()).logintoaccountonstep3();
	}

	public void createnewaccount() {
		constants con = new constants();
		log.info("\nRunning account creation test...");
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).createnewwebappaccount();

	}

	public void logintoexistingaccount() {
		log.info("Running login to existing account test...");
		constants con = new constants();
		WebAppBridge.loginwith(con.validdealeremail()).withpassword(con.password()).logintoexistingAccount();
	}

	public void resetPassword() {
		log.info("\nReset password test...");
		constants con = new constants();
		WebAppBridge.loginwith(con.validdealeremail()).theresetpassword();
	}

	// AutoGravity.com
	public void loadnewautogravityhomePage() {
		log.info("Load autogravity.com home page");
		WebAppBridge.loginwith(null).loadautogravityPage();
	}

	// Support Dashboard
	public void getsdbuild() {

		try {
			log.info("Capturing current build version...");
			Propertycaller data;
			data = new Propertycaller();
			Buildscaller bc = new Buildscaller();
//			WebAppBridge.loginwith(null).getcurrentbuildVersion(data.getenvironment()+data.getsupportdashbuildVersion(),
//					bc.getsupportbuildVersion());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void logintoexistingaccountSupport() {
		try {
			constants con = new constants();
			Propertycaller data;
			data = new Propertycaller();
			log.info("Logging into Support Dashboard");
			WebAppBridge.loginwith(con.validdealeremail()).withpassword(con.password()).logintosupportDash();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// FJ Web Widget
	public void loadpage() {
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).loadpage();

	}

	public void logintoaccount() {
		log.info("Login to existing account test...");
		constants con = new constants();
		WebAppBridge.loginwith(con.validdealeremail()).withpassword(con.password()).fjlogintoaccount();

	}

	public void approveapplicationtest() {
		log.info("Pass over values to widget test and decline...");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password())
				.applicationapprovedTest();
	}
	
	public void approvecalculatorbuttonapplicationtest() {
		log.info("Calculator button application test");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).calculatorbuttontest();
	}
	
	public void preapprovalbuttonvehiclelisttest() {
		log.info("Pre Approval button from the car list.");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).preapprovalfromcarlisttest();
		
	}

	public void declinedapplicationtest() {
		log.info("Pass over values to widget test and decline app...");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).fjdeclinedappliction();
		;
	}

	public void applicationtestFirst() {
		log.info("First Investors application...");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).firstinvestorsApp();
		
	}

	public void applicationWestLakeTest() {
		log.info("WestLake Application...");
		constants con = new constants();
		WebAppBridge.loginwith(LibrariesExtensions.randomEmail()).withpassword(con.password()).westlakeApp();
		
	}

	public void newedwardstest() {
		log.info("Edwards site test");
		constants con = new constants();
		WebAppBridge.loginwith(null).withpassword(null).newedwardstest1();
		
	}

	public void inputtest1() {
		log.info("QA Testing Site, input test");
		WebAppBridge.loginwith(null).withpassword(null).inputtest1();
	}

	

	

}
