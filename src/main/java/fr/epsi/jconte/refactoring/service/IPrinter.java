package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;

public interface IPrinter {

    void printCustomerRental(ICustomerRental customerRental) throws FunctionnalException;

    void setCalculatorAmoutOwed(ICalculatorAmountOwed calculatorAmoutOwed);

    void setCalculatorRentalCost(ICalculatorRentalCost calculatorRentalCost);

    void setCalculatorFrequentRenterPoint(ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint);
}
