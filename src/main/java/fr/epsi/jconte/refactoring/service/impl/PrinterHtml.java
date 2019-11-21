package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.*;
import fr.epsi.jconte.refactoring.service.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.service.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.service.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.service.IPrinter;

import java.util.List;

/**
 * Provides methods to print in HTML format the customer rentals, the amount owed by the customer and his frequent renter points.
 */
public class PrinterHtml extends Printer{

    /**
     * Print in HTML format all the customer rentals, the amount owed by the customer and his frequent renter points.
     */
    @Override
    public void printCustomerRental(ICustomerRental customerRental) throws FunctionnalException {
        List<IRental> rentals = customerRental.getRentals();
        ICustomer customer = customerRental.getCustomer();
        String htmlFirstBalise = "<html>";
        String htmlLastBalise = "</html>";
        String bodyFirstBalise = "<body>";
        String bodyLastBalise = "</body>";
        String headFirstBalise = "<head>";
        String headLastBalise = "</head>";

        String result = "";

        result += htmlFirstBalise + "\n";

        result += headFirstBalise + headLastBalise + "\n";

        result += bodyFirstBalise + "\n";

        result += " Rental Record for " + customer.getName() + "\n";

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
                + " frequent renter points " + "\n";

        result += bodyLastBalise + "\n";

        result += htmlLastBalise;
        System.out.println(result);
    }
}
