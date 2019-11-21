package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;

public interface ICalculatorAmountOwed {

    double getAmountOwed(ICustomerRental customerRental) throws FunctionnalException;
}
