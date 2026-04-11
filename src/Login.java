import java.util.Scanner;

public class Login {
    //DECLARATION
    String storedUsername;
    String storedPassword;
    String fistName;
    String lastName;

    public Login(String username, String password, String fistName, String lastName){
        this.storedUsername = username;
        this.storedPassword = password;
        this.fistName = fistName;
        this.lastName = lastName;
    }

    // Boolean check
public boolean loginUser(String username,String password){
        return username.equals(storedUsername)&&password.equals(storedPassword);
}

    // Return message
   public String returnLoginStatus(boolean status){
        if (status){
            return "Welcome " + fistName + ", " + lastName + " it is great to see you again.";
        }else {
            return "Username or password incorrect, please try again.";
        }
   }
    // Process login
   public void loginProcess(){
       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter username:");
       String inputUsername = scanner.nextLine();

       System.out.println("Enter password:");
       String inputPassword = scanner.nextLine();

       boolean result = loginUser(inputUsername, inputPassword);

       System.out.println(returnLoginStatus(result));
   }
}
