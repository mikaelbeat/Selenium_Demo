package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".jpg";
		String directory = System.getProperty("user.dir")+"\\Reports\\Screenshots\\";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		String destination = directory + fileName;
		return destination;
	}

}


//public static String capture(WebDriver driver) {
//    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    StringBuffer failedPicPath = new StringBuffer();
//    failedPicPath.append(System.getProperty("user.dir")+"//Reports//ScreenShots//");
//    String fn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString(); //Or the name you want. I suggest don't use static name.
//    failedPicPath.append(fn);
//    failedPicPath.append(".jpg");
//}