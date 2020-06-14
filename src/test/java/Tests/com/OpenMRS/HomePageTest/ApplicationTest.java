package Tests.com.OpenMRS.HomePageTest;

import Pages.HomePage;
import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class ApplicationTest extends TestBase {

    LoginPage page;
    HomePage homePage;
    @BeforeClass
    public void setUpPage(){
        page=new LoginPage(driver);
        homePage=new HomePage(driver);
        driver.manage().deleteAllCookies();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

    }

    @Parameters({"username","password","locationname"})
    @Test
    public void validationFunctionalities(String user,String pass,String location){
        page.login(user, pass, location);
        //Return Of Investment
        List<WebElement> apps=homePage.applications;
        Assert.assertEquals(apps.size(),9); // actual 5 but expected 9
        Assert.assertTrue(apps.size()==9);

        for(WebElement app:apps){
            Assert.assertTrue(app.isDisplayed());
        }
        homePage.clickApplication("Register a patient");

    }
}
