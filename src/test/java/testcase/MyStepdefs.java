package testcase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import page.Waiter1;
import utils.BrowserDriver;
import utils.ScreenShot;


/**
 * Created by sl on 2017/5/24.
 *
 */

public class MyStepdefs extends CucumberRunner {

    String win1 = "";
    @Before
    public void setUp() throws Exception {
        driver = new BrowserDriver("http://www.baidu.com");
    }
    @Given("^打开门店地址 \"([^\"]*)\"$")
    public void 打开门店地址(String arg0) throws Throwable {
        driver.open(arg0);

    }
    @When("^输入用户名 \"([^\"]*)\" ，密码 \"([^\"]*)\"$")
    public void 输入用户名密码(String arg0, String arg1) throws Throwable {
        driver.type(Waiter1.userNameX,arg0);
        driver.type(Waiter1.passWordX,arg1);
    }

    @Then("^点击登录按钮$")
    public void 点击登录按钮() throws Throwable {
        driver.click(Waiter1.logIn_Ok);
        driver.capture();

    }

    @After
    public void takeScreenShot(Scenario scenario) {
        ScreenShot.takeScreenShot(scenario);
    }


    @Given("^打开地址 \"([^\"]*)\"$")
    public void 打开地址(String arg0) throws Throwable {
        driver.open(arg0);
    }


    @Then("^列出所有的店名字$")
    public void 列出所有的店名字() throws Throwable {
        for (String win2:driver.dr.getWindowHandles()) {
            if (!win2.equals(win1)) {
                driver.changeWindow(win2);
            }
        }
        driver.click("//*[@id='classfy']/a[4]/span");
        int count = driver.getRowCount("//div[@id='shop-all-list']/ul/li/div[2]/div/a/h4");
        System.out.println("The count is :"+count);
        for (int i = 0;i<count;i++) {
            System.out.println("the shop's name is:"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div/a/h4",i)+";人均:"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[2]/a[2]/b",i)+";"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[2]/a/b",i)+"条点评;"+"地址："+
                    driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[3]/a[2]/span",i));
        }
    }

    @When("^点击 \"([^\"]*)\"$")
    public void 点击(String arg0) throws Throwable {
        win1 = driver.getWindowHandle();
        driver.clickByText("//ul[@class='term-list block-inner Fix']/li/ul/li",arg0);
    }
}
