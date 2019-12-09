package fr.epsi.jconte.refactoring.printer;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;

public interface IPrinter {

    String printCustomerRental(ICustomerRental customerRental) throws FunctionnalException;

    void setCalculatorAmoutOwed(ICalculatorAmountOwed calculatorAmoutOwed);

    void setCalculatorRentalCost(ICalculatorRentalCost calculatorRentalCost);

    void setCalculatorFrequentRenterPoint(ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint);
}
