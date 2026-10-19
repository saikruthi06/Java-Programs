public class EventService {
    public boolean addEvent(int id, String name, String date, String venue,
                            double price, int totalSeats) {
        if (id <= 0 || name.isBlank() || date.isBlank() || venue.isBlank()
                || price < 0 || totalSeats <= 0 || EventDatabase.findEventById(id) != null) {
            return false;
        }
        EventDatabase.getEvents().add(new Event(id, name, date, venue, price, totalSeats));
        return true;
    }

    public boolean updateEvent(int id, String name, String date, String venue,
                               double price, int totalSeats) {
        Event event = EventDatabase.findEventById(id);
        if (event == null || name.isBlank() || date.isBlank() || venue.isBlank()
                || price < 0 || totalSeats < event.getBookedSeats()) {
            return false;
        }
        event.updateDetails(name, date, venue, price, totalSeats);
        return true;
    }

    public void displayAllEvents() {
        if (EventDatabase.getEvents().isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        for (Event event : EventDatabase.getEvents()) System.out.println(event);
    }
}
