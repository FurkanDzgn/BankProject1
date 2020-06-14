package Tests.com.OpenMRS.LoginTest;

import DataSource.LoginData2;
import Pages.LoginPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork extends TestBase {

    LoginPage page;
    @BeforeClass
    public void setUpPage(){

        page=new LoginPage(driver);
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    /*
       HOMEWORK
       Create new loginTest and Validate the login functionality with following values
       1- wrong username and correct password
       2- correct username and wrong password
       3- wrong username and wrong password
       User DataProvider for your username and password
        */

    @Test(dataProvider = "OpenMrsLogin",dataProviderClass = LoginData2.class)
    public void validateCase(String username,String password,String locationName){

        page.login(username,password,locationName);
        String actual=page.errorMessage.getText().trim();
        String expected="Invalid username/password. Please try again.";
        Assert.assertEquals(actual,expected);

    }

}
