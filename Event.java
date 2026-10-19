public class Event {
    private int id;
    private String name;
    private String date;
    private String venue;
    private double ticketPrice;
    private int totalSeats;
    private int bookedSeats;

    public Event(int id, String name, String date, String venue, double ticketPrice, int totalSeats) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getVenue() { return venue; }
    public double getTicketPrice() { return ticketPrice; }
    public int getTotalSeats() { return totalSeats; }
    public int getBookedSeats() { return bookedSeats; }
    public int getAvailableSeats() { return totalSeats - bookedSeats; }

    public void updateDetails(String name, String date, String venue, double ticketPrice, int totalSeats) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        if (totalSeats >= bookedSeats) {
            this.totalSeats = totalSeats;
        }
    }

    public boolean bookSeats(int quantity) {
        if (quantity > 0 && quantity <= getAvailableSeats()) {
            bookedSeats += quantity;
            return true;
        }
        return false;
    }

    public void cancelSeats(int quantity) {
        if (quantity > 0 && quantity <= bookedSeats) {
            bookedSeats -= quantity;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Date: " + date + " | Venue: " + venue
                + " | Price: Rs." + String.format("%.2f", ticketPrice)
                + " | Seats available: " + getAvailableSeats() + "/" + totalSeats;
    }
}
