import java.util.Scanner;

public class PaymentService {
    // Demo only: this does NOT charge real money.
    public boolean processPayment(double amount, Scanner scanner) {
        System.out.printf("Total amount: Rs.%.2f%n", amount);
        System.out.print("Choose payment method (1=UPI, 2=Card): ");
        int method = readInt(scanner);

        if (method != 1 && method != 2) {
            System.out.println("Invalid payment method.");
            return false;
        }

        System.out.println("Demo payment: type Y to simulate successful payment, or N to fail.");
        System.out.print("Payment successful? (Y/N): ");
        String result = scanner.nextLine().trim();
        return result.equalsIgnoreCase("Y");
    }

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
