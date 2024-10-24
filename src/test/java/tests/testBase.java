package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class testBase {
    protected WebDriver driver;
    protected Faker fake;
    protected SoftAssert soft;
    protected static ExtentReports report;
    protected static ExtentTest reportTest;

    @BeforeSuite
    public void setUP(){
        report=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(new File("Reports/report.html"));
        spark.config().setTheme(Theme.DARK);
        report.attachReporter(spark);

    }

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("src/main/resources/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_6_8_0_0.crx"));
        driver = new ChromeDriver(options);
        driver.navigate().to("https://wuzzuf.net/jobs/egypt");
        //ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));
        //driver.close();
        //driver.switchTo().window(tabs.get(0));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

    @AfterSuite
    public void tearDown() throws IOException {
        report.flush();
        Desktop.getDesktop().open(new File("Reports/report.html"));

    }
}
