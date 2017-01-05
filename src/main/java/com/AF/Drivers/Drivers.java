package com.AF.Drivers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.AF.ConfigCaller.Propertycaller;
import com.gargoylesoftware.htmlunit.BrowserVersion;

import io.appium.java_client.ios.IOSDriver;

public class Drivers {

	public static WebDriver instance;
	public static IOSDriver iosinstance;
	public static RemoteWebDriver rdriver;
	public static Propertycaller data;

	public static void Initialize(String Browser, String url) {
		try {
			data = new Propertycaller();
			Browser = data.getbrowsersession();
			String env = data.getenvironment();
			String newurl;
			data.getenvironment();

			if (env.equals("prod")) {
				newurl = url.replace("-<env>", "");
			} else {
				if (url.contains("https://www.autogravity.com")) {
					newurl = url.replace("<env>", "home-redesign/");
				} else
					newurl = url.replace("<env>", env);
			}
			if (Browser.equals("firefox")) {
				instance = new FirefoxDriver();
				instance.manage().window().maximize();
				instance.get(newurl);
				instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (Browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:/Users/Cisco/Documents/Eclipse/chromedriver.exe");
				System.setProperty("webdriver.chrome.silentOutput", "true");
				instance = new ChromeDriver();
				instance.manage().window().maximize();
				instance.get(newurl);
				instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (Browser.equals("internet explorer")) {
				instance = new InternetExplorerDriver();
				instance.manage().window().maximize();
				instance.get(newurl);
				instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (Browser.equals("safari")) {
				// System.setProperty("SafariDriver", "/usr/bin/safaridriver");
				instance = new SafariDriver();
				instance.manage().window().maximize();
				instance.get(newurl);
				instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			} else if (Browser.equals("headless")) {
				instance = new HtmlUnitDriver(BrowserVersion.CHROME);
				instance.get(newurl);
				instance.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static void close() {
		try {
			Drivers.iosinstance.close();
		} catch (RuntimeException e) {
			try {
				Drivers.instance.close();
			} catch (RuntimeException e2) {
				e2.printStackTrace();
			}

		}
	}

}
