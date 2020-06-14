package DataSource;

import org.testng.annotations.DataProvider;

public class LoginData2 {

    @DataProvider(name="OpenMrsLogin")
    public Object[][] getData2(){
        return new Object[][]{
                {"admin1","Admin123","Inpatient Ward"},
                {"admin","Admin1234","Isolation Ward"},
                {"Admin","admin1232","Laboratory"}
        };
    }
}
