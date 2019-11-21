package fr.epsi.jconte.refactoring;

import fr.epsi.jconte.refactoring.calculator.*;
import fr.epsi.jconte.refactoring.calculator.impl.*;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.*;
import fr.epsi.jconte.refactoring.model.impl.*;
import fr.epsi.jconte.refactoring.printer.IPrinter;
import fr.epsi.jconte.refactoring.printer.impl.PrinterConsole;
import fr.epsi.jconte.refactoring.printer.impl.PrinterHtml;
import fr.epsi.jconte.refactoring.service.*;
import fr.epsi.jconte.refactoring.service.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FunctionnalException {
        // create movies
        IMovie m1 = new Movie("M1", MovieType.REGULAR);
        IMovie m2 = new Movie("M2",MovieType.NEW_RELEASE);
        IMovie m3 = new Movie("M3",MovieType.NEW_RELEASE);
        IMovie m4 = new Movie("M4",MovieType.CHILDREN);
        IMovie m5 = new Movie("M5",MovieType.CHILDREN);

        // create customer
        ICustomer c1 = new Customer("Moi");

        // create rentals
        IRental r1 = new Rental(m5, 5);
        IRental r2 = new Rental(m1, 10);
        IRental r3 = new Rental(m3, 5);
        IRental r4 = new Rental(m4, 6);
        IRental r5 = new Rental(m2, 8);

        // create customer rentals
        ICustomerRental customerRental = new CustomerRental(c1);
        customerRental.addRental(r1);
        customerRental.addRental(r2);
        customerRental.addRental(r3);
        customerRental.addRental(r4);
        customerRental.addRental(r5);

        // create price rules
        List<IPriceRule> priceRules = new ArrayList<>();
        IPriceRule priceRuleREGULAR = new PriceRuleFirstXDays(MovieType.REGULAR,2, 2, 1.5);
        IPriceRule priceRuleNEWRELEASE = new PriceRuleSamePriceEveryDay(MovieType.NEW_RELEASE, 3);
        IPriceRule priceRuleCHILDREN = new PriceRuleFirstXDays(MovieType.CHILDREN, 1.5, 3, 1.5);
        priceRules.add(priceRuleREGULAR);
        priceRules.add(priceRuleCHILDREN);
        priceRules.add(priceRuleNEWRELEASE);

        // create calculators
        ICalculatorRentalCostPriceRuleSamePriceEveryDay calculatorRentalCostPriceRuleSamePriceEveryDay = new CalculatorRentalCostPriceRuleSamePriceEveryDay();
        ICalculatorRentalCostPriceRuleFirstXDays calculatorRentalCostPriceRuleFirstXDays = new CalculatorRentalCostPriceRuleFirstXDays();
        ICalculatorRentalCost calculatorRentalCost = new CalculatorRentalCost(priceRules, calculatorRentalCostPriceRuleFirstXDays, calculatorRentalCostPriceRuleSamePriceEveryDay);
        ICalculatorAmountOwed calculatorAmountOwedNoReduc = new CalculatorAmountOwedNoReduc(calculatorRentalCost);
        ICalculatorFrequentRenterPoint calculatorFrequentRenterPointBonusNewRelease = new CalculatorFrequentRenterPointBonusNewRelease();

        // create printers
        IPrinter printer = new PrinterConsole();
        IPrinter printerHtml = new PrinterHtml();

        // create customer rentals service
        ICustomerRentalService customerRentalService = new CustomerRentalService(calculatorRentalCost, calculatorAmountOwedNoReduc, calculatorFrequentRenterPointBonusNewRelease, printer);

        // print customer rentals informations
        customerRentalService.printCustomerRentalInformations(customerRental);

        // change printer in service to printer HTML
        customerRentalService.setPrinter(printerHtml);

        // print customer rentals informations using html format
        customerRentalService.printCustomerRentalInformations(customerRental);
    }
}
