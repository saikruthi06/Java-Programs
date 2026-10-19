import java.util.ArrayList;
import java.util.List;

public class EventDatabase {
    // In-memory storage: data is lost when the program stops.
    private static final List<Event> events = new ArrayList<>();
    private static final List<Registration> registrations = new ArrayList<>();

    public static List<Event> getEvents() { return events; }
    public static List<Registration> getRegistrations() { return registrations; }

    public static Event findEventById(int id) {
        for (Event event : events) {
            if (event.getId() == id) return event;
        }
        return null;
    }

    public static Registration findRegistrationById(int id) {
        for (Registration registration : registrations) {
            if (registration.getId() == id) return registration;
        }
        return null;
    }
}
