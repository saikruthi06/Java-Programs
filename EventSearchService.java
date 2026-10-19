import java.util.ArrayList;
import java.util.List;

public class EventSearchService {
    public List<Event> searchByName(String keyword) {
        List<Event> results = new ArrayList<>();
        for (Event event : EventDatabase.getEvents()) {
            if (event.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(event);
            }
        }
        return results;
    }

    public void displaySearchResults(String keyword) {
        List<Event> results = searchByName(keyword);
        if (results.isEmpty()) {
            System.out.println("No matching events found.");
        } else {
            for (Event event : results) System.out.println(event);
        }
    }
}
