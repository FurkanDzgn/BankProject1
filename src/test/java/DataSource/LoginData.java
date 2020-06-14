package DataSource;

import org.testng.annotations.DataProvider;

public class LoginData {

    // I am using DataProvider Annotation in my framework.
    // It will help me to run same test case with different set of data
    @DataProvider(name="OpenMrsLocations")
    public Object[][] getData(){

        return new Object[][]{
          //      {"admin","Admin123","Inpatient Ward"},
                {"Inpatient Ward"},
                {"Isolation Ward"},
                {"Laboratory"},
                {"Outpatient Clinic"},
                {"Pharmacy"},
                {"Registration Desk"}

        };
    }
}
