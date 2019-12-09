package fr.epsi.jconte.refactoring.printer.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.*;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Provides methods to print in HTML format the customer rentals, the amount owed by the customer and his frequent renter points.
 */
public class PrinterHtml extends Printer{

    private Logger logger = Logger.getLogger(PrinterHtml.class);
    /**
     * Print in HTML format all the customer rentals, the amount owed by the customer and his frequent renter points.
     */
    @Override
    public void printCustomerRental(ICustomerRental customerRental) throws FunctionnalException {
        StringBuilder stringBuilder = new StringBuilder();
        List<IRental> rentals = customerRental.getRentals();
        ICustomer customer = customerRental.getCustomer();
        String htmlFirstBalise = "<html>";
        String htmlLastBalise = "</html>";
        String bodyFirstBalise = "<body>";
        String bodyLastBalise = "</body>";
        String headFirstBalise = "<head>";
        String headLastBalise = "</head>";
        String h1FirstBalise = "<h1>";
        String h1LastBalise = "</h1>";
        String pFirstBalise = "<p>";
        String pLastBalise = "</p>";
        String ulFirstBalise = "<ul>";
        String ulLastBalise = "</ul>";
        String liFirstBalise = "<li>";
        String liLastBalise = "</li>";

        stringBuilder.append("\n");
        stringBuilder.append(htmlFirstBalise);
        stringBuilder.append("\n");
        stringBuilder.append(headFirstBalise);
        stringBuilder.append(headLastBalise);
        stringBuilder.append("\n");
        stringBuilder.append(bodyFirstBalise);
        stringBuilder.append("\n");
        stringBuilder.append(h1FirstBalise);
        stringBuilder.append(" Rental record for ");
        stringBuilder.append(customer.getName());
        stringBuilder.append(h1LastBalise);
        stringBuilder.append("\n");

        stringBuilder.append(ulFirstBalise);
        stringBuilder.append("\n");
        for (IRental rental : rentals) {
            double thisAmount = calculatorRentalCost.calculateRentalCost(rental);
            stringBuilder.append(liFirstBalise);
            stringBuilder.append(rental.getMovie().getTitle());
            stringBuilder.append("\t");
            stringBuilder.append("-");
            stringBuilder.append("\t");
            stringBuilder.append(thisAmount);
            stringBuilder.append(liLastBalise);
            stringBuilder.append("\n");
        }
        stringBuilder.append(ulLastBalise);
        stringBuilder.append("\n");
        stringBuilder.append(pFirstBalise);
        stringBuilder.append("Amount owed is ");
        stringBuilder.append(calculatorAmountOwed.getAmountOwed(customerRental));
        stringBuilder.append(pLastBalise);
        stringBuilder.append("\n");

        stringBuilder.append(pFirstBalise);
        stringBuilder.append("You earned ");
        stringBuilder.append(calculatorFrequentRenterPoint.getFrequentRenterPoint(customerRental));
        stringBuilder.append(" frequent renter points ");
        stringBuilder.append(pLastBalise);
        stringBuilder.append("\n");

        stringBuilder.append(bodyLastBalise);
        stringBuilder.append("\n");

        stringBuilder.append(htmlLastBalise);
        logger.info(stringBuilder.toString());
    }

    public PrinterHtml() {}

    public PrinterHtml(ICalculatorAmountOwed calculatorAmountOwed, ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint, ICalculatorRentalCost calculatorRentalCost) {
        super(calculatorAmountOwed, calculatorFrequentRenterPoint, calculatorRentalCost);
    }
}
