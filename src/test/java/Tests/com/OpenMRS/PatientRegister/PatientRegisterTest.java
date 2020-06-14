package Tests.com.OpenMRS.PatientRegister;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Tests.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import  DataSource.PatientRegisterData;

import java.security.Key;
import java.util.List;

public class PatientRegisterTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeClass
    public void setUpPage(){
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        driver.manage().deleteAllCookies();
        registerPage=new RegisterPage(driver);
    }

    @Parameters({"username","password","locationname","applicationName"})
    @Test(priority = 1)
    public void validateHeaders(String username,String password,String locationname,String applicationname){
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://demo.openmrs.org/openmrs/login.htm");
        loginPage.login(username, password, locationname);
        homePage.clickApplication(applicationname);
        List<String> headers=registerPage.getHeaders();
        List<WebElement> actualHeaders=registerPage.headers;

        Assert.assertEquals(actualHeaders.size(),headers.size());

        for(int i=0;i<registerPage.getHeaders().size();i++){

            String expectedHeader=headers.get(i);
            String actualHeader=actualHeaders.get(i).getText();
                    Assert.assertEquals(actualHeader,expectedHeader);

        }

    }

    @Test(priority = 2, dependsOnMethods = "validateHeaders")
    public void validatePatientRegister(){
        registerPage.givenName.sendKeys("Jhon");
        registerPage.familyName.sendKeys("Wilson");
        registerPage.clickHeaders("Gender");

        Select select=new Select(registerPage.gender);
        select.selectByVisibleText("Male");
        registerPage.clickHeaders("Birthdate");

        registerPage.estimatedYears.sendKeys("22");
        registerPage.estimatedMonths.sendKeys("6");
        registerPage.clickHeaders("Address");

        registerPage.address1.sendKeys("2200 E Lincoln Ave");
        registerPage.cityVillage.sendKeys("Des Plaines");
        registerPage.stateProvince.sendKeys("IL");
        registerPage.country.sendKeys("USA");
        registerPage.zipCode.sendKeys("50332");
        registerPage.clickHeaders("Phone Number");

        registerPage.phoneNumber.sendKeys("2242013389");
        registerPage.clickHeaders("Relatives");

        registerPage.deleteRelation();

        Select select1=new Select(registerPage.relatives);
        select1.selectByVisibleText("Parent");
        registerPage.relativeType.sendKeys("Susan Adams");

        registerPage.clickHeaders("Confirm");

        List<WebElement> confrimationDetails=registerPage.confirmationInfo;
        Assert.assertEquals(confrimationDetails.get(0).getText(),"Name: Jhon, Wilson");
        Assert.assertEquals(confrimationDetails.get(1).getText(),"Gender: Male");
        Assert.assertEquals(confrimationDetails.get(2).getText(),"Birthdate: 22 year(s), 6 month(s)");
        Assert.assertEquals(confrimationDetails.get(3).getText(),"Address: 2200 E Lincoln Ave, Des Plaines, IL, USA, 50332");
        Assert.assertEquals(confrimationDetails.get(4).getText(),"Phone Number: 2242013389");
        Assert.assertEquals(confrimationDetails.get(5).getText(),"Relatives: Susan Adams - Parent");

        registerPage.submit.submit();

    }

    @Test(priority = 3,dataProvider = "registerData",dataProviderClass = PatientRegisterData.class)
    public void validateMultipleRegister(String name,String lastName,String gender,String year,String month,
                                         String addrees1,String city,String state,String country,
                                         String zipCode,String phone,String relationShipType,String personName){
        driver.manage().deleteAllCookies();

        registerPage.getHomeButton.click();
        homePage.clickApplication("Register a patient");
        registerPage.givenName.sendKeys(name);
        registerPage.familyName.sendKeys(lastName);
        registerPage.clickHeaders("Gender");

        Select select=new Select(registerPage.gender);
        select.selectByVisibleText(gender);
        registerPage.clickHeaders("Birthdate");

        registerPage.estimatedYears.sendKeys(year);
        registerPage.estimatedMonths.sendKeys(month);
        registerPage.clickHeaders("Address");

        registerPage.address1.sendKeys(addrees1);
        registerPage.cityVillage.sendKeys(city);
        registerPage.stateProvince.sendKeys(state);
        registerPage.country.sendKeys(country);
        registerPage.zipCode.sendKeys(zipCode);
        registerPage.clickHeaders("Phone Number");

        registerPage.phoneNumber.sendKeys(phone);
        registerPage.clickHeaders("Relatives");

        registerPage.deleteRelation();

        Select select1=new Select(registerPage.relatives);
        select1.selectByVisibleText(relationShipType);
        registerPage.relativeType.sendKeys(personName);

        registerPage.clickHeaders("Confirm");

        List<WebElement> confirmationDetails=registerPage.confirmationInfo;
        Assert.assertEquals(confirmationDetails.get(0).getText(),"Name: "+name+", "+lastName);
        Assert.assertEquals(confirmationDetails.get(1).getText(),"Gender: "+gender);
        Assert.assertEquals(confirmationDetails.get(2).getText(),"Birthdate: "+year+" year(s), "+month+" month(s)");
        Assert.assertEquals(confirmationDetails.get(3).getText(),"Address: "+addrees1+", "+city+", "+state+", "+country+", "+zipCode);
        Assert.assertEquals(confirmationDetails.get(4).getText(),"Phone Number: "+phone);
        Assert.assertEquals(confirmationDetails.get(5).getText(),"Relatives: "+personName+" - "+relationShipType);


        registerPage.submit.submit();


    }



}


//        Assert.assertEquals(confrimationDetails.get(0).getText(),"Name: "+name+", "+lastName  );
//        Assert.assertEquals(confrimationDetails.get(1).getText(),"Gender: "+gender);
//        Assert.assertEquals(confrimationDetails.get(2).getText(),"Birthdate: "+year+" year(s), "+month+" month(s)");
//        Assert.assertEquals(confrimationDetails.get(3).getText(),"Address: "+addrees1+", "+city+", "+state+", "+country+", "+", "+zipCode);
//        Assert.assertEquals(confrimationDetails.get(4).getText(),"Phone Number: "+phone);
//        Assert.assertEquals(confrimationDetails.get(5).getText(),"Relatives: "+personName+" - "+relationShipType);