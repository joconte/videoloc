package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.model.IRental;

public interface ICalculatorRentalCostPriceRuleFirstXDays {

    double getRentalCost(IRental rental, IPriceRuleFirstXDays priceRuleFirstXDays);
}
