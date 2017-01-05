package com.AF.TestCases;

import java.awt.image.ColorConvertOp;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.AF.ConfigCaller.Buildscaller;
import com.AF.ConfigCaller.Propertycaller;
import com.AF.TestRail.APIException;
import com.AF.TestRail.Result;
import com.AF.TestRail.TestRailLibrary;

import Libraries.LibrariesExtensions;
import Libraries.WebDriverLibrary;
import Libraries.constants;

public class WebappTestCases extends WebDriverLibrary {

	public static Logger log = Logger.getLogger(WebappTestCases.class);

	private static Propertycaller data;
	private static constants cons;
	public static TestRailLibrary tc;
	private static Buildscaller bc;

	// public static void TC_1293_verifybuildVersion(String currentversionsaved)
	// {
	// try {
	// data = new Propertycaller();
	// bc = new Buildscaller();
	// String currentbuildNumber = getcssAttribute(data.getmetacss(),
	// data.getbuildnumber());
	// log.info("Current build #: " + currentbuildNumber);
	// TestRailLibrary.updateresult(data.gettestrun(), 1293,
	// comparebuildversion(currentbuildNumber, currentversionsaved,
	// data.getenvironment()));
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// } catch (APIException e) {
	// e.printStackTrace();
	// }
	// }

