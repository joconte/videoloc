package fr.epsi.jconte.refactoring.service;

import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.printer.IPrinter;

public interface ICustomerRentalService {
    String printCustomerRentalInformations(ICustomerRental customerRental) throws FunctionnalException;

    void setPrinter(IPrinter printer);
}
