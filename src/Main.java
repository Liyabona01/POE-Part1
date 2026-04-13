//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Register user
Registration registration = new Registration();
registration.Register();


Scanner scanner = new Scanner(System.in);
System.out.println("Please log in now.");
System.out.println("Enter Username: ");
String loginUser = scanner.nextLine();
System.out.println("Enter Password: ");
String loginPass = scanner.nextLine();

Login login = new Login(registration.UserName,registration.Password,registration.FirstName,registration.LastName);
System.out.println(login.loginUser(loginUser,loginPass));



}
