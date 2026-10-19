import java.util.UUID;

public class TicketService {
    public String generateTicketId() {
        return "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void displayTicket(Registration registration, Event event) {
        System.out.println("\n========== BOOKING CONFIRMATION ==========");
        System.out.println("Booking ID : " + registration.getId());
        System.out.println("Ticket ID  : " + registration.getTicketId());
        System.out.println("Name       : " + registration.getUserName());
        System.out.println("Event      : " + event.getName());
        System.out.println("Date       : " + event.getDate());
        System.out.println("Venue      : " + event.getVenue());
        System.out.println("Tickets    : " + registration.getQuantity());
        System.out.printf("Paid       : Rs.%.2f%n", registration.getAmount());
        System.out.println("Status     : " + registration.getPaymentStatus());
        System.out.println("==========================================\n");
    }
}
