package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorFrequentRenterPoint;
import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.MovieType;

/**
 * Provides methods to get the number of frequent renter points of a customer based on his rentals.
 */
public class CalculatorFrequentRenterPointBonusNewRelease implements ICalculatorFrequentRenterPoint {

    /**
     * Return the number of frequent renter points of a customer based on his rentals.
     * In this implementation there is a base +1 point on any rental but +2 point on new release movies
     * @param customerRental
     * @return
     */
    @Override
    public int getFrequentRenterPoint(ICustomerRental customerRental) {
        int frequentRentalPoints = 0;
        for (IRental rental : customerRental.getRentals()) {
            if (rental.getMovie().getMovieType() == MovieType.NEW_RELEASE) {
                frequentRentalPoints += 2;
            } else {
                frequentRentalPoints += 1;
            }
        }
        return frequentRentalPoints;
    }
}
