package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IMovie;
import fr.epsi.jconte.refactoring.model.IRental;

/**
 * The Rental class represents the rental of a movie in our store
 */
public class Rental implements IRental {

    private int daysRented;

    private IMovie movie;

    public Rental(IMovie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public IMovie getMovie() {
        return movie;
    }
}


