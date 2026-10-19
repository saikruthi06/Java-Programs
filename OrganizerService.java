import java.util.Scanner;

public class OrganizerService {
    private final EventService eventService = new EventService();

    public void addEvent(Scanner scanner) {
        System.out.print("Event ID (number): ");
        int id = readInt(scanner);
        System.out.print("Event name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Date (e.g. 2026-11-25): ");
        String date = scanner.nextLine().trim();
        System.out.print("Venue: ");
        String venue = scanner.nextLine().trim();
        System.out.print("Ticket price: ");
        double price = readDouble(scanner);
        System.out.print("Total seats: ");
        int seats = readInt(scanner);

        if (eventService.addEvent(id, name, date, venue, price, seats)) {
            System.out.println("Event added successfully.");
        } else {
            System.out.println("Could not add event. Check the values and ensure the ID is unique.");
        }
    }

    public void updateEvent(Scanner scanner) {
        System.out.print("Event ID to update: ");
        int id = readInt(scanner);
        System.out.print("New event name: ");
        String name = scanner.nextLine().trim();
        System.out.print("New date: ");
        String date = scanner.nextLine().trim();
        System.out.print("New venue: ");
        String venue = scanner.nextLine().trim();
        System.out.print("New ticket price: ");
        double price = readDouble(scanner);
        System.out.print("New total seats: ");
        int seats = readInt(scanner);

        if (eventService.updateEvent(id, name, date, venue, price, seats)) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Update failed. Check the event ID and values.");
        }
    }

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a whole number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a valid amount: ");
            scanner.nextLine();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
