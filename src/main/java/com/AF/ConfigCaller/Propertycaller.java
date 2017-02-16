
package com.AF.ConfigCaller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertycaller {

	protected Properties prop = null;
	protected InputStream input = new FileInputStream("src/main/resources/Config.properties");

	public Propertycaller() throws IOException {
		prop = new Properties();
		prop.load(input);
	}
	
	public String getedwardsurl(){
		return prop.getProperty("edwards");
	}

	public String getsettingicon() {
		return prop.getProperty("settingicon");
	}

	public String getbaseapp() {
		return prop.getProperty("/Users/gracetshihata/Desktop/UI-Catalog-App.zip");
	}

	public String getlocalserveriOS() {
		return prop.getProperty("http://0.0.0.0:4723/wd/hub");
	}

	public String getgraceprivate() {
		return prop.getProperty("9fd3f5680532e3ce4b75e14d5e0cd77cfea94ed0");
	}

	public String getgraceworkingdevice() {
		return prop.getProperty("3a8599751a2a0a8ce31cbed5a83793d842e287af");
	}

	public String getsettingiconpath() {
		return prop.getProperty("settingiconpath");
	}

	public String getsettingiconid() {
		return prop.getProperty("settingiconid");
	}

	public String getsettingiconcss() {
		return prop.getProperty("settingiconcss");
	}

	public String getsettingiconname() {
		return prop.getProperty("settingiconname");
	}

	public String getsingup() {
		return prop.getProperty("singup");
	}

	public String getLogin() {
		return prop.getProperty("Login");
	}

	public String getSettingpagetitlee() {
		return prop.getProperty("Settingpagetitle");
	}

	public String getFAQ() {
		return prop.getProperty("FAQ");
	}

	public String getContactUs() {
		return prop.getProperty("ContactUs");
	}

	public String getTermsofService() {
		return prop.getProperty("TermsofService");
	}

	public String getPrivacyNotice() {
		return prop.getProperty("PrivacyNotice");
	}

	public String getPrivacyPolicy() {
		return prop.getProperty("PrivacyPolicy");
	}

	public String getappVersion() {
		return prop.getProperty("appVersion");
	}

	public String getSinupcloseicon() {
		return prop.getProperty("Sinupcloseicon");
	}

	public String getsignUppagetitle() {
		return prop.getProperty("signUppagetitle");
	}

	public String getsignUploginbutton() {
		return prop.getProperty("signUploginbutton");
	}

	public String getSignUpemail() {
		return prop.getProperty("SignUpemail");
	}

	public String getsignUpPassword() {
		return prop.getProperty("signUpPassword");
	}

	public String getsignUpcreateandcontinuebutton() {
		return prop.getProperty("signUpcreateandcontinuebutton");
	}

	public String getsignUpemailvalidationtext() {
		return prop.getProperty("signUpemailvalidationtext");
	}

	public String getsignUppasswordValidationtext() {
		return prop.getProperty("signUppasswordValidationtext");
	}

	public String getsignUpAvalidEmailAddresstext() {
		return prop.getProperty("signUpAvalidEmailAddresstext");
	}

	public String getsignUpAtleast8characterstext() {
		return prop.getProperty("signUpAtleast8characterstext");
	}

	public String getsignUpAtleast1lowercasetext() {
		return prop.getProperty("signUpAtleast1lowercasetext");
	}

	public String getsingUpatleast1capitallettertext() {
		return prop.getProperty("singUpatleast1capitallettertext");
	}

	public String getsignUpatleastnumbertext() {
		return prop.getProperty("signUpatleastnumbertext");
	}

	public String getinternalServererrorpagetext() {
		return prop.getProperty("internalServererrorpagetext");
	}

	public String getsomthingWentwrongerrorpagetext() {
		return prop.getProperty("somthingWentwrongerrorpagetext");
	}

	public String getnointernetconnectionerrortext() {
		return prop.getProperty("nointernetconnectionerrortext");
	}

	public String getadminbaseurl() {
		return prop.getProperty("adminbaseurl");
	}

	public String getDealerinbaseurl() {
		return prop.getProperty("Dealerinbaseurl");
	}

	public String getadmindashHomeheader() {
		return prop.getProperty("admindashHomeheader");
	}

	public String getadmindashemailId() {
		return prop.getProperty("admindashemailId");
	}

	public String getadmindashpasswordid() {
		return prop.getProperty("admindashpasswordid");
	}

	public String getadmindashforgotpasswordtext() {
		return prop.getProperty("admindashforgotpasswordtext");
	}

	public String getadmindashresetpassword() {
		return prop.getProperty("admindashresetpassword");
	}

	public String getDealerbaseUrl() {
		return prop.getProperty("DealerbaseUrl");
	}

	public String getChooseYourVehicle() {
		return prop.getProperty("ChooseYourVehicle");
	}

	public String getbackbutton() {
		return prop.getProperty("backbutton");
	}

	public String getChooseYourVehicletitle() {
		return prop.getProperty("ChooseYourVehicletitle");
	}

	public String getgearicon() {
		return prop.getProperty("gearicon");
	}

	public String gethelpstoestimateyourloanamounttext() {
		return prop.getProperty("helpstoestimateyourloanamounttext");
	}

	public String getCclass() {
		return prop.getProperty("Cclass");
	}

	public String getyear2016() {
		return prop.getProperty("year2016");

	}

	public String getyear2015() {
		return prop.getProperty("year2015");
	}

	public String getyear2014() {
		return prop.getProperty("year2014");
	}

	public String getyear2013() {
		return prop.getProperty("year2013");
	}

	public String getyear2012() {
		return prop.getProperty("year2012");
	}

	public String getyear2011() {
		return prop.getProperty("year2011");
	}

	public String getyear2010() {
		return prop.getProperty("year2010");
	}

	public String getxmlacknowledgementpath() {
		return prop.getProperty("xmlacknowledgementpath");
	}

	public String getDealerStagingbaseUrl() {
		return prop.getProperty("DealerStagingbaseUrl"); // this is for dealer
															// staging URL only
															// !
	}

	public String getAdminStagingbaseUrl() {
		return prop.getProperty("AdminDashboardbaseUrl");
	}

	public String getdealeremailid() {
		return prop.getProperty("dealeremailid");
	}

	public String getdealeremailxpath() {
		return prop.getProperty("dealeremailxpath");
	}

	public String getdealerPasswordid() {
		return prop.getProperty("dealerPasswordid");
	}

	public String getdealerLoginButton() {
		return prop.getProperty("dealerLoginbuttonpath"); /// this is the submit
															/// button in order
															/// to login for
															/// dealer dash
	}

	// Test
	public String getLoginButtonhome() {
		return prop.getProperty("LoginButtonhome");
	}

	public String getdealerloginError() {
		return prop.getProperty("dealerloginError");
	}

	public String getForgotyourpasswordlink() {
		return prop.getProperty("Forgotyourpasswordlink");
	}

	public String getEmailVerificationtext() {
		return prop.getProperty("EmailVerificationtext");
	}

	public String getSubmitbutton() {
		return prop.getProperty("Submitbutton");
	}

	public String getAccountnotrecognized() {
		return prop.getProperty("Accountnotrecognized");
	}

	public String getDealerSummarylandingpage() {
		return prop.getProperty("DealerSummarylandingpage");
		// TODO Auto-generated method stub
	}

	public String getlogoutlink() {
		// TODO Auto-generated method stub
		return prop.getProperty("logout");
	}

	public String getForgotPasswordErrorMessage() {
		return prop.getProperty("ForgotPasswordErrorMessage");
	}

	public String getfirstname() {
		return prop.getProperty("firstname");
	}

	public String getlastname() {
		return prop.getProperty("lastname");
	}

	public String gettitle() {
		return prop.getProperty("title");
	}

	public String getphone() {
		return prop.getProperty("phone");
	}

	public String getemail() {
		return prop.getProperty("email");
	}

	public String getsignuplink() {
		return prop.getProperty("signup");
	}

	public String getrepeatedpassword() {
		return prop.getProperty("repeatedpassword");
	}

	public String getNextbutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("NextButton");
	}

	public String getAgreebutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("agreebutton");
	}

	public String getdealernamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("dealernamefield");
	}

	public String getDealerlistContainer() {
		// TODO Auto-generated method stub
		return prop.getProperty("DealerlistContainer");
	}

	public String getDealerIdentifier() {
		// TODO Auto-generated method stub
		return prop.getProperty("DealerIdentifier");
	}

	public String getDealershipName() {
		// TODO Auto-generated method stub
		return prop.getProperty("dealershipnamecss");
	}

	public String getLegalName() {
		// TODO Auto-generated method stub
		return prop.getProperty("legalnamecss");
	}

	public String getOwnerName() {
		// TODO Auto-generated method stub
		return prop.getProperty("ownernamecss");
	}

	public String getdealergroupcss() {
		return prop.getProperty("dealergroupcss");
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return prop.getProperty("address1css");
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return prop.getProperty("citycss");
	}

	public String getzipcode() {
		// TODO Auto-generated method stub
		return prop.getProperty("zipcodecss");
	}

	public String getwebsite() {
		// TODO Auto-generated method stub
		return prop.getProperty("websitecss");
	}

	public String getNextbuttonAC() {
		return prop.getProperty("nextbuttoncss");
	}

	public String getdealergroup() {
		return prop.getProperty("dealergroupcss");
	}

	public String getState() {
		return prop.getProperty("statecss");
	}

	public String getfirstDealership() {
		// TODO Auto-generated method stub
		return prop.getProperty("firstdealershipfromlist");
	}

	public String getSubmitApplicationbutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("SubmitApplicationbutton");
	}

	public String getSavebutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("Savebutton");
	}

	public String getDealershipAdditionMessage() {
		// TODO Auto-generated method stub
		return prop.getProperty("DealershipAdditionMessage");
	}

	public String getlegalbusinessname() {
		// TODO Auto-generated method stub
		return prop.getProperty("legalbusinessname");
	}

	public String getmodalframe() {
		return prop.getProperty("modalframe");
	}

	public String getAdminLoginConfirmation() {
		return prop.getProperty("AdminLoginConfirmation");
	}

	public String getautogravitysite() {
		return prop.getProperty("autogravitysite");
	}

	public String getcarpricefieldcss() {
		return prop.getProperty("carpricefieldcss");
	}

	public String gettermfield() {
		return prop.getProperty("termfieldcss");
	}

	// public String getdownpaymentfield() {
	// // TODO Auto-generated method stub
	// return prop.getProperty("downpaymentfieldcss");
	// }

	public String getdownpaymentfield() {
		return prop.getProperty("downpaymentfield");
	}

	public String getestimatedtradeinfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("estimatedtradeinfieldcss");
	}

	public String gettaxratefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("taxratecss");
	}

	public String getaprratefield() {
		return prop.getProperty("aprratecss");
	}

	public String getestimatedmonthlypaymentfield() {
		return prop.getProperty("estimatedmonthlypaymentfield");
	}

	public String getsettingslink() {
		return prop.getProperty("settingslink");
	}

	public String getmyaccountLink() {
		// TODO Auto-generated method stub
		return prop.getProperty("myaccountLink");
	}

	// public String getmyaccountlink(){
	// return prop.getProperty("myaccountlink");
	// }
	public String geteditlink() {
		// TODO Auto-generated method stub
		return prop.getProperty("editlink");
	}

	public String getemailinnertext() {
		return prop.getProperty("getemailinnertext");
	}

	public String getfirstnameinnertext() {
		// TODO Auto-generated method stub
		return prop.getProperty("firstnameinnertext");
	}

	public String getlastnameinnertext() {
		// TODO Auto-generated method stub
		return prop.getProperty("lastnameinnertext");
	}

	public String gettitleinnertext() {
		// TODO Auto-generated method stub
		return prop.getProperty("titleinnertext");
	}

	public String getphoneinnertext() {
		// TODO Auto-generated method stub
		return prop.getProperty("phoneinnertext");
	}

	public String gettitleinputfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("titleinputfield");
	}

	public String getdealersummarylink() {
		// TODO Auto-generated method stub
		return prop.getProperty("dealersummarylink");
	}

	public String getmyaccountlink() {
		// TODO Auto-generated method stub
		return prop.getProperty("myaccountlink");
	}

	public String getphoneinnertextadmin() {
		// TODO Auto-generated method stub
		return prop.getProperty("phoneinnertextadmin");
	}

	public String getemailinnertextadmin() {
		// TODO Auto-generated method stub
		return prop.getProperty("emailinnertextadmin");
	}

	public String geteditlinkadmin() {
		// TODO Auto-generated method stub
		return prop.getProperty("editlinkadmin");
	}

	public String getfirstnamefieldadmin() {
		// TODO Auto-generated method stub
		return prop.getProperty("firstnamefieldadmin");
	}

	public String getdealershipmenulink() {
		// TODO Auto-generated method stub
		return prop.getProperty("dealershipmenulink");
	}

	public String getagapplysite() {
		// TODO Auto-generated method stub
		return prop.getProperty("agapplysite");
	}

	public String getmakeselectorcss() {
		// TODO Auto-generated method stub
		return prop.getProperty("makeselectorcss");
	}

