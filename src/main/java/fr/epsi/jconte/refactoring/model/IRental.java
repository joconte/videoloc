package fr.epsi.jconte.refactoring.model;

/**
 * This interface represents the minimum we need to build a rental class :
 * The rented movie and the number of rented days
 */
public interface IRental {

    int getDaysRented();

    IMovie getMovie();
}
