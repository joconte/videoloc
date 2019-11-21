package fr.epsi.jconte.refactoring.utils;

import fr.epsi.jconte.refactoring.model.*;
import fr.epsi.jconte.refactoring.model.impl.*;

public class CreateTestDataHelper {

    public ICustomerRental createCustomerRental() {

        // create movies
        IMovie m1 = new Movie("M1", MovieType.REGULAR);
        IMovie m2 = new Movie("M2",MovieType.NEW_RELEASE);
        IMovie m3 = new Movie("M3",MovieType.NEW_RELEASE);
        IMovie m4 = new Movie("M4",MovieType.CHILDREN);
        IMovie m5 = new Movie("M5",MovieType.CHILDREN);

        // create customer
        ICustomer c1 = new Customer("Moi");

        // create rentals
        IRental r1 = new Rental(m5, 5);
        IRental r2 = new Rental(m1, 10);
        IRental r3 = new Rental(m3, 5);
        IRental r4 = new Rental(m4, 6);
        IRental r5 = new Rental(m2, 8);

        // create customer rentals
        ICustomerRental customerRental = new CustomerRental(c1);
        customerRental.addRental(r1);
        customerRental.addRental(r2);
        customerRental.addRental(r3);
        customerRental.addRental(r4);
        customerRental.addRental(r5);

        return customerRental;
    }

    public IRental createRental() {

        // create movies
        IMovie m1 = new Movie("M1", MovieType.REGULAR);

        // create rentals
        IRental r2 = new Rental(m1, 10);

        return r2;

    }
}
