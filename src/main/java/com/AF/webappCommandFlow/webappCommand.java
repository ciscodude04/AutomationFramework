package com.AF.webappCommandFlow;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.AF.ConfigCaller.Propertycaller;
import com.AF.TestCases.WebappTestCases;

import Libraries.LibrariesExtensions;
import Libraries.WebAppCoreMethods;
import Libraries.constants;

public class webappCommand extends WebAppCoreMethods {
	public static Propertycaller data;
	public static constants cons;

	public static Logger log = Logger.getLogger(webappCommand.class);

	private String email;
	private String password;

	public webappCommand(String email) {
		this.email = email;
	}

	public webappCommand withpassword(String password) {
		this.password = password;
		return this;
	}

	// Command Flow
	public void getcurrentbuildVersion(String product) {
		WebappTestCases.getbuildVersion(product);
	}

	public void test1() {
		try {
			Propertycaller data = new Propertycaller();
			cons = new constants();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String dealercity = LibrariesExtensions.randomcaliforniaCity();
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();

			//appstep1(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep1update(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanoption2(), year);
			
			//appstep1update(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanoption2(), year);

			appstep2(dealercity, cons.state(), null);

			appstep3confirmDetails(downPayment, null, tradein, null);

			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);

			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption, cons.rent(),
					cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(), randomSSN());

