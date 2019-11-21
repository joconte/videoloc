package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.service.ICalculatorFrequentRenterPoint;

public class CalculatorFrequentRenterPointNoPoint implements ICalculatorFrequentRenterPoint {
    @Override
    public int getFrequentRenterPoint(ICustomerRental customerRental) {
        return 0;
    }
}
