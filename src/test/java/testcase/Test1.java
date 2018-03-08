package testcase;

import com.webdriver.exception.StepException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BrowserDriver;

/**
 * Created by sl on 2017/5/27.
 */
public class Test1 {
    BrowserDriver driver = null;
    String win1 = "";

    @BeforeTest
    public void setup() {
        driver = new BrowserDriver("https://www.dianping.com/beijing");
    }

    @Test
    public void aTest() throws Exception {
        win1 = driver.getWindowHandle();
        driver.clickByText("//ul[@class='term-list block-inner Fix']/li/ul/li","小吃快餐");
        for (String win2:driver.dr.getWindowHandles()) {
            if (!win2.equals(win1)) {
                driver.changeWindow(win2);
            }
        }
//        driver.click("//*[@id='classfy']/a[4]/span");
        int count = driver.getRowCount("//div[@id='shop-all-list']/ul/li/div[2]/div/a/h4");
        String curUrl = driver.dr.getCurrentUrl();
        System.out.println("The count is :"+count);
        // 如果下一页没有显示，则停止。

        while (driver.getElement("//a[.='下一页']").isDisplayed()) {
            for (int i = 0;i<count;i++) {
                String win3 = driver.getWindowHandle();
                driver.waitTime(2500);
                driver.clickByIndex("//div[@id='shop-all-list']/ul/li/div[2]/div/a/h4",i);
                for (String win2:driver.dr.getWindowHandles()) {
                    if (!win2.equals(win3)) {
                        driver.changeWindow(win2);
                    }
                }
                String curUrl2 = driver.dr.getCurrentUrl();
                System.out.println("门店名称:"+driver.getText("//div[@id='basic-info']/h1")+";门店Url:"+curUrl2);
                driver.open(curUrl);

//            System.out.println("the shop's name is:"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div/a/h4",i)+";人均:"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[2]/a[2]/b",i)+";"+driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[2]/a/b",i)+"条点评;"+"地址："+
//                    driver.getRowText("//div[@id='shop-all-list']/ul/li/div[2]/div[3]/a[2]/span",i));
            }
            driver.click("//a[.='下一页']");
        }
    }

    @AfterClass
    public void tearDown() throws StepException {
        driver.close();
    }
}
