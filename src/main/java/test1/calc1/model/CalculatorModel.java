package test1.calc1.model;

public class CalculatorModel {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }

    public double modulus(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 % num2;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Square root of negative number is not allowed.");
        }
        return Math.sqrt(num);
    }

    public double absolute(double num) {
        return Math.abs(num);
    }

    public double naturalLog(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Logarithm of non-positive number is not allowed.");
        }
        return Math.log(num);
    }

    public double factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not allowed.");
        }
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

}
