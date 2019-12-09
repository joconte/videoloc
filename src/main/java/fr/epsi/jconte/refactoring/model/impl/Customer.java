package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICustomer;

/**
 * The customer class represent a customer in our store
 */
public class Customer implements ICustomer {

    private java.lang.String name;

    public Customer(String name) {
        name = name;
    }

    public java.lang.String getName() {
        return name;
    }
}
