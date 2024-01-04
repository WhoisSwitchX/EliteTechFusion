import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates;

    public static void main(String[] args) {
        initializeExchangeRates();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        while (true) {
            displayCurrencies();
            System.out.println("Enter the code of the currency you want to convert from (e.g., USD):");
            String fromCurrencyCode = scanner.nextLine().toUpperCase();

            if (!isValidCurrency(fromCurrencyCode)) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            System.out.println("Enter the amount:");
            double amount = scanner.nextDouble();

            System.out.println("Enter the code of the currency you want to convert to (e.g., EUR):");
            String toCurrencyCode = scanner.next().toUpperCase();

            if (!isValidCurrency(toCurrencyCode)) {
                System.out.println("Invalid currency code. Please try again.");
                continue;
            }

            double convertedAmount = convertCurrency(amount, fromCurrencyCode, toCurrencyCode);
            System.out.println(String.format("%.2f %s is equal to %.2f %s", amount, fromCurrencyCode, convertedAmount, toCurrencyCode));

            System.out.println("Do you want to perform another conversion? (yes/no)");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Thank you for using the Currency Converter. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void initializeExchangeRates() {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.84);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("JPY", 113.67);
        // Add more exchange rates as needed
    }

    private static void displayCurrencies() {
        System.out.println("Supported currencies:");
        for (String currencyCode : exchangeRates.keySet()) {
            System.out.print(currencyCode + " ");
        }
        System.out.println();
    }

    private static boolean isValidCurrency(String currencyCode) {
        return exchangeRates.containsKey(currencyCode);
    }

    private static double convertCurrency(double amount, String fromCurrencyCode, String toCurrencyCode) {
        double fromRate = exchangeRates.get(fromCurrencyCode);
        double toRate = exchangeRates.get(toCurrencyCode);

        return amount * (toRate / fromRate);
    }
}
