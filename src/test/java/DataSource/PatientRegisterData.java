package DataSource;

import org.testng.annotations.DataProvider;

public class PatientRegisterData {

    @DataProvider(name="registerData")
    public Object[][] getRegisterData(){

        return new Object[][]{
                {"Jackson","Jack","Male","21","3","223 dd ave","Des","IL","US","56789","3345568877","Parent","Mark Lewis"},
                {"John","Der","Male","33","5","223 dd ave","CHI","IL","US","60000","3345568877","Sibling","Mark Miller"},
                {"Jessica","King","Female","26","8","111 dd","Los Angeles","CA","US","60668","3345568877","Supervisor","Betty Martinez"},
                {"Jessica","King","Female","26","8","111 dd","Los Angeles","CA","US","56789","3345568877","Parent","Mark Lewis"}

        };

//        {"Jackson","Jack","Male","25","3","223 dd ave","Des","IL","US","53543","2131243143","Parent","Mark Lewis"},
//        {"John","Deer","Male","27","2","farwr;ds,fdsf","MOuntPros","Il","US","21312","4324325235","Sibling","Mark Miller"},
//        {"Jessica","King","Female","27","2","farwr;ds,fdsf","MOuntPros","CA","US","232322","4324325232","Supervisor","Betty Martinez"},
//        {"Melissa","Lee","Female","24","2","farwr;ds,fdsf","San Diego","Il","US","21312","43243250000","Child","Daniel Thomas"},
    }
}
