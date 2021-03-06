package fr.epsi.jconte.refactoring.printer.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomer;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Provides methods to print in the console customer rentals, amount owed and the number of frequent renter points of a customer.
 */
public class PrinterConsole extends Printer{

    private Logger logger = Logger.getLogger(PrinterConsole.class);
    /**
     * Print in the console all the customer rentals, the total amount owed by the customer and his frequent renter points.
     */
    @Override
    public String printCustomerRental(ICustomerRental customerRental) throws FunctionnalException {
        StringBuilder stringBuilder = new StringBuilder();
        List<IRental> rentals = customerRental.getRentals();
        ICustomer customer = customerRental.getCustomer();

        stringBuilder.append("\n");
        stringBuilder.append("Rental Record for ");
        stringBuilder.append(customer.getName());
        stringBuilder.append("\n");

        for (IRental rental : rentals) {
            double thisAmount = calculatorRentalCost.calculateRentalCost(rental);

            // show figures for this rental
            stringBuilder.append("\t");
            stringBuilder.append(rental.getMovie().getTitle());
            stringBuilder.append("\t");
            stringBuilder.append(thisAmount);
            stringBuilder.append("\n");
        }

        // add footer lines
        stringBuilder.append("Amount owed is ");
        stringBuilder.append(calculatorAmountOwed.getAmountOwed(customerRental));
        stringBuilder.append("\n");

        stringBuilder.append("You earned ");
        stringBuilder.append(calculatorFrequentRenterPoint.getFrequentRenterPoint(customerRental));
        stringBuilder.append(" frequent renter points ");

        String toLog = stringBuilder.toString();
        logger.info(toLog);

        return toLog;
    }

    public PrinterConsole() {}

    public PrinterConsole(ICalculatorAmountOwed calculatorAmountOwed, ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint, ICalculatorRentalCost calculatorRentalCost) {
        super(calculatorAmountOwed, calculatorFrequentRenterPoint, calculatorRentalCost);
    }
}
