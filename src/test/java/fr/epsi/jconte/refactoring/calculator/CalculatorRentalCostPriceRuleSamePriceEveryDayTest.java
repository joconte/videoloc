package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.calculator.impl.CalculatorRentalCostPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.MovieType;
import fr.epsi.jconte.refactoring.model.impl.PriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorRentalCostPriceRuleSamePriceEveryDayTest {

    private static CreateTestDataHelper createTestDataHelper;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Test
    public void getRentalCost() {

        // Arrange
        ICalculatorRentalCostPriceRuleSamePriceEveryDay calculatorRentalCostPriceRuleSamePriceEveryDay = new CalculatorRentalCostPriceRuleSamePriceEveryDay();
        IRental rental = createTestDataHelper.createRental();
        IPriceRuleSamePriceEveryDay priceRuleSamePriceEveryDay = new PriceRuleSamePriceEveryDay(MovieType.CHILDREN, 2);
        // Act
        double rentalCost = calculatorRentalCostPriceRuleSamePriceEveryDay.getRentalCost(rental, priceRuleSamePriceEveryDay);

        // Assert
        Assert.assertEquals(20, rentalCost, 0.0);
    }
}