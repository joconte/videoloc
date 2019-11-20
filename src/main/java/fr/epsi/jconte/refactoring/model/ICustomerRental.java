package fr.epsi.jconte.refactoring.model;

import java.util.List;

public interface ICustomerRental {
    ICustomer getCustomer();

    List<IRental> getRentals();

    List<IRental> addRental(IRental rental);
}
