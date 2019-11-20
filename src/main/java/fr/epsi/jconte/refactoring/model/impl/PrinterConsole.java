package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.*;

import java.util.Enumeration;
import java.util.List;

public class PrinterConsole implements IPrinter {

    private ICustomerRental customerRental;

    private IAmountOwed amountOwed;

    private IFrequentRenterPoint frequentRenterPoint;

    public PrinterConsole(ICustomerRental customerRental, IAmountOwed amountOwed, IFrequentRenterPoint frequentRenterPoint) {
        this.customerRental = customerRental;
        this.amountOwed = amountOwed;
        this.frequentRenterPoint = frequentRenterPoint;
    }

    @Override
    public void printCustomerRental() {
        List<IRental> rentals = customerRental.getRentals();
        ICustomer customer = customerRental.getCustomer();
        String result = "Rental Record for " + customer.getName() + "\n";

        for (IRental rental : rentals) {
            double thisAmount = rental.amoutFor();

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle()
                    + "\t" + String.valueOf(thisAmount) + "\n";
        }

// add footer lines
        result += "Amount owed is "
                + String.valueOf(amountOwed.getAmountOwed(customerRental))
                + "\n";

        result += "You earned "
                + String.valueOf(frequentRenterPoint.getFrequentRenterPoint(customerRental))
                + " frequent renter points ";
        System.out.println(result);
    }
}
