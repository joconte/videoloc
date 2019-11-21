package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.service.*;

public class CustomerRentalService implements ICustomerRentalService {

    private ICalculatorRentalCost calculatorRentalCost;

    private ICalculatorAmountOwed calculatorAmountOwed;

    private ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint;

    private IPrinter printer;

    public CustomerRentalService(ICalculatorRentalCost calculatorRentalCost, ICalculatorAmountOwed calculatorAmountOwed, ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint, IPrinter printer) {
        this.calculatorRentalCost = calculatorRentalCost;
        this.calculatorAmountOwed = calculatorAmountOwed;
        this.calculatorFrequentRenterPoint = calculatorFrequentRenterPoint;
        this.setPrinter(printer);
    }

    @Override
    public void printCustomerRentalInformations(ICustomerRental customerRental) throws FunctionnalException {
        this.printer.printCustomerRental(customerRental);
    }

    public void setPrinter(IPrinter printer) {
        this.printer = printer;
        this.printer.setCalculatorAmoutOwed(this.calculatorAmountOwed);
        this.printer.setCalculatorFrequentRenterPoint(this.calculatorFrequentRenterPoint);
        this.printer.setCalculatorRentalCost(this.calculatorRentalCost);
    }
}
