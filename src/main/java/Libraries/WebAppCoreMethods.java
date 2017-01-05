package Libraries;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.AF.ConfigCaller.LatestApplicationCaller;
import com.AF.ConfigCaller.Propertycaller;
import com.AF.TestCases.WebappTestCases;
import com.AF.TestRail.APIException;
import com.AF.TestRail.TestRailLibrary;

public class WebAppCoreMethods extends WebappTestCases {

	public static Logger log = Logger.getLogger(WebAppCoreMethods.class);
	private static Propertycaller data;
	private static constants cons;

	public static void webappcreatenewAccount(String email, String password) {
		try {
			data = new Propertycaller();
			clickbycss(data.getagloginButton());
			Thread.sleep(300);
			clickbyxpath(data.getagsignuplink());

			inputbycss(data.getagnewregistrationemailfield(), email);
			inputbycss(data.getagnewregisterpasswordfield(), password);
			inputbycss(data.getagnewregisterconfirmpasswordfield(), password);
			Thread.sleep(500);
			clickbycss(data.getSubmitbutton());
			log.info("New Account created " + email);
			TC_1896_createnewAccount(data.gettestrun(), email);
			log.debug("Signing out...");
			clickbycss(data.getaglogoutlink());
			log.debug("Signing in...");
			clickbylinkText(data.getaglogin());
			log.debug("Entering new password...");
			inputbycss(data.getagemailfrontfield(), email);
			inputbycss(data.getloginpassword(), password);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void webapploginexistingAccount(String email, String password) {
		try {
			data = new Propertycaller();
			cons = new constants();
			clickbylinkText(data.getaglogin());

			inputbycss(data.getagemailfrontfield(), email);
			inputbycss(data.getloginpassword(), password);
			clickbycss(data.getLoginButtonhome());
			log.info("Checking the logged in account...");
			TC_2277_signintoexisting_Account(data.gettestrun(), email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void resetpassword(String email) {
		try {
			data = new Propertycaller();
			cons = new constants();
			clickbylinkText(data.getaglogin());
			clickbylinkText(data.Forgotpasswordlink());
			inputbycss(data.getagemailfrontfield(), email);
			clickbycss(data.getSubmitbutton());
			waitforelementcss(data.getresetpassworedemailsenttext());
			log.info("Info Email " + email);
			String currentext = getinnertextCss(data.getresetpassworedemailsenttext());
			driver().navigate().to("https://www.mailinator.com");
			// driver().get("www.mailinator.com");
			Thread.sleep(10000);
			driver().findElement(By.cssSelector("input[type*='text'][placeholder*='Check Any Inbox!']"))
					.sendKeys(cons.validdealeremail());
			;
			driver().findElement(By.cssSelector("button[class*='btn-dark']")).click();
			// if()

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void appstep1(String make, String offer, String year) {
		try {
			data = new Propertycaller();
			log.info("Step 1: Selecting Vehicle");
			dropdownselectorbyCSS(data.getmakeselectorcss(), make);
			dropdownselectorbyCSS(data.getmodelselector(), LibrariesExtensions.randomModel(data.getmovetomodel()));
			dropdownselectorYear(data.getyearselectorcss(), year);
			LibrariesExtensions.writetoRecorder("YEAR: " + year);
			clickbycss(data.getnextbuttoncss());
			log.info("Step 1: Selecting Trim");
			clickbycss(data.getfirsttrimoption());
			String trimName = getinnertextCss(data.getfirsttrimoption());
			LibrariesExtensions.writetoRecorder("TRIM: " + trimName);
			log.info("Step 1: Select lease or loan");
			Thread.sleep(700);
			clickbycss(offer);
			String offertype = getinnertextCss(offer);
			LibrariesExtensions.writetoRecorder("OFFER TYPE: " + offertype);// --Recorded
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void appstep1update(String Make, String offer, String year) {
		try {
			data = new Propertycaller();
			log.info("Step 1: Selecting Make");
			LibrariesExtensions.datacollection(data.getmakeselectorcss(), data.getchildclasscss(), Make);
			log.info("Step 1: Selecting Model");
			Thread.sleep(2000);
			LibrariesExtensions.randomdatacollection(data.getmodelcollector(), data.getchildmodelselectorcss());
			log.info("Step 1: Selecting Trim");
			Thread.sleep(700);
			clickbycss(data.getfirsttrimoption());
			String trimName = getinnertextCss(data.getfirsttrimoption());
			LibrariesExtensions.writetoRecorder("TRIM: " + trimName);
			log.info("Step 1: Select lease or loan");
			Thread.sleep(700);
			if (iselementPresent(By.cssSelector(offer))) {
				clickbycss(offer);
			}
			else clickbycss(data.getloanOption());
			//String offertype = getinnertextCss(offer);
			//LibrariesExtensions.writetoRecorder("OFFER TYPE: " + offertype);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void appstep2(String city, String state, String dealership) {
		try {
			data = new Propertycaller();
			log.info("Step 2: Find a dealership");
			LibrariesExtensions.writetoRecorder("-----Dealership Information-----");
			LibrariesExtensions.writetoRecorder("City: " + city);
			if (!city.equals(null) || !city.equals(city.isEmpty())) {
				inputbycss(data.getsearchfield(), city);
				Thread.sleep(500);
				inputbycss(data.getsearchfield(), Keys.ENTER);
				Thread.sleep(1000);
			}
			if (city.equals("Los Angeles") && (dealership != null)) {
				LibrariesExtensions.datacollectionLower(data.getdealershipcontainer(), data.getdealershipoption(),
						dealership);
				Thread.sleep(500);
			} else clickbycss(data.getdealershipoption());
			String dealershipname = getinnertextCss(data.getdealershipoption());
			LibrariesExtensions.writetoRecorder(dealershipname);
			clickbycss(data.getnextbuttoncss());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void appstep2outsidecalpopup(String email) {
		try {
			cons = new constants();
			data = new Propertycaller();
			// clickbycss(data.getdealershipoption());
			// String dealership = getinnertextCss(data.getdealershipoption());
			// LibrariesExtensions.writetoRecorder(dealership);// --Recorder
			// clickbycss(data.getnextbuttoncss());
			// Thread.sleep(600);
			if (iselementPresent(By.cssSelector(data.getdealerpopupwindow()))) {
				// TC_1713_Cannot_proceed_beyond_step3_outside_California();
				waitforelementcss(data.getagemailfieldpopup());
				inputbycss(data.getagemailfieldpopup(), email);
				waitforelementcss(data.getpopupcheckbox());
				clickbycss(data.getpopupcheckbox());
				clickbycss(data.getrightarrowclickpopup());
				waitforelementcss(data.getclosewindowlink());
				log.info("Notification email: " + email);
				clickbycss(data.getclosewindowlink());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void appstep3confirmDetails(String downPayment, String term, String tradein, String annualMileage) {
		try {
			Propertycaller data = new Propertycaller();
			log.info("Step 3: Confirm Details page...");
			// TC_2516_down_payment_on_Loan();
			inputbycss(data.getdownpaymentfield(), downPayment);
			inputbycss(data.getestimatedtradeinfield(), tradein);
			clickbycss(data.getnextbuttoncss());
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void appstep3createAccount(String firstName, String lastName, String phoneNumber, String dob,
			String email, String password) {
		// TC_2516_down_payment_on_Loan();
		try {
			data = new Propertycaller();
			LibrariesExtensions.writetoRecorder("-----Personal Information-----");
			inputbycss(data.getagfirstnamefield(), firstName);
			LibrariesExtensions.writetoRecorder("FIRST NAME: " + firstName);// --Recorder
			inputbycss(data.getaglastnamefield(), lastName);
			LibrariesExtensions.writetoRecorder("LAST NAME: " + lastName);// --Recorder
			inputbycss(data.getagphonenumberfield(), phoneNumber);
			LibrariesExtensions.writetoRecorder("PHONE: " + phoneNumber);// --Recorder
			inputbycss(data.getagdateofbirthfield(), dob);
			LibrariesExtensions.writetoRecorder("BIRTHDATE: " + dob);// --Recorder
			log.info("Step 3: Personal Information...");
			inputbycss(data.getagnewemailfield(), email);
			LibrariesExtensions.writetoRecorder("EMAIL: " + email);// --Recorder
			inputbycss(data.getagnewpasswordfield(), password);
			inputbycss(data.getagrepeatnewpasswordfield(), password);
			LibrariesExtensions.writetoRecorder("PASSWORD: " + password);// --Recorder
			clickbycss(data.getnextbuttoncss());
			LibrariesExtensions.WritetoFile(email, data.getenvironment());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void appstep3login(String firstName, String lastName, String phoneNumber, String dob, String email,
			String password) {

		try {// Step 3
			log.info("Step 3: Confirm Details page...");
			// TC_2516_down_payment_on_Loan();
			Thread.sleep(600);
			clickbycss(data.getnextbuttoncss());
			Thread.sleep(600);
			log.info("Entering personal information...");
			inputbycss(data.getagfirstnamefield(), firstName);
			inputbycss(data.getaglastnamefield(), lastName);
			inputbycss(data.getagphonenumberfield(), phoneNumber);
			inputbycss(data.getagdateofbirthfield(), dob);
			clickbypartiaLink(data.getLogin());
			inputbycss(data.getagemailfrontfield(), email);
			inputbycss(data.getloginpassword(), password);
			clickbycss(data.getSubmitbutton());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void appstep3completeapplication(String address, String city, String state, String zipcode,
			String rentOption, String mortgage, String employerName, String title, String employmentStatus,
			String phone, String income, String ssn) {
		cons = new constants();
		log.info("Step 3: Address Information...");
		LibrariesExtensions.writetoRecorder("-----Residence Information-----");
		inputbycss(data.getagaddressfield(), address);
		LibrariesExtensions.writetoRecorder("ADDRESS: " + address);// --Recorder
		inputbycss(data.getagcityfield(), city);
		LibrariesExtensions.writetoRecorder("CITY: " + city);// --Recorder
		clickbycss(data.getagstatefield());
		dropdownselectorbyCSS(data.getagstatefield(), state);
		LibrariesExtensions.writetoRecorder("STATE: " + cons.state());// --Recorder
		inputbycss(data.getagzipcode(), zipcode);
		LibrariesExtensions.writetoRecorder("ZIP: " + zipcode);// --Recorder
		inputbycss(data.getagmovinDate(), cons.moveinDate());
		LibrariesExtensions.writetoRecorder("MOVE IN DATE: " + cons.moveinDate());// --Recorder
		dropdownselectorbyXpath(data.getagrentownfield(), rentOption);
		LibrariesExtensions.writetoRecorder("RENT OPTION: " + rentOption);// --Recorder
		inputbycss(data.getagmortgagepayment(), mortgage);
		LibrariesExtensions.writetoRecorder("RENT AMOUNT: " + mortgage);// --Recorder
		clickbycss(data.getnextbuttoncss());
		log.info("Step 3: Employment Information");
		LibrariesExtensions.writetoRecorder("-----Employment Information-----");
		inputbycss(data.getagemployernamefield(), employerName);
		LibrariesExtensions.writetoRecorder("EMPLOYER:" + employerName);// --Recorder
		inputbycss(data.getagtitlefield(), title);
		LibrariesExtensions.writetoRecorder("TITLE: " + title);// --Recorder
		inputbycss(data.getagstartdate(), cons.moveinDate());
		LibrariesExtensions.writetoRecorder("MOVE IN DATE: " + cons.moveinDate());// --Recorder
		dropdownselectorbyXpath(data.getagemploymentstatusfield(), employmentStatus);
		LibrariesExtensions.writetoRecorder("EMPLOYMENT STATUS: " + employmentStatus);// --Recorder
		inputbycss(data.getagemployernumberfield(), phone);
		LibrariesExtensions.writetoRecorder("PHONE: " + phone);// Recorder
		inputbycss(data.getaggrossmonthlyincomefield(), income);
		LibrariesExtensions.writetoRecorder("INCOME: " + income);// --Recorder
		clickbycss(data.getnextbuttoncss());
		log.info("Step 3: Identification");
		LibrariesExtensions.writetoRecorder("-----Identification Information-----");
		inputbycss(data.getagssnfield(), ssn);
		LibrariesExtensions.writetoRecorder("SSN: " + ssn);// --Recorder
		clickbycss(data.getnextbuttoncss());
		log.info("Step 3: Review Page");
		clickbycss(data.getagsignconsent());
		// Same button push; just a checkbox turns true when clicked
		clickbycss(data.getagsignconsent());
	}

	public static void appreviewandsubmit(String email, String appStatus) {
		try {
			String ENV = driver().getCurrentUrl();
			if (ENV.contains("uat") || ENV.contains("apply.autogravity")) {
				log.info("Done testing...cannot submit app on " + ENV);
				driver().close();
			} else {
				clickbycss(data.getnextbuttoncss());
				Thread.sleep(25000);
				String applicationnumber = getcssAttribute(data.getapplicationnumber(), data.getagvaluefield());
				setProperty("application_number", applicationnumber);
				setProperty("submittedEmail", email);
				LibrariesExtensions.writetoRecorder("App Number: " + applicationnumber);
				log.info("App Number: " + applicationnumber);
				// TODO: Add the application ID
				// String applicationId =
				// getcssAttribute(data.getapplicationidnumber(),
				// data.getvaluefield());
				// setProperty("creditapplicationDetailsId", applicationId);
				// log.info("ApplicationID: " + applicationId);
				if (iselementPresent(By.cssSelector(data.getlendertab()))) {
					LibrariesExtensions.lendercollection(data.getlendertab(), data.getlendername(), appStatus);
					Thread.sleep(40000);
				} else {
					log.info(/* data.getlendertab() + " is not present. */ "No matching lenders found.");
					driver().close();
				}
				LibrariesExtensions.writetoRecorder("SUBMITTED APPS /" + Timestamp());
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Data was not passed over correctly");
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.info("Timing was off");
		}

	}

	public static void applicationtemplate(String make, String offer, String appStatus, String dealership,
			String firstName, String lastName, String phone, String email, String birthDate, String address,
			String city, String state, String zipcode, String rentOption, String mortgage, String employerName,
			String title, String employmentStatus, String income, String ssn) {
		try {
			data = new Propertycaller();
			cons = new constants();
			log.info("Step 1: Selecting Vehicle");
			// dropdownselectorbyCSS(data.getmakeselectioncss(), make);
			dropdownselectorbyCSS(data.getmodelselector(), LibrariesExtensions.randomModel(data.getmovetomodel()));
			dropdownselectorbyCSS(data.getyearselectorcss(), data.getyearselectionxpath());
			clickbycss(data.getnextbuttoncss());
			log.info("Step 1: Selecting Trim");
			clickbycss(data.getfirsttrimoption());
			String trimName = getinnertextCss(data.getfirsttrimoption());
			LibrariesExtensions.writetoRecorder("TRIM: " + trimName);
			log.info("Step 1: Select lease or loan");
			if (!iselementPresent(By.cssSelector(offer))) {
				clickbycss(data.getleaseOption2());
				String loanType = getinnertextCss(data.getleaseOption2());
				LibrariesExtensions.writetoRecorder("OFFER: " + loanType);
			} else {
				String loanType2 = getinnertextCss(offer);
				clickbycss(offer);
				LibrariesExtensions.writetoRecorder("OFFER: " + loanType2);// --Recorded
			}
			log.info("Step 2: Find a dealership");
			LibrariesExtensions.writetoRecorder("-----Dealership Information-----");
			LibrariesExtensions.writetoRecorder("City: " + city);
			if (!state.equals(null) || !state.equals(state.isEmpty())) {
				inputbycss(data.getsearchfield(), city);
				Thread.sleep(500);
				inputbycss(data.getsearchfield(), Keys.ENTER);
				Thread.sleep(600);
				// if
				// (iselementPresent(By.cssSelector(data.getnodealersfoundtext())))
				// {
				// String message =
				// getinnertextCss(data.getnodealersfoundtext());
				// log.info(message);
				// }
			}
			// TODO: Need to add the selected dealership if needed
			clickbycss(data.getdealershipoption());
			String dealershipname = getinnertextCss(data.getdealershipoption());
			LibrariesExtensions.writetoRecorder(dealershipname);
			// Thread.sleep(600);
			clickbycss(data.getnextbuttoncss());
			// Thread.sleep(600);
			// TODO: Need to do more on this page
			log.info("Step 3: Confirm Details page...");
			// TC_2516_down_payment_on_Loan();
			Thread.sleep(600);
			clickbycss(data.getnextbuttoncss());
			log.info("Step 3: Personal Information...");
			inputbycss(data.getagnewemailfield(), email);
			LibrariesExtensions.writetoRecorder("EMAIL: " + email);// --Recorder
			inputbycss(data.getagnewpasswordfield(), cons.password());
			inputbycss(data.getagrepeatnewpasswordfield(), cons.password());
			LibrariesExtensions.writetoRecorder("PASSWORD: " + cons.password());// --Recorder
			clickbycss(data.getnextbuttoncss());
			LibrariesExtensions.WritetoFile(email, data.getenvironment());
			log.info("Step 3: Address Information...");
			LibrariesExtensions.writetoRecorder("-----Residence Information-----");
			inputbycss(data.getagaddressfield(), address);
			LibrariesExtensions.writetoRecorder("ADDRESS: " + address);// --Recorder
			inputbycss(data.getagcityfield(), city);
			LibrariesExtensions.writetoRecorder("CITY: " + city);// --Recorder
			clickbycss(data.getagstatefield());
			dropdownselectorbyCSS(data.getagstatefield(), state);
			LibrariesExtensions.writetoRecorder("STATE: " + state);// --Recorder
			inputbycss(data.getagzipcode(), zipcode);
			LibrariesExtensions.writetoRecorder("ZIP: " + zipcode);// --Recorder
			inputbycss(data.getagmovinDate(), cons.moveinDate());
			LibrariesExtensions.writetoRecorder("MOVE IN DATE: " + cons.moveinDate());// --Recorder
			dropdownselectorbyXpath(data.getagrentownfield(), rentOption);
			LibrariesExtensions.writetoRecorder("RENT OPTION: " + rentOption);// --Recorder
			inputbycss(data.getagmortgagepayment(), mortgage);
			LibrariesExtensions.writetoRecorder("RENT AMOUNT: " + mortgage);// --Recorder
			clickbycss(data.getnextbuttoncss());
			log.info("Step 3: Employment Information");
			LibrariesExtensions.writetoRecorder("-----Employment Information-----");
			inputbycss(data.getagemployernamefield(), employerName);
			LibrariesExtensions.writetoRecorder("EMPLOYER:" + employerName);// --Recorder
			inputbycss(data.getagtitlefield(), title);
			LibrariesExtensions.writetoRecorder("TITLE: " + title);// --Recorder
			inputbycss(data.getagstartdate(), cons.moveinDate());
			LibrariesExtensions.writetoRecorder("MOVE IN DATE: " + cons.moveinDate());// --Recorder
			dropdownselectorbyXpath(data.getagemploymentstatusfield(), employmentStatus);
			LibrariesExtensions.writetoRecorder("EMPLOYMENT STATUS: " + employmentStatus);// --Recorder
			inputbycss(data.getagemployernumberfield(), phone);
			LibrariesExtensions.writetoRecorder("PHONE: " + phone);// Recorder
			inputbycss(data.getaggrossmonthlyincomefield(), income);
			LibrariesExtensions.writetoRecorder("INCOME: " + income);// --Recorder
			clickbycss(data.getnextbuttoncss());
			log.info("Step 3: Identification");
			LibrariesExtensions.writetoRecorder("-----Identification Information-----");
			inputbycss(data.getagssnfield(), ssn);
			LibrariesExtensions.writetoRecorder("SSN: " + ssn);// --Recorder
			clickbycss(data.getnextbuttoncss());
			log.info("Step 3: Review Page");
			clickbycss(data.getagsignconsent());
			String ENV = driver().getCurrentUrl();
			if (ENV.contains("uat") || ENV.contains("apply.autogravity")) {
				log.info("Done testing...cannot submit app on " + ENV);
				driver().close();
			} else {
				clickbycss(data.getnextbuttoncss());
				// Wait for Application Status
				Thread.sleep(30000);
				String applicationnumber = getcssAttribute(data.getapplicationnumber(), data.getagvaluefield());
				setProperty("application_number", applicationnumber);
				setProperty("submittedEmail", email);
				LibrariesExtensions.writetoRecorder("App Number: " + applicationnumber);
				log.info("App Number: " + applicationnumber);
				if (iselementPresent(By.cssSelector(data.getlendertab()))) {
					LibrariesExtensions.lendercollection(data.getlendertab(), data.getlendername(), appStatus);
					Thread.sleep(20000);
				} else {
					log.info(data.getlendertab() + " is not present. No matching lenders found.");
					driver().close();
				}
				LibrariesExtensions.writetoRecorder("SUBMITTED APPS /" + Timestamp());
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Data was not passed over correctly");
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.info("Timing was off");
		}
	}

	// Autogravity.com
	public static void autogravitydotcomPageTest() {
		try {
			data = new Propertycaller();
			if (iselementPresent(By.cssSelector(data.getaghomepasswordprotectfield()))) {
				inputbycss(data.getaghomepasswordprotectfield(), "aut0gravity");
				clickbycss(data.getagsubmitbutton());
			}
			log.info("Testing top of page.");
			TC_2244_AGNextbuttononHeroImage();
			returntopreviouspage();
			TC_2245_AGtopofpageclickonIOSbutton();
			returntopreviouspage();
			log.info("How AutoGravity works...");

			log.info("Know Before You Go");
			// TODO: Need to add the mathematics formula on the automation
			// inputbyxpath(data.getagvaluefield(), "19995");
			// clickbycss(data.getagtermbutton());
			// clickbycss(data.getagleaseoptionslink());
			// clickbyxpath(data.getagleaseoptionslink());
			// Thread.sleep(15000);

			log.info("Browse Cars...");

			log.info("State of the Art Security");
			TC_2261_AGclickonGetStartedbutton();
			returntopreviouspage();
			log.info("Finance Your Car with AutoGravity");
			TC_2246_AGclickonIOSappbutton();
			returntopreviouspage();
			TC_2247_AGclickonAndroidappbutton();
			returntopreviouspage();
			TC__AGclickonwebappbutton();
			returntopreviouspage();
			LibrariesExtensions.writetoRecorder("This is a selection outside of California");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Support Dashboard
	public static void loginSupportDash(String email, String password) {
		try {
			data = new Propertycaller();
			cons = new constants();
			LatestApplicationCaller app = new LatestApplicationCaller();

			app.getappNumber();
			inputbycss(data.getagnewemailfield(), email);
			inputbycss(data.getloginpassword(), password);
			clickbycss(data.getSubmitbutton());
			// dropdownselectorbyXpath(data.getproductdropdown(),
			// data.getagproductcode());
			Thread.sleep(9000);
			// inputbyxpath(data.getsupportsearchemailfield(),
			// app.getsubmittedEmail());
			// Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fjcreateAccount(String email, String password) {
		try {
			data = new Propertycaller();
			clickbypartiaLink(data.getsignuplink());
			inputbycss(data.getagnewregistrationemailfield(), email);
			inputbycss(data.getagnewregisterpasswordfield(), password);
			inputbycss(data.getagnewregisterconfirmpasswordfield(), password);
			clickbycss(data.getSubmitbutton());
			LibrariesExtensions.WritetoFile(email, data.getenvironment());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fjlogintoAccount(String email, String password) {
		try {
			data = new Propertycaller();
			inputbycss(data.getagemailfrontfield(), email);
			inputbycss(data.getloginpassword(), password);
			clickbycss(data.getLoginButtonhome());
			Thread.sleep(1500);
			clickbypartiaLink("click here");
			clickbycss(data.getpreapprovedbutton());
			// waituntiltextisPresent("You will be auto redirected to Fletcher
			// Jones Newport Beach");
			// Thread.sleep(45000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void fjmercedesvehicleNavigation(String whichlink, String vehicle) {
		try {
			data = new Propertycaller();
			inputbycss(data.getfjsearchfield(), vehicle);
			clickbycss(data.getfjsearchbutton());
			LibrariesExtensions.datacollection(data.getfjcarlist(), data.getfjcarselection(), vehicle);
			Thread.sleep(500);
			clickbycss(whichlink);
			Thread.sleep(5000);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Could not load property file");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fjmercedesvehicleNavigation2(String whichlink, String vehicle) {
		try {
			data = new Propertycaller();
			inputbycss(data.getfjsearchfield(), vehicle);
			clickbycss(data.getfjsearchbutton());
			clickbycss(whichlink);
			Thread.sleep(1500);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Could not load property file");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void edwardshomepagetest(){
		try {
			data = new Propertycaller();
			clickbyxpath(data.getmainpagemenu());
			clickbycss(data.getfindjobsbutton());
			Thread.sleep(4000);
			String jobtitle = "009470";
			inputbycss(data.getkeywordinput(), jobtitle);
			//clickbylinkText("Quality");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputtestSite(){
		try {
			data = new Propertycaller();
			inputbycss(data.gettestsiteinputfield(), "Testing 123, DID YOU READ ME ON TIME");
			clickbycss(data.getsecondcheckbox());
			clickbycss(data.getthirdradiobutton());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}