//	public String getmakeselectioncss() {
//		// TODO Auto-generated method stub
//		return prop.getProperty("makeselectioncss");
//	}

	public String getcontainerelement() {
		return prop.getProperty("containerelement");
	}

	public String getmodelselector() {
		// TODO Auto-generated method stub
		return prop.getProperty("modelselectorcss");
	}

	public String getfirstmodelselectioncss() {
		// TODO Auto-generated method stub
		return prop.getProperty("modelselection");
	}

	public String getyearselectorcss() {
		// TODO Auto-generated method stub
		return prop.getProperty("yearselectioncss");
	}

	public String getyearselection() {
		// TODO Auto-generated method stub
		return prop.getProperty("yearselection");
	}

	public String getnextbuttoncss() {
		// TODO Auto-generated method stub
		return prop.getProperty("nextbuttoncss");
	}

	public String gettemppasswordfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("temppasswordfield");
	}

	public String getagsubmitbutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("agsubmitbutton");
	}

	public String gettestcarpricefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("testcarpricefield");
	}

	public String getmovetoMercedes() {
		// TODO Auto-generated method stub
		return prop.getProperty("movetoMercedes");
	}

	public String getfirsttrimoption() {
		// TODO Auto-generated method stub
		return prop.getProperty("firsttrimoption");
	}

	public String getleaseOption() {
		// TODO Auto-generated method stub
		return prop.getProperty("leaseoption");
	}

	public String getdealershipoption() {
		// TODO Auto-generated method stub
		return prop.getProperty("dealershipoption");
	}

	public String getagfirstnamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agfirstnamefield");
	}

	public String getaglastnamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aglastnamefield");
	}

	public String getagphonenumberfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agphonenumberfield");
	}

	public String getagdateofbirthfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agdateofbirthfield");
	}

	public String getagnewemailfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agnewemailfield");
	}

	public String getagnewpasswordfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agnewpasswordfield");
	}

	public String getagrepeatnewpasswordfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agrepeatnewpasswordfield");
	}

	public String getagaddressfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agaddressfield");
	}

	public String getagcityfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agcityfield");
	}

	public String getagstatefield() {
		return prop.getProperty("agstatefield");
	}

	public String getcaliforniastateoption() {
		// TODO Auto-generated method stub
		return prop.getProperty("californiastateoption");
	}
	
	public String getstateOption(){
		return prop.getProperty("stateoption");
	}

	public String getagzipcode() {
		// TODO Auto-generated method stub
		return prop.getProperty("agzipcode");
	}

	public String getagmovinDate() {
		// TODO Auto-generated method stub
		return prop.getProperty("agmoveinDate");
	}

	public String getagrentownfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agrentownfield");
	}

	public String getagrentoption() {
		// TODO Auto-generated method stub
		return prop.getProperty("agrentoption");
	}

	public String getagmortgagepayment() {
		// TODO Auto-generated method stub
		return prop.getProperty("agmortgagepayment");
	}

	public String getagemployernamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemployernamefield");
	}

	public String getagtitlefield() {
		return prop.getProperty("agtitlefield");
	}

	public String getagstartdate() {
		// TODO Auto-generated method stub
		return prop.getProperty("agstartdate");
	}

	public String getagemploymentstatusfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemploymentstatusfield");
	}

	public String getagemploymentstatus() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemploymentstatus");
	}

	public String getagemployernumberfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemployernumberfield");
	}

	public String getaggrossmonthlyincomefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aggrossmonthlyincomefield");
	}

	public String getagssnfield() {
		return prop.getProperty("agssnfield");
	}

	public String getagsignconsent() {
		// TODO Auto-generated method stub
		return prop.getProperty("agsignconsent");
	}

	public String getagaddress2field() {
		return prop.getProperty("agaddress2field");
	}

	public String getagloginButton() {
		return prop.getProperty("agloginButton");
	}

	public String getagsignuplink() {
		return prop.getProperty("signuplink");
	}

	public String getagnewregistrationemailfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agnewemailfield");
	}

	public String getagnewregisterpasswordfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agnewregisterpasswordfield");
	}

	public String getagnewregisterconfirmpasswordfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agnewregisterconfirmpasswordfield");
	}

	public String getloggedinUser() {
		// TODO Auto-generated method stub
		return prop.getProperty("loggedinUser");
	}

	public String getagforgotpasswordLink() {
		// TODO Auto-generated method stub
		return prop.getProperty("agforgotpasswordLink");
	}

	public String getagemailfrontfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemailfield");
	}

	public String getactiveMQurl() {
		// TODO Auto-generated method stub
		return prop.getProperty("activeMQurl");
	}

	public String getmetacss() {
		// TODO Auto-generated method stub
		return prop.getProperty("metacss");
	}

	public String getbuildnumber() {
		// TODO Auto-generated method stub
		return prop.getProperty("buildnumber");
	}

	public String gettruebuildversion() {
		return prop.getProperty("truebuildVersion");
	}

	public String getapplication_number() {
		return prop.getProperty("application_number");
	}

	public String getenvironment() {
		return prop.getProperty("environment");
	}

	public String gettestrailurl() {
		// TODO Auto-generated method stub
		return prop.getProperty("testrailurl");
	}

	public String getidcontainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getlinkcss() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getpriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public String gettimestamp() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getmessage() {
		return null;
	}

	public String getbrowsersession() {
		return prop.getProperty("browser");
	}

	public String gettestrun() {
		return prop.getProperty("testrun");
	}

	public String getaglogoutlink() {
		return prop.getProperty("aglogout");
	}

	public String getaglogin() {
		return prop.getProperty("aglogin");
	}

	public String getloginpassword() {
		return prop.getProperty("loginpassword");
	}

	public String getselectMake() {
		return prop.getProperty("selectMake");
	}

	public String getmovetomodel() {
		return prop.getProperty("movetomodel");
	}

	public String getyearselectionxpath() {
		return prop.getProperty("yearselectionxpath");
	}

	public String getloanOption() {
		return prop.getProperty("loanoption");
	}
	
	public String getloanoption2(){
		return prop.getProperty("loanoption2");
	}

	public String getlendertab() {
		return prop.getProperty("lendertab");
	}

	public String getleaseOption2() {
		return prop.getProperty("leaseOption2");
	}

	public String getlendername() {
		return prop.getProperty("lendername");
	}

	public String getsearchfield() {
		return prop.getProperty("searchfield");
	}

	public String getautogravitydotcompage() {
		return prop.getProperty("autogravitydotcompage");
	}

	public String getaglearnmoreButton() {
		return prop.getProperty("aglearnmorebutton");
	}

	public String getaghomepasswordprotectfield() {
		return prop.getProperty("aghomepasswordprotectfield");
	}

	public String getaghomepagenextbutton() {
		return prop.getProperty("aghomepagenextbutton");
	}

	public String getbottompageiosversionlink() {
		return prop.getProperty("agbottomiosversionlink");
	}

	public String getbottompageaggoogleversionlink() {
		return prop.getProperty("aggoogleversionlink");
	}

	public String getbottompageagwebapplink() {
		// TODO Auto-generated method stub
		return prop.getProperty("agwebapplink");
	}

	public String getaggetstartedbutton() {
		return prop.getProperty("aggetstartedbutton");
	}

	public String getiostopofpagebutton() {
		return prop.getProperty("iostopofpagebutton");
	}

	public String gettopofpagegooglestorebutton() {

		return prop.getProperty("topofpagegooglestorebutton");
	}

	public String getagvaluefield() {

		return prop.getProperty("agvaluefield");
	}

	public String getagtermbutton() {
		return prop.getProperty("agtermbutton");
	}

	public String getagleaseoptionslink() {
		return prop.getProperty("agleaseoption");
	}

	public String getdealerpopupwindow() {
		return prop.getProperty("dealerpopupwindow");
	}

	public String getagemailfieldpopup() {
		// TODO Auto-generated method stub
		return prop.getProperty("agemailfieldpopup");
	}

	public String getrightarrowclickpopup() {
		// TODO Auto-generated method stub
		return prop.getProperty("rightarrowclickpopup");
	}

	public String getnodealersfoundtext() {
		return prop.getProperty("nodealersfoundtext");
	}

	public String getclosewindowlink() {
		return prop.getProperty("closewindowlink");
	}

	public String getresetpassworedemailsenttext() {
		return prop.getProperty("resetpassworedemailsenttext");
	}

	public String Forgotpasswordlink() {
		return prop.getProperty("Forgotpasswordlink");
	}

	public String getpopupcheckbox() {
		return prop.getProperty("popupcheckbox");
	}

	public String getmsrpprice() {
		return prop.getProperty("msrpprice");
	}

	public String getapplicationnumber() {
		return prop.getProperty("applicationnumber");
	}

	public String getlenderimage() {
		return prop.getProperty("lenderimage");
	}

	public String getwebappbuildVersion() {
		return prop.getProperty("webappbuildVersion");
	}

	public String getdealerdashbuildVersion() {
		return prop.getProperty("dealerdashbuildVersion");
	}

	public String getsupportdashUrl() {
		return prop.getProperty("supportdashUrl");
	}

	public String getsupportdashbuildVersion() {
		return prop.getProperty("supportdashbuildVersion");
	}

	public String getsupportlogoutbutton() {
		return prop.getProperty("supportlogoutbutton");
	}

	public String getsupportconsumerlink() {
		// TODO Auto-generated method stub
		return prop.getProperty("supportconsumerlink");
	}

	public String getproductdropdown() {
		return prop.getProperty("productdropdown");
	}

	public String getagproductcode() {
		return prop.getProperty("agproductcode");
	}

	public String getsupportsearchemailfield() {
		return prop.getProperty("supportsearchemailfield");
	}

	public String getnewelementtest() {
		return prop.getProperty("newelementtest");

	}

	public String CurrentIntegrationServers() {
		return prop.getProperty("CurrentIntegrationServers");
	}

	public String simulatecreditresponseendpoint() {
		return prop.getProperty("simulatecreditresponseEndPoint");
	}

	public String getmbfspostRequest() {
		return prop.getProperty("mbfspostrequest");
	}

	public String getroadloansendpoint() {
		return prop.getProperty("roadloansendpoint");
	}

	public String getroadloansrequest() {
		return prop.getProperty("roadloansrequest");
	}

	public String getfjwidgetsite() {
		return prop.getProperty("fjwidgetsite");
	}

	public String getsignUplink() {
		return prop.getProperty("signUplink");
	}

	public String getclickhereLink() {
		return prop.getProperty("clickhere");
	}

	public String getpreapprovedbutton() {
		return prop.getProperty("preapprovedbutton");
	}
	
	public String getpassvaluespage(){
		return prop.getProperty("passvaluespage");
	}

	public String getdealershipcontainer() {
		return prop.getProperty("dealershipcontainer");
	}
	
	public String getrouteonedecisionendpoint(){
		return prop.getProperty("routeonedecisionendpoint");
	}
	
	public String getfirstinvestorsdecision(){
		return prop.getProperty("firstinvestorsdecision");
	}

	public String getfjmercedesurl() {
		// TODO Auto-generated method stub
		return prop.getProperty("fjmercedesurl");
	}

	public String getfjcarlist() {
		return prop.getProperty("fjcarlist");
	}

	public String getfjcarselection() {
		return prop.getProperty("fjcarselection");
	}

	public String getfjpreapprovedButton() {
		return prop.getProperty("fjpreapprovedbutton");
	}

	public String getfjcalculatorbutton() {
		return prop.getProperty("fjcalculatorbutton");
	}

	public String getfjsearchfield() {
		return prop.getProperty("fjsearchfield");
	}

	public String getfjsearchbutton() {
		return prop.getProperty("fjsearchbutton");
	}

	public String getfjpreapprovedbuttonfromcarlist() {
		return prop.getProperty("fjpreapprovedbuttonfromcarlist");
	}

	public String getchildclasscss() {
		return prop.getProperty("childclasscss");
	}

	public String getmodelcollector() {
		return prop.getProperty("modelcollector");
	}

	public String getchildmodelselectorcss() {
		return prop.getProperty("childmodelselectorcss");
	}

	public String getmainpagemenu() {
		return prop.getProperty("mainpagemenu");
	}

	public String getanotherurl() {
		// TODO Auto-generated method stub
		return prop.getProperty("edwardsurl");
	}

	public String getsearchjoblink() {
		// TODO Auto-generated method stub
		return prop.getProperty("searchjoblink");
	}

	public String getshowmore() {
		// TODO Auto-generated method stub
		return prop.getProperty("showmore");
	}

	public String getfindjobsbutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("findjobs");
	}

	public String getkeywordinput() {
		return prop.getProperty("keywordinput");
	}

	public String getqatestSite() {
		// TODO Auto-generated method stub
		return prop.getProperty("qatestSite");
	}
	
	public String getapartmentsurl(){
		return prop.getProperty("apartmentsurl");
	}

	public String gettestsiteinputfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("testsiteinputfield");
	}

	public String getsecondcheckbox() {
		// TODO Auto-generated method stub
		return prop.getProperty("secondcheckbox");
	}

	public String getthirdradiobutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("thirdradiobutton");
	}

	public String getsearchfieldid() {
		// TODO Auto-generated method stub
		return prop.getProperty("searchfieldid");
	}

	public String getsearchrange() {
		// TODO Auto-generated method stub
		return prop.getProperty("searchrange");
	}

	public String getminrange() {
		// TODO Auto-generated method stub
		return prop.getProperty("minrange");
	}
	
	public String getmaxrange(){
		return prop.getProperty("maxrange");
	}

	public String gobutton() {
		// TODO Auto-generated method stub
		return prop.getProperty("gobutton");
	}

	public String getaptcontainer() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptlistings");
	}

	public String getindividuallisting() {
		// TODO Auto-generated method stub
		return prop.getProperty("apttitle");
	}

	public String hamburgermenu() {
		// TODO Auto-generated method stub
		return prop.getProperty("hamburgermenu");
	}

	public String getaptsaddressfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptaddressinput");
	}

	public String getcondoradio() {
		// TODO Auto-generated method stub
		return prop.getProperty("condoradiobutton");
	}

	public String getsquareftfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("squareftfield");
	}

	public String getaptrentfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptrentfield");
	}

	public String getaptdepositefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptdepositefield");
	}

	public String getcalendarfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("calendarfield");
	}

	public String getleaselengthfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("leaselengthfield");
	}

	public String getaptfirstnamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptfirstname");
	}

	public String getaptlastnamefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptlastname");
	}

	public String getaptemailfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptemailfield");
	}

	public String getaptphonefield() {
		// TODO Auto-generated method stub
		return prop.getProperty("aptphonefield");
	}

	public String getdogfield() {
		// TODO Auto-generated method stub
		return prop.getProperty("dogfield");
	}

}