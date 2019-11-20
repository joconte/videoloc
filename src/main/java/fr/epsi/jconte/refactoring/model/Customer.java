package fr.epsi.jconte.refactoring.model;

import java.util.*;

// The Customer class represents the customer of the store.
public class Customer {
    private java.lang.String name_;
    private Vector rentals_;

    public Customer(String name) {
        name_ = name;
    }

    public void addRentals(Rental arg) {
        rentals_.addElement(arg);
    }

    public java.lang.String getName() {
        return name_;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = rentals_.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
//determines amount for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
// add frequent renter points
            frequentRenterPoints++;
// add bonus for a two day new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                frequentRenterPoints++;
// show figures for this rental
            result += "\t" + each.getMovie().getTitle()
                    + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is "
                + String.valueOf(totalAmount)
                + "\n";
        result += "You earned "
                + String.valueOf(frequentRenterPoints)
                + "frequent renter points ";
        return result;
    }
}
