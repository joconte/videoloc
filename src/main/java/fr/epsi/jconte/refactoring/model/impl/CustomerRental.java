package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICustomer;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.MovieType;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class CustomerRental implements ICustomerRental {

    private ICustomer customer;

    private List<IRental> rentals;

    public ICustomer getCustomer() {
        return customer;
    }

    public List<IRental> getRentals() {
        return rentals;
    }

    public void setRentals(List<IRental> rentals) {
        this.rentals = rentals;
    }

    public CustomerRental(ICustomer customer) {
        this.customer = customer;
        this.rentals = new ArrayList<>();
    }

    public CustomerRental(ICustomer customer, List<IRental> rentals) {
        this.customer = customer;
        this.rentals = rentals;
    }

    public List<IRental> addRental(IRental rental) {
        this.rentals.add(rental);
        return this.rentals;
    }
}
