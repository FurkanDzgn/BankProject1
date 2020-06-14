package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="username")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement password;

    // List<WebElement> locations=driver.findElements(By.xpath("//ul[@id='sessionLocation']//li"));
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    public List<WebElement> locations;

    @FindBy(id = "Pharmacy")
    public WebElement pharmacy;

    @FindBy(id="loginButton")
    public WebElement loginButton;

    @FindBy(id="error-message")
    public WebElement errorMessage;

    // get the data from excel file, csv, DB, Api Response, confluence page(Documentation page in the comany)
    public List<String> getLocations(){
        List<String> locations=new ArrayList<>();
        locations.add("Inpatient Ward");
        locations.add("Isolation Ward");
        locations.add("Laboratory");
        locations.add("Outpatient Clinic");
        locations.add("Pharmacy");
        locations.add("Registration Desk");

        return locations;
    }

    //login() --> username, password, locationName
    public void login(String username, String password, String locationName){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        clickLocation(locationName);
        this.loginButton.click();
    }

    public void clickLocation(String locationName){
        // Task
        // implement the step if the webelement value
        for (WebElement location:locations) {
            if(location.getText().equals(locationName)){
                location.click();
            }
        }
    }
}
