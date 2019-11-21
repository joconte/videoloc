package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.calculator.impl.CalculatorFrequentRenterPointNoPoint;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorFrequentRenterPointNoPointTest {

    private static CreateTestDataHelper createTestDataHelper;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Test
    public void getFrequentRenterPoint() {

        // Arrange
        ICalculatorFrequentRenterPoint calculatorFrequentRenterPoint = new CalculatorFrequentRenterPointNoPoint();
        ICustomerRental customerRental = createTestDataHelper.createCustomerRental();

        // Act
        int frequentRenterPoints = calculatorFrequentRenterPoint.getFrequentRenterPoint(customerRental);

        // Assert
        Assert.assertEquals(0, frequentRenterPoints);

    }
}