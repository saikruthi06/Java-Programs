public class Registration {
    private int id;
    private String userName;
    private String email;
    private int eventId;
    private int quantity;
    private double amount;
    private String paymentStatus;
    private String ticketId;

    public Registration(int id, String userName, String email, int eventId,
                        int quantity, double amount, String paymentStatus, String ticketId) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.eventId = eventId;
        this.quantity = quantity;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.ticketId = ticketId;
    }

    public int getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public int getEventId() { return eventId; }
    public int getQuantity() { return quantity; }
    public double getAmount() { return amount; }
    public String getPaymentStatus() { return paymentStatus; }
    public String getTicketId() { return ticketId; }

    @Override
    public String toString() {
        return "Booking ID: " + id + " | User: " + userName + " | Event ID: " + eventId
                + " | Tickets: " + quantity + " | Amount: Rs." + String.format("%.2f", amount)
                + " | Payment: " + paymentStatus + " | Ticket ID: " + ticketId;
    }
}
