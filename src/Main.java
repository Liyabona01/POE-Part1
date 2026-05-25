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

    boolean loggedIn = login.loginUser(loginUser, loginPass);

    System.out.println(login.returnLoginStatus(loggedIn));

    // ONLY allow QuickChat if login is successful
    if (loggedIn) {

        System.out.println("Welcome to QuickChat.");

        System.out.print("Enter number of messages you want to send: ");
        int numMessages = scanner.nextInt();
        scanner.nextLine();

        int messageCount = 0;

        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                if (messageCount >= numMessages) {
                    System.out.println("You have reached the message limit.");
                    continue;
                }

                System.out.print("Enter recipient number: ");
                String recipient = scanner.nextLine();

                System.out.print("Enter your message: ");
                String messageText = scanner.nextLine();

                Message message = new Message(
                        messageCount + 1,
                        recipient,
                        messageText
                );

                if (message.checkRecipientCell()) {
                    System.out.println("Cell phone number successfully captured.");
                } else {
                    System.out.println("Cell phone number is incorrectly formatted or does not contain an international code.");
                }

                System.out.println(message.checkMessageLength());

                if (message.checkRecipientCell()
                        && message.checkMessageLength().equals("Message ready to send.")) {

                    String result = message.sentMessage();

                    System.out.println(result);

                    if (result.equals("Message successfully sent.")) {
                        System.out.println(message.printMessages());
                    }

                    messageCount++;
                }

            } else if (choice == 2) {

                System.out.println("Coming Soon.");

            } else if (choice == 3) {

                System.out.println("Total messages sent: " + Message.returnTotalMessages());
                System.out.println("Goodbye.");
                break;

            } else {

                System.out.println("Invalid option.");
            }
        }

    } else {

        System.out.println("You cannot send messages because login failed.");
    }
}



