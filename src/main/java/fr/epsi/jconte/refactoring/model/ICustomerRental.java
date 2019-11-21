package fr.epsi.jconte.refactoring.model;

import java.util.List;


/**
 * This interface represents the minimum we need to build a customer rental class :
 * The customer, his rentals and the possibility to add rentals to the customer
 */
public interface ICustomerRental {
    ICustomer getCustomer();

    List<IRental> getRentals();

    List<IRental> addRental(IRental rental);
}
