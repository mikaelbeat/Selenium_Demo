package utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport {
	
	public static ExtentReports reportResult() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir")+"\\Reports\\Report\\Report.html";
		extent = new ExtentReports(Path, false);
		return extent;

	}

}
