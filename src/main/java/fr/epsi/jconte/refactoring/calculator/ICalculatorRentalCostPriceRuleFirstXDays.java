package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.model.IPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.IRental;

public interface ICalculatorRentalCostPriceRuleFirstXDays {

    double getRentalCost(IRental rental, IPriceRuleFirstXDays priceRuleFirstXDays);
}
