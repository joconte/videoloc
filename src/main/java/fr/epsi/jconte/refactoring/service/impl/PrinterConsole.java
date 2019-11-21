package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomer;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;

import java.util.List;

/**
 * Provides methods to print in the console customer rentals, amount owed and the number of frequent renter points of a customer.
 */
public class PrinterConsole extends Printer{

    /**
     * Print in the console all the customer rentals, the total amount owed by the customer and his frequent renter points.
     */
    @Override
    public void printCustomerRental(ICustomerRental customerRental) throws FunctionnalException {
        List<IRental> rentals = customerRental.getRentals();
        ICustomer customer = customerRental.getCustomer();
        String result = "Rental Record for " + customer.getName() + "\n";

        for (IRental rental : rentals) {
            double thisAmount = calculatorRentalCost.calculateRentalCost(rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle()
                    + "\t" + String.valueOf(thisAmount) + "\n";
        }

// add footer lines
        result += "Amount owed is "
                + String.valueOf(calculatorAmountOwed.getAmountOwed(customerRental))
                + "\n";

        result += "You earned "
                + String.valueOf(calculatorFrequentRenterPoint.getFrequentRenterPoint(customerRental))
                + " frequent renter points ";
        System.out.println(result);
    }
}
