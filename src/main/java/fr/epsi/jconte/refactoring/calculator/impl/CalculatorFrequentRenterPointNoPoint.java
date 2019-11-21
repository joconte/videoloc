package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.model.ICustomerRental;

public class CalculatorFrequentRenterPointNoPoint implements ICalculatorFrequentRenterPoint {
    @Override
    public int getFrequentRenterPoint(ICustomerRental customerRental) {
        return 0;
    }
}
