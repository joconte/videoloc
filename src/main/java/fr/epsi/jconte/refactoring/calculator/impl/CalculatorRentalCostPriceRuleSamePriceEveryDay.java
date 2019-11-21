package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCostPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IRental;

public class CalculatorRentalCostPriceRuleSamePriceEveryDay implements ICalculatorRentalCostPriceRuleSamePriceEveryDay {
    @Override
    public double getRentalCost(IRental rental) {

        return rental.getDaysRented() * 3;
    }
}
