package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.IRental;

public interface ICalculatorRentalCost {

    double calculateRentalCost(IRental rental) throws FunctionnalException;
}
