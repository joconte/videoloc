package fr.epsi.jconte.refactoring.printer.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.printer.IPrinter;

public abstract class Printer implements IPrinter {

    protected ICalculatorAmountOwed calculatorAmountOwed;

    protected ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint;

    protected ICalculatorRentalCost calculatorRentalCost;

    public Printer(){}

    public Printer(ICalculatorAmountOwed calculatorAmountOwed, ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint, ICalculatorRentalCost calculatorRentalCost) {
        this.calculatorAmountOwed = calculatorAmountOwed;
        this.calculatorFrequentRenterPoint = calculatorFrequentRenterPoint;
        this.calculatorRentalCost = calculatorRentalCost;
    }

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
