package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.model.IRental;

public interface ICalculatorRentalCostPriceRule {

    double getRentalCost(IRental rental);
}
