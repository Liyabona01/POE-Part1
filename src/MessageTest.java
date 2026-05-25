import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    // Test if the message is less than 250 characters
    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals("Message ready to send.", msg.checkMessageLength());
    }

    // Test if the message is more than 250 characters
    @Test
    public void testMessageTooLong() {
        String longMessage = "a".repeat(260);

        Message msg = new Message(1, "+27718693002", longMessage);

        assertTrue(msg.checkMessageLength()
                .contains("Message exceeds 250 characters"));
    }

    // Test if recipient number is correctly formatted
    @Test
    public void testRecipientNumberSuccess() {
        Message msg = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertTrue(msg.checkRecipientCell());
    }

    // Test if recipient number is incorrectly formatted
    @Test
    public void testRecipientNumberFailure() {
        Message msg = new Message(1, "08575975889",
                "Hi Keegan, did you receive the payment?");

        assertFalse(msg.checkRecipientCell());
    }

    // Test if message ID is created and not more than 10 characters
    @Test
    public void testMessageIDCreated() {
        Message msg = new Message(1, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertTrue(msg.checkMessageID());
    }

    // Test if message hash is created correctly
    @Test
    public void testMessageHash() {
        Message msg = new Message(0, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertTrue(msg.createMessageHash().contains(":0:HITONIGHT"));
    }

    // Test option 1: Send Message
    @Test
    public void testSendMessage() {
        Message msg = new Message(1, "+27718693002", "Hello");

        String result = msg.sentMessageChoice(1);

        assertEquals("Message successfully sent.", result);
    }

    // Test option 2: Disregard Message
    @Test
    public void testDisregardMessage() {
        Message msg = new Message(1, "+27718693002", "Hello");

        String result = msg.sentMessageChoice(2);

        assertEquals("Press 0 to delete the message.", result);
    }

    // Test option 3: Store Message
    @Test
    public void testStoreMessage() {
        Message msg = new Message(1, "+27718693002", "Hello");

        String result = msg.sentMessageChoice(3);

        assertEquals("Message successfully stored.", result);
    }

    // Test invalid send option
    @Test
    public void testInvalidSendOption() {
        Message msg = new Message(1, "+27718693002", "Hello");

        String result = msg.sentMessageChoice(5);

        assertEquals("Invalid option.", result);
    }
}
