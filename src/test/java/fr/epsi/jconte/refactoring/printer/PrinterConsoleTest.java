package fr.epsi.jconte.refactoring.printer;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.printer.impl.PrinterConsole;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

    // TODO : write pertinent test
    @Test
    public void printCustomerRental() throws FunctionnalException {

        // Arrange
        ICustomerRental customerRental = createTestDataHelper.createCustomerRental();
        IPrinter printerConsole = new PrinterConsole(calculatorAmountOwed, calculatorFrequentRenterPoint, calculatorRentalCost);

        // Act
        printerConsole.printCustomerRental(customerRental);

    }
}