package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IAmountOwed;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;

import java.util.Arrays;

public class AmountOwedNoReduc implements IAmountOwed {
    @Override
    public double getAmountOwed(ICustomerRental customerRental) {
        double sum = 0;
        for (IRental rental : customerRental.getRentals()) {
            sum += rental.amoutFor();
        }
        return sum;
    }
}
