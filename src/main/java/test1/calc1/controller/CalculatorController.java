package test1.calc1.controller;

import test1.calc1.model.CalculatorModel;
import test1.calc1.view.CalculatorView;

import java.util.Scanner;


public class CalculatorController {

    private final CalculatorModel model;
    private final CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void startCalculator() {
        view.displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter calculation (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if("exit".equalsIgnoreCase(input)) {
                System.out.println("We hope to see you soon!");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3 && parts.length != 2) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                double result;

                if(parts.length == 3) {
                    double num2 = Double.parseDouble(parts[2]);
                    String operation = parts[1];

                    result = switch (operation) {
                        case "+" -> model.add(num1, num2);
                        case "-" -> model.subtract(num1, num2);
                        case "*" -> model.multiply(num1, num2);
                        case "/" -> model.divide(num1, num2);
                        case "%" -> model.modulus(num1, num2);
                        case "^" -> model.power(num1, num2);
                        default -> Double.NaN;  // Sentinel value
                    };

                    if (Double.isNaN(result)) {
                        System.out.println("Unsupported binary operation.");
                        continue;
                    }

                } else {
                    String operation = parts[1];

                    result = switch (operation) {
                        case "sqrt" -> model.squareRoot(num1);
                        case "abs" -> model.absolute(num1);
                        case "ln" -> model.naturalLog(num1);
                        case "!" -> {
                            if(num1 > 20) {
                                System.out.println("Factorial might be too large for this value.");
                                yield Double.NaN;  // Sentinel value
                            }
                            yield model.factorial((int) num1);
                        }
                        default -> Double.NaN;  // Sentinel value
                    };

                    if (Double.isNaN(result)) {
                        System.out.println("Unsupported unary operation.");
                        continue;
                    }
                }

                view.displayResult(result);

            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers provided.");
            } catch (Exception e) {
                view.displayError(e.getMessage());
            }
        }
    }


}
