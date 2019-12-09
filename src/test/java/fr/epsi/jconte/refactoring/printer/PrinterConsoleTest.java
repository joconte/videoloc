package fr.epsi.jconte.refactoring.printer;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.printer.impl.PrinterConsole;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class PrinterConsoleTest {

    private static CreateTestDataHelper createTestDataHelper;

    @Mock
    private ICalculatorRentalCost calculatorRentalCost;

    @Mock
    private ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint;

    @Mock
    private ICalculatorAmountOwed calculatorAmountOwed;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void printCustomerRental() throws FunctionnalException {

        // Arrange
        ICustomerRental customerRental = createTestDataHelper.createCustomerRental();
        IPrinter printerConsole = new PrinterConsole(calculatorAmountOwed, calculatorFrequentRenterPoint, calculatorRentalCost);

        // Mock
        double amountOwed = 2.0;
        Integer frequentRenterPoint = 10;
        double rentalCost = 5.0;
        Mockito.when(calculatorAmountOwed.getAmountOwed(Mockito.any(ICustomerRental.class))).thenReturn(amountOwed);
        Mockito.when(calculatorFrequentRenterPoint.getFrequentRenterPoint(Mockito.any(ICustomerRental.class))).thenReturn(frequentRenterPoint);
        Mockito.when(calculatorRentalCost.calculateRentalCost(Mockito.any(IRental.class))).thenReturn(rentalCost);

        // Act
        String log = printerConsole.printCustomerRental(customerRental);

        // Assert
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        stringBuilder.append("Rental Record for Moi");
        stringBuilder.append("\n");
        stringBuilder.append("\t");
        stringBuilder.append("M5");
        stringBuilder.append("\t");
        stringBuilder.append(rentalCost);
        stringBuilder.append("\n");
        stringBuilder.append("\t");
        stringBuilder.append("M1");
        stringBuilder.append("\t");
        stringBuilder.append(rentalCost);
        stringBuilder.append("\n");
        stringBuilder.append("\t");
        stringBuilder.append("M3");
        stringBuilder.append("\t");
        stringBuilder.append(rentalCost);
        stringBuilder.append("\n");
        stringBuilder.append("\t");
        stringBuilder.append("M4");
        stringBuilder.append("\t");
        stringBuilder.append(rentalCost);
        stringBuilder.append("\n");
        stringBuilder.append("\t");
        stringBuilder.append("M2");
        stringBuilder.append("\t");
        stringBuilder.append(rentalCost);
        stringBuilder.append("\n");
        stringBuilder.append("Amount owed is ");
        stringBuilder.append(amountOwed);
        stringBuilder.append("\n");
        stringBuilder.append("You earned ");
        stringBuilder.append(frequentRenterPoint);
        stringBuilder.append(" frequent renter points ");

        String expected = stringBuilder.toString();
        assertEquals(expected, log);
    }
}