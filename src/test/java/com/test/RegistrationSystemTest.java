import com.Login.RegistrationSystem;
import static org.junit.Assert.*;
import org.junit.*;

public class RegistrationSystemTest {

    @Test
    public void testCheckUserNameValid() {
        assertTrue(RegistrationSystem.checkUserName("test_"));
    }

    @Test
    public void testCheckUserNameInvalid() {
        assertFalse(RegistrationSystem.checkUserName("kyLI"));
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        assertTrue(RegistrationSystem.checkPasswordComplexity("Ch&i&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        assertFalse(RegistrationSystem.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegisterUserSuccess() {
        String username = "test_user";
        String password = "Test@123";
        String firstName = "John";
        String lastName = "Doe";

        RegistrationSystem.registerUser();
        //assertTrue(RegistrationSystem.users.containsKey(username));
    }

    @Test
    public void testRegisterUserFailure() {
        String username = "invalid_username";
        String password = "Test@123";
        String firstName = "John";
        String lastName = "Doe";

      
        //assertEquals("Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.", status);
    }

    @Test
    public void testLoginUserSuccess() {
        String username = "test_user";
        String password = "Test@123";
        String firstName = "John";
        String lastName = "Doe";
        RegistrationSystem.registerUser();


    }

    @Test
    public void testLoginUserFailure() {
        String username = "test_user";
        String password = "WrongPassword";
    }
}
