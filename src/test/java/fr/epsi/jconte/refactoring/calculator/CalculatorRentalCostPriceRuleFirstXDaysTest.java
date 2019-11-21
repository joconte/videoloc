package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.calculator.impl.CalculatorRentalCostPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.IPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.MovieType;
import fr.epsi.jconte.refactoring.model.impl.PriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorRentalCostPriceRuleFirstXDaysTest {

    private static CreateTestDataHelper createTestDataHelper;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Test
    public void getRentalCost() {

        // Arrange
        ICalculatorRentalCostPriceRuleFirstXDays calculatorRentalCostPriceRuleFirstXDays = new CalculatorRentalCostPriceRuleFirstXDays();
        IRental rental = createTestDataHelper.createRental();
        IPriceRuleFirstXDays priceRuleFirstXDays = new PriceRuleFirstXDays(MovieType.REGULAR, 2, 2, 1.5);

        // Act
        double rentalCost = calculatorRentalCostPriceRuleFirstXDays.getRentalCost(rental, priceRuleFirstXDays);

        // Assert
        Assert.assertEquals(14, rentalCost, 0.0);
    }
}