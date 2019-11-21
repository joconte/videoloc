package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.service.ICalculatorRentalCostPriceRuleSamePriceEveryDay;

public class CalculatorRentalCostPriceRuleSamePriceEveryDay implements ICalculatorRentalCostPriceRuleSamePriceEveryDay {
    @Override
    public double getRentalCost(IRental rental) {

        return rental.getDaysRented() * 3;
    }
}
