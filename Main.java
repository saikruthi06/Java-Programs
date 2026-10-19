import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();
        EventSearchService searchService = new EventSearchService();
        RegistrationService registrationService = new RegistrationService();
        OrganizerService organizerService = new OrganizerService();

        // Sample events to make the project easy to test.
        eventService.addEvent(1, "Tech Fest", "2026-11-15", "College Auditorium", 250.00, 100);
        eventService.addEvent(2, "Music Night", "2026-12-05", "City Convention Hall", 500.00, 200);
        eventService.addEvent(3, "Career Workshop", "2026-11-22", "Seminar Hall", 100.00, 60);

        int choice;
        do {
            System.out.println("\n===== EVENT MANAGEMENT SYSTEM =====");
            System.out.println("1. View all events");
            System.out.println("2. Search events");
            System.out.println("3. Register for an event / Buy tickets");
            System.out.println("4. Add event (organizer)");
            System.out.println("5. Update event (organizer)");
            System.out.println("6. View all registrations");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a number: ");
                scanner.nextLine();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    eventService.displayAllEvents();
                    break;
                case 2:
                    System.out.print("Enter event name or keyword: ");
                    searchService.displaySearchResults(scanner.nextLine().trim());
                    break;
                case 3:
                    registrationService.registerUser(scanner);
                    break;
                case 4:
                    organizerService.addEvent(scanner);
                    break;
                case 5:
                    organizerService.updateEvent(scanner);
                    break;
                case 6:
                    if (EventDatabase.getRegistrations().isEmpty()) {
                        System.out.println("No registrations yet.");
                    } else {
                        for (Registration registration : EventDatabase.getRegistrations()) {
                            System.out.println(registration);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using Event Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
