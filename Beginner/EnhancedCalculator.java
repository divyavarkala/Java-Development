package Beginner;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedCalculator {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("=== Welcome to Enhanced Console Calculator ===");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Functions");
            System.out.println("3. Unit Conversion");
            System.out.println("4. Exit");

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> basicArithmetic();
                case 2 -> scientificFunctions();
                case 3 -> unitConversion();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to safely get integer input
    public static int getIntInput(String prompt) {
        int num = -1;
        while (true) {
            try {
                System.out.print(prompt);
                num = sc.nextInt();
                sc.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return num;
    }

    // Method to safely get double input
    public static double getDoubleInput(String prompt) {
        double num = -1;
        while (true) {
            try {
                System.out.print(prompt);
                num = sc.nextDouble();
                sc.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // Clear invalid input
            }
        }
        return num;
    }

    // Basic Arithmetic Operations
    public static void basicArithmetic() {
        System.out.println("\n--- Basic Arithmetic ---");
        double num1 = getDoubleInput("Enter first number: ");
        double num2 = getDoubleInput("Enter second number: ");

        System.out.println("Choose operation: +, -, *, /");
        char op = sc.nextLine().charAt(0);
        double result;

        switch (op) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Error! Division by zero.");
                    return;
                }
                result = num1 / num2;
            }
            default -> {
                System.out.println("Invalid operation!");
                return;
            }
        }
        System.out.println("Result: " + result);
    }

    // Scientific Functions
    public static void scientificFunctions() {
        System.out.println("\n--- Scientific Functions ---");
        System.out.println("Choose function: sin, cos, tan, sqrt, pow");
        String func = sc.nextLine().toLowerCase();

        switch (func) {
            case "sin" -> {
                double angle = getDoubleInput("Enter angle in degrees: ");
                double result = Math.sin(Math.toRadians(angle));
                System.out.println("sin(" + angle + ") = " + result);
            }
            case "cos" -> {
                double angle = getDoubleInput("Enter angle in degrees: ");
                double result = Math.cos(Math.toRadians(angle));
                System.out.println("cos(" + angle + ") = " + result);
            }
            case "tan" -> {
                double angle = getDoubleInput("Enter angle in degrees: ");
                double result = Math.tan(Math.toRadians(angle));
                System.out.println("tan(" + angle + ") = " + result);
            }
            case "sqrt" -> {
                double num = getDoubleInput("Enter number: ");
                if (num < 0) {
                    System.out.println("Error! Negative number.");
                    return;
                }
                double result = Math.sqrt(num);
                System.out.println("sqrt(" + num + ") = " + result);
            }
            case "pow" -> {
                double base = getDoubleInput("Enter base: ");
                double exp = getDoubleInput("Enter exponent: ");
                double result = Math.pow(base, exp);
                System.out.println(base + " ^ " + exp + " = " + result);
            }
            default -> System.out.println("Invalid function!");
        }
    }

    // Unit Conversion
    public static void unitConversion() {
        System.out.println("\n--- Unit Conversion ---");
        System.out.println("1. Temperature (Celsius <-> Fahrenheit)");
        System.out.println("2. Currency (USD <-> INR)");

        int choice = getIntInput("Choose conversion type: ");

        switch (choice) {
            case 1 -> {
                double celsius = getDoubleInput("Enter temperature in Celsius: ");
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.println(celsius + "°C = " + fahrenheit + "°F");
            }
            case 2 -> {
           // --- Currency Conversion ---
System.out.print("Enter amount in USD: ");
double usd = sc.nextDouble();
double inr = usd * 83.5; // fixed conversion rate
System.out.println(usd + " USD = " + inr + " INR");

            }
            default -> System.out.println("Invalid choice!");
        }
    }
}
