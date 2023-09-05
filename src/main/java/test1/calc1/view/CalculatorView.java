package test1.calc1.view;

public class CalculatorView {

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the JavaMavenCalculator! \n");
        System.out.println("Instructions:");
        System.out.println("Enter operations in the format: [number] [operation] [number] (for binary operations)");
        System.out.println("Or [number] [operation] (for unary operations like squareRoot)");
        System.out.println("Supported operations: +, -, *, /, % (modulus), sqrt (squareRoot), abs (absolute), ln (natural log), ! (factorial)");
    }

    public void displayResult(double result) {
        System.out.println("Result: \n" + result);
    }

    public void displayError(String errorMessage) {
        System.out.println("Error: " + errorMessage);
    }

}
