package create_account;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateAccountTest extends BaseTest {
    @Test
    public void TestAccountCreation(){
        String username = "Eric";
        var account = homePage.goCreateAccount();
        account.fillOutUserData(username,"eric@gmail.com","123456");

        String successString = "Hello "+ username+ " (not "+ username+"?"+ " Log out)";
        assertEquals(account.successAccountCreation(),successString,"Registering failed");
    }
}
