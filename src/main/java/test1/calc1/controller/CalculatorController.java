package test1.calc1.controller;

import test1.calc1.model.CalculatorModel;
import test1.calc1.view.CalculatorView;

import java.util.Scanner;


public class CalculatorController {

    private CalculatorModel model;
    private CalculatorView view;

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
                double result = 0;

                if(parts.length == 3) {
                    double num2 = Double.parseDouble(parts[2]);
                    String operation = parts[1];

                    switch (operation) {
                        case "+":
                            result = model.add(num1, num2);
                            break;
                        case "-":
                            result = model.subtract(num1, num2);
                            break;
                        case "*":
                            result = model.multiply(num1, num2);
                            break;
                        case "/":
                            result = model.divide(num1, num2);
                            break;
                        case "%":
                            result = model.modulus(num1, num2);
                            break;
                        default:
                            System.out.println("Unsupported binary operation.");
                            continue;
                    }
                } else {
                    String operation = parts[1];


                    switch (operation) {
                        case "sqrt":
                            result = model.squareRoot(num1);
                            break;
                        case "abs":
                            result = model.absolute(num1);
                            break;
                        case "ln":
                            result = model.naturalLog(num1);
                            break;
                        case "!":
                            if(num1 > 20) {
                                System.out.println("Factorial might be too large for this value.");
                                continue;
                            }
                            result = model.factorial((int) num1);
                            break;
                        default:
                            System.out.println("Unsupported unary operation.");
                            continue;
                    }
                }

                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid numbers provided.");
            } catch (Exception e) {
                view.displayError(e.getMessage());
            }
        }


    }

}