			appreviewandsubmit(email, "APPR");
		} catch (IOException e) {

			e.printStackTrace();
			log.info("Did not read propertycaller file");
		}
	}

	public void test2() {
		try {
			Propertycaller data = new Propertycaller();
			cons = new constants();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String dealercity = LibrariesExtensions.randomcaliforniaCity();
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();
			appstep1update(cons.mbmake(), data.getloanoption2(), year);
//			appstep1(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getloanoption2(),
//					year);
			
			

			appstep2(dealercity, cons.state(), null);

			appstep3confirmDetails(downPayment, null, tradein, null);

			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);

			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption, cons.rent(),
					cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(), randomSSN());

			appreviewandsubmit(email, "APPR");

		} catch (IOException e) {

			e.printStackTrace();
			log.info("Did not read propertycaller file");
		}
	}

	public void test3() {
		try {
			Propertycaller data = new Propertycaller();
			cons = new constants();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String dealercity = LibrariesExtensions.randomcaliforniaCity();
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();

//			appstep1(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getleaseOption(),
//					year);
			
			appstep1update(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getloanoption2(), year);

			appstep2(dealercity, cons.state(), null);

			appstep3confirmDetails(downPayment, null, tradein, null);

			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);

			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption, cons.rent(),
					cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(), randomSSN());

			appreviewandsubmit(email, "APPR");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test4() {
		try {
			data = new Propertycaller();
			cons = new constants();
			String dealercity = LibrariesExtensions.randomoutsideCity();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());

//			appstep1(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getleaseOption(),
//					year);
			
			appstep1update(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getloanoption2(), year);
			
			appstep2(dealercity, cons.state(), null);
			appstep2outsidecalpopup(email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test5() {
		try {
			data = new Propertycaller();
			cons = new constants();
			String dealercity = LibrariesExtensions.randomoutsideCity();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());

//			appstep1(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getloanoption2(),
//					year);
			
			appstep1update(LibrariesExtensions.specificMake(data.getselectMake(), cons.mbmake()), data.getloanoption2(), year);
			
			appstep2(dealercity, cons.state(), null);
			appstep2outsidecalpopup(email);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test6() {

		try {
			data = new Propertycaller();
			cons = new constants();
			String dealercity = LibrariesExtensions.randomoutsideCity();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());

			//appstep1(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep1update(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep2(dealercity, cons.state(), null);
			appstep2outsidecalpopup(email);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createaccountstep3() {
		try {
			data = new Propertycaller();
			cons = new constants();
			String dealercity = LibrariesExtensions.randomcaliforniaCity();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();
			//appstep1(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep1update(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep2(dealercity, cons.state(), null);
			appstep3confirmDetails(downPayment, null, tradein, null);
			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logintoaccountonstep3() {
		try {
			data = new Propertycaller();
			cons = new constants();
			String dealercity = LibrariesExtensions.randomcaliforniaCity();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();
			//appstep1(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanOption(), year);
			
			appstep1update(LibrariesExtensions.randomMake(data.getselectMake()), data.getloanoption2(), year);
			appstep2(dealercity, cons.state(), null);
			appstep3confirmDetails(downPayment, null, tradein, null);
			appstep3login(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createnewwebappaccount() {
		try {
			data = new Propertycaller();
			cons = new constants();
			webappcreatenewAccount(email, password);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void logintoexistingAccount() {
		webapploginexistingAccount(email, password);
	}

	public void loadautogravityPage() {
		autogravitydotcomPageTest();
	}

	public void theresetpassword() {
		resetpassword(email);
	}

	public void logintosupportDash() {
		loginSupportDash(email, password);
	}

	// FJ Web Widget
	public void loadpage() {
		fjcreateAccount(email, password);
	}

	public void fjlogintoaccount() {
		fjlogintoAccount(email, password);
	}

	public void applicationapprovedTest() {
		try {
			constants cons = new constants();
			data = new Propertycaller();
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String vehicle = LibrariesExtensions.randomMercedesModel();

			fjmercedesvehicleNavigation(data.getfjpreapprovedButton(), vehicle);
			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption,
					cons.rentOption1(), cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(),
					randomSSN());
			appreviewandsubmit(email, "APPR");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void preapprovalfromcarlisttest() {
		try {
			constants cons = new constants();
			data = new Propertycaller();
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String vehicle = LibrariesExtensions.randomMercedesModel();
			fjmercedesvehicleNavigation2(data.getfjpreapprovedbuttonfromcarlist(), vehicle);
			//appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
			//appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption,
				//	cons.rentOption1(), cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(),
					//randomSSN());
			//appreviewandsubmit(email, "APPR");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void calculatorbuttontest() {
		try {
			constants cons = new constants();
			data = new Propertycaller();
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String vehicle = "Mercedes-Benz CLA CLA250";
			fjmercedesvehicleNavigation(data.getfjcalculatorbutton(), vehicle);
			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption,
					cons.rentOption1(), cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(),
					randomSSN());
			// appreviewandsubmit(email, "APPR");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fjdeclinedappliction() {
		try {
			constants cons = new constants();
			Propertycaller data = new Propertycaller();
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String vehicle = LibrariesExtensions.randomMercedesModel();//"Mercedes-Benz CLA CLA250";
			// driver().navigate().to(
			// "https://apply-staging.fjdrive.com/widget-application?dealerId=29633&msrp=32000&imageLink=http://www.blogcdn.com/slideshows/images/slides/389/176/9/S3891769/slug/l/01-2017-mercedes-benz-c300-fd-1.jpg&chromeStyleId=379177");
			// clickbycss(data.getLoginButtonhome());
			fjmercedesvehicleNavigation(data.getfjpreapprovedButton(), vehicle);
			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);
			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption,
					cons.rentOption1(), cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(),
					randomSSN());
			appreviewandsubmit(email, "DECL");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void firstinvestorsApp() {
		try {
			Propertycaller data = new Propertycaller();
			cons = new constants();
			String year = LibrariesExtensions.randomYear(data.getyearselectionxpath());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.state());
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption1());
			String dealercity = cons.ficity();
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String tradein = cons.tradein();
			String downPayment = cons.downPayment();
			
			appstep1update(LibrariesExtensions.specificMake(data.getselectMake(), cons.fimake()), data.getloanOption(), year);
			//appstep1(LibrariesExtensions.specificMake(data.getselectMake(), cons.fimake()), data.getloanOption(), year);

			appstep2(dealercity, cons.state(), cons.fidealership());

			appstep3confirmDetails(downPayment, null, tradein, null);

			appstep3createAccount(cons.FirstName(), cons.LastName(), cons.Phone(), cons.dob(), email, password);

			appstep3completeapplication(cons.address1(), cons.city(), state, cons.zipcode(), rentOption, cons.rent(),
					cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(), randomSSN());

			appreviewandsubmit(email, "A");
		} catch (IOException e) {

			e.printStackTrace();
			log.info("Did not read propertycaller file");
		}

	}
	
	public void westlakeApp(){
		try{
			Propertycaller data = new Propertycaller();
			cons = new constants();
			String downPayment = cons.downPayment();
			String tradein = cons.tradein();
			String rentOption = LibrariesExtensions.selectrentOption(data.getagrentoption(), cons.rentOption2());
			String employmentStatus = LibrariesExtensions.jobStatus(data.getagemploymentstatus());
			String state = LibrariesExtensions.selectState(data.getstateOption(), cons.wlstate());
			appstep1update(cons.wlmake(), data.getloanOption(), null);
			appstep2(cons.wlmakecity(), null, cons.wldealership());
			appstep3confirmDetails(downPayment, null, tradein, null);
			appstep3createAccount(cons.wlfirstname(), cons.wllastname(), cons.Phone(), cons.wldob(), email, password);
			appstep3completeapplication(cons.wladdress(), cons.wlcity(), state, cons.wlzip(), rentOption, cons.rent(), cons.employerName(), cons.Title(), employmentStatus, cons.Phone(), cons.money(), cons.wlssn());
			appreviewandsubmit(email, "APPR");
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void newedwardstest1() {
		edwardshomepagetest();	
	}
	
	public void inputtest1(){
		inputtestSite();
	}

	public void newapttest1() {
		apartmentsite();
		
	}

	public void menusection() {
		menusectiontest();
		
	}

	public void addalisting() {
		addlistingtest();
		
	}

}