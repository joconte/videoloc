package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.calculator.impl.CalculatorRentalCost;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.*;
import fr.epsi.jconte.refactoring.model.impl.PriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.impl.PriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.utils.CreateTestDataHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class CalculatorRentalCostTest {

    private static CreateTestDataHelper createTestDataHelper;

    @Mock
    private ICalculatorRentalCostPriceRuleFirstXDays calculatorRentalCostPriceRuleFirstXDays;

    @Mock
    private ICalculatorRentalCostPriceRuleSamePriceEveryDay calculatorRentalCostPriceRuleSamePriceEveryDay;

    @BeforeClass
    public static void initDataTestHelper() {
        createTestDataHelper = new CreateTestDataHelper();
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateRentalCost() throws FunctionnalException {

        // Arrange
        IRental rental = createTestDataHelper.createRental();
        List<IPriceRule> priceRules = new ArrayList<>();
        IPriceRule priceRuleRegular = new PriceRuleFirstXDays(MovieType.REGULAR, 2, 2, 1.5);
        IPriceRule priceRuleNewRelease = new PriceRuleSamePriceEveryDay(MovieType.NEW_RELEASE, 3);
        IPriceRule priceRuleChildren = new PriceRuleFirstXDays(MovieType.CHILDREN, 2, 3, 1.5);
        priceRules.add(priceRuleRegular);
        priceRules.add(priceRuleNewRelease);
        priceRules.add(priceRuleChildren);
        ICalculatorRentalCost calculatorRentalCost = new CalculatorRentalCost(priceRules, calculatorRentalCostPriceRuleFirstXDays, calculatorRentalCostPriceRuleSamePriceEveryDay);

        // Mock
        Mockito.when(calculatorRentalCostPriceRuleFirstXDays.getRentalCost(Mockito.any(IRental.class), Mockito.any(IPriceRuleFirstXDays.class))).thenReturn(2D);
        Mockito.when(calculatorRentalCostPriceRuleSamePriceEveryDay.getRentalCost(Mockito.any(IRental.class), Mockito.any(IPriceRuleSamePriceEveryDay.class))).thenReturn(3D);

        // Act
        double rentalCost = calculatorRentalCost.calculateRentalCost(rental);

        // Assert
        Assert.assertEquals(2, rentalCost, 0.0);

    }
}