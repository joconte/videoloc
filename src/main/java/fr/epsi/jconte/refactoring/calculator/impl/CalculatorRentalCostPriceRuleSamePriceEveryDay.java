package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCostPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IRental;

public class CalculatorRentalCostPriceRuleSamePriceEveryDay implements ICalculatorRentalCostPriceRuleSamePriceEveryDay {
    @Override
    public double getRentalCost(IRental rental, IPriceRuleSamePriceEveryDay priceRuleSamePriceEveryDay) {

        return rental.getDaysRented() * priceRuleSamePriceEveryDay.getPrice();
    }
}
