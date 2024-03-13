package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {
    public static ExtentReports extentReports;
    public static ExtentReports createInstance(String fileName,String reporterName,String documentTitel){
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reporterName);
        extentSparkReporter.config().setDocumentTitle(documentTitel);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" +formattedTime+ ".html";
        return reportName;
    }
}
