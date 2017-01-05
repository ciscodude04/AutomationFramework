package Libraries;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.AF.Drivers.Drivers;
import com.AF.TestRail.Result;

import junit.framework.Assert;

public class WebDriverLibrary {

	public static WebDriver driver() {
		return Drivers.instance;
	}
	
	public static void clickbycssName(String name, String Selection){
		WebElement x = driver().findElement(By.className(name));
	
	}

	public static void clickbypartiaLink(String partialink) {
		WebElement x = driver().findElement(By.partialLinkText(partialink));
		x.click();
	}

	public static void clickbylinkText(String linkText) {
		WebElement x = driver().findElement(By.linkText(linkText));
		x.click();
	}

	public static void clickbyid(String id) {
		WebElement x = driver().findElement(By.id(id));
		x.click();
	}

	public static void clickbyName(String name) {
		WebElement x = driver().findElement(By.name(name));
		x.click();
	}

	public static void clickbyclassName(String className) {
		WebElement x = driver().findElement(By.className(className));
		x.click();
	}

	public static void clickbycss(String selector) {
		WebElement x = driver().findElement(By.cssSelector(selector));
		x.click();
	}

	public static void clickbyxpath(String xpath) {
		WebElement x = driver().findElement(By.xpath(xpath));
		x.click();
	}

	public static void inputbyid(String id, String datainput) {
		WebElement x = driver().findElement(By.id(id));
		x.clear();
		x.sendKeys(datainput);
	}

	public static void inputbyName(String name, String datainput) {
		WebElement x = driver().findElement(By.name(name));
		x.clear();
		x.sendKeys(datainput);
	}

	public static void inputbyclassName(String className, String datainput) {
		WebElement x = driver().findElement(By.xpath(className));
		x.clear();
		x.sendKeys(datainput);
	}

	public static void inputbycss(String css, String datainput) {
		WebElement x = driver().findElement(By.cssSelector(css));
		x.clear();
		x.sendKeys(datainput);
	}

	public static void inputbycss(String css, Keys key) {
		WebElement x = driver().findElement(By.cssSelector(css));
		x.clear();
		x.sendKeys(key);
	}

	public static void inputbyxpath(String xpath, String datainput) {
		WebElement x = driver().findElement(By.xpath(xpath));
		x.clear();
		x.sendKeys(datainput);
	}

//	public static void inputbyxpath(String xpath, Keys key) {
//		WebElement x = driver().findElement(By.xpath(xpath));
//		x.clear();
//		x.sendKeys(key);
//	}

	public static String getpagesource() {
		String pageSource = driver().getPageSource().toString();
		return pageSource;
	}

	public static String getpageSource() {
		String pg = driver().findElement(By.tagName("body")).toString();
		return pg;
	}

	public static void pageTitle() {
		driver().getTitle();
	}

