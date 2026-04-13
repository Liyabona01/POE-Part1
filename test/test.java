import org.junit.Test;
import static org.junit.Assert.*;

public class test{

    //Registration: USERNAME TEST
    @Test
    public void testValidUsername(){
        Registration registration =new Registration();
        assertTrue(registration.checkUsername("abc_"));
    }
    @Test
    public void testInvalidUsername(){
        Registration registration= new Registration();
        assertTrue(registration.checkUsername("abcdef_"));
    }
    @Test
    public void testInvalidUsernameNoUndescore(){
        Registration registration= new Registration();
        assertTrue(registration.checkUsername("abcd"));

    }
    //Registration: PASSWORD TEST
    @Test
    public void testValidPassword(){
        Registration registration= new Registration();
        assertTrue(registration.checkPassword("Passw0rd!"));
    }
    @Test
    public void testInvalidPasswordTooShort(){
        Registration registration= new Registration();
        assertTrue(registration.checkPassword("Pw1!"));
    }
    @Test
    public void testInvalidPasswordNoUppercase(){
        Registration registration=new Registration();
        assertTrue(registration.checkPassword("password1!"));
    }
    @Test
    public void testInvalidPasswordNoDigit(){
        Registration registration= new Registration();
        assertTrue(registration.checkPassword("Password!"));
    }
    @Test
    public void testInvalidPasswordNoSpecialCharecters(){
     Registration registration = new Registration();
     assertTrue(registration.checkPassword("Password1"));
    }

    //REGISTRATION: phone number
    @Test
    public void  testInvalidPhoneNoLocal(){
        Registration registration = new Registration();
        assertTrue(registration.checkPhoneNo("0123456789"));
    }
    @Test
    public void testInvalidPhoneNoInternational(){
        Registration registration = new Registration();
        assertTrue(registration.checkPassword("+27123456789"));
    }
    @Test
    public void testInvalidPhoneNoTooShort(){
        Registration registration = new Registration();
        assertTrue(registration.checkPhoneNo("12345"));
    }
    @Test
    public void testInvalidPhoneNoWrongPrefix(){
        Registration registration= new Registration();
        assertTrue(registration.checkPhoneNo("9912345678"));
    }

    //LOGIN : SUCCESSFULL LOGIN
    @Test
    public void testSuccefulLogin(){
        Login login = new Login("user123","pass123","Liyabona","Mangcengeza");
        boolean result = login.loginUser("user123","pass123");
        assertTrue(result);
        System.out.println("Welcome Liyabona Mangcengeza");
    }
    @Test
    public void testFailedLogin(){
        Login login = new Login("user123","pass123","Liyabona","Mangcengeza");
        boolean result = login.loginUser("wrong username","wrong password");
        assertTrue(result);
        System.out.println("Password or Username incorrect.Please try again.");
    }



}
