package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.service.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.service.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.service.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.service.IPrinter;

public abstract class Printer implements IPrinter {

    protected ICustomerRental customerRental;

    protected ICalculatorAmountOwed calculatorAmountOwed;

    protected ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint;

    protected ICalculatorRentalCost calculatorRentalCost;

    @Override
    public void printCustomerRental(ICustomerRental customerRental) throws FunctionnalException {

    }

    @Override
    public void setCalculatorAmoutOwed(ICalculatorAmountOwed calculatorAmoutOwed) {
        this.calculatorAmountOwed = calculatorAmoutOwed;
    }

    @Override
    public void setCalculatorRentalCost(ICalculatorRentalCost calculatorRentalCost) {
        this.calculatorRentalCost = calculatorRentalCost;
    }

    @Override
    public void setCalculatorFrequentRenterPoint(ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint) {
        this.calculatorFrequentRenterPoint = calculatorFrequentRenterPoint;
    }
}
