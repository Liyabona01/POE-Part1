import java.util.Scanner;

public class Registration {


    public String UserName;
    public String Password;
    public String PhoneNo;
    public String FirstName;
    public String LastName;
    // Username check
    public Boolean checkUsername(String Username) {
        return Username.contains("_") && Username.length() <= 5;
    }

    // Password check
    public Boolean checkPassword(String Password) {
        return Password.length() >= 8 &&
                Password.matches(".*[A-Z].*") &&
                Password.matches(".*[0-9].*") &&
                Password.matches(".*[@#$%^&*()].*");

    }

    // Phone check
    public Boolean checkPhoneNo(String PhoneNo) {
        return PhoneNo.matches("(\\+27)[0-9]{9}");


    }

    // Register user
    public void Register() {
        Scanner scanner = new Scanner(System.in);

        // USERNAME
        do {
            System.out.println("Enter username");
            UserName = scanner.nextLine();

            if (!checkUsername(UserName)) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        } while (!checkUsername(UserName));
        System.out.println("Username successfully captured.");


        // PASSWORD
        do {
            System.out.println("Enter password");
            Password = scanner.nextLine();

            if (!checkPassword(Password)) {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        } while (!checkPassword(Password));
        System.out.println("Password successfully captured.");


        // PHONE NUMBER
        do {
            System.out.println("Enter cell phone number (+27):");
            PhoneNo = scanner.nextLine();

            if (!checkPhoneNo(PhoneNo)) {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.");
            }
        } while (!checkPhoneNo(PhoneNo));
        System.out.println("Cell phone number successfully captured.");

        //CALL LOGIN HERE
        Login login = new Login(UserName, Password, "Liyabona", "Mangcengeza");
        login.loginProcess();

    }
}




