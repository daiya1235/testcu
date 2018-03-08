package testcase;

import com.webdriver.exception.StepException;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.BrowserDriver;

import java.io.IOException;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/features", glue = "testcase", plugin = {
        "pretty", "html:target/cucumber-html-report;", "json:target/cucumber.json"}, tags = {"@papaya"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
    public static BrowserDriver driver = null;




    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new BrowserDriver("http://www.baidu.com");
    }

    @AfterSuite(alwaysRun = true)
    public void quit() throws StepException {
        driver.close();
    }


}
