import java.util.Scanner;

public class RegistrationService {
    private final PaymentService paymentService = new PaymentService();
    private final TicketService ticketService = new TicketService();
    private final NotificationService notificationService = new NotificationService();
    private int nextBookingId = 1001;

    public void registerUser(Scanner scanner) {
        System.out.print("Enter event ID: ");
        int eventId = readInt(scanner);
        Event event = EventDatabase.findEventById(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Number of tickets: ");
        int quantity = readInt(scanner);

        if (name.isBlank() || email.isBlank() || quantity <= 0) {
            System.out.println("Please enter valid details.");
            return;
        }
        if (quantity > event.getAvailableSeats()) {
            System.out.println("Not enough seats. Available seats: " + event.getAvailableSeats());
            return;
        }

        double amount = event.getTicketPrice() * quantity;
        if (!paymentService.processPayment(amount, scanner)) {
            System.out.println("Payment failed. No booking was created.");
            return;
        }

        // Reserve seats only after the demo payment succeeds.
        if (!event.bookSeats(quantity)) {
            System.out.println("Sorry, those seats are no longer available.");
            return;
        }

        String ticketId = ticketService.generateTicketId();
        Registration registration = new Registration(nextBookingId++, name, email, eventId,
                quantity, amount, "SUCCESS", ticketId);
        EventDatabase.getRegistrations().add(registration);

        ticketService.displayTicket(registration, event);
        notificationService.sendConfirmation(email, name, event, ticketId);
    }

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
