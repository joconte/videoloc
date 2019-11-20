package fr.epsi.jconte.refactoring;

import fr.epsi.jconte.refactoring.model.*;
import fr.epsi.jconte.refactoring.model.impl.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IMovie m1 = new Movie("M1", MovieType.REGULAR);
        IMovie m2 = new Movie("M2",MovieType.NEW_RELEASE);
        IMovie m3 = new Movie("M3",MovieType.NEW_RELEASE);
        IMovie m4 = new Movie("M4",MovieType.CHILDREN);
        IMovie m5 = new Movie("M5",MovieType.CHILDREN);

        ICustomer c1 = new Customer("Moi");

        ICalculatorRentalCost calculatorRentalCost = new CalculatorRentalCost();

        IRental r1 = new Rental(m5, 5, calculatorRentalCost);
        IRental r2 = new Rental(m1, 10, calculatorRentalCost);
        IRental r3 = new Rental(m3, 5, calculatorRentalCost);

        ICustomerRental customerRental = new CustomerRental(c1);
        customerRental.addRental(r1);
        customerRental.addRental(r2);
        customerRental.addRental(r3);

        IAmountOwed amountOwed = new AmountOwedNoReduc();
        IFrequentRenterPoint frequentRenterPoint = new FrequentRenterPoint();

        IPrinter printer = new PrinterConsole(customerRental, amountOwed, frequentRenterPoint);
        printer.printCustomerRental();

        IPrinter printerHtml = new PrinterHtml(customerRental, amountOwed, frequentRenterPoint);
        printerHtml.printCustomerRental();
    }
}
