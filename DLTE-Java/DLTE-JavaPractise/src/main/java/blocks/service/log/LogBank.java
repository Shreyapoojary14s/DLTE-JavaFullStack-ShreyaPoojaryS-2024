package blocks.service.log;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LogBank {
    private static final Logger logger = Logger.getLogger(LogBank.class.getName());
        private static double balance = 0;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            logger.log(Level.INFO, "Welcome to the Bank!");

            while (true) {
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        deposit(scanner);
                        break;
                    case 2:
                        withdraw(scanner);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        logger.log(Level.INFO, "Thank you for using our bank services!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void deposit(Scanner scanner) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            balance += amount;
            logger.log(Level.INFO, "Deposited: $" + amount + ", New Balance: $" + balance);
        }

        private static void withdraw(Scanner scanner) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (amount > balance) {
                logger.log(Level.WARNING, "Insufficient funds!");
                System.out.println("Insufficient funds!");
            } else {
                balance -= amount;
                logger.log(Level.INFO, "Withdrawn: $" + amount + ", New Balance: $" + balance);
            }
        }

        private static void checkBalance() {
            logger.log(Level.INFO, "Current Balance: $" + balance);
            System.out.println("Current Balance: $" + balance);
        }
    }


