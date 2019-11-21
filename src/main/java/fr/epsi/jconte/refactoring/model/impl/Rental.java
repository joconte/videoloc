package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IMovie;
import fr.epsi.jconte.refactoring.model.IRental;

/**
 * The Rental class represents the rental of a movie in our store
 */
public class Rental implements IRental {

    private int _daysRented;

    private IMovie _movie;

    public Rental(IMovie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public IMovie getMovie() {
        return _movie;
    }
}


