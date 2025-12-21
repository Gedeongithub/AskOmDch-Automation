package login;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){
        var login = homePage.goLogin();
        login.fillCredentials();
        String greetingMessage = "Hello Gedeon (not Gedeon? Log out)";
        assertEquals(login.successLogin(),greetingMessage,"Didn't log in");
    }
}
