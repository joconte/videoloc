package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCostPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.IPriceRuleFirstXDays;

public class CalculatorRentalCostPriceRuleFirstXDays implements ICalculatorRentalCostPriceRuleFirstXDays {

    @Override
    public double getRentalCost(IRental rental, IPriceRuleFirstXDays priceRuleFirstXDays) {
        double thisAmount = 0;
        thisAmount += priceRuleFirstXDays.getPriceForFirstXDays();
        if (rental.getDaysRented() > priceRuleFirstXDays.getxDays()) {
            thisAmount += (rental.getDaysRented() - priceRuleFirstXDays.getxDays()) * priceRuleFirstXDays.getPriceForMoreDays();
        }
        return thisAmount;
    }
}
