import java.util.Scanner;

 
// Calculator interface
interface Calculator {
    double add(double num1, double num2);
    double subtract(double num1, double num2);
    double multiply(double num1, double num2);
    double divide(double num1, double num2);
}

// Calculator implementation
class CalculatorImpl implements Calculator {
    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return Double.NaN; // Not a Number
        }
        return num1 / num2;
    }
}

// Main class for running the calculator
public class BasicCalculator {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        double num1 = 10.0;
        double num2 = 5.0;

        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));
        System.out.println("Division: " + calculator.divide(num1, num2));
    }
}
