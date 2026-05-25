import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Message {


    //variebles for message details
    String messageID;
    int messageNumber;
    String recipient;
    String message;
    String messageHash;

    //variebles for the total number of messages sent and to store all messages
    private static int totalMessagesSent = 0;
    private static String allMessages = "";

    // Constructor to store message information
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Method to generate a random 10-digit message ID
    private String generateMessageID() {

        Random random = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {
            id += random.nextInt(10);
        }
        return id;

    }

    // Method to check if message ID is valid
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Method to check if recipient cell number is valid
    public boolean checkRecipientCell() {

        return recipient.matches("\\+27[0-9]{9}");

    }

    // Method to check message length
    public String checkMessageLength() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by " + extraCharacters + ", please reduce size.";
        }

    }

    // Method to create message hash
    public String createMessageHash() {

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0];
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();

        return (messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();

    }

    // Method to handle sent messages
    public String sentMessage() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message");

        int choice = scanner.nextInt();

        if (choice == 1) {

            totalMessagesSent++;
            allMessages += printMessages() + "\n\n";

            return "Message successfully sent.";

        } else if (choice == 2) {
            return "Message disregarded.";
        } else if (choice == 3) {

            storeMessage();

            return "Message successfully stored.";
        } else {

            return "Invalid option.";

        }
    }

    // Method used for unit testing send, disregard, and store choices
    public String sentMessageChoice(int choice) {

        if (choice == 1) {
            totalMessagesSent++;
            allMessages += printMessages() + "\n\n";
            return "Message successfully sent.";

        } else if (choice == 2) {
            return "Press 0 to delete the message.";

        } else if (choice == 3) {
            storeMessage();
            return "Message successfully stored.";

        } else {
            return "Invalid option.";
        }


    }


    // Method to display message details
    public String printMessages() {

        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;

    }

    // Method to store message in a JSON file
    public void storeMessage() {

        try {
            FileWriter writer = new FileWriter("messages.json", true);

            writer.write("{\n");
            writer.write("  \"messageID\": \"" + messageID + "\",\n");
            writer.write("  \"messageHash\": \"" + messageHash + "\",\n");
            writer.write("  \"recipient\": \"" + recipient + "\",\n");
            writer.write("  \"message\": \"" + message + "\"\n");
            writer.write("},\n");

            writer.close();

            System.out.println("Message stored in JSON file.");

        } catch (IOException e) {
            System.out.println("An error occurred while storing the message.");
        }
    }

    // Method to return the total number of sent messages
    public static int returnTotalMessages() {

        return totalMessagesSent;

    }
}

