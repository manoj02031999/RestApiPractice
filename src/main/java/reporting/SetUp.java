package reporting;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class SetUp implements ITestListener {
    private static ExtentReports extentReports;
    public void onStart(ITestContext context) {
        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") +"\\reports\\"+ fileName;
        extentReports = ExtentReportManager.createInstance(fullReportPath,"Test API Automation Report", "Test Execution report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null){
            extentReports.flush();
        }
    }
}