	public static void getbuildVersion(String product) {
		try {
			data = new Propertycaller();
			bc = new Buildscaller();
			String savedbuildVersion = bc.getstagingwebappbuildVersion();
			String buildname = product;
			//System.out.println("PRODUCT:  " + product);
			String getcurrentbuildnumber = getcssAttribute(data.getmetacss(), data.getbuildnumber());
			if (product != null) {
				if (!getcurrentbuildnumber.contains(savedbuildVersion)) {
					log.info("New version deployed! --> " + getcurrentbuildnumber);
					setProperty(buildname, getcurrentbuildnumber);
					LibrariesExtensions.writebuildVersion(getcurrentbuildnumber);
					log.info("Build updated...");
				}
				else log.info("No build update: " + savedbuildVersion);

			} else
				log.info("NULL VALUE PASSED");

			// setProperty(propertyname, currentversionsaved);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2277_signintoexisting_Account(String testrun, String account) {
		try {
			int result = 0;
			String message = "";
			data = new Propertycaller();
			cons = new constants();
			tc = new TestRailLibrary();
			if (!iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				result = Result.Blocked();
				message = data.getloggedinUser() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				String signedinAccount = getinnertextCss(data.getloggedinUser());
				String account1 = signedinAccount.substring(signedinAccount.lastIndexOf(" ") + 1).trim();
				boolean comparisontest = true;
				boolean comparison = compareString(account1, account);
				if (comparison != comparisontest) {
					result = Result.Failed();
					message = account1 + " doesn't match with " + account;
				} else if (comparison == comparisontest) {
					result = Result.Pass();
					message = account1 + " matches with " + account;
				} else {
					result = Result.Blocked();
					message = "Unknown error, please check page.";
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2277, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_1896_createnewAccount(String testrun, String newemailaccount) {
		try {
			int result = 0;
			String message = "";
			data = new Propertycaller();
			cons = new constants();
			tc = new TestRailLibrary();
			clickbycss(data.getSubmitbutton());
			Thread.sleep(1000);
			if (!iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				result = Result.Blocked();
				message = data.getloggedinUser() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				String signedinAccount = getinnertextCss(data.getloggedinUser());
				String account1 = signedinAccount.substring(signedinAccount.lastIndexOf(" ") + 1).trim();
				boolean comparisontest = true;
				boolean comparison = compareString(account1, newemailaccount);
				if (comparison != comparisontest) {
					result = Result.Failed();
					message = account1 + " doesn't match with " + newemailaccount;
				} else if (comparison == comparisontest) {
					LibrariesExtensions.WritetoFile(newemailaccount, data.getenvironment());
					result = Result.Pass();
					message = account1 + " matches with " + newemailaccount;
				} else {
					result = Result.Blocked();
					message = "Unknown error, please check page.";
				}
			}
			TestRailLibrary.updateresult(testrun, 1896, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void TC_2276_step3accountCreation(String testrun, String newemailaccount) {
		try {
			int result = 0;
			String message = "";
			data = new Propertycaller();
			cons = new constants();
			tc = new TestRailLibrary();
			clickbycss(data.getSubmitbutton());
			if (!iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				result = Result.Blocked();
				message = data.getloggedinUser() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getloggedinUser()))) {
				String signedinAccount = getinnertextCss(data.getloggedinUser());
				String account1 = signedinAccount.substring(signedinAccount.lastIndexOf(" ") + 1).trim();
				boolean comparisontest = true;
				boolean comparison = compareString(account1, account1);
				if (comparison != comparisontest) {
					result = Result.Failed();
					message = comparison + " doesn't match with " + comparisontest;
				} else if (comparison == comparisontest) {
					LibrariesExtensions.WritetoFile(newemailaccount, data.getenvironment());
					result = Result.Pass();
					message = account1 + " matches with " + newemailaccount;
				} else {
					result = Result.Blocked();
					message = "Unknown error, please check page.";
				}
			}
			TestRailLibrary.updateresult(testrun, 2276, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}

	}

	// TODO: Need to turn this into proper test case
	public static void verifycorrectimageforlender() {
		if (iselementPresent(By.cssSelector(data.getlendername()))) {
			String innersrc = getcssAttribute(data.getlendername(), "src");
			log.info(innersrc);
			if (innersrc == "https://s3-us-west-2.amazonaws.com/autogravity.assets/RoadLoans-300-300.png") {
				log.info("Inner src matches for Roadloans");
			} else
				fail();
		}
	}

	public static void TC_getcorrectlenderimage() {
		try {
			data = new Propertycaller();

			cons = new constants();
			clickbycss(data.getlendertab());
			String lender = getcssAttribute(data.getlendername(), "src");
			if (lender.contains("mbfs-300-300.png")) {

			}
			// String lender = getinnertextCss(data.getRoadloansimage());
			log.info(lender);
			if (lender == "RoadLoans") {
				log.info("Suceess..." + lender + " is present.");
			} else {
				log.info(lender + " is not present.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void TC_2244_AGNextbuttononHeroImage() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://apply.autogravity.com/vehicle";
			if (!iselementPresent(By.cssSelector(data.getaghomepagenextbutton()))) {
				result = Result.Blocked();
				message = data.getaghomepagenextbutton() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getaghomepagenextbutton()))) {
				clickbycss(data.getaghomepagenextbutton());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2244, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2261_AGclickonGetStartedbutton() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://apply.autogravity.com/vehicle";
			if (!iselementPresent(By.cssSelector(data.getaggetstartedbutton()))) {
				result = Result.Blocked();
				message = data.getaggetstartedbutton() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getaggetstartedbutton()))) {
				clickbycss(data.getaggetstartedbutton());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2261, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2246_AGclickonIOSappbutton() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://itunes.apple.com/app/id1082767972?mt=8";
			if (!iselementPresent(By.xpath(data.getbottompageiosversionlink()))) {
				result = Result.Blocked();
				message = data.getbottompageiosversionlink() + " is not present.";
				// log.info(data.getbottompageiosversionlink() + " is not
				// present.");
			} else if (iselementPresent(By.xpath(data.getbottompageiosversionlink()))) {
				clickbyxpath(data.getbottompageiosversionlink());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2246, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2247_AGclickonAndroidappbutton() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://play.google.com/store/apps/details?id=com.autogravity";
			if (!iselementPresent(By.xpath(data.getbottompageaggoogleversionlink()))) {
				result = Result.Blocked();
				message = data.getbottompageaggoogleversionlink() + " is not present.";
			} else if (iselementPresent(By.xpath(data.getbottompageaggoogleversionlink()))) {
				clickbyxpath(data.getbottompageaggoogleversionlink());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2247, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2245_AGtopofpageclickonIOSbutton() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://itunes.apple.com/app/id1082767972?mt=8";
			if (!iselementPresent(By.cssSelector(data.getiostopofpagebutton()))) {
				result = Result.Blocked();
				message = data.getiostopofpagebutton() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getiostopofpagebutton()))) {
				clickbycss(data.getiostopofpagebutton());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2245, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC__AGclickonwebappbutton() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://apply.autogravity.com/vehicle";
			if (!iselementPresent(By.xpath(data.getbottompageagwebapplink()))) {
				result = Result.Blocked();
				message = data.getbottompageagwebapplink() + " is not present.";
			} else if (iselementPresent(By.xpath(data.getbottompageagwebapplink()))) {
				clickbyxpath(data.getbottompageagwebapplink());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2245, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_AGtopofpageclickonAndroidapp() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			String expectedurl = "https://play.google.com/store/apps/details?id=com.autogravity";
			if (!iselementPresent(By.cssSelector(data.gettopofpagegooglestorebutton()))) {
				result = Result.Blocked();
				message = data.gettopofpagegooglestorebutton() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.gettopofpagegooglestorebutton()))) {
				clickbycss(data.gettopofpagegooglestorebutton());
				String url = driver().getCurrentUrl();
				if (url.contains(expectedurl)) {
					result = Result.Pass();
					message = "User is routed to " + url;
				} else {
					System.out.println("Fail!");
					message = ("User is routed to " + url);
					result = Result.Failed();
				}
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2245, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_1713_Cannot_proceed_beyond_step3_outside_California() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			if (!iselementPresent(By.cssSelector(data.getdealerpopupwindow()))) {
				result = Result.Blocked();
				message = data.getdealerpopupwindow() + " is not present.";
			} else if (iselementPresent(By.cssSelector(data.getdealerpopupwindow()))) {
				waituntiltextisPresent("is coming soon");
				result = Result.Pass();
				message = "Pop up present, user gets the coming soon pop up.";
			} else {
				message = "User did not get the pop up window.";
				result = Result.Failed();
			}
			TestRailLibrary.updateresult(data.gettestrun(), 1713, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

	public static void TC_2516_down_payment_on_Loan() {
		try {
			data = new Propertycaller();
			int result = 0;
			String message = "";
			// Grab MSRP and get down payment equivalent.
			String msrp = getinnertextCss(data.getmsrpprice());
			String newMSRP = msrp.replaceAll("[^0-9]", "");
			int numMSRP = LibrariesExtensions.convertstringtoInt(newMSRP);
			double resultdownpayment = numMSRP * .10;
			Double d = new Double(resultdownpayment);
			int truedownpaymentfromMSRP = d.intValue();

			// Get current down payment from the field.
			String currentdownpayment = getcssAttribute(data.getdownpaymentfield(), "value");
			String newcurrentdownpayment = currentdownpayment.replaceAll("[^0-9]", "");
			int truedownpayment = LibrariesExtensions.convertstringtoInt(newcurrentdownpayment);

			// Compare the downpayments and make sure they match
			boolean downpaymentcheck = compareintValue(truedownpayment, truedownpaymentfromMSRP);
			boolean comparisontest = true;
			if (downpaymentcheck != comparisontest) {
				result = Result.Failed();
				message = truedownpayment + " does not match with expected " + currentdownpayment;
			} else if (downpaymentcheck == comparisontest) {
				result = Result.Pass();
				message = truedownpaymentfromMSRP + " is correct.";
			}
			TestRailLibrary.updateresult(data.gettestrun(), 2516, result, message);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (APIException e) {
			e.printStackTrace();
		}
	}

}
