package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.model.IMovie;
import fr.epsi.jconte.refactoring.model.IRental;
import fr.epsi.jconte.refactoring.model.impl.Movie;

//The class Rental represents a customer renting a movie
public class Rental implements IRental {

    private int _daysRented;

    private IMovie _movie;

    private ICalculatorRentalCost calculatorRentalCost;

    public Rental(IMovie movie, int daysRented, ICalculatorRentalCost calculatorRentalCost) {
        _movie = movie;
        _daysRented = daysRented;
        this.calculatorRentalCost = calculatorRentalCost;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public IMovie getMovie() {
        return _movie;
    }

    public double amoutFor() {
        return this.calculatorRentalCost.calculateRentalCost(this);
    }
}


