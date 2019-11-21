package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.calculator.ICalculatorAmountOwed;
import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.printer.IPrinter;
import fr.epsi.jconte.refactoring.service.impl.CustomerRentalService;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CustomerRentalServiceTest {

    private static CreateTestDataHelper createTestDataHelper;

    @Mock
    private ICalculatorRentalCost calculatorRentalCost;

    @Mock
    private ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint;

    @Mock
    private ICalculatorAmountOwed calculatorAmountOwed;

    @Mock
    private IPrinter printer;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void printCustomerRentalInformations() throws FunctionnalException {

        // Arrange
        ICustomerRentalService customerRentalService = new CustomerRentalService(calculatorRentalCost, calculatorAmountOwed, calculatorFrequentRenterPoint, printer);
        ICustomerRental customerRental = createTestDataHelper.createCustomerRental();

        // Mock
        Mockito.doNothing().when(printer).printCustomerRental(Mockito.any(ICustomerRental.class));

        // Act
        customerRentalService.printCustomerRentalInformations(customerRental);
    }

    @Test
    public void setPrinter() {
    }
}
