package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICustomer;

/**
 * The customer class represent a customer in our store
 */
public class Customer implements ICustomer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
