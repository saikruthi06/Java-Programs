public class NotificationService {
    public void sendConfirmation(String email, String userName, Event event, String ticketId) {
        // Demo only: prints a message instead of sending a real email/SMS.
        System.out.println("\n--- Notification (simulation) ---");
        System.out.println("To: " + email);
        System.out.println("Hello " + userName + ", your booking for \"" + event.getName()
                + "\" is confirmed.");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("---------------------------------\n");
    }
}
