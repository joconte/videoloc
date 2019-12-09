package fr.epsi.jconte.refactoring.printer;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.printer.impl.PrinterHtml;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class PrinterHtmlTest {

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
        IPrinter printerHTML = new PrinterHtml(calculatorAmountOwed, calculatorFrequentRenterPoint, calculatorRentalCost);

        // Mock
        double amountOwed = 2.0;
        Integer frequentRenterPoint = 10;
        double rentalCost = 5.0;
        Mockito.when(calculatorAmountOwed.getAmountOwed(Mockito.any(ICustomerRental.class))).thenReturn(amountOwed);
        Mockito.when(calculatorFrequentRenterPoint.getFrequentRenterPoint(Mockito.any(ICustomerRental.class))).thenReturn(frequentRenterPoint);
        Mockito.when(calculatorRentalCost.calculateRentalCost(Mockito.any(IRental.class))).thenReturn(rentalCost);

        // Act
        String log = printerHTML.printCustomerRental(customerRental);

        // Assert
        String expected = new StringBuilder()
                .append("\n")
                .append("<html>\n")
                .append("<head></head>\n")
                .append("<body>\n")
                .append("<h1> Rental record for Moi</h1>\n")
                .append("<ul>\n")
                .append("<li>M5\t-\t")
                .append(rentalCost)
                .append("</li>\n")
                .append("<li>M1\t-\t")
                .append(rentalCost)
                .append("</li>\n")
                .append("<li>M3\t-\t")
                .append(rentalCost)
                .append("</li>\n")
                .append("<li>M4\t-\t")
                .append(rentalCost)
                .append("</li>\n")
                .append("<li>M2\t-\t")
                .append(rentalCost)
                .append("</li>\n")
                .append("</ul>\n")
                .append("<p>Amount owed is ")
                .append(amountOwed)
                .append("</p>\n")
                .append("<p>You earned ")
                .append(frequentRenterPoint)
                .append(" frequent renter points </p>\n")
                .append("</body>\n")
                .append("</html>").toString();
        assertEquals(expected, log);
    }
}