package testcase;

import static org.testng.Assert.assertEquals;
import utils.BrowserDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search extends CucumberRunner {
	
	@Given("^打开百度，验证title$")
	public void setp1() throws Throwable {
		assertEquals(BrowserDriver.dr.getTitle(), "百度一下，你就知道");
	}
	
	@When("^输入 \"(.*?)\"$")
	public void setp2(String text) throws Throwable {
		driver.type("//*[@id='kw']", text);
	}
	
	@Then("^点击搜索按钮$")
	public void setp3() throws Throwable {
		driver.click("//*[@id='su']");
	}
	
	@Then("^清除搜索框$")
	public void setp4() throws Throwable {
		String[] ss = {"//*[@id='kw']"};
		driver.clearText(ss);
	}
	
	

}
