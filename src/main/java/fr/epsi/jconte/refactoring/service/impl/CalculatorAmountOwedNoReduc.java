package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.service.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.service.ICalculatorRentalCost;

/**
 * This class provide methods to calculate the owed amount by the customer to the store, no reduction possible
 */
public class CalculatorAmountOwedNoReduc implements ICalculatorAmountOwed {

    private ICalculatorRentalCost calculatorRentalCost;

    public CalculatorAmountOwedNoReduc(ICalculatorRentalCost calculatorRentalCost) {
        this.calculatorRentalCost = calculatorRentalCost;
    }

    @Override
    public double getAmountOwed(ICustomerRental customerRental) throws FunctionnalException {
        double sum = 0;
        for (IRental rental : customerRental.getRentals()) {
            sum += calculatorRentalCost.calculateRentalCost(rental);
        }
        return sum;
    }
}
