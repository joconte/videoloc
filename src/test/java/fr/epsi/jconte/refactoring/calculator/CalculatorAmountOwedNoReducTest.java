package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.calculator.impl.CalculatorAmountOwedNoReduc;
import fr.epsi.jconte.refactoring.calculator.impl.CalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculatorAmountOwedNoReducTest {

    @Mock
    private CalculatorRentalCost calculatorRentalCost;

    private static CreateTestDataHelper createTestDataHelper;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAmountOwed() throws FunctionnalException {
        // Arrange
        ICalculatorAmountOwed calculatorAmountOwed = new CalculatorAmountOwedNoReduc(calculatorRentalCost);

        ICustomerRental customerRental = createTestDataHelper.createCustomerRental();

        // Mock
        Mockito.when(calculatorRentalCost.calculateRentalCost(Mockito.any(IRental.class))).thenReturn(2D);

        // Act
        double result = calculatorAmountOwed.getAmountOwed(customerRental);

        // Assert
        Assert.assertEquals(10, result, 0.0);

    }
}