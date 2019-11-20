package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICustomerRental;
import fr.epsi.jconte.refactoring.model.IFrequentRenterPoint;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.MovieType;

public class FrequentRenterPoint implements IFrequentRenterPoint {
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
