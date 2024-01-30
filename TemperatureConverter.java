import java.util.Scanner;

public class TemperatureConverter {
     
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Choose an option:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter temperature in Fahrenheit:");
            double fahrenheit = scanner.nextDouble();
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.println("Converted temperature in Celsius: " + celsius);
        } else if (choice == 2) {
            System.out.println("Enter temperature in Celsius:");
            double celsius = scanner.nextDouble();
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.println("Converted temperature in Fahrenheit: " + fahrenheit);
        } else {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }

    // Method to convert Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to convert Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
