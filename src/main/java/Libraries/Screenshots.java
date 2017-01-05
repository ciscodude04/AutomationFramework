package Libraries;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.thoughtworks.selenium.ScreenshotListener;

public class Screenshots extends RunListener {

	private static TakesScreenshot screenshotTaker;

	// @Override
//	public static void screenshot(String TestCase) throws Exception {
//		File file = screenshotTaker.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("/Users/Francisco/Documents/AutomationScreenshots/ " + TestCase + "_"
//				+ WebDriverLibrary.Timestamp() + ".png"));
//		System.out.println();
//	}

}
