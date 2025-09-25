package TestScript;

import org.testng.annotations.Test;




import Base.Basetest;
import pages.LoginPage;

public class TestLogin extends Basetest{

    @Test
    public void testValidLogin() throws InterruptedException {
    	
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("esf.admin.001@torrantal.asia", "111111111111Ab$");
        Thread.sleep(20000);

        System.out.println("✅ Browser opened and login attempted");
    }
}