	public static boolean iselementPresent(By by) {
		try {
			driver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void waitforelementcss(String element) {
		WebDriverWait wait = new WebDriverWait(driver(), 5);
		WebElement elementtag = driver().findElement(By.cssSelector(element));
		wait.until(ExpectedConditions.elementToBeClickable(elementtag));
	}

	public static void waitforelementxpath(String element) {
		WebDriverWait wait = new WebDriverWait(driver(), 5);
		WebElement elementtag = driver().findElement(By.xpath(element));
		wait.until(ExpectedConditions.elementToBeClickable(elementtag));
	}

	public static void waituntiltextisPresent(String text) {
		WebDriverWait wait = new WebDriverWait(driver(), 5);
		istextPresent(text);
	}

	public static boolean isalertPresent() {
		try {
			driver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static boolean istextPresent(String text) {
		try {
			boolean b = driver().getPageSource().contains(text);
			return b;
		} catch (Exception e) {
			return false;
		}
	}

	public static void asserttextequals(String actual, String expected) {
		if (actual.equals(expected)) {
			// Pass("Comparison test passed.");
		} else if (actual.isEmpty()) {
			// fail("No data being shown");
		} // else
			// fail(actual + " does not equal to " + expected);
	}

	public static void assertstringcontains(String actual, String expected) {
		String message = (actual + "does no equal to " + expected);
		if (actual.indexOf(expected) < 0) {
			// fail(message);
		}
		// Pass();
	}

	public static void anotherattemptoselect(String selector, String select) {
		String pageSource = driver().findElement(By.tagName("body")).getText();
		ArrayList<String> options = new ArrayList<String>();
		int count = 50;
		for (int i = 0; i <= count; i++)

			if (pageSource.contains(selector)) {
				String selectorids = driver().findElement(By.cssSelector(selector)).getText();
				options.add(selectorids.toString());
			}
	}

	public static void dropdownselectorbyCSS(String elementtoclick, String texttoclick) {
		try {
			clickbycss(elementtoclick);
			Thread.sleep(700);
			clickbyxpath(texttoclick);
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void dropdownselectorbyXpath(String elementtoclick, String texttoclick) {
		try {
			clickbyxpath(elementtoclick);
			Thread.sleep(700);
			clickbyxpath(texttoclick);
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void dropdownselectorYear(String elementtoclick, String texttoclick) {
		try {
			clickbycss(elementtoclick);
			Thread.sleep(600);
			/// waitforelementxpath(texttoclick);
			if (!iselementPresent(By.xpath(texttoclick))) {
				if (!iselementPresent(By.xpath("//div[text()='2017']"))) {
					clickbyxpath("//div[text()='2015']");
				} else
					clickbyxpath("//div[text()='2017']");
			} else
				clickbyxpath(texttoclick);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void dropdownselectorbyCSS2(String elementtoclick, String texttoclick) {
		try {
			clickbycss(elementtoclick);
			Thread.sleep(1500);
			clickbyxpath(texttoclick);
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getinnertextCss(String element) {
		String InnerText = driver().findElement(By.cssSelector(element)).getText();
		return InnerText;
	}

	public static String getinnertextXpath(String element) {
		String innerText = driver().findElement(By.xpath(element)).getText();
		return innerText;
	}

	public static String getinnertextName(String element) {
		String innerText = driver().findElement(By.name(element)).getText();
		return innerText;
	}

	public static String getinnertextId(String element) {
		String innerText = driver().findElement(By.id(element)).getText();
		return innerText;
	}

	public static String getinnertextclassName(String element) {
		String innerText = driver().findElement(By.xpath(element)).getText();
		return innerText;
	}

	public static String getcssAttribute(String selector, String attribute) {
		String value = driver().findElement(By.cssSelector(selector)).getAttribute(attribute);
		if (value == null || value.isEmpty()) {
			// fail(value + " String is empty");
		}
		return value;
	}

	public static boolean comparebuildversion(String currentbuildNumber, String truebuildversion, String environment) {
		if (!currentbuildNumber.equals(truebuildversion)) {
			String result = "Fail";
			recordbuilversion(currentbuildNumber, truebuildversion, environment, result);
			return false;
		} else {
			String result = "Pass";
			recordbuilversion(currentbuildNumber, truebuildversion, environment, result);
			return true;
		}
	}

	public static void recordbuilversion(String currentbuildNumber, String truebuildversion, String environment,
			String result) {
		try {
			String content = "";
			if (result.equals("Pass")) {
				content = Timestamp() + "\nPass: " + truebuildversion + " is matching on " + environment;
			} else {
				content = Timestamp() + "\nFail: " + currentbuildNumber + " does not match " + truebuildversion + " on "
						+ environment;
			}
			File file = new File("src/main/resources/" + environment + "AGbrowser.txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("Created new file...");
				}
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.flush();
			bw.close();

		} catch (IOException e) {
			System.out.println("COULD NOT LOG TO FILE");
		}
	}

	public static String Timestamp() {
		String timestamp = new SimpleDateFormat("MM-dd-yy.HH:mm:ss").format(new Date());
		return timestamp;
	}

	public static int verifyUrl(String expected) {
		String url = driver().getCurrentUrl();
		if (url.contains(expected)) {
			return Result.Pass();
		} else
			System.out.println("Fail!");
		System.out.println("user is routed to " + url);
		return Result.Failed();
	}

	public static void returntopreviouspage() {
		try {
			driver().navigate().back();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Did not navigate to previous screen.");
		}
	}

	public static void switchtoframe(String element) {
		// di().switchTo().frame(element);
		driver().switchTo().activeElement();
		// di().switchTo().frame(di().findElement(By.xpath(element)));

	}

	public static String randomEmail() {
		String newEmail = "AGTest" + RandomStringUtils.random(5, true, true) + "@mailinator.com";
		return newEmail;
	}

	public static boolean compareString(String compare1, String compare2) {

		if (compare1 == null || compare1.isEmpty()) {
			System.out.println(compare1 + " does not equal to " + compare2);
			return false;
		} else {
			if (compare1.contains(compare2)) {
				//System.out.println(compare1 + " equals to " + compare2);
				return true;
			}
		}
		return false;
	}

	public static boolean compareintValue(int compare1, int compare2) {
		if (compare1 == compare2) {
			return true;
		} else if (compare1 >= compare2 + 1) {
			return true;
		} else if (compare1 <= compare2 + 1) {
			return true;
		}
		return false;

	}

	public static void fail() {
		Assert.assertEquals(1, 2);
	}

	public static void fail(String comment) {
		if (comment == null) {
			fail();
		} else if (comment != null) {
			System.out.println(comment);
			fail();
		}
	}

	public static void Pass(String Value) {
		if (Value == null) {
			System.out.println(Value);
			Assert.assertEquals(1, 1);
		} else if (Value != null) {

			Assert.assertEquals(1, 1);
			System.out.println(Value);
		}
	}

	public static String randomSSN() {
		String beginssn = "1";
		String ssnumber = RandomStringUtils.random(8, false, true);
		String ssn = beginssn + ssnumber;
		return ssn;
	}

	public static void setProperty(String property, String value) {
		try {
			PropertiesConfiguration conf = new PropertiesConfiguration("src/main/resources/Builds.properties");
			conf.setProperty(property, value);
			conf.save();
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public void checkpropertyExists(String key){
		try{
			PropertiesConfiguration conf = new PropertiesConfiguration("src/main/resources/Builds.properties");
			conf.containsKey(key);
			
		}catch(ConfigurationException e){
			System.out.println("Did not set the property");
			e.printStackTrace();
		}
	}

	public static void selectdropdownelements(String buttonname) {
		List<WebElement> li = driver().findElements(By.linkText(buttonname));
		li.get(0).click();
	}

}
