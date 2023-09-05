package test1.calc1;

import test1.calc1.controller.CalculatorController;
import test1.calc1.model.CalculatorModel;
import test1.calc1.view.CalculatorView;

public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);
        controller.startCalculator();

    }
}