package fr.epsi.jconte.refactoring.calculator;

import fr.epsi.jconte.refactoring.model.IPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IRental;

public interface ICalculatorRentalCostPriceRuleSamePriceEveryDay {

    double getRentalCost(IRental rental, IPriceRuleSamePriceEveryDay priceRuleSamePriceEveryDay);
}
