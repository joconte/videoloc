package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;

public interface ICustomerRentalService {
    void printCustomerRentalInformations(ICustomerRental customerRental) throws FunctionnalException;

    void setPrinter(IPrinter printer);
}
