package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICustomer;

/**
 * The customer class represent a customer in our store
 */
public class Customer implements ICustomer {

    private java.lang.String name_;

    public Customer(String name) {
        name_ = name;
    }

    public java.lang.String getName() {
        return name_;
    }
